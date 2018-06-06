package com.angeliur.kotlin.grammar.chapter2

/**
 * Created by Administrator on 2018/5/1 0001.
 */
//kotlin中对于编译器可以猜到的类型可以自动进行类型推导，不用来声明
val FINAL_HELLO_WORLD = "HelloWorld"//类似于java中的final，但它是运行期常量，并不与final完全相同
var helloGirl: String = "HelloGirl"


val FINAL_HELLO: String = "Hello"
var hello:String = FINAL_HELLO

const val FINAL_YOU = "Welocome"//相当于java中的final FINAL_YOU = "Welocome"，是编译期常量，可以提高效率

fun main(args: Array<String>) { // (Array<String>) -> Unit

    println(FINAL_HELLO)

    checkArgs(args)
    val arg1 = args[0].toInt()
    val arg2 = args[1].toInt()
    println("$arg1 + $arg2 = ${sum(arg1, arg2)}")
    println(int2Long(3))
    println(sum(1, 3))//相当于println(sum.invoke(1, 3))
    println(sum.invoke(1, 3))

    args.forEach ForEach@{
        if(it == "q") return@ForEach
        println(it)
    }

    println("The End")

    println(sum)
    println(int2Long)
    println(::printUsage is ()-> Unit)
}

fun checkArgs(args: Array<String>) {
    if (args.size != 2) {
        printUsage()
        System.exit(-1)
    }
}

//函数的默认返回值是Unit,相当于Java中的void，可以不写
fun printUsage() {
    println("请传入两个整型参数，例如 1 2") // (Any?) -> Unit
} // ()->Unit

//用Lambda函数来表示，Lambda表达式其实就是匿名函数，写法{[参数列表] -> [函数体，最后一行是返回值]}
//Lambda表达式用（）来调用，例如sum(1,2)，等价于sum.invoke(1,2)

//Lambda表达式的简化：
//函数参数调用时最后一个Lambda可以移出去
//函数参数只有一个Lambda,调用时小括号可省略
//Lambda只有一个参数可以默认为it
//入参、返回值和形参一致的函数可以用函数引用的方式作为实参传入
val sum = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}
// (Int, Int) -> Int

//如果函数的函数体是一个表达式，可以直接用=来直接定义，不用{}
fun sum(arg1: Int,arg2: Int,arg3: Int) = arg1 + arg2 + arg3


val printlnHello = {
    println("Hello")
}
// ()-> Unit

//定义函数可以不写函数名，就是匿名函数，直接用fun(x: Int): Long,但是必须用一个变量来声明
val int2Long = fun(x: Int): Long {
    return x.toLong()
}

//Int Long String  ABC

// (Int) -> Long