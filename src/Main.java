import droid.Droid;
import menu.*;

import utilits.SaveFight;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static menu.MethodsOfMenu.*;


public class Main {


    public static void main(String[] args) throws InterruptedException, IOException {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);


        List<Droid> droids = new ArrayList<>();

        int option;
        boolean Start = true;
        while (Start) {
            printMenu(menu.getOptions());

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("---------------------");
                    droids.add(MethodsOfMenu.createDroid());
                    System.out.println("---------------------");
                    break;
                case 2:
                    System.out.println("---------------------");
                    MethodsOfMenu.printList(droids);
                    System.out.println("---------------------");
                    break;
                case 3:
                    SaveFight.setBaos(new ByteArrayOutputStream());
                    SaveFight.log("---------------------");
                    MethodsOfMenu.droidFight(droids);
                    SaveFight.log("---------------------");
                    break;
                case 4:
                    SaveFight.setBaos(new ByteArrayOutputStream());
                    System.out.println("---------------------");
                    MethodsOfMenu.teamFight(droids);
                    System.out.println("---------------------");
                    break;
                case 5:
                    SaveFight.save();
                    break;
                case 6:

                    break;
                case 7:
                    Start = false;
                    break;
                default:
                    break;
            }
        }
    }
}

