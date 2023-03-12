package com.atidevs.composing

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atidevs.composing.ui.theme.ComposingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposingTheme {
                Surface {
                    MessageCard(
                        msg = Message(
                            author = "Atmane",
                            body = "Hey there it's me. I am learning jetpack compose!"
                        )
                    )
                }
            }
        }
    }

    @Composable
    fun MessageCard(
        msg: Message
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "${msg.author} Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RectangleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, RectangleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface {

                }
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }

    data class Message(val author: String, val body: String)


    @Preview(name = "Light Mode Message Card")
    @Preview(name = "Dark Mode Message Card", uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun PreviewMessageCard() {
        ComposingTheme {
            Surface {
                MessageCard(msg = Message("Atmane", "Hey there! How are you?"))
            }
        }
    }
}
