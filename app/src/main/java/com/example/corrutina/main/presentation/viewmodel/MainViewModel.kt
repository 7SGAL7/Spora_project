package com.example.corrutina.main.presentation.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.corrutina.main.data.datasourceimplementations.MainUseCaseImpl


class MainViewModel: ViewModel() {
    private val _requestData = MutableLiveData<String>()
    val requestData: LiveData<String> = _requestData

    val mainUseCaseImpl = MainUseCaseImpl();

    fun requestData(){
        viewModelScope.launch(Dispatchers.IO){
            _requestData.postValue(mainUseCaseImpl.requestData())
        }
    }
}