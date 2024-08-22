package com.example.e_commerce.ui.signIn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignInViewModel : ViewModel() {

    private val _someFlow = MutableStateFlow<String>("Initial Value")
    val someFlow: StateFlow<String> = _someFlow
    fun updateData(newValue: String) {
        _someFlow.value = newValue

    }
}