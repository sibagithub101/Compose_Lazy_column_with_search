package com.siba.myapplication.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.siba.myapplication.ui.theme.PrimaryRedColor
import com.siba.myapplication.ui.theme.WhiteColor

@Composable
fun CustomPopUpMessage(
    warningDesc: String = "",
    onClick: () -> Unit,
    showNoNetworkDialog: MutableState<Boolean>
) {
    Dialog(onDismissRequest = {
        showNoNetworkDialog.value = false
    }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = WhiteColor,
            modifier = Modifier.border(
                width = 2.dp,
                shape = RoundedCornerShape(16.dp),
                color = PrimaryRedColor
            )
        ) {
            Box(contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    androidx.compose.material3.Text(
                        text = warningDesc,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        ),
                        textAlign = TextAlign.Justify
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Box(
                        modifier = Modifier.padding(
                            horizontal = 30.dp
                        )
                    ) {
                        Column {
                            Button(onClick = {
                                onClick.invoke()
                            }) {
                                Text(text = "OK")
                            }
                        }
                    }
                }
            }
        }
    }

}