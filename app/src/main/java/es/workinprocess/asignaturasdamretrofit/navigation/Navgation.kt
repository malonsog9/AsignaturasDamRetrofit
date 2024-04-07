package es.workinprocess.asignaturasdamretrofit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.workinprocess.asignaturasdamretrofit.views.Main
import es.workinprocess.asignaturasdamretrofit.views.MainViewModel

@Composable
fun Navigation(){

    val navigationController = rememberNavController()

    NavHost(navController = navigationController, startDestination = Paths.Main.path){

        /*A modo de ejemplo, desarrollo del grafo de Navegación*/
        composable(Paths.Main.path){ Main(navigationController, MainViewModel()) }

    }

}