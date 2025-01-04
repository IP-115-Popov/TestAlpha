package ru.sergey.testalpha.presentation

import android.content.Context
import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.sergey.data.repository.BinRepository
import ru.sergey.data.repository.BinRepositoryImpl
import ru.sergey.testalpha.presentation.screens.CardScreen
import ru.sergey.testalpha.presentation.screens.HistoryScreen
import ru.sergey.testalpha.presentation.theme.TestAlphaTheme
import ru.sergey.testalpha.presentation.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAlphaTheme {
                Main(MainViewModel(BinRepositoryImpl()))
            }
        }
    }
}
@Composable
fun Main(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    Column {
        NavHost(
            navController = navController,
            startDestination = NavRoutes.CardScreen.route,
            modifier = Modifier.fillMaxHeight(0.87f)
        ) {
            composable(NavRoutes.CardScreen.route) {
                CardScreen(mainViewModel)
            }
            composable(NavRoutes.HistoryScreen.route) {
                HistoryScreen(mainViewModel)
            }
        }

        BottomNavigationBar(
            navController = navController, modifier = Modifier.fillMaxHeight()
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry.value?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(selected = currentRoute == navItem.route, onClick = {
                navController.navigate(navItem.route)
            }, icon = {
                Icon(
                    imageVector = navItem.image,
                    contentDescription = navItem.title,
                )
            }, label = {
                Text(text = navItem.title)
            })
        }
    }
}

data class BarItem(
    val title: String, val image: ImageVector, val route: String
)

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "TaskScreen", image = Icons.Filled.Home, route = NavRoutes.CardScreen.route
        ),
        BarItem(
            title = "GraphScreen", image = Icons.Filled.DateRange, route = NavRoutes.HistoryScreen.route
        )
    )
}

sealed class NavRoutes(val route: String) {
    object CardScreen : NavRoutes("CardScreen")
    object HistoryScreen : NavRoutes("HistoryScreen")
}