package com.example.myapplicationdatabase.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationdatabase.Repository.MahasiswaRepository
import com.example.myapplicationdatabase.model.Mahasiswa
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed class HomeUiState{
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object Error: HomeUiState()
    object Loading: HomeUiState()
}
class HomeViewModel (private val mhs: MahasiswaRepository): ViewModel(){
    var mhsUIState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

}