package com.angeliur.kotlin.grammar.chapter1;

public class TypeCast {
    public static void main(String... args) {
        Parent parent = new Parent();
        System.out.println(((Child)parent).getName());

    }
}
