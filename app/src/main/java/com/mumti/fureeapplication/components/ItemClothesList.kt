package com.mumti.fureeapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.mumti.fureeapplication.ui.theme.Typography
import com.mumti.fureeapplication.ui.theme.primaryTextColor

@Composable
fun ItemClothesList(name: String, imageUrl: String, price: String, onItemClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 20.dp, end = 20.dp, bottom = 15.dp)
            .clickable(onClick = onItemClick)
            .fillMaxWidth(0.5f)
    ) {
        Column {
            ImageClothes(imageUrl = imageUrl)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = name,
                style = Typography.subtitle1,
                color = primaryTextColor)
            Text(
                text = "$ ".plus(price),
                style = Typography.subtitle2,
                color = primaryTextColor)
        }
    }
}

@Composable
fun ImageClothes(imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ItemClothesImage(imageUrl = imageUrl)
    }
}

@Composable
fun ItemClothesImage(imageUrl: String) {
    Card(
        modifier = Modifier
            .background(Color.White),
        shape = RoundedCornerShape(20.dp),
        elevation = 4.dp
    ) {
        Box {
            Image(
                painter = rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        size(OriginalSize)
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
