package com.mumti.fureeapplication.navigation

import androidx.annotation.StringRes
import com.mumti.fureeapplication.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object GetStarted : Screen ("get_started", R.string.text_getStarted)
    object ClothesList : Screen("clothes_list", R.string.text_clothesList)
    object Details : Screen("clothes_details", R.string.text_clothesDetails)
}