package com.example.myapplication.prem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StateManagementEx() {

    // remember keeps this value during recomposition

    // mutableState of hold a value that can change
    // & triggers re composition when the value is changes

    var score by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Score: $score", fontSize = 30.sp)
        Row() {
            Button(
                onClick = {
                    score++
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Increase")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    score--
                },
                modifier = Modifier.weight(1f),
                enabled = score > 0
            ) {
                Text(text = "Decrease")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RememberSavableExample() {

    // rememberSaveable saves the state during configration changes
    var score by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Score: $score", fontSize = 30.sp)
        Row() {
            Button(
                onClick = {
                    score++
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Increase")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    score--
                },
                modifier = Modifier.weight(1f),
                enabled = score > 0
            ) {
                Text(text = "Decrease")
            }
        }
    }
}

@Composable
fun StateHoistingParents() {
    var score by remember { mutableStateOf(0) }
    CounterChild(
        score = score,
        increment = { score++ },
        decrement = { score-- }
    )
}

@Composable
fun CounterChild(
    score: Int,
    increment: () -> Unit,
    decrement: () -> Unit
) {
    var score by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Score: $score", fontSize = 30.sp)
        Row() {
            Button(
                onClick = { increment() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Increase")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { decrement() },
                modifier = Modifier.weight(1f),
                enabled = score > 0
            ) {
                Text(text = "Decrease")
            }
        }
    }
}