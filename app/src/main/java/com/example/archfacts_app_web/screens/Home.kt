package com.example.archfacts_app_web.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.archfacts_app_web.PartnerCompaniesScreen
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.screens.Proposal1.EnvioPropostaScreen
import com.example.archfacts_app_web.ui.theme.ArchFactsAppWebTheme

@Composable
fun HomeScreen() {
}

@Preview(name = "Hero Section", showBackground = true)
@Composable
fun HeroSectionPreview2() {
    HeroSection()
}

@Preview(name = "Problem Section", showBackground = true)
@Composable
fun ProblemSectionPreview2() {
    ProblemSection()
}

@Preview(name = "Solution Section", showBackground = true)
@Composable
fun SolutionSectionPreview2() {
    SolutionSection()
}

@Preview(name = "Role Section", showBackground = true)
@Composable
fun RoleSectionPreview2() {
    RoleSection()
}

@Preview(name = "Contact Section", showBackground = true)
@Composable
fun ContactSectionPreview2() {
    ContactSection()
}

@Preview(name = "Footer Section", showBackground = true)
@Composable
fun FooterSectionPreview2() {
    FooterSection()
}

@Preview(name = "Enterprise Section", showBackground = true)
@Composable
fun Proposal1Preview2() {
    EnvioPropostaScreen(
        negocioNome = "Volkswagen",
        logo = R.drawable.archfacts,
        mediaAvaliacoes = 6,
        servicosTotais = 55
    )
}

@Preview
@Composable
fun PartnerPreview() {
    PartnerCompaniesScreen()
}



//@Preview(showBackground = true)
//@Composable
//private fun HomeScreenPreview() {
//    ArchFactsAppWebTheme {
//        Column {
//            HeroSectionPreview()
//            ProblemSectionPreview()
//            SolutionSectionPreview()
//            RoleSectionPreview()
//            ContactSectionPreview()
//            FooterSectionPreview()
//        }
//    }
