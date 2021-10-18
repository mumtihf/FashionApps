package com.mumti.fureeapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mumti.fureeapplication.ui.theme.Shapes
import com.mumti.fureeapplication.ui.theme.Typography
import com.mumti.fureeapplication.ui.theme.primaryTextColor

@Composable
fun ItemClothesList(name: String, imageUrl: String, price: String, onItemClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 20.dp, end = 20.dp)
            .clickable(onClick = onItemClick)
            .fillMaxWidth(0.5f)
    ) {
        Column {
            ItemClothesImage(imageUrl)
            Text(
                text = name,
                style = Typography.subtitle1,
                color = primaryTextColor)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "$ ".plus(price),
                style = Typography.subtitle2,
                color = primaryTextColor)
        }
    }
}

@Composable
fun ItemClothesImage(imageUrl: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.White)
            .clip(shape = Shapes.large)
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
            ),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
        )
    }
}
