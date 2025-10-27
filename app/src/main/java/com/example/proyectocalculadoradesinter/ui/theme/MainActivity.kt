package com.example.proyectocalculadoradesinter

// Importaciones necesarias
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.proyectocalculadoradesinter.Components.CalculadoraLocaApp

/**
 * Actividad principal de la aplicación.
 * Aquí se carga la interfaz de la calculadora loca.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent define la UI usando Jetpack Compose
        setContent {
            // MaterialTheme aplica el tema visual
            MaterialTheme {
                // Surface actúa como contenedor de la interfaz
                Surface {
                    // Cargamos la interfaz de la calculadora
                    CalculadoraLocaApp()
                }
            }
        }
    }
}
