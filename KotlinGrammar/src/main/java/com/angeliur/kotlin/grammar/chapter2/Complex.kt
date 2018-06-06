package net.println.kotlin.chapter3

/**
 * Created by benny on 3/19/17.
 */

//基本运算符：
//任何类可以定义或者重载父类的基本运算符
//通过运算符对应的具名函数来定义
//对参数个数做要求，对参数和返回值类型不做要求
//不能像Scala一样定义任意运算符
class Complex(var real: Double, var imaginary: Double){
    operator fun plus(other: Complex): Complex{
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    operator fun plus(other: Int): Complex{
        return Complex(real + other, imaginary)
    }

    operator fun plus(other: Any): Int{
        return real.toInt()
    }

    operator fun invoke(): Double{
        return Math.hypot(real, imaginary)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

//中缀表达式：只有一个参数，且用infix修饰的函数
class Book{
     infix fun on(any: Any): Boolean{
        return false
    }
}

class Desk

fun main(args: Array<String>) {
    //-name <Name>
    if("-name" in args){
        println(args[args.indexOf("-name") + 1])
    }

    //中缀表达式的写法Book() on Desk()，不需要通过.()来调用方法
    if(Book() on Desk()){ // dsl

    }
}