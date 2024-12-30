package com.example.myapplicationdatabase.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationdatabase.Repository.MahasiswaRepository
import com.example.myapplicationdatabase.model.Mahasiswa
import kotlinx.coroutines.launch

class InsertViewModel(private val mahasiswaRepository: MahasiswaRepository): ViewModel(){
    var uiState by mutableStateOf(InsertUiState())
        private set
    fun updateInsertMhsState(insertUiEvent: InsertUiEvent){
        uiState = InsertUiState(insertUiEvent = insertUiEvent)
    }
    suspend fun insertMhs(){
        viewModelScope.launch {
            try {
                mahasiswaRepository.insertMahasiswa(uiState.insertUiEvent.toMhs())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

