package home.bruce.bean;

import home.bruce.lesson1.service.Animal;

public class Pig implements Animal {
    public Pig() {
        System.out.println("Pig 無參");
    }

    public Pig(String p) {
        System.out.println("Pig 有一個 String 參數");
    }

    public Pig(String p, Integer i) {
        System.out.println("Pig 有兩個參數，String 和 Integer");
    }

    @Override
    public String getName() {
        return "豬";
    }
}
