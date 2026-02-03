import java.util.Locale;
import java.util.Random;

public class Lab1 {

    public static void main (String[] arr){
        short[] s = new short[17];
        double[] x = new double[19];
        double [][] w = new double[16][18];

        // заполнение одномерного массива s длинной 17
        for (short i = 16; i > 0; i--) {
            s[i] = i;
        }

        // заполнение одномерного массива х длинной 19
        Random rnd = new Random();
        double r;
        for (int i = 0; i < 18; ++i){
            r = rnd.nextDouble(-10.0,7.0);
            x[i] = r;
        }
        short [] list = {1,2,4,5,8,9,12,14};
        for (short i = 0; i < 16; ++i){
            // заранее определим входит ли s[i] в list
            boolean flag = false;
            for (short k : list){
                if (k == s[i]){
                    flag = true;
                    break;
                }
            }
            // заполнение двумерного массива w размером 16х18
            for (short j = 0; j < 18; ++j){

                if (s[i] == 10){
                    double arctan = Math.atan(1/Math.pow(Math.E,Math.abs(x[j])));
                    double power = Math.pow(Math.pow(x[j]/2, x[j]), 1/3d);
                    w[i][j] = Math.pow((3/4d)/(arctan + 1), power);
                }
                else if (flag) {
                    double in_cos = Math.pow(Math.exp(Math.abs(x[j])), 1/3d);
                    w[i][j] = Math.cos(in_cos);
                }
                else {
                    double in_pow = (x[j] - 1.5)/17;
                    double in_sin = Math.pow(Math.pow(in_pow, 2), 2);
                    w[i][j] = Math.pow(Math.exp(1), Math.asin(in_sin));
                }
            }
        }

        // вывод двумерного массива w в формате таблицы 16х18
        for (short i = 0; i < 16; ++i){
            for (short j = 0; j < 18; ++j){
                System.out.printf(Locale.US,"|%.5f| ", w[i][j]);
            }
            System.out.printf("%n");
        }
    }
}