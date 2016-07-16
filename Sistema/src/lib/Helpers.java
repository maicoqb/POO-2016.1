package lib;


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
}
