package com.example.appwithviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appwithviewmodel.ui.theme.AppwithviewmodelTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppwithviewmodelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@Composable
fun Greeting2() {
Column(modifier= Modifier
    .fillMaxWidth()
    .padding(30.dp)) {
    var textValue by remember{
        mutableStateOf("UnChecked")
    }
    CoustomTextField(modifier=Modifier.fillMaxWidth().height(90.dp),
    onTextChange = {

    })
    CheckBoxComponent({checkState->
        if(checkState==true) {
            textValue = "Checked"
        }else{
            textValue="UnChecked"
        }
    })
    Text(text = textValue)
}
}
@Composable
fun CheckBoxComponent(
    isCheck:(Boolean)->Unit
){
    var isCheckBoxChecked by remember{
        mutableStateOf(false)
    }
    Checkbox(checked=isCheckBoxChecked, onCheckedChange ={
        isCheckBoxChecked=it
        isCheck.invoke(it)
    })
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoustomTextField(
    modifier : Modifier=Modifier,
    onTextChange:(String)->Unit
){

    var textValue by remember{
        mutableStateOf("")
    }
    OutlinedTextField(modifier = modifier, value = textValue, onValueChange = {
        textValue=it
        onTextChange(it)
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AppwithviewmodelTheme {
        Greeting2()
    }
}