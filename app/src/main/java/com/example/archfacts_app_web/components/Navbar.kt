package com.example.archfacts_app_web.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme
import com.example.archfacts_app_web.ui.theme.Poppins
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavbarCorner(onHamburguerClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .clip(shape = RoundedCornerShape(bottomEnd = 16.dp))
            .background(ArchBlack)
            .clickable { onHamburguerClick() },
        contentAlignment = Alignment.Center
    ) {
        HamburguerMenu()
    }
}
@Composable
fun NavbarVariation() {
    Row(
        modifier = Modifier
            .background(ArchBlack)
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HamburguerMenu()

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo Principal ArchFacts",
            modifier = Modifier.size(70.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.logo_af),
            contentDescription = "Logo com letras 'AF' ArchFacts",
            modifier = Modifier.size(70.dp),
        )
    }
}

@Composable
fun Navbar(modifier: Modifier = Modifier, navActions: NavActions? = null) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(ArchBlack)
            .padding(horizontal = 15.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        Row(verticalAlignment = Alignment.CenterVertically) {
            // Logos
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Principal ArchFacts",
                modifier = Modifier.size(50.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_af),
                contentDescription = "Logo com letras 'AF' ArchFacts",
                modifier = Modifier.size(70.dp),
            )
        }

        Row{

            Text(
                text = "Login",
                fontFamily = Poppins,
                fontWeight = FontWeight.Black,
                color = Color.White,
                modifier = Modifier.clickable {
                    navActions?.navigate(AppRoutes.Login)

                }
            )

            Spacer(
                modifier = modifier.width(20.dp)
            )

            Text(
                text = "Cadastro",
                fontFamily = Poppins,
                fontWeight = FontWeight.Black,
                color = Color.White,
                modifier = Modifier.clickable {
                    navActions?.navigate(AppRoutes.Registro)
                }
            )
            Spacer(
                modifier = modifier.width(50.dp)
            )

        }


    }
}

enum class PerfilUsuario { PRESTADOR, BENEFICIARIO }

// Drawer único e centralizado
//@Composable
//fun AppNavDrawer(
//    perfilUsuario: PerfilUsuario,
//    drawerState: DrawerState,
//    navActions: NavActions,
//    scope: CoroutineScope,
//    content: @Composable (PaddingValues) -> Unit
//) {
//    ModalNavigationDrawer(
//        drawerContent = {
//            when (perfilUsuario) {
//                PerfilUsuario.PRESTADOR -> NavAppPrestador(
//                    onItemClick = { navItem ->
//                        // Centralize os caminhos de navegação aqui!
//                        scope.launch { drawerState.close() }
//                        when (navItem.text) {
//                            "Home" -> navActions.navigate(AppRoutes.GreetingsPrestador)
//                            "Projetos" -> navActions.navigate(AppRoutes.ProjetosPrestador)
//                            // ...etc
//                        }
//                    }
//                )
//                PerfilUsuario.BENEFICIARIO -> NavAppBeneficiario(
//                    onItemClick = { navItem ->
//                        scope.launch { drawerState.close() }
//                        when (navItem.text) {
//                            "Home" -> navActions.navigate(AppRoutes.GreetingsBeneficiario)
//                            "Projetos" -> navActions.navigate(AppRoutes.ProjetosBeneficiario)
//                            // ...etc
//                        }
//                    }
//                )
//                PerfilUsuario.BENEFICIARIO -> TODO()
//            }
//        },
//        drawerState = drawerState
//    ) {
//        content(WindowInsets.navigationBars.asPaddingValues())
//    }
//}

@Preview()
@Composable
fun NavbarPreview() {
    ArchFactsAppWebTheme {
//        Navbar()
//        NavbarVariation()
//        NavbarCorner()
    }
}
