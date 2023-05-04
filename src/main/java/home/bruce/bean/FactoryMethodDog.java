package home.bruce.bean;

public class FactoryMethodDog {
    public static Dog getDog(String title, int age) {
        System.out.println("getDog(title, age)");
        return new Dog(title, age);
    }

    public Dog getDog2(String title, int age) {
        System.out.println("getDog2(title, age)");
        return new Dog(title, age);
    }
}
