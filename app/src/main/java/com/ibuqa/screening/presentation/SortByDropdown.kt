package com.ibuqa.screening.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun DropdownSortBy() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("ealiest", "latest")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier
        .pointerInput(Unit) {
            detectTapGestures { offset ->
                // Check if the tap is outside the dropdown menu
                if (offset.x < 0 || offset.y < 0 || offset.x > 200 || offset.y > 50) {
                    expanded = false
                }
            }
        }

    ) {
        Text(items[selectedIndex],modifier = Modifier
            .clickable(onClick = { expanded = true })
            .background(
                Color.Black
            ))
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(
                    Color.White
                )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    Text(text = s)
                }
            }
        }
    }
}


@Composable
fun DropdownState() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("open", "close", "unknown")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier
        .pointerInput(Unit) {
            detectTapGestures { offset ->
                // Check if the tap is outside the dropdown menu
                if (offset.x < 0 || offset.y < 0 || offset.x > 200 || offset.y > 50) {
                    expanded = false
                }
            }
        }) {
        Text(items[selectedIndex],modifier = Modifier
            .clickable(onClick = { expanded = true })
            .background(
                Color.Black
            ))
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(
                    Color.White
                )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    Text(text = s)
                }
            }

        }
    }
}
