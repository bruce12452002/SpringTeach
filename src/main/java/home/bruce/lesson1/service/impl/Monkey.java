package home.bruce.lesson1.service.impl;

import home.bruce.lesson1.dao.AnimalDao;
import home.bruce.lesson1.service.Animal;
import lombok.Data;

@Data
public class Monkey implements Animal {
    private String name;

    public void setDao(AnimalDao dao) {
        System.out.println("dao 被調用了!");
    }

    public Monkey() {
        System.out.println("monkey init");
    }

}
