package net.println.kotlin.chapter3

/**
 * Created by benny on 3/19/17.
 */
fun main(vararg args: String) {
//    for (arg in args){
//        println(arg)
//    }

    val list = arrayListOf(1,3,4,5)
    val array = intArrayOf(1,3,4,5)
    //kotlin目前只支持int类型的array使用*array来表示
    hello(3.0, *array, string = "world")
}

//变长参数：
//某个参数可以接受多个值
//java中变长参数必须为最后一个参数，kotlin中可以不为最后一个参数
//如果传参时有歧义，可以使用具名函数
fun hello(double: Double, vararg ints: Int, string: String = "Hello"){
    println(double)
    ints.forEach(::println)
    println(string)
}