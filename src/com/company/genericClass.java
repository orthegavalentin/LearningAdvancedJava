package com.company;

public class genericClass<T,V> {
    T value1;
    V value2;

    public genericClass(T value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }



    public void print(){
        System.out.println( value1 +" and" +value2);
    }

}
