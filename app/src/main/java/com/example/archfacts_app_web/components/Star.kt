import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R
@Composable
fun StarComponent(
    isMarked: Boolean,
    onToggle: () -> Unit
) {
    val orangeColor = Color(0xFFFFA500) // HEX para laranja

    // Cor da estrela: laranja se marcada, branca se desmarcada
    val starColor = if (isMarked) orangeColor else Color.White

    Icon(
        painter = painterResource(id = R.drawable.baseline_star_24), // Ícone de estrela
        contentDescription = if (isMarked) "Estrela Marcada" else "Estrela Desmarcada",
        tint = starColor,
        modifier = Modifier
            .size(24.dp)
            .clickable { onToggle() }
    )
}

@Preview()
@Composable
fun StarComponentPreview() {
    var isMarked by remember { mutableStateOf(true) }

    StarComponent(
        isMarked = isMarked,
        onToggle = { isMarked = !isMarked } // Alterna o estado ao clicar
    )
}