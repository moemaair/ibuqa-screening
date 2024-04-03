package com.ibuqa.screening.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibuqa.screening.data.FormattedDate
import com.ibuqa.screening.ui.theme.IbuqascreeningTheme
@Composable
fun SearchAndFilterScreen() {

    val day = FormattedDate()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            // This will make the box occupy 1/4th of the entire height
            .background(Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)){
            // Content of the box
            Text(text = "Today",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.headlineLarge)

            Text(text = day.formattedDate,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(40.dp))
            //TextField(value = "", onValueChange = {})

        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchAndFilterScreenPreview() {
    IbuqascreeningTheme {
        SearchAndFilterScreen()
    }
}