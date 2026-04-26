package classes;

import static classes.Color.colorMaker;

import static runner.Runner.scanner;

public class Person {
    private int height; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле не может быть null

    public Person(int height, Color eyeColor, Color hairColor) {
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    @Override
    public String toString(){
        return "height: " + this.height + ", eye_color: " + this.eyeColor + ", hair_color: " + this.hairColor;
    }

    public static Person personMaker(){
        System.out.println("Введите его характеристики:");
        System.out.print("Рост: ");
        int height = scanner.nextInt();
        Color eyeColor = colorMaker("Цвет глаз: ");
        Color hairColor = colorMaker("Цвет волос: ");
        return new Person(height, eyeColor, hairColor);
    }

    public int getHeight() {
        return height;
    }
}