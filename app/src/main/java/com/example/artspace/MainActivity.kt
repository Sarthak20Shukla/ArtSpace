
package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme() {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var currentStep by remember { mutableStateOf(1) }

        when (currentStep) {
            1 -> {
                LemonTextAndImage(
                    textLabelResourceId1 = R.string.image1, textLabelResourceId2 = R.string.image11,
                    drawableResourceId = R.drawable.image1,
                    contentDescriptionResourceId = R.string.image1,
                    OnButtonClick1 = {
                        currentStep = 2
                    },OnButtonClick2={
                        currentStep=5
                    }
                )
            }
            2 -> {
                // Display lemon image and ask user to squeeze the lemon
                LemonTextAndImage(
                    textLabelResourceId1 = R.string.image2,textLabelResourceId2 = R.string.image22,
                    drawableResourceId = R.drawable.image2,
                    contentDescriptionResourceId = R.string.image2,
                    OnButtonClick1 = {
                        currentStep=3
                    },OnButtonClick2={
                        currentStep=1
                    }
                )
            }
            3 -> {
                LemonTextAndImage(
                    textLabelResourceId1 = R.string.image3,textLabelResourceId2 = R.string.image33,
                    drawableResourceId = R.drawable.image3,
                    contentDescriptionResourceId = R.string.image3,
                    OnButtonClick1 = {

                        currentStep = 4
                    },OnButtonClick2={
                        currentStep=2
                    }
                )
            }
            4 -> {
                LemonTextAndImage(
                    textLabelResourceId1 = R.string.image4,textLabelResourceId2 = R.string.image44,
                    drawableResourceId = R.drawable.image4,
                    contentDescriptionResourceId = R.string.image4,
                    OnButtonClick1 = {
                        currentStep = 5
                    },OnButtonClick2={
                        currentStep=3
                    }
                )
            }
            5->{
                LemonTextAndImage(
                    textLabelResourceId1 = R.string.image5,textLabelResourceId2 = R.string.image55,
                    drawableResourceId = R.drawable.image5,
                    contentDescriptionResourceId = R.string.image5,
                    OnButtonClick1 = {

                        currentStep = 1
                    },
                            OnButtonClick2= {
                                currentStep=4
                    }
                )
            }
            }
        }



@Composable
fun LemonTextAndImage(
    textLabelResourceId1: Int,textLabelResourceId2: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    OnButtonClick1: () -> Unit,
    OnButtonClick2:()->Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = stringResource(contentDescriptionResourceId),
            modifier = Modifier
                .wrapContentSize().padding(start = 15.dp, end = 15.dp, bottom = 10.dp, top = 25.dp)

                .border(
                    BorderStroke(3.dp, Color.DarkGray),
                    shape = RoundedCornerShape(5.dp)

                )
                .shadow(2.dp)
                .padding(25.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = modifier.wrapContentSize()
                .shadow(5.dp).
                padding(20.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(textLabelResourceId1),
                fontSize = 50.sp
            )
            Text(text = stringResource(textLabelResourceId2),
                fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment =Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize().padding(bottom = 35.dp)) {

            Button(onClick = OnButtonClick2) {
                Text(text = "Previous", textAlign = TextAlign.Center, fontSize = 24.sp, modifier = Modifier.width(150.dp))
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = OnButtonClick1) {
                Text(text = "Next", fontSize = 24.sp,textAlign = TextAlign.Center, modifier = Modifier.width(150.dp))
            }
        }
    }
}
@Preview
@Composable
fun ArtSpace() {
    ArtSpaceTheme() {
        ArtSpaceApp()
    }
}