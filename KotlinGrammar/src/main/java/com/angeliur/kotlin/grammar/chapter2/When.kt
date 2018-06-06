package net.println.kotlin.chapter3

/**
 * Created by benny on 3/19/17.
 */

//when表达式：
//加强版switch，支持任意类型
//支持纯表达式条件分支（类似if）
//表达式与完备性
fun main(args: Array<String>) {
    val x = 5
    when(x){
        is Int -> println("Hello $x")
        in 1..100 -> println("$x is in 1..100")
        !in 1..100 -> println("$x is not in 1..100")
        args[0].toInt() -> println("x == args[0]")
    }

    val mode = when{
        args.isNotEmpty() && args[0] == "1" -> 1
        else -> 0
    }
}