package net.println.kotlin.chapter2

import com.angeliur.kotlin.grammar.chapter1.Child
import com.angeliur.kotlin.grammar.chapter1.Parent

fun main(args: Array<String>) {
    val parent: Parent = Parent()

    val child: Child? = parent as? Child
    println(child)

    val string: String? = "Hello"
    if(string != null)
        println(string.length)


}