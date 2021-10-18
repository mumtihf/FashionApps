package com.mumti.fureeapplication.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mumti.fureeapplication.R
import com.mumti.fureeapplication.components.*
import com.mumti.fureeapplication.model.BottomMenuContent
import com.mumti.fureeapplication.model.Category
import com.mumti.fureeapplication.model.ClothesItem
import com.mumti.fureeapplication.navigation.MainActions
import com.mumti.fureeapplication.ui.theme.*
import com.mumti.fureeapplication.utils.ViewState
import com.mumti.fureeapplication.viewmodel.MainViewModel

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(viewModel: MainViewModel, actions: MainActions) {
    when(val result = viewModel.clothes.value) {
        ViewState.Loading -> Text(text = "Loading")
        is ViewState.Error -> Text(text = "Error found : ${result.exception}")
        is ViewState.Success -> {
            ClothesList(result.data, actions)
        }
        ViewState.Empty -> Text(text = "No results found")
    }
}

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun ClothesList(clothesList: List<ClothesItem>, actions: MainActions) {
    val input = remember {
        mutableStateOf("")
    }

    Box {
        Column {
            TopBar()

            // Search Card
            Box {
                Box(modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Brush.horizontalGradient(
                        colors = listOf(
                            secondaryTextColor,
                            cardColor
                        )
                    ))
                    .padding(16.dp)
                    .fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = "Find the best \n" +
                                    " clothes for you",
                            style = Typography.h5,
                            color = buttonColor
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        SearchInputField(
                            label = stringResource(R.string.search),
                            value = input.value,
                            onValueChanged = {
                                input.value = it
                            })
                    }
                }
            }

            // category title
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            ) {
                Text(
                    text = "Categories",
                    style = Typography.h5,
                    color = primaryTextColor
                )
                Text(
                    text = "View All",
                    style = Typography.subtitle1,
                    color = thirdTextColor
                )
            }

            CategoriesView(
                items = listOf(
                    Category("Clothes", R.drawable.clothes),
                    Category("Shoes", R.drawable.shoes),
                    Category("Bags", R.drawable.bag)
                ),
            )
            
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "New arrivals",
                style = Typography.h5,
                color = primaryTextColor,
                modifier = Modifier.padding(start = 20.dp)
            )

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(clothesList.filter { it.name.contains(input.value, ignoreCase = true) }) { clothes ->
                    ItemClothesList(clothes.name, clothes.imageUrl, clothes.price, onItemClick = {
                        actions.gotoClothesDetails.invoke(clothes.name)
                    })
                }
            }
        }

        BottomMenu(items = listOf(
            BottomMenuContent(R.drawable.ic_outline_home_24),
            BottomMenuContent(R.drawable.ic_outline_favorite_border_24),
            BottomMenuContent(R.drawable.ic_outline_notifications_24),
            BottomMenuContent(R.drawable.ic_outline_person_outline_24)
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}