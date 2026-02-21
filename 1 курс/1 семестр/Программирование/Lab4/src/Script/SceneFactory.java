package Script;

import exeptions.NullLocationException;
import person.enums.Emotions;
import person.enums.RunType;
import environment.Location;
import environment.Sun;
import person.MainShorty;
import person.SideShorty;

import java.util.Scanner;

public class SceneFactory {
    private Scanner scanner = new Scanner(System.in);
    private String mainName;
    private String sideName;
    private String sunName;
    public SceneFactory() {
        System.out.print("Введите имя для главного персонажа: ");
        this.mainName = scanner.nextLine();
        System.out.print("Введите имя для второстепенного персонажа: ");
        this.sideName = scanner.nextLine();
        System.out.print("Введите имя для звезды: ");
        this.sunName = scanner.nextLine();
    }

    public Scene create() throws NullLocationException {
        MainShorty mainShorty = new MainShorty(mainName, Location.CAVE, Emotions.SCARED, RunType.TIRED);
        SideShorty sideShorty = new SideShorty(sideName, Location.CAVE, Emotions.SCARED, RunType.TIRED);
        Sun sun = new Sun(sunName);

        return new Scene(mainShorty, sideShorty, sun);
    }
}
