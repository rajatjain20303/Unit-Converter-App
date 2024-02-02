package com.example.unitconverterapp

import android.health.connect.datatypes.units.Temperature
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyApp(navController : NavHostController) {
      NavHost(navController = navController, startDestination = Screens.HomeScreen.route){
            composable(
                  route=Screens.HomeScreen.route
            ){
                  LandingMenu(
                        navigateToLength = {
                        navController.navigate(Screens.LengthScreen.route)
                                           },
                        navigateToTime = {
                              navController.navigate(Screens.TimeScreen.route)
                        },
                        navigateToArea = {
                              navController.navigate(Screens.AreaScreen.route)
                        },
                        navigateToSpeed = {
                              navController.navigate(Screens.SpeedScreen.route)
                        },
                        navigateToCurrency = {
                              navController.navigate(Screens.CurrencyScreen.route)
                        },
                        navigateToTemperature = {
                              navController.navigate(Screens.TemperatureScreen.route)
                        },
                        navigateToVolume = {
                              navController.navigate(Screens.VolumeScreen.route)
                        },
                  navigateToMass = {
                        navController.navigate(Screens.MassScreen.route)
                  },
                  navigateToData = {
                        navController.navigate(Screens.DataScreen.route)
                  }
                        )
            }



            composable(route = Screens.LengthScreen.route)
            {
                  LengthConversion()
            }
            composable(route = Screens.MassScreen.route)
            {
                  MassConversion()
            }
            composable(route = Screens.AreaScreen.route)
            {
//                  AreaConversion()
            }
            composable(route = Screens.SpeedScreen.route)
            {
                //  SpeedConversion()
            }
            composable(route = Screens.TimeScreen.route)
            {
//                  TimeConversion()
            }
            composable(route = Screens.TemperatureScreen.route)
            {
//                  TemperatureConversion()
            }
            composable(route = Screens.VolumeScreen.route)
            {
                 // VolumeConversion()
            }
            composable(route = Screens.CurrencyScreen.route)
            {
              //    CurrencyConversion()
            }
            composable(route = Screens.DataScreen.route)
            {
              //    DataConversion()
            }

      }
}




//navigateToLength:()->Unit,
//navigateToTime:()->Unit,
//navigateToArea:()->Unit,
//navigateToSpeed:()->Unit,
//navigateToCurrency:()->Unit,
//navigateToTemperature:()->Unit,
//navigateToVolume:()->Unit,
//navigateToMass:()->Unit,
//navigateToData:()->Unit,