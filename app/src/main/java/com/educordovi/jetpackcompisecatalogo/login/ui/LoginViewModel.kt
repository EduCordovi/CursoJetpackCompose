package com.educordovi.jetpackcompisecatalogo.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.educordovi.jetpackcompisecatalogo.login.domain.LoginUserCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loginUserCase = LoginUserCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> = _isLoading

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    fun onLoginSelected(){
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUserCase(email.value!!, password.value!!)
            if (result){
                //mavegar a la siguiente pantalla
                Log.i("Eduardo","Result OK")
            }

            _isLoading.value = false
        }
    }
}