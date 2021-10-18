package com.mumti.fureeapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mumti.fureeapplication.model.Category
import com.mumti.fureeapplication.ui.theme.*

@Composable
fun CategoriesView(
    items: List<Category>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = secondaryTextColor,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        items.forEachIndexed { index, category ->
            ItemCategory(
                item = category,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun ItemCategory(
    item: Category,
    isSelected: Boolean = false,
    activeHighlightColor: Color = buttonColor,
    onItemClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .height(40.dp)
            .clickable {
                onItemClick()
            }
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .border(1.dp, Color.LightGray),
            elevation = if (isSelected) 20.dp else 5.dp
        ) {
            Surface(
                shape = RoundedCornerShape(50)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(if (isSelected) activeHighlightColor else Color.Transparent)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(50))
                ) {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "Category",
                        tint = if (isSelected) Color.White else buttonColor
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = item.title,
                        style = Typography.body2,
                        color = if (isSelected) Color.White else primaryTextColor
                    )
                }
            }
        }
    }
}
