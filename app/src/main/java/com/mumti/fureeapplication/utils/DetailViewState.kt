package com.mumti.fureeapplication.utils

import com.mumti.fureeapplication.model.ClothesItem

sealed class DetailViewState {
    object Empty: DetailViewState()
    object Loading: DetailViewState()
    data class Success(val data: ClothesItem) : DetailViewState()
    data class Error(val exception: Throwable) : DetailViewState()
}
