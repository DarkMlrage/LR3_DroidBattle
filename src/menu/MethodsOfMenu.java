package menu;

import area.*;
import droid.*;
import utilits.SaveFight;

import java.util.List;
import java.util.Scanner;

public class MethodsOfMenu {

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static Droid createDroid() {
        Scanner scanner = new Scanner(System.in);

        String[] droidOptions = {"1- DBDroid",
                "2- GingerDroid",
                "3- KurkusDroid",
                "4- NinjaDroid",
        };

        printMenu(droidOptions);

        switch (scanner.nextInt()) {
            case 1:
                System.out.print("Input DroidName:");
                scanner.nextLine();

                return new DBDroid(50, 10, scanner.nextLine(), 20);
            case 2:
                System.out.print("Input DroidName:");
                scanner.nextLine();

                return new GingerDroid(60, 9, scanner.nextLine(), 20);
            case 3:
                System.out.print("Input DroidName:");
                scanner.nextLine();

                return new KurkusDroid(50, 10, scanner.nextLine(), 30);
            case 4:
                System.out.print("Input DroidName:");
                scanner.nextLine();

                return new NinjaDroid(40, 13, scanner.nextLine(), 25);
            default:
                break;
        }
        return new Droid(0, 0, "0");
    }

    public static void printList(List<Droid> droids) {
        for (Droid droid : droids) {
            System.out.println(droid);
        }
    }

    public static void droidFight(List<Droid> droids) throws InterruptedException {
        Arena arena = new Arena(droids.get(0), droids.get(1));
        Droid winner = arena.startFight();

        SaveFight.log("--------------");
        SaveFight.log("The winner is " + winner.getName());
    }

    public static void teamFight(List<Droid> droids) throws InterruptedException {
        TeamArena arena = new TeamArena(droids);
        Droid winner = arena.startFight();

        SaveFight.log("--------------");
        SaveFight.log("The winner is " + winner.getName() + "'s team");
    }
}
