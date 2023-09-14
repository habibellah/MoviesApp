package com.example.moviesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.core.presentation.navigation.graph.MoviesAppNavGraph
import com.example.moviesapp.home_feature.presentation.screens.seeAllScreen.SeeAllScreen
import com.example.moviesapp.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   @OptIn(ExperimentalMaterial3Api::class)
   @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
   override fun onCreate(savedInstanceState : Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         MoviesAppTheme {
            val navigationController = rememberNavController()
           val items  = listOf(
              BottomNavigationItem(title = "Home" , route = "homeScreen" , selectedIcon = Icons.Filled.Home , unselectedIcon =Icons.Outlined.Home),
              BottomNavigationItem(title = "Search" , route = "exploreScreen" , selectedIcon = Icons.Filled.Search , unselectedIcon =Icons.Outlined.Search),
              BottomNavigationItem(title = "Favorite" , route = "favoriteScreen" , selectedIcon = Icons.Filled.Favorite , unselectedIcon =Icons.Outlined.Favorite),
              BottomNavigationItem(title = "Profile" , route = "profileScreen" , selectedIcon = Icons.Filled.Person , unselectedIcon =Icons.Outlined.Person),
           )
            var selectedItemIndex by remember{
               mutableStateOf(0)
            }
            Surface(
               modifier = Modifier.fillMaxSize() ,
               color = MaterialTheme.colorScheme.background
            ) {
               Scaffold(
                  bottomBar = {
                     NavigationBar {
                 items.forEachIndexed { index, bottomNavigationItem ->
                    NavigationBarItem(
                       selected = selectedItemIndex == index ,
                       onClick = { selectedItemIndex = index
                                 navigationController.navigate(bottomNavigationItem.route)
                                 },
                       icon = {
                       Icon(
                          imageVector = if (selectedItemIndex == index) {
                             bottomNavigationItem.selectedIcon
                          } else {
                             bottomNavigationItem.unselectedIcon
                          } , contentDescription = ""
                       )
                       })
                 }
                     }
                  }
               ){
            MoviesAppNavGraph(navController =  navigationController, startDestination = "homeScreen")
               }
            }
         }
      }
   }
}

data class BottomNavigationItem(
   val title : String,
   val route : String,
   val selectedIcon : ImageVector,
   val unselectedIcon : ImageVector,
)
