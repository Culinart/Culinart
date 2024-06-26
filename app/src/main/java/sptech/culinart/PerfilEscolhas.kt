package sptech.culinart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import sptech.culinart.api.data.PreferencesManager
import sptech.culinart.ui.theme.CulinartTheme

class PerfilEscolhas : ComponentActivity() {
    val prefsManager = PreferencesManager.getInstance(this)
    val nome = prefsManager.getName()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CulinartTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (nome != null) {
                        TelaPerfilEscolhas(nome)
                    }
                }
            }
        }
    }
}

@Composable
fun TelaPerfilEscolhas(nome: String, modifier: Modifier = Modifier) {
    ComponenteHeader(name = "Android")
    val contexto = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp)
            .zIndex(1f)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Perfil",
                style = TextStyle(
                    Color(4, 93, 83),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 32.sp
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = nome,
                    style = TextStyle(
                        Color(4, 93, 83),
                        fontWeight = FontWeight.Light,
                        fontSize = 24.sp
                    )
                )

            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(android.graphics.Color.parseColor("#C1CECD")))
            )

            Spacer(modifier = Modifier.height(55.dp))

            Button(
                onClick = {
                    val telaInformacoesPessoais = Intent(contexto, PerfilInformacoesPessoais::class.java)
                    contexto.startActivity(telaInformacoesPessoais)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(46, 196, 182),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Informações Pessoais",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = {
                    val telaSenhaEAutenticacao = Intent(contexto, PerfilSenhaEAutenticacao::class.java)
                    contexto.startActivity(telaSenhaEAutenticacao)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(46, 196, 182),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Senha e Autenticação",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = {
                    val telaMeusEnderecos = Intent(contexto, PerfilEnderecos::class.java)
                    contexto.startActivity(telaMeusEnderecos)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(46, 196, 182),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Meus Endereços",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = {
                    val telaPagamento = Intent(contexto, PerfilPagamento::class.java)
                    contexto.startActivity(telaPagamento)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(46, 196, 182),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Pagamento",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaPerfilEscolhasPreview() {
    CulinartTheme {
        TelaPerfilEscolhas("Android")
    }
}