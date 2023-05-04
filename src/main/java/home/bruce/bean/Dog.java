package home.bruce.bean;

import home.bruce.lesson1.service.Animal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dog implements Animal {
    private String title;
    private int age;

    @Override
    public String getName() {
        return "狗";
    }
}
