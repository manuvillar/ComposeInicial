package es.iesoretania.ejemploinicialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.iesoretania.ejemploinicialcompose.ui.theme.EjemploInicialComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
           AppScreen()
        }
    }
}

@Composable
fun AppScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var inputText by remember { mutableStateOf("") }
        var contador by remember { mutableIntStateOf(0) }

        Text(text = "Contador: $contador", style = TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.height(16.dp))
        
        Row {
            Button(onClick = { contador++ }) {
                Text("Incrementar")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { contador-- }) {
                Text("Decrementar")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Texto Introducido: $inputText", style = TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Introduce tu nombre") }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppScreen() {
   AppScreen()
}