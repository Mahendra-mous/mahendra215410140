package com.example.mahendra215410140

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mahendra215410140.ui.theme.Mahendra215410140Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mahendra215410140Theme {
                ContentScreen()
            }
        }
    }
}

data class Item(val imageRes: Int, val text: String)

@Composable
fun ContentScreen() {
    val items = listOf(
        Item(R.drawable.image1, "Power Ranger Merah"),
        Item(R.drawable.image2, "Power Ranger Putih"),
        Item(R.drawable.image3, "Power Ranger Biru")
    )

    var currentIndex by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(350.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = item.text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(

                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (currentIndex > 0) {
                                currentIndex--
                            } else {
                                currentIndex = items.size - 1
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Previous")
                    }

                    Button(
                        onClick = {
                            if (currentIndex < items.size - 1) {
                                currentIndex++
                            } else {
                                currentIndex = 0
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Next")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentScreenPreview() {
    ContentScreen()
}
