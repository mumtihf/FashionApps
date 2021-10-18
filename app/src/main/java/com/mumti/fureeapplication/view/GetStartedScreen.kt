package com.mumti.fureeapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mumti.fureeapplication.R
import com.mumti.fureeapplication.navigation.MainActions
import com.mumti.fureeapplication.ui.theme.*

@Composable
fun GetStartedScreen(actions: MainActions) {
    StartScreen(actions)
}

@Composable
fun StartScreen(actions: MainActions) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.horizontalGradient(
                colors = listOf(
                    secondaryTextColor,
                    cardColor
                )
            ))
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterStart)
                .background(Color.Transparent),
            backgroundColor = Color.Transparent,
        ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Start"
            )
        }
        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(30.dp),
            elevation = 4.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                // Heading 1 text
                Text(
                    text = stringResource(id = R.string.heading1),
                    style = Typography.h5,
                    color = primaryTextColor
                )
                Text(
                    text = stringResource(id = R.string.heading2),
                    style = Typography.h5,
                    color = primaryTextColor
                )
                Spacer(modifier = Modifier.height(5.dp))

                // Caption Text
                Text(
                    text = stringResource(id = R.string.caption1),
                    style = Typography.subtitle1,
                    color = primaryTextColor
                )
                Text(
                    text = stringResource(id = R.string.caption2),
                    style = Typography.subtitle1,
                    color = primaryTextColor
                )

                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(0.2f),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(color = Color.DarkGray)
                                .wrapContentSize(Alignment.Center)
                        )
                        Box(
                            modifier = Modifier
                                .size(7.dp)
                                .clip(CircleShape)
                                .background(color = Color.LightGray)
                                .wrapContentSize(Alignment.Center)
                        )
                        Box(
                            modifier = Modifier
                                .size(7.dp)
                                .clip(CircleShape)
                                .background(color = Color.LightGray)
                                .wrapContentSize(Alignment.Center)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Button Start
                OutlinedButton(
                    onClick = {
                        actions.gotoClothesList.invoke()
                    },
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = buttonColor)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.start),
                            style = Typography.button,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
