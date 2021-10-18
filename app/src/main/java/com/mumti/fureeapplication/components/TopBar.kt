package com.mumti.fureeapplication.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mumti.fureeapplication.R

@Composable
fun TopBar() {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        Icon(painter = painterResource(id = R.drawable.ic_baseline_shopping_bag_24), contentDescription = "Add to Chart")
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}