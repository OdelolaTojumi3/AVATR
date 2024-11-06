package com.example.avatr.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.avatr.R

@Composable
fun ModelSelectionScreen(model1: Int, model2: Int, modifier : Modifier = Modifier) {
    var selectedCardIndex by remember { mutableIntStateOf(-1) }


    Column (
        modifier  = Modifier.fillMaxSize().padding( 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){

        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.extra_large_padding)),
            horizontalAlignment = Alignment.Start
        ) {
            Column(
                modifier = Modifier.padding(top = 40.dp),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding)),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Select AI Model", style = MaterialTheme.typography.displayLarge)
                Text(
                    text = "Select an AI image generation model to continue, you \ncan always change this in preferences.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xff494d5a)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding))
            ) {
                ModelOption1(
                    model = model1,
                    isSelected = selectedCardIndex == 0,
                    onClick = { selectedCardIndex = 0 }
                )

                ModelOption2(model = model2,
                    isSelected = selectedCardIndex == 1,
                    onClick = { selectedCardIndex = 1 }
                )
            }
        }

        Button(text = R.string.lets_go)
    }
}

@Composable
private fun ModelOption1(model: Int, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(width = 2.dp, Color.Black, shape = RoundedCornerShape(8.dp))
            .width(dimensionResource(id = R.dimen.button_width))
            .height(dimensionResource(id = R.dimen.button_height)),
        colors = CardDefaults.cardColors(containerColor = Color.Black, contentColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(model),
                style = MaterialTheme.typography.bodyMedium
            )

            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
private fun ModelOption2(model: Int, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(2.dp, Color(0xffdfe0e0), shape = RoundedCornerShape(8.dp))
            .width(dimensionResource(id = R.dimen.button_width))
            .height(dimensionResource(id = R.dimen.button_height)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(model),
                style = MaterialTheme.typography.bodyMedium
            )

            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}