package com.example.unitconverterapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt

@Composable
fun  AreaConversion(){
      Column(modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            var inputValue by remember { mutableStateOf("") }
            var outputValue by remember { mutableStateOf("0.0") }
            var inputUnit by remember { mutableStateOf("m²") }
            var outputUnit by remember { mutableStateOf("m²") }
            var iexpand by remember { mutableStateOf(false) }
            var oexpand by remember { mutableStateOf(false) }
            var  iconversion= remember { mutableStateOf(1.0) }
            var oconversion= remember{ mutableStateOf(1.0) }

            fun convert(){
                  val inputValueDouble=inputValue.toDoubleOrNull() ?:0.0000
                  val result=(inputValueDouble*iconversion.value*100.0000/oconversion.value)/100.0000
                  val res= BigDecimal(result).setScale(12, RoundingMode.HALF_EVEN)
//                  result=BigDecimal(3.14159265359).setScale(2, RoundingMode.HALF_EVEN)
                  outputValue=res.toString()
            }

            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id =R.drawable.area), contentDescription = "Length",modifier= Modifier
                  .height(150.dp)
                  .width(150.dp)
                  .padding(16.dp))
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Area Conversion", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(value = inputValue, onValueChange = {inputValue=it
                  convert()},
                  label = { Text(text = "Enter Value") },
                  keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
            Spacer(modifier = Modifier.height(16.dp))

            Row {

                  Box(modifier = Modifier)
                  {
                        Button(onClick = { iexpand=true}) {
                              Text(text =inputUnit, fontSize = 18.sp, modifier = Modifier.padding(4.dp))
                              Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down",modifier= Modifier )
                              DropdownMenu(expanded = iexpand, onDismissRequest = { iexpand=false }) {
                                    DropdownMenuItem(
                                          text = { Text(text = "Square Metre (m²)") },
                                          onClick = {
                                                inputUnit="m²"
                                                iconversion.value=1.0000
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Square Centimetre (cm²)") },
                                          onClick = {
                                                inputUnit="cm²"
                                                iconversion.value=0.0001
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Square Kilometre (km²)") },
                                          onClick = {
                                                inputUnit=" km²"
                                                iconversion.value=1000000.0000
                                                iexpand=false
                                                convert() })
                                    DropdownMenuItem(
                                          text = { Text(text = "Square feet (ft²)") },
                                          onClick = {
                                                inputUnit=" ft²"
                                                iconversion.value=0.0929
                                                iexpand=false
                                                convert() })
                                    DropdownMenuItem(
                                          text = { Text(text = "Acres") },
                                          onClick = {
                                                inputUnit=" Acres"
                                                iconversion.value=4046.8564
                                                iexpand=false
                                                convert() })
                                    DropdownMenuItem(
                                          text = { Text(text = "Hectares") },
                                          onClick = {
                                                inputUnit=" Hectares"
                                                iconversion.value=10000.00
                                                iexpand=false
                                                convert() })
                              }
                        }
                  }

                  Spacer(modifier = Modifier.width(8.dp))

                  Box(modifier = Modifier)
                  {
                        Button(onClick = { oexpand=true }) {
                              Text(text = outputUnit, fontSize = 18.sp, modifier = Modifier.padding(4.dp))
                              Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down",modifier= Modifier )
                              DropdownMenu(expanded = oexpand, onDismissRequest = { oexpand=false }) {
                                    DropdownMenuItem(
                                          text = { Text(text = "Square Metre (m²)") },
                                          onClick = {
                                                outputUnit="m²"
                                                oconversion.value=1.0000
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Square Centimetre (cm²)") },
                                          onClick = {
                                                outputUnit="cm²"
                                                oconversion.value=0.0001
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Square Kilometre (km²)") },
                                          onClick = {
                                                outputUnit=" km²"
                                                oconversion.value=1000000.0000
                                                oexpand=false
                                                convert()
                                          })

                                    DropdownMenuItem(
                                          text = { Text(text = "Square Feet (ft²)") },
                                          onClick = {
                                                outputUnit=" ft²"
                                                oconversion.value=0.00929
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Acres") },
                                          onClick = {
                                                outputUnit=" Acres"
                                                oconversion.value=4046.8544
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text =  "Hectares") },
                                          onClick = {
                                                outputUnit="Hectares"
                                                oconversion.value=10000.0000
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

            Box(modifier =Modifier.wrapContentSize()
                  . border(border = BorderStroke(4.dp, Color(0XFF018786)), shape = RoundedCornerShape(10)
                  )
                  .align(Alignment.CenterHorizontally)){
                  Text(text = "Result: $outputValue $outputUnit", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(8.dp))

            }
      }
}

