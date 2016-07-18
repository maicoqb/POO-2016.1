package lib;

import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Helpers {

    private static Scanner teclado = new Scanner(System.in);

    public static int lerInt(String frase) {
        System.out.println(frase);
        return teclado.nextInt();
    }

    public static String lerString(String frase) {
        System.out.println(frase);
        return teclado.nextLine().trim();
    }

    public static double lerDouble(String frase) {
        System.out.println(frase);
        return teclado.nextDouble();
    }

    public static String toMoney(float valor) {
        return Float.toString(valor).replace('.', ',');
    }

    public static float toFloat(String text) {
        if (text.length() == 0) {
            return 0;
        }
        return Float.parseFloat(text.replace(',', '.'));
    }

    public static int randIntMinMax(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max-min) + min;
    }
}
