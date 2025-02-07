package es.iesoretania.ejemploinicialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable que define la pantalla principal
            AppScreen()
        }
    }
}

// Función composable que representa la interfaz de usuario principal
@Composable
fun AppScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .padding(16.dp), // Añade margen
        horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos en el eje horizontal
        verticalArrangement = Arrangement.Center // Centra los elementos en el eje vertical
    ) {
        // Estado para manejar el texto ingresado (recoge la elevación de estado)
        var inputText by remember { mutableStateOf("") }
        // Estado para manejar el contador (Se mantiene el estado de la variable)
        var contador by rememberSaveable { mutableIntStateOf(0) }

        // Muestra el valor del contador
        Text(text = "Contador: $contador", style = TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre elementos

        // Fila con botones para incrementar y decrementar el contador
        Row {
            Button(onClick = { contador++ }) {
                Text("Incrementar")
            }
            Spacer(modifier = Modifier.width(8.dp)) // Espacio entre botones
            Button(onClick = { contador-- }) {
                Text("Decrementar")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Muestra el texto introducido en el TextField
        Text(text = "Texto Introducido: $inputText", style = TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para introducir un nombre
        //Hace una elevación de estado.
        TextField(
            value = inputText,
            onValueChange = { inputText = it }, // Actualiza el estado con el nuevo valor
            label = { Text("Introduce tu nombre") }
        )
    }
}

// Función para previsualizar la interfaz en el editor
@Preview(showBackground = true)
@Composable
fun PreviewAppScreen() {
    AppScreen()
}