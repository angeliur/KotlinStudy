package com.angeliur.kotlin.grammar.chapter1;


public class NullUnSafe {
    public void main(String... args){
        String name = getName();
        if (name == null) {
            System.out.println("name is invalid");
        }else {
            System.out.println(name.length());
        }
    }

    public String getName(){
        return "";
    }
}
