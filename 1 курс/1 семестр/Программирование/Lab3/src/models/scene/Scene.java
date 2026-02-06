package models.scene;

import models.people.Person;
import models.places.Place;
import models.things.SpaceBoot;

import java.util.ArrayList;

public class Scene {
    private Person mainCharacter;
    private ArrayList<Person> characters;
    private ArrayList<SpaceBoot> space_boots;
    private ArrayList<Place> surroundings;

    public Scene(Person mainCharacter,
                 ArrayList<Person> characters,
                 ArrayList<SpaceBoot> space_boots,
                 ArrayList<Place> surroundings){
        this.mainCharacter = mainCharacter;
        this.characters = characters;
        this.space_boots = space_boots;
        this.surroundings = surroundings;
    }

    public Person getMainCharacter(){
        return mainCharacter;
    }
    public void setMainCharacter(){
        this.mainCharacter = mainCharacter;
    }

    public ArrayList<Person> getCharacters(){
        return characters;
    }
    public void setCharacters(){
        this.characters = characters;
    }

    public ArrayList<SpaceBoot> getSpace_boots(){
        return space_boots;
    }
    public void setSpace_boots(){
        this.space_boots = space_boots;
    }

    public ArrayList<Place> getSurroundings(){
        return surroundings;
    }
    public void setSurroundings(){
        this.surroundings = surroundings;
    }
}
