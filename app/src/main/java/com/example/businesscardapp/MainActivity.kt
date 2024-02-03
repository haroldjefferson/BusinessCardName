package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeBusinessCard()
                }
            }
        }
    }
}

@Composable
fun ComposeBusinessCard(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF7DCEA0))
        .padding(16.dp)){
        ComposeIconDescription(
            image = painterResource(R.drawable.android_logo),
            name = stringResource(R.string.name) ,
            title = stringResource(R.string.title),
            modifier = Modifier
                .padding(top = 140.dp)
        )
        Column(modifier = Modifier

            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            ContactInfo(
                icon = painterResource(R.drawable.phone),
                description = stringResource(R.string.phone),

            )
            ContactInfo(
                icon = painterResource(R.drawable.email),
                description = stringResource(R.string.email),
                )
            ContactInfo(
                icon = painterResource(R.drawable.nickname),
                description = stringResource(R.string.nickname),

                )
        }

    }
}

@Composable
fun ContactInfo(icon: Painter, description: String, modifier: Modifier = Modifier){
    Row(modifier = Modifier
         .padding(vertical = 10.dp)
           ) {
            Image(painter = icon, contentDescription = null)
            Text(text = description, color = Color.Black)
    }
}


@Composable
fun ComposeIconDescription(image: Painter, name: String, title:String, modifier: Modifier = Modifier){
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier
            .padding(horizontal = 100.dp)) {
            Image(painter = image,
                contentDescription = null,
                modifier = Modifier
                .background(color = Color(0xFF1C2833))
                    .padding(vertical = 20.dp))

        }
        Text(text = name,
            fontSize = 40.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 2.dp),
            color = Color.Black)
        Text(text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF145A32))

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        ComposeBusinessCard()
    }
}