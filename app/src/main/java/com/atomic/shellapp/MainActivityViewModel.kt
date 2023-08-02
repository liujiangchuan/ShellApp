package com.atomic.shellapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atomic.featuredsport.ui.SportCardUiState
import com.atomic.shellapp.data.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {
    private val _data = MutableLiveData<SportCardUiState>()
    val data: LiveData<SportCardUiState>
        get() = _data

    fun fetchData() {
        _data.postValue(SportCardUiState.Loading)
        viewModelScope.launch {
            try {
                val fetchedData = withContext(Dispatchers.IO) {
                    contentRepository.getFeaturedSports()
                }
                val sport = fetchedData.random()
                _data.postValue(SportCardUiState.Success(sport.name, sport.description))
            } catch (e: Exception) {
                Log.e("MainActivityViewModel", e.toString())
            }
        }
    }
}