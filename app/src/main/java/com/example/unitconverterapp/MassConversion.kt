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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt

@Composable
fun  MassConversion(){
      Column(modifier= Modifier.fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally) {

            var inputValue by remember { mutableStateOf("") }
            var outputValue by remember { mutableStateOf("0.0") }
            var inputUnit by remember { mutableStateOf("g") }
            var outputUnit by remember { mutableStateOf("g") }
            var iexpand by remember { mutableStateOf(false) }
            var oexpand by remember { mutableStateOf(false) }
            var  iconversion= remember { mutableStateOf(1.0000) }
            var oconversion= remember{ mutableStateOf(1.0000) }

            fun convert(){
                  val inputValueDouble=inputValue.toDoubleOrNull() ?:0.0000
                  val result=(inputValueDouble*iconversion.value*100.0000/oconversion.value)/100.0000
                  val res=BigDecimal(result).setScale(7,RoundingMode.HALF_EVEN)
//                  result=BigDecimal(3.14159265359).setScale(2, RoundingMode.HALF_EVEN)
                  outputValue=res.toString()
            }

            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id =R.drawable.mass), contentDescription = "Length",modifier= Modifier
                  .height(150.dp)
                  .width(150.dp)
                  .padding(16.dp))
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Mass Conversion", style = MaterialTheme.typography.headlineLarge)
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
                                          text = { Text(text = "Gram (g)") },
                                          onClick = {
                                                inputUnit="g"
                                                iconversion.value=1.0000
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Centigram (cg)") },
                                          onClick = {
                                                inputUnit="cg"
                                                iconversion.value=0.0100
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Milligram (mg)") },
                                          onClick = {
                                                inputUnit="mg"
                                                iconversion.value=0.0010
                                                iexpand=false
                                                convert() })
                                    DropdownMenuItem(
                                          text = { Text(text = "Decigram (dg)") },
                                          onClick = {
                                                inputUnit="dg"
                                                iconversion.value=0.1000
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Kilogram (Kg)") },
                                          onClick = {
                                                inputUnit="Kg"
                                                iconversion.value=1000.0000
                                                iexpand=false
                                                convert() })
                                    DropdownMenuItem(
                                          text = { Text(text = "Pound (lb)") },
                                          onClick = {
                                                inputUnit="lb"
                                                iconversion.value=453.5920
                                                iexpand=false
                                                convert()
                                          })
                              }
                        }
                  }

                  Spacer(modifier = Modifier.width(16.dp))

                  Box(modifier = Modifier)
                  {
                        Button(onClick = { oexpand=true }) {
                              Text(text = outputUnit, fontSize = 18.sp, modifier = Modifier.padding(4.dp))
                              Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down",modifier= Modifier )
                              DropdownMenu(expanded = oexpand, onDismissRequest = { oexpand=false }) {
                                    DropdownMenuItem(
                                          text = { Text(text = "Gram (g)") },
                                          onClick = {
                                                outputUnit="g"
                                                oconversion.value=1.0
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Centigram (cg)") },
                                          onClick = {
                                                outputUnit="cg"
                                                oconversion.value=0.0100
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Milligram (mg)") },
                                          onClick = {
                                                outputUnit="mg"
                                                oconversion.value=0.0010
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Decigram (dg)") },
                                          onClick = {
                                                outputUnit="dg"
                                                oconversion.value=0.1000
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Kilogram (Kg)") },
                                          onClick = {
                                                outputUnit="kg"
                                                oconversion.value=1000.0000
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Pound (lb)") },
                                          onClick = {
                                                outputUnit="lb"
                                                oconversion.value=453.5920
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
                  . border(border = BorderStroke(4.dp, Color(0XFF018786)),
                        shape = RoundedCornerShape(10))
                  .align(Alignment.CenterHorizontally)){
                  Text(text = "Result: $outputValue $outputUnit", style = MaterialTheme.typography.headlineMedium,modifier = Modifier.padding(8.dp))

            }
      }
}