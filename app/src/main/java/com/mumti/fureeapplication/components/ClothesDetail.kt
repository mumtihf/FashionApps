package com.mumti.fureeapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mumti.fureeapplication.R
import com.mumti.fureeapplication.ui.theme.*

@Composable
fun ClothesDetail(
    name: String,
    imageUrl: String,
    price: String,
    longDescription: String,
    store: String,
    sizeChart: List<String>
) {
    Surface {
        LazyColumn {
            item {
                ImageItem(imageUrl)
            }

            item {
                Spacer(modifier = Modifier.height(5.dp))
                StoreInfo(store)
            }
            item {
                ClothesInfo(name, longDescription)
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 20.dp)
                ){
                    Text(
                        text = stringResource(id = R.string.size),
                        style = Typography.h6,
                        color = primaryTextColor
                    )

                }
            }
            item {
                SelectSize(sizeChart = sizeChart)
            }
            item {
                ButtonAdd(price)
            }
        }
    }
}

@Composable
fun ImageItem(imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        ImageCard(imageUrl)
    }
}

@Composable
fun ImageCard(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = 4.dp
    ) {
        Box(
            modifier = modifier.height(400.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = imageUrl,
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
                        contentDescription = "Favorite",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_shopping_bag_24), 
                        contentDescription = "Cart",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun StoreInfo(store: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.TopStart)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(secondaryTextColor)
                    .wrapContentSize(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_sentiment_very_satisfied_24),
                    contentDescription = "Store"
                )
            }
            
            Spacer(modifier = Modifier.width(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = store,
                        style = Typography.overline,
                        color = primaryTextColor
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = stringResource(id = R.string.store),
                        style = Typography.caption,
                        color = primaryTextColor
                    )
                }
                Card(
                    modifier = Modifier
                        .border(1.dp, greenColor, RoundedCornerShape(50))
                        .padding(8.dp)
                        .clip(RoundedCornerShape(50))
                        .wrapContentSize(Alignment.Center),
                ) {
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(25.dp)
                                .clip(CircleShape)
                                .background(color = greenColor)
                                .wrapContentSize(Alignment.Center)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_done_24),
                                contentDescription = "Follow"
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Following",
                            style = Typography.caption,
                            color = greenColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ClothesInfo(name: String, longDescription: String) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = name,
            style = Typography.h6,
            color = primaryTextColor
        )
        Text(
            text = longDescription,
            style = Typography.caption,
            color = primaryTextColor
        )
    }
}

@Composable
fun SelectSize(
    sizeChart: List<String>,
    activeHighlightColor: Color = thirdTextColor,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        modifier = Modifier
            .padding(start = 20.dp)
            .wrapContentSize(Alignment.TopStart)
            .fillMaxWidth()
    ) {
        sizeChart.forEachIndexed { index, s ->
            Size(
                size = s,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor
            ) {
                selectedItemIndex = index
            }
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}

@Composable
fun Size(
    size: String,
    isSelected: Boolean = false,
    activeHighlightColor: Color = thirdTextColor,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .clickable {
                onItemClick()
        }
    ) {
        Card(
            modifier = Modifier
                .border(1.dp, Color.LightGray, CircleShape)
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(8.dp)
                .size(25.dp)
                .clip(CircleShape)
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = size,
                style = Typography.button,
                color = primaryTextColor,
                modifier = Modifier
                    .background(if (isSelected) activeHighlightColor else Color.Transparent)
            )
        }
    }
}

@Composable
fun ButtonAdd(
    price: String,
    sectionHeight: Dp = 20.dp
) {
    OutlinedButton(
        onClick = { },
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = buttonColor)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "$ ".plus(price),
                style = Typography.button,
                color = Color.White
            )
            Spacer(modifier = Modifier
                .size(1.dp, sectionHeight)
                .background(Color.LightGray)
            )
            Text(
                text = stringResource(id = R.string.add),
                style = Typography.button,
                color = Color.White
            )
        }
    }
}