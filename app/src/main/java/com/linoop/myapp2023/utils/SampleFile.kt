package com.linoop.myapp2023.utils
import kotlin.reflect.KProperty

class NetworkUtil (private val name: String) {
    var connection: String by NetConnection()

    fun printConnection(conType: String){
        connection = conType
        println(connection)
    }

}

fun interface Calculate {
    fun cal(a: Int, b: Int): Int
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
    /*val networkUtil = NetworkUtil("Linoop")
    networkUtil.printConnection("Connection type")
    println("Hi")
*/
    val calculate = Calculate { a, b ->  a+b }
    println(calculate.cal(10, 20))
}