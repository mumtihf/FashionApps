package com.mumti.fureeapplication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import com.mumti.fureeapplication.ui.theme.*
import com.mumti.fureeapplication.R

@ExperimentalComposeUiApi
@Composable
fun SearchInputField(label: String, value: String, onValueChanged: (String) -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = {
            onValueChanged(it)
        },
        label = { LabelView(title = label) },
        textStyle = Typography.body1,
        colors = com.mumti.fureeapplication.components.textFieldColors(),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        shape = RoundedCornerShape(50),
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_search_24), contentDescription = "Search")
        }
    )

}

@Composable
fun LabelView(title: String) {
    Text(
        text = title,
        style = Typography.caption,
        textAlign = TextAlign.Start,
        color = primaryTextColor
    )
}

@Composable
fun textFieldColors() = textFieldColors(
    textColor = primaryTextColor,
    disabledTextColor = Color.Gray,
    backgroundColor = Color.White,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent
)
