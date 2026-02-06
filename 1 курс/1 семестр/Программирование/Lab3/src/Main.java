import models.people.*;
import models.places.Cave;
import models.places.Place;

public class Main{
    public static void main(String[] args){
        Cave cave = new Cave("пещера");
        cave.genitiveCase();
        System.out.println(cave.toString());
    }
}