package classes;

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

    public int getHeight() {
        return height;
    }
}