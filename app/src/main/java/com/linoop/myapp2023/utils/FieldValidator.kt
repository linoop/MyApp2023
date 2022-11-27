package com.linoop.myapp2023.utils


object FieldValidator {
    fun validateName(name: String): Boolean {
        return name.isNotBlank() && name.isNotEmpty()
    }

    //fun confirmPassword(p1:String, p2:String) = p1 == p2
    fun validatePassword(password: String): Boolean {
        return password.isNotBlank() && password.isNotEmpty()
    }

    fun validateUsername(username: String): Boolean {
        return username.isNotBlank() && username.isNotEmpty()
    }

    fun validateEmail(email: String): Boolean {
        return email.isNotBlank() && email.isNotEmpty()
    }


}