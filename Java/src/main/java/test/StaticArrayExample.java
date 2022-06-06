package test;

import java.util.ArrayList;

public class StaticArrayExample {

    public static void main(String[] args) {
        Animal dog = new Animal("dog");
        Animal cat = new Animal("cat");

        for (Animal animal : Animal.animals) {
            System.out.println(animal.getName());
        }

        System.out.println(dog.getNumber());
        System.out.println(cat.getNumber());

    }

    static class Animal {
        public static ArrayList<Animal> animals = new ArrayList<Animal>();
        private final String name;
        private final int number;

        Animal(String name) {
            this.name = name;
            animals.add(this);
            this.number = animals.size();
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }
    }
}
