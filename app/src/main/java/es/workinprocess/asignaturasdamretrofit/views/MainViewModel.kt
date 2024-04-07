package es.workinprocess.asignaturasdamretrofit.views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.workinprocess.asignaturasdamretrofit.services.RetrofitClient
import es.workinprocess.asignaturasdamscaffold.clases.Clases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    var calendario: Clases by mutableStateOf(Clases())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.webService.getCalendario()
                withContext(Dispatchers.Main) {
                    if(response.code()==200){
                        calendario = response.body()!!
                    }
                    else{
                        calendario = Clases()
                    }
                }
            }
            catch(exception:Exception){
                calendario = Clases()
            }

        }

    }

    /**
     * Devuelve el nombre del mes recibido como entero.
     * @param monthIntValue Numero del mes recibido como un entero
     * @return String con el nombre del mes.
     */
    fun monthName(monthIntValue: Int): String = arrayOf("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre", "Noviembre","Diciembre")[monthIntValue-1]
}