package com.mumti.fureeapplication.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.mumti.fureeapplication.components.ClothesDetail
import com.mumti.fureeapplication.navigation.MainActions
import com.mumti.fureeapplication.utils.DetailViewState
import com.mumti.fureeapplication.utils.ViewState
import com.mumti.fureeapplication.viewmodel.MainViewModel

@Composable
fun DetailScreen(viewModel: MainViewModel) {

    when(val resultDetail = viewModel.clothesDetail.value) {
        DetailViewState.Loading -> Text(text = "Loading")
        is DetailViewState.Error -> Text(text = "Error found : ${resultDetail.exception}")
        is DetailViewState.Success -> {
            val clothes = resultDetail.data
            ClothesDetail(clothes.name, clothes.imageUrl, clothes.price, clothes.longDescription, clothes.store, clothes.sizeChart)
        }
        DetailViewState.Empty -> Text(text = "No results found")
    }
}