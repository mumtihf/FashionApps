package com.mumti.fureeapplication.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mumti.fureeapplication.model.ClothesItem
import com.mumti.fureeapplication.utils.DetailViewState
import com.mumti.fureeapplication.utils.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    private val _detailViewState = MutableStateFlow<DetailViewState>(DetailViewState.Loading)

    val clothes = _viewState.asStateFlow()
    val clothesDetail = _detailViewState.asStateFlow()

    // help format json
    private val format = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }

    // get all data from json file
    fun getAllClothes(context: Context) = viewModelScope.launch {
        try {
            // read json file
            val json = context.assets.open("ClothesResponses.json").bufferedReader().use {
                it.readText()
            }
            // format json
            val clothesList = format.decodeFromString<List<ClothesItem>>(json)
            _viewState.value = ViewState.Success(clothesList)
        } catch (e: Exception) {
            _viewState.value = ViewState.Error(e)
        }
    }

    // get clothes by name
    fun getClothesByName(context: Context, name: String) = viewModelScope.launch {
        try {
            // read json file
            val json = context.assets.open("ClothesResponses.json").bufferedReader().use {
                it.readText()
            }
            // format json
            val clothesList = format.decodeFromString<List<ClothesItem>>(json)
                .filter {
                    it.name.contentEquals(name)
                }
                .first()
            _detailViewState.value = DetailViewState.Success(clothesList)
        } catch (e: Exception) {
            _detailViewState.value = DetailViewState.Error(e)
        }
    }
}