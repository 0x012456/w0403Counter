package kr.ac.kumoh.s20180115

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20180115.ui.theme.W0403CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                Counter()
                Counter()
                Counter()
            }
        }
    }
}

@androidx.compose.runtime.Composable
fun MyApp(content: @Composable () -> Unit) {
    W0403CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Column(modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "${count}", fontSize = 80.sp)

        Row() {
            Button(
                onClick = {
                    count++
                    Log.i("Counter: ", count.toString())
                },
                modifier = Modifier.weight(2f)
            ) {
                Text(text = "증가")
            }
            // Spacer(modifier = Modifier.width(8.dp))
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    if(count>0) count--
                    Log.i("Counter: ", count.toString())
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "감소")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Counter()
}