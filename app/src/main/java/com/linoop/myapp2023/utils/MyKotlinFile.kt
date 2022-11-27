package com.linoop.myapp2023.utils

sealed class Vehicle<T>(private val model: T) {

    class Car(val model: String) : Vehicle<String>(model)

    class Bike(val model: Int) : Vehicle<Int>(model)

}

class Van(val model: Int): Vehicle<Int>(model)

