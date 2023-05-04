package home.bruce.bean;

import home.bruce.bean.Dragon;

public class FactoryMethod1 {
    public static Dragon getDragon() {
        System.out.println("getDragon()");
        return new Dragon();
    }

    public static Dragon getDragon(String str, Integer i) {
        System.out.println("getDragon()" + str + i);
        return new Dragon();
    }

    public Dragon getDragon2() {
        System.out.println("getDragon2()");
        return new Dragon();
    }

    public Dragon getDragon2(String str, Integer i) {
        System.out.println("getDragon2()" + str + i);
        return new Dragon();
    }
}
