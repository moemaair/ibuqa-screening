package com.ibuqa.screening.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            .padding(10.dp)){
            // Content of the box
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Today",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.headlineLarge)
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.Settings, contentDescription = "")

                }

            }
            Text(text = day.formattedDate,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(35.dp))

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