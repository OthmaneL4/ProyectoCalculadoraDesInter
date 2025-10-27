
# Calculadora Loca (Jetpack Compose + Material 3)

**Repositorio:** [https://github.com/tu-usuario/proyecto-calculadora-loca](https://github.com/tu-usuario/proyecto-calculadora-loca)

---

## Descripción del proyecto

La **Calculadora Loca** es una aplicación Android desarrollada con **Kotlin** y **Jetpack Compose (Material 3)**.  
Su objetivo es crear una calculadora con un comportamiento inesperado y divertido: los números y las operaciones **no corresponden directamente** con lo que el usuario pulsa.

El propósito de este proyecto es mostrar el manejo de estados, componentes composables y lógica personalizada en Jetpack Compose, dentro de una interfaz moderna, funcional y creativa.

Esta práctica forma parte del módulo **Desarrollo de Interfaces** y demuestra la capacidad de integrar diseño, lógica y experiencia de usuario en un entorno Android moderno.

---

## Características principales

- Interfaz diseñada completamente con **Jetpack Compose**, sin archivos XML.
- **Botones personalizados** con esquinas redondeadas y colores configurables.
- Lógica matemática interna sin dependencias externas.
- **Mapeos “locos”** de números y operaciones, generando una calculadora impredecible.
- Reglas especiales que alteran el resultado final para darle un toque humorístico.

---

## Tecnologías utilizadas

| Tecnología | Uso principal |
|-------------|----------------|
| **Kotlin** | Lenguaje principal de desarrollo. |
| **Jetpack Compose** | Creación de la interfaz de usuario declarativa. |
| **Material 3** | Diseño visual y componentes modernos de interfaz. |
| **Android Studio** | Entorno de desarrollo y compilación del proyecto. |

**Versión mínima del SDK:** 24 (Android 7.0)

---

## Instrucciones de ejecución

1. Clonar el repositorio desde GitHub:
   ```bash
   git clone https://github.com/tu-usuario/proyecto-calculadora-loca.git
   ```

2. Abrir el proyecto en **Android Studio**.

3. Esperar a que Gradle sincronice las dependencias.

4. Conectar un dispositivo físico o iniciar un emulador con Android 7.0 o superior.

5. Ejecutar el proyecto desde el botón **Run ▶️**.

> Al iniciarse, se mostrará la calculadora con fondo oscuro, botones redondeados y símbolos alterados.

---

## Mapa de desorden

### Mapeo de números (lo que se ve → lo que realmente inserta)

| Botón mostrado | Valor real insertado |
|----------------|----------------------|
| `0` | `2` |
| `1` | `3` |
| `2` | `4` |
| `3` | `6` |
| `4` | `7` |
| `6` | `8` |
| `7` | `9` |
| `8` | `0` |
| `9` | `1` |

> El número **5 no existe** en la calculadora.

### Mapeo de operaciones (símbolo mostrado → operación real)

| Símbolo mostrado | Operación real |
|------------------|----------------|
| `&` | `+` |
| `#` | `-` |
| `@` | `*` |
| `$` | `/` |

---

## Lógica de funcionamiento

El proyecto cuenta con tres partes principales:

- **`CalculadoraLocaApp()`**: función composable principal que define toda la interfaz y maneja los estados de la expresión y el resultado.
- **`BotonCalculadora()`**: componente composable reutilizable para crear cada botón con estilo personalizado.
- **`evaluarExpresion()`**: función lógica que interpreta la cadena ingresada y realiza los cálculos matemáticos respetando la prioridad de operaciones.

Una vez obtenida la operación, la aplicación aplica una **regla especial**: todos los números **5** en el resultado final se reemplazan por **6**.

---

## Enlace al vídeo de demostración

> **Enlace de Google Drive (acceso público):** [(https://drive.google.com/drive/folders/11OG4unJYYCWcr2Gbbo15S4MuCoAwicf4?usp=sharing)](https://drive.google.com/drive/folders/11OG4unJYYCWcr2Gbbo15S4MuCoAwicf4?usp=sharing)


---

## Conclusión

La **Calculadora Loca** combina diseño moderno, creatividad y lógica personalizada para demostrar el potencial de **Jetpack Compose** en el desarrollo de interfaces interactivas.  
El proyecto refleja un uso adecuado de estados, componentes composables, gestión de eventos y evaluación de expresiones matemáticas.

Además de su carácter divertido, esta aplicación demuestra una implementación sólida, bien estructurada y alineada con las buenas prácticas del desarrollo Android moderno.

---

**Autor:** Othmane Laghouiyel Siyouri 

