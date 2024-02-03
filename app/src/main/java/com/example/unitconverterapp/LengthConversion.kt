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
fun  LengthConversion(){
      Column(modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            var inputValue by remember { mutableStateOf("") }
            var outputValue by remember { mutableStateOf("0.0") }
            var inputUnit by remember { mutableStateOf("m") }
            var outputUnit by remember { mutableStateOf("m") }
            var iexpand by remember { mutableStateOf(false) }
            var oexpand by remember { mutableStateOf(false) }
            var  iconversion= remember { mutableStateOf(1.0) }
            var oconversion= remember{ mutableStateOf(1.0) }

            fun convert(){
                  val inputValueDouble=inputValue.toDoubleOrNull() ?:0.0000
                  val result=(inputValueDouble*iconversion.value*100.0000/oconversion.value)/100.0000
                  val res= BigDecimal(result).setScale(7, RoundingMode.HALF_EVEN)
//                  result=BigDecimal(3.14159265359).setScale(2, RoundingMode.HALF_EVEN)
                  outputValue=res.toString()
            }

            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id =R.drawable.length), contentDescription = "Length",modifier= Modifier
                  .height(150.dp)
                  .width(150.dp)
                  .padding(16.dp))
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Length Conversion", style = MaterialTheme.typography.headlineLarge)
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
                                          text = { Text(text = "Feet (ft)") },
                                          onClick = {
                                                inputUnit="ft"
                                                iconversion.value=0.3048
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "inches (in)") },
                                          onClick = {
                                                inputUnit="in"
                                                iconversion.value=0.0254
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Yard (yd)") },
                                          onClick = {
                                                inputUnit="yd"
                                                iconversion.value=0.9144
                                                iexpand=false
                                                convert()
                                          })

                                    DropdownMenuItem(
                                          text = { Text(text = "Metre (m)") },
                                          onClick = {
                                                inputUnit="m"
                                                iconversion.value=1.0000
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Centimetre (cm)") },
                                          onClick = {
                                                inputUnit="cm"
                                                iconversion.value=0.0100
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Millimetre (mm)") },
                                          onClick = {
                                                inputUnit="mm"
                                                iconversion.value=0.0010
                                                iexpand=false
                                                convert() })
                                    DropdownMenuItem(
                                          text = { Text(text = "Decimetre (dm)") },
                                          onClick = {
                                                inputUnit="dm"
                                                iconversion.value=0.1000
                                                iexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Kilometre (Km)") },
                                          onClick = {
                                                inputUnit="Km"
                                                iconversion.value=1000.0000
                                                iexpand=false
                                                convert() })
                                    DropdownMenuItem(
                                          text = { Text(text = "Mile (mi)") },
                                          onClick = {
                                                inputUnit="mi"
                                                iconversion.value=1609.344
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
                                          text = { Text(text = "Feet (ft)") },
                                          onClick = {
                                                outputUnit="ft"
                                                oconversion.value=0.3048
                                                oexpand=false
                                                convert()
                                          })

                                    DropdownMenuItem(
                                          text = { Text(text = "Inches (in)") },
                                          onClick = {
                                                outputUnit="in"
                                                oconversion.value=0.0254
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Yard (yd)") },
                                          onClick = {
                                                outputUnit="yd"
                                                oconversion.value=0.9144
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Metre (m)") },
                                          onClick = {
                                                outputUnit="m"
                                                oconversion.value=1.0000
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Centimetre (cm)") },
                                          onClick = {
                                                outputUnit="cm"
                                                oconversion.value=0.0100
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Millimetre (mm)") },
                                          onClick = {
                                                outputUnit="mm"
                                                oconversion.value=0.0010
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Decimetre (dm)") },
                                          onClick = {
                                                outputUnit="dm"
                                                oconversion.value=0.1000
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Kilometre (Km)") },
                                          onClick = {
                                                outputUnit="Km"
                                                oconversion.value=1000.0000
                                                oexpand=false
                                                convert()
                                          })
                                    DropdownMenuItem(
                                          text = { Text(text = "Miles (mi)") },
                                          onClick = {
                                                outputUnit="mi"
                                                oconversion.value=1609.344
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

@Preview(showBackground=true)
@Composable
fun UnitConverterPreview() {
}