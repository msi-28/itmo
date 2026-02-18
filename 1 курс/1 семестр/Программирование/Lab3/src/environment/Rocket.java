package environment;

import actoin.ButtonStatus;
import actoin.DoorStatus;
import exeptions.DoorIsNotOpenException;
import person.Shorty;


public class Rocket extends Place{
    private String name;
    private ButtonStatus buttonStatus = ButtonStatus.UNPRESSED;
    private DoorStatus doorStatus = DoorStatus.CLOSED;
    public Rocket(String name){
        super(name);

    }

    @Override
    public void goTo(Shorty shorty) throws DoorIsNotOpenException{
        if (doorStatus.equals(DoorStatus.OPENED)) {
            System.out.printf("%s %s%n", shorty.getName(), "залез в ракету");
            System.out.printf("%s%n", "Дверь закрылась");
            doorStatus = DoorStatus.CLOSED;
        }
        else {
            throw new DoorIsNotOpenException(shorty.getName() + " должен сначала открыть дверь");
        }

    }

    @Override
    public void goOut(Shorty shorty){
        if (doorStatus.equals(DoorStatus.OPENED)) {
            System.out.printf("%s %s%n", shorty.getName(), "вылез из ракеты");
            doorStatus = DoorStatus.CLOSED;
        }
        else {
            System.out.printf("%s %s%n", shorty.getName(), "должен сначала открыть дверь");
        }
    }

    public void pressButton(Shorty shorty){
        if (buttonStatus.equals(ButtonStatus.UNPRESSED)) {
            System.out.printf("%s %s%n", shorty.getName(), "нажал на кнопку");
            buttonStatus = ButtonStatus.PRESSED;
        }
        else{
            System.out.printf("кнопка уже нажата%n");
        }
    }
    public void openTheDoor(Shorty shorty){
        if (buttonStatus.equals(ButtonStatus.PRESSED)) {
            if (doorStatus.equals(DoorStatus.CLOSED)) {
                System.out.printf("%s %s%n", shorty.getName(), "открыл дверь");
                doorStatus = DoorStatus.OPENED;
            }
            else{
                System.out.printf("%s %s%n", shorty.getName(), "уже открыл дверь");
            }
        }
        else{
            if (doorStatus.equals(DoorStatus.CLOSED)) {
                System.out.printf("%s %s%n", shorty.getName(), "сначала должен нажать на кнопку");
                doorStatus = DoorStatus.OPENED;
            }
            else{
                System.out.printf("%s %s%n", shorty.getName(), "уже открыл дверь");
            }
        }
    }
}
