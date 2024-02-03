package com.example.unitconverterapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Composable
//fun LandingMenu(){
//      Column(modifier = Modifier.fillMaxSize()) {
//            Row(modifier = Modifier.fillMaxWidth()){
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.length), contentDescription = "Length")
//                              Text(text = "Length")
//                        }
//                  }
//
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.mass), contentDescription = "Length")
//                              Text(text = "Mass")
//                        }
//                  }
//
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.area), contentDescription = "Length")
//                              Text(text = "Area")
//                        }
//                  }
//            }
//
//            Row(modifier = Modifier.fillMaxWidth()){
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.speed), contentDescription = "Length")
//                              Text(text = "Speed")
//                        }
//                  }
//
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.currency), contentDescription = "Length")
//                              Text(text = "Currency")
//                        }
//                  }
//
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.temperature), contentDescription = "Length")
//                              Text(text = "Temperature")
//                        }
//                  }
//            }
//
//
//            Row(modifier = Modifier.fillMaxWidth()){
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.time), contentDescription = "Length")
//                              Text(text = "Time")
//                        }
//                  }
//
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.data), contentDescription = "Length")
//                              Text(text = "Data")
//                        }
//                  }
//
//                  Card(modifier=Modifier) {
//                        Column(modifier=Modifier) {
//                              Image(painter = painterResource(id =R.drawable.volume), contentDescription = "Length")
//                              Text(text = "Volume")
//                        }
//                  }
//            }
//      }
//}



@Composable
fun LandingMenu(navigateToLength:()->Unit,
                navigateToTime:()->Unit,
                navigateToArea:()->Unit,
                navigateToSpeed:()->Unit,
                navigateToCurrency:()->Unit,
                navigateToTemperature:()->Unit,
                navigateToVolume:()->Unit,
                navigateToMass:()->Unit,
                navigateToData:()->Unit,
                ){

      val configuration = LocalConfiguration.current
      val density = LocalDensity.current.density
      val screenWidth = (configuration.screenWidthDp * density).toInt()
      val cardWidth = (screenWidth) / 3
Column(modifier=Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally){

      Text(text = "Conversion Hub", style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(32.dp))
            Image(painter = painterResource(id = R.drawable.conversion),
                  contentDescription = "ICON", modifier = Modifier
                        .height(150.dp)
                        .width(150.dp))
            Spacer(modifier = Modifier.height(32.dp))

      LazyVerticalGrid(GridCells.Fixed(3),modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalArrangement = Arrangement.Center ) {

            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToLength() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp),
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.length),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Length")
                        }
                  }
            }
            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToMass() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.mass),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Mass")
                        }
                  }
            }
            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToArea() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.area),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Area")
                        }
                  }
            }
            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToTime() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.time),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Time")
                        }
                  }
            }
            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToVolume() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.volume),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Volume")
                        }
                  }
            }
            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToSpeed() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.speed),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Speed")
                        }
                  }
            }
            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToTemperature() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.pressure),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Pressure")
                        }
                  }
            }
            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToData() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.data),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Data")
                        }
                  }
            }
            item {
                  Card(
                        modifier = Modifier
                              .padding(8.dp)
                              .width(cardWidth.dp)
                              .clickable { navigateToCurrency() },
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                  ) {
                        Column(
                              modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxSize(),
                              verticalArrangement = Arrangement.Center,
                              horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                              Image(
                                    painter = painterResource(id = R.drawable.currency),
                                    contentDescription = "Length",
                                    modifier = Modifier
                                          .height(80.dp)
                                          .width(80.dp)
                              )
                              Text(text = "Currency")
                        }
                  }
            }


      }

      }
}

@Preview(showBackground=true)
@Composable
fun LandingMenuPreview() {

}