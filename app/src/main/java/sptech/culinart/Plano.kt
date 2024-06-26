package sptech.culinart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sptech.culinart.ui.theme.CulinartTheme

class Plano : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CulinartTheme {
               
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaPlano()
                }
            }
        }
    }
}

@Composable
fun TelaPlano(modifier: Modifier = Modifier) {

    val contexto = LocalContext.current


    val selectedDay = remember { mutableStateOf("") }

    val numeroPessoas = remember { mutableStateOf(0) }

    val numeroRefeicoesDia = remember { mutableStateOf(0) }

    val numeroDiasPorSemana = remember { mutableStateOf(0) }

    val isCarnesClicked = remember { mutableStateOf(false) }

    val isVegetarianoClicked = remember { mutableStateOf(false) }

    val isPescetarianoClicked = remember { mutableStateOf(false) }

    val isVeganoClicked = remember { mutableStateOf(false) }

    val isRapidoFacilClicked = remember { mutableStateOf(false) }

    val isFitSaudavelClicked = remember { mutableStateOf(false) }

    val horarios = listOf(
        "06:00", "07:00", "08:00", "09:00", "10:00", "11:00",
        "12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
        "18:00", "19:00", "20:00", "21:00", "22:00"
    )
    val selectedHorario = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(249, 251, 251))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ComponenteHeader("Android")
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Plano",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                Color(4, 93, 83),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        Canvas(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .height(1.dp)
        ) {
            drawRoundRect(
                color = Color(160, 160, 160),
                cornerRadius = CornerRadius(0f)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Categorias",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                Color(4, 93, 83),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row {

            Spacer(modifier = Modifier.weight(0.4f))

            Card (modifier = modifier
                .height(100.dp)
                .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = if (isCarnesClicked.value) Color(255, 241, 221) else Color.White
                ),
                border = if (isCarnesClicked.value) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(2.dp, Color(228, 228, 228)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ){
                TextButton(onClick = {
                    isCarnesClicked.value = !isCarnesClicked.value
                }) {
                    Column( modifier = modifier
                        .fillMaxHeight()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.mipmap.iconecarnes), contentDescription = "Ícone de Carnes")
                        Text(
                            "Carnes",
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                Color(4, 93, 83),
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(0.4f))

            Card (modifier = modifier
                .height(100.dp)
                .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = if (isVegetarianoClicked.value) Color(255, 241, 221) else Color.White
                ),
                border = if (isVegetarianoClicked.value) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(2.dp, Color(228, 228, 228)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ){
                TextButton(onClick = {
                    isVegetarianoClicked.value = !isVegetarianoClicked.value
                }) {
                    Column( modifier = modifier
                        .fillMaxHeight()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.mipmap.iconevegetariano), contentDescription = "Ícone de Vegetariano")
                        Text(
                            "Vegetariano",
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                Color(4, 93, 83),
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.weight(0.4f))

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row {

            Spacer(modifier = Modifier.weight(0.4f))

            Card (modifier = modifier
                .height(100.dp)
                .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = if (isPescetarianoClicked.value) Color(255, 241, 221) else Color.White
                ),
                border = if (isPescetarianoClicked.value) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(2.dp, Color(228, 228, 228)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ){
                TextButton(onClick = {
                    isPescetarianoClicked.value = !isPescetarianoClicked.value
                }) {
                    Column( modifier = modifier
                        .fillMaxHeight()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.mipmap.iconepescetariano), contentDescription = "Ícone pescetariano")
                        Text(
                            "Pescetariano",
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                Color(4, 93, 83),
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(0.4f))

            Card (modifier = modifier
                .height(100.dp)
                .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = if (isVeganoClicked.value) Color(255, 241, 221) else Color.White
                ),
                border = if (isVeganoClicked.value) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(2.dp, Color(228, 228, 228)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ){
                TextButton(onClick = {
                    isVeganoClicked.value = !isVeganoClicked.value
                }) {
                    Column( modifier = modifier
                        .fillMaxHeight()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.mipmap.iconevegano), contentDescription = "Ícone vegano")
                        Text(
                            "Vegano",
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                Color(4, 93, 83),
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.weight(0.4f))

        }


        Spacer(modifier = Modifier.height(30.dp))

        Row {

            Spacer(modifier = Modifier.weight(0.4f))

            Card(
                modifier = Modifier
                    .height(100.dp)
                    .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = if (isRapidoFacilClicked.value) Color(255, 241, 221) else Color.White
                ),
                border = if (isRapidoFacilClicked.value) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(2.dp, Color(228, 228, 228)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                TextButton(onClick = {
                    isRapidoFacilClicked.value = !isRapidoFacilClicked.value
                }) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.iconerapidoefacil),
                            contentDescription = "Ícone rápido e fácil"
                        )
                        Text(
                            "Rápido e Fácil",
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                color = Color(4, 93, 83),
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.weight(0.4f))

            Card (modifier = modifier
                .height(100.dp)
                .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = if (isFitSaudavelClicked.value) Color(255, 241, 221) else Color.White
                ),
                border = if (isFitSaudavelClicked.value) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(2.dp, Color(228, 228, 228)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ){
                TextButton(onClick = {
                    isFitSaudavelClicked.value = !isFitSaudavelClicked.value
                }) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.mipmap.iconefitesaudavel), contentDescription = "Ícone fit e saudável")
                        Text(
                            "Fit e Saudável",
                            modifier = Modifier.fillMaxWidth(),
                            style = TextStyle(
                                Color(4, 93, 83),
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.weight(0.4f))

        }

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            "Quantidades",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                Color(4, 93, 83),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Pessoas",
                style = TextStyle(
                    Color(220,119,38),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp
                )
            )

            Spacer(modifier = Modifier.weight(5f))

        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            (1..8).forEach { number ->
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    colors =  CardDefaults.cardColors(
                        containerColor = if (numeroPessoas.value == number) Color(255, 241, 221) else Color.White
                    ),
                    shape = RoundedCornerShape(topStart = if (number == 1) 8.dp else 0.dp,
                        bottomStart = if (number == 1) 8.dp else 0.dp,
                        topEnd = if (number == 8) 8.dp else 0.dp,
                        bottomEnd = if (number == 8) 8.dp else 0.dp),
                    border = if (numeroPessoas.value == number) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(1.dp, Color(175, 175, 175))
                ) {
                    Column (modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        TextButton(onClick = { numeroPessoas.value = number }
                        ) {
                            Text(text = number.toString(), color = Color.Black)
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Refeições Por Dia",
                style = TextStyle(
                    Color(220,119,38),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp
                )
            )

            Spacer(modifier = Modifier.weight(5f))

        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            (1..6).forEach { number ->
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    colors =  CardDefaults.cardColors(
                        containerColor = if (numeroRefeicoesDia.value == number) Color(255, 241, 221) else Color.White
                    ),
                    shape = RoundedCornerShape(topStart = if (number == 1) 8.dp else 0.dp,
                        bottomStart = if (number == 1) 8.dp else 0.dp,
                        topEnd = if (number == 8) 8.dp else 0.dp,
                        bottomEnd = if (number == 8) 8.dp else 0.dp),
                    border = if (numeroRefeicoesDia.value == number) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(1.dp, Color(175, 175, 175))
                ) {
                    Column (modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        TextButton(onClick = { numeroRefeicoesDia.value = number }
                        ) {
                            Text(text = number.toString(), color = Color.Black)
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Dias Por Semana",
                style = TextStyle(
                    Color(220,119,38),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp
                )
            )

            Spacer(modifier = Modifier.weight(5f))

        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            (1..7).forEach { number ->
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    colors =  CardDefaults.cardColors(
                        containerColor = if (numeroDiasPorSemana.value == number) Color(255, 241, 221) else Color.White
                    ),
                    shape = RoundedCornerShape(topStart = if (number == 1) 8.dp else 0.dp,
                        bottomStart = if (number == 1) 8.dp else 0.dp,
                        topEnd = if (number == 8) 8.dp else 0.dp,
                        bottomEnd = if (number == 8) 8.dp else 0.dp),
                    border = if (numeroDiasPorSemana.value == number) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(1.dp, Color(175, 175, 175))
                ) {
                    Column (modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        TextButton(onClick = { numeroDiasPorSemana.value = number }
                        ) {
                            Text(text = number.toString(), color = Color.Black)
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Dia para a Entrega",
                style = TextStyle(
                    Color(220,119,38),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp
                )
            )

            Spacer(modifier = Modifier.weight(5f))

        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(20.dp))

            val days = listOf("SEGUNDA", "TERCA", "QUARTA", "QUINTA", "SEXTA")
            days.forEach { day ->
                val dayInitial = day[0].toString()
                Card(
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp),
                    shape = RoundedCornerShape(50),
                    colors =  CardDefaults.cardColors(
                        containerColor = if (selectedDay.value == day) Color(255, 241, 221) else Color.White
                    ),
                    border = if (selectedDay.value == day) BorderStroke(2.dp, Color(255, 159, 28)) else BorderStroke(1.dp, Color(140, 140, 140))
                ) {
                    TextButton(onClick = { selectedDay.value = day }) {
                        Text(text = dayInitial, color = Color.Black)
                    }
                }
            }

            Spacer(modifier = Modifier.width(20.dp))
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Horário para a Entrega",
                style = TextStyle(
                    Color(220,119,38),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp
                )
            )

            Spacer(modifier = Modifier.weight(5f))

        }

        Spacer(modifier = Modifier.height(15.dp))

        Column {
            Column(
                modifier = Modifier
                    .width(150.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))

                Box() {
                    TextButton(onClick = { expanded.value = !expanded.value }) {

                        Text(
                            text = if (selectedHorario.value.isNotEmpty()) selectedHorario.value else "Horário",
                            color = if (selectedHorario.value.isNotEmpty()) Color.Black else Color.Gray
                        )
                    }

                }
                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false },
                    modifier = Modifier
                        .background(Color.White)
                        .border(1.dp, Color(160, 160, 160))
                        .height(300.dp)
                ) {
                    horarios.forEach { horario ->
                        DropdownMenuItem(
                            text = { Text(horario, color = Color.Black) },
                            onClick = {
                                selectedHorario.value = horario
                                expanded.value = false
                            }
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(1.dp)
                        .background(color = Color.Black)
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Card (
            modifier = Modifier.fillMaxWidth(0.8f),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            border = BorderStroke(2.dp, Color(228, 228, 228)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ){
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    "Checkout",
                    style = TextStyle(
                        Color(255, 159, 28),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("+ X Refeições")
                    Text("R$00,00")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                ) {
                    drawRoundRect(
                        color = Color(140, 140, 140),
                        cornerRadius = CornerRadius(0f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Total")
                    Text("R$00,00")
                }

                Spacer(modifier = Modifier.height(30.dp))

            }
        }

        Spacer(modifier = Modifier.height(60.dp))


        Row {

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(4, 93, 83, 255),
                    contentColor = Color.White
                )
            ) {
                Text("Descartar Alterações")
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(255, 159, 28),
                    contentColor = Color.White
                )
            ) {
                Text("Salvar Alterações")
            }

            Spacer(modifier = Modifier.weight(1f))

        }

        Spacer(modifier = Modifier.height(40.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun TelaPlanoPreview() {
    CulinartTheme {
        TelaPlano()
    }
}