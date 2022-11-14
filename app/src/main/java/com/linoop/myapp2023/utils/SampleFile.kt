package com.linoop.myapp2023.utils
import kotlin.reflect.KProperty

class NetworkUtil (private val name: String) {
    var connection: String by NetConnection()

    fun printConnection(conType: String){
        connection = conType
        println(connection)
    }

}


class NetConnection{

    operator fun getValue(networkUtil: NetworkUtil, property: KProperty<*>): String {
        return "Linoop"
    }

    operator fun setValue(networkUtil: NetworkUtil, property: KProperty<*>, value: String){
        println("Property ${property.name}")
        println("I am here at setValue $value")
    }
}


fun main() {
    val networkUtil = NetworkUtil("Linoop")
    networkUtil.printConnection("Connection type")
    println("Hi")
}