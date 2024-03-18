package sptech.culinart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sptech.culinart.ui.theme.CulinartTheme

class Cadastro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CulinartTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TelaCadastro("Android")
                }
            }
        }
    }
}

@Composable
fun TelaCadastro(name: String, modifier: Modifier = Modifier) {

    val nome = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val telefone = remember {
        mutableStateOf("")
    }
    val senha = remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(249, 251, 251))
    ) {
        // Imagens posicionadas conforme solicitado
        Image(
            painter = painterResource(id = R.mipmap.ondalaranjaforte),
            contentDescription = "Onda Laranja Forte",
            modifier = Modifier.align(Alignment.BottomEnd)
        )

        Image(
            painter = painterResource(id = R.mipmap.ondalaranjamedio),
            contentDescription = "Onda Laranja Médio",
            modifier = Modifier.align(Alignment.BottomStart)
        )

        Image(
            painter = painterResource(id = R.mipmap.ondalaranjaclaro),
            contentDescription = "Onda Laranja Claro",
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }

    Column() {
        Text(
            "Crie sua conta e",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                Color(4, 93, 83),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
        )
        Text(
            "faça arte!",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                Color(4, 93, 83),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
        )

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = nome.value,
                onValueChange = { nome.value = it },
                label = {
                    Text("Nome")
                },
                placeholder = { Text("Nome Completo") },
                colors = TextFieldDefaults.colors (
                    unfocusedLabelColor = Color(4, 93, 83),
                    focusedLabelColor = Color(4, 93, 83),
                    unfocusedContainerColor = Color(249, 251, 251),
                    focusedContainerColor = Color(232,240,239)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") },
                placeholder = { Text("example@email.com") },
                colors = TextFieldDefaults.colors (
                    unfocusedLabelColor = Color(4, 93, 83),
                    focusedLabelColor = Color(4, 93, 83),
                    unfocusedContainerColor = Color(249, 251, 251),
                    focusedContainerColor = Color(232,240,239)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )
            TextField(
                value = telefone.value,
                onValueChange = { telefone.value = it },
                label = { Text("Telefone") },
                placeholder = { Text("(99) 99999-9999") },
                colors = TextFieldDefaults.colors (
                    unfocusedLabelColor = Color(4, 93, 83),
                    focusedLabelColor = Color(4, 93, 83),
                    unfocusedContainerColor = Color(249, 251, 251),
                    focusedContainerColor = Color(232,240,239)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            TextField(
                value = senha.value,
                onValueChange = { senha.value = it },
                label = { Text("Senha") },
                placeholder = { Text("********") },
                colors = TextFieldDefaults.colors (
                    unfocusedLabelColor = Color(4, 93, 83),
                    focusedLabelColor = Color(4, 93, 83),
                    unfocusedContainerColor = Color(249, 251, 251),
                    focusedContainerColor = Color(232,240,239)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(250.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = ButtonDefaults.buttonElevation (
                    defaultElevation = 8.dp,
                    pressedElevation = 4.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(255,159,28),
                    contentColor = Color.White
                )
            ) {
                Text("Cadastrar")
            }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Canvas(
                    modifier = Modifier
                        .size(100.dp, 2.dp)
                ) {
                    drawRoundRect(
                        color = Color.Black,
                        cornerRadius = CornerRadius(100f)
                    )
                }
                Text("ou")
                Canvas(
                    modifier = Modifier
                        .size(100.dp, 2.dp)
                ) {
                    drawRoundRect(
                        color = Color.Black,
                        cornerRadius = CornerRadius(100f)
                    )
                }
            }

            Text("Entre na sua conta",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    Color(46, 196, 182),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                ))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun TelaCadastroPreview() {
    CulinartTheme {
        TelaCadastro("Android")
    }
}