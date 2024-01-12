package com.example.unitconverterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background ){
                }
            }
        }
    }
}

@Composable
fun  UnitConverter(){
    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        var inputValue by remember { mutableStateOf("") }
        var outputValue by remember { mutableStateOf("") }
        var inputUnit by remember { mutableStateOf("Meters") }
        var outputUnit by remember { mutableStateOf("Meters") }
        var iexpand by remember { mutableStateOf(false) }
        var oexpand by remember { mutableStateOf(false) }
        var  iconversion= remember { mutableStateOf(1.0) }
        var oconversion=remember{ mutableStateOf(1.0) }

        fun convert(){
        val inputValueDouble=inputValue.toDoubleOrNull() ?:0.0
            val result=(inputValueDouble*iconversion.value*100.0/oconversion.value).roundToInt()/100.0
            outputValue=result.toString()
        }

        Text(text = "Unit Converter", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {inputValue=it
            convert()},
            label = { Text(text = "Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))

        Row {

            Box(modifier = Modifier)
            {
                Button(onClick = { iexpand=true}) {
                    Text(text =inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down",modifier=Modifier )
                    DropdownMenu(expanded = iexpand, onDismissRequest = { iexpand=false }) {
                        DropdownMenuItem(
                            text = { Text(text = "Meter")},
                            onClick = {
                                inputUnit="Meter"
                                iconversion.value=1.0
                                iexpand=false
                                convert()
                            })
                        DropdownMenuItem(
                            text = { Text(text = "Centimeter")},
                            onClick = {
                                inputUnit="Centimeter"
                                iconversion.value=0.01
                                iexpand=false
                                convert()
                            })
                        DropdownMenuItem(
                            text = { Text(text = "Millimeter")},
                            onClick = {
                                inputUnit="Milimeter"
                                iconversion.value=0.001
                                iexpand=false
                                convert() })
                        DropdownMenuItem(
                            text = { Text(text = "Decimeter")},
                            onClick = {
                                inputUnit="Decimeter"
                                iconversion.value=0.1
                                iexpand=false
                                convert()
                            })
                        DropdownMenuItem(
                            text = { Text(text = "Kilometer")},
                            onClick = {
                                inputUnit="Kilometer"
                                iconversion.value=1000.0
                                iexpand=false
                                convert() })
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(modifier = Modifier)
            {
                Button(onClick = { oexpand=true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down",modifier=Modifier )
                    DropdownMenu(expanded = oexpand, onDismissRequest = { oexpand=false }) {
                        DropdownMenuItem(
                            text = { Text(text = "Meter")},
                            onClick = {
                                outputUnit="Meter"
                                oconversion.value=1.0
                                oexpand=false
                                convert()
                            })
                        DropdownMenuItem(
                            text = { Text(text = "Centimeter")},
                            onClick = {
                                outputUnit="Centimeter"
                                oconversion.value=0.01
                                oexpand=false
                                convert()
                            })
                        DropdownMenuItem(
                            text = { Text(text = "Millimeter")},
                            onClick = {
                                outputUnit="Milimeter"
                                oconversion.value=0.001
                                oexpand=false
                                convert()
                            })
                        DropdownMenuItem(
                            text = { Text(text = "Decimeter")},
                            onClick = {
                                outputUnit="Decimeter"
                                oconversion.value=0.1
                                oexpand=false
                                convert()
                            })
                        DropdownMenuItem(
                            text = { Text(text = "Kilometer")},
                            onClick = {
                                outputUnit="Kilometer"
                                oconversion.value=1000.0
                                oexpand=false
                                convert()
                            })
                    }
                }
            }



//            val context= LocalContext.current
//            Button(onClick = { Toast.makeText(context,
//                "Thanks  for clicking!",Toast.LENGTH_LONG).show() }) {
//                Text(text="Click  Me!")
//            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $outputValue $outputUnit", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview (showBackground=true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}