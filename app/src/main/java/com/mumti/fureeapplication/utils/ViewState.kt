package com.mumti.fureeapplication.utils

import com.mumti.fureeapplication.model.ClothesItem

sealed class ViewState {
    object Empty : ViewState()
    object Loading : ViewState()
    data class Success(val data: List<ClothesItem>) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}
