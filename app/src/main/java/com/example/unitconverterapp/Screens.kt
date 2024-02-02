package com.example.unitconverterapp

sealed class Screens(val route: String) {
      object HomeScreen:Screens("homescreen")
      object LengthScreen:Screens("lengthscreen")
      object MassScreen:Screens("massscreen")
      object TimeScreen:Screens("timescreen")
      object SpeedScreen:Screens("speedscreen")
      object TemperatureScreen:Screens("temperaturescreen")
      object VolumeScreen:Screens("volumescreen")
      object DataScreen:Screens("datascreen")
      object AreaScreen:Screens("areascreen")
      object CurrencyScreen:Screens("currencyscreen")


}