package com.angeliur.kotlin.grammar.chapter1

fun getName(): String? {
    return null
}

fun main(args:Array<String>){
    val value: String?= "HelloWorld"
    println(value!!.length)

    var name: String = getName()?:return
    println(name.length)

}