package com.example.tvshowsappassessment.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tvshowsappassessment.ui.details.DetailsScreens
import com.example.tvshowsappassessment.ui.home.HomeScreen
import com.example.tvshowsappassessment.ui.login.LoginScreen
import com.example.tvshowsappassessment.ui.navigation.Routes


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowsNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LOGIN.name) {

        composable(route = Routes.LOGIN.name) {
            LoginScreen()
        }
        composable(route = Routes.DETAILS.name) {
            DetailsScreens ({ navController.navigate(Routes.HOME.name) })
        }

    }
}
