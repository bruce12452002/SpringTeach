package home.bruce.bean;

import home.bruce.lesson1.service.Animal;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
public class PropertyPractice {
    private List<String> strOfList;
    private List<Animal> animalOfList;
    private Set<String> strOfSet;
    private Map<String, Integer> map;
    private Map<String, Animal> animalOfMap;
    private Properties ps;
    private int[] arr;
    private String[][] strArr;
}
