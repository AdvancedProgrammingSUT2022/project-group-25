package model;

import java.util.Scanner;

public class UtilityClass {
    public static Scanner scanner = new Scanner(System.in);
    public static String read(){
        return scanner.nextLine();
    }
    public static void write(String feedBack){
        System.out.println(feedBack);
    }



}
