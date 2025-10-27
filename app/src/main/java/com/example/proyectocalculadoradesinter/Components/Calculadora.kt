package com.example.proyectocalculadoradesinter.Components

// Importaciones necesarias para usar Jetpack Compose
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Función principal que muestra toda la interfaz de la calculadora loca.
 */
@Composable
fun CalculadoraLocaApp() {

    // Estado para la expresión que el usuario está escribiendo
    var expresion by remember { mutableStateOf("") }

    // Estado para el resultado mostrado en pantalla
    var resultado by remember { mutableStateOf("") }

    // Colores principales
    val colorFondo = Color(0xFF101010)
    val colorBoton = Color(0xFF202020)
    val colorTexto = Color.White

    //  Mapeo de números desordenados
    // El número mostrado en el botón NO es el número que se ingresa realmente.
    val botonesNumeros = mapOf(
        "0" to "2",
        "1" to "3",
        "2" to "4",
        "3" to "6", // el 5 no existe
        "4" to "7",
        "6" to "8",
        "7" to "9",
        "8" to "0",
        "9" to "1"
    )

    // 🔣 Mapeo de operaciones "locas"
    val botonesOperaciones = mapOf(
        "&" to "+",
        "#" to "-",
        "@" to "*",
        "$" to "/"
    )

    // Estructura de la interfaz principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // 🔹 Pantalla de texto (expresión y resultado)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = expresion,
                color = Color.Gray,
                fontSize = 28.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = resultado,
                color = colorTexto,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // 🔹 Sección de botones
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

            // FILA 1: Operaciones locas
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                botonesOperaciones.forEach { (simbolo, real) ->
                    BotonCalculadora(
                        texto = simbolo,
                        colorFondo = colorBoton
                    ) {
                        expresion += real
                    }
                }
            }

            // FILAS DE NÚMEROS (sin el 5)
            val numerosPorFila = listOf(
                listOf("7", "8", "9"),
                listOf("4", "6", "3"),
                listOf("1", "2", "0")
            )

            numerosPorFila.forEach { fila ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    fila.forEach { numero ->
                        BotonCalculadora(
                            texto = numero,
                            colorFondo = colorBoton
                        ) {
                            val valorReal = botonesNumeros[numero]
                            if (valorReal != null) {
                                expresion += valorReal
                            }
                        }
                    }
                }
            }

            // FILA FINAL: C (borrar) y =
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Botón para limpiar
                BotonCalculadora(
                    texto = "C",
                    colorFondo = Color.Red
                ) {
                    expresion = ""
                    resultado = ""
                }

                // Botón para evaluar
                BotonCalculadora(
                    texto = "=",
                    colorFondo = Color.Green
                ) {
                    try {
                        val res = evaluarExpresion(expresion)
                        var resultadoTexto = res.toString()
                        resultadoTexto = resultadoTexto.replace('5', '6') // Regla loca
                        resultado = resultadoTexto
                    } catch (e: Exception) {
                        resultado = "Error"
                    }
                }
            }
        }
    }
}

/**
 * Composable que crea un botón reutilizable.
 */
@Composable
fun BotonCalculadora(texto: String, colorFondo: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(80.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorFondo),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = texto,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * Evalúa una expresión matemática simple (+, -, *, /)
 * sin usar librerías externas.
 */
fun evaluarExpresion(expr: String): Double {
    val expression = expr.replace(" ", "")
    if (expression.isEmpty()) return 0.0

    try {
        val numeros = mutableListOf<Double>()
        val operadores = mutableListOf<Char>()
        var actual = ""

        for (c in expression) {
            if (c.isDigit()) {
                actual += c
            } else if (c in listOf('+', '-', '*', '/')) {
                numeros.add(actual.toDouble())
                operadores.add(c)
                actual = ""
            }
        }

        if (actual.isNotEmpty()) numeros.add(actual.toDouble())

        // Primero * y /
        var i = 0
        while (i < operadores.size) {
            if (operadores[i] == '*' || operadores[i] == '/') {
                val a = numeros[i]
                val b = numeros[i + 1]
                val res = if (operadores[i] == '*') a * b else a / b
                numeros[i] = res
                numeros.removeAt(i + 1)
                operadores.removeAt(i)
            } else i++
        }

        // Luego + y -
        var resultado = numeros[0]
        for (j in operadores.indices) {
            val op = operadores[j]
            val num = numeros[j + 1]
            resultado = when (op) {
                '+' -> resultado + num
                '-' -> resultado - num
                else -> resultado
            }
        }
        return resultado
    } catch (e: Exception) {
        return 0.0
    }
}
