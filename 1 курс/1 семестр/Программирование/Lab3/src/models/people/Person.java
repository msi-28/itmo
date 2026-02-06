package models.people;
import interfaces.Jumpable;
import interfaces.Runnable;

public class Person{
    private String name;
    private Sex sex;

    public Person(String name, Sex sex){
        this.name = name;
        this.sex = sex;
    }

    public boolean isMale(){
        return sex == Sex.MALE;
    }
    public String pronunciation(){
        return isMale() ? "его" : "её";
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    public Sex getSex(){
        return sex;
    }
    public void setSex(){
        this.sex = sex;
    }


}
