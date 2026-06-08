package com.example.myapplication.prem

import android.graphics.drawable.Icon
import android.icu.text.CaseMap
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlertDiaEx() {

    var openDialogue by remember { mutableStateOf(true) }

    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = "Delete Iteam!",
                    color = Color.DarkGray,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                IconButton(
                    onClick = { openDialogue = true },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.LightGray
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete Iteam"
                    )
                }
            }
        }

        if (openDialogue) {
            AlertDialog(
                onDismissRequest = { openDialogue = false },

                title = { Text(text = "Delete Item") },

                text = { Text(text = "Are you sure want to delete this iteam?") },

                confirmButton = {
                    Button(
                        onClick = {
                            Toast.makeText(
                                context, "Iteam Delete Sucessfully.", Toast.LENGTH_SHORT
                            ).show()
                            openDialogue = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color.Gray
                        )
                    ) {
                        Text(text = "Delete")
                    }
                },

                dismissButton = {
                    Button(
                        onClick = {
                            openDialogue = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color.LightGray
                        )
                    ) {
                        Text(text = "Cancle")
                    }
                },
                containerColor = Color.White,
                titleContentColor = Color.DarkGray,
                textContentColor = Color.DarkGray
            )
        }
    }
}