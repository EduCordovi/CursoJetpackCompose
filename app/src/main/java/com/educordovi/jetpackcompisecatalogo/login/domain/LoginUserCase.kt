package com.educordovi.jetpackcompisecatalogo.login.domain

import com.educordovi.jetpackcompisecatalogo.login.data.LoginRepository

class LoginUserCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}