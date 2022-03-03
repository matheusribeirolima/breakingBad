package com.example.breakingbad.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.data.CharacterRepository
import com.example.breakingbad.domain.Character
import com.example.breakingbad.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<Result<List<Character>>>(Result.Loading)
    val uiState: StateFlow<Result<List<Character>>> = _uiState

    init {
        viewModelScope.launch {
            try {
                val characters = characterRepository.getCharacters(100, 20)
//                _uiState.value = Result.Success(characters) // map to characters
            } catch (_: Exception) {
                _uiState.value = Result.Error("Error loading characters")
            }
        }
    }
}
