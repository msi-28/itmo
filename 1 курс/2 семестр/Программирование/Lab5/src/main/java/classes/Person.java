package classes;

import static runner.Runner.scanner;

public class Person implements Comparable<Person>{
    private int height; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле не может быть null

    public Person(int height, Color eyeColor, Color hairColor) {
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString(){
        return "height: " + this.height + ", eye_color: " + this.eyeColor + ", hair_color: " + this.hairColor;
    }

    @Override
    public int compareTo(Person o){
        int compareHeight = Integer.compare(this.height, o.height);
        int compareEyeColor = this.eyeColor.compareTo(o.eyeColor);
        int compareHairColor = this.hairColor.compareTo(o.hairColor);

        if (compareHeight != 0) return compareHeight;
        if (compareEyeColor != 0) return compareEyeColor;
        return compareHairColor;
    }
}