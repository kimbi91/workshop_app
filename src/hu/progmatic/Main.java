package hu.progmatic;

import hu.progmatic.models.Client;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Írd be a végrehajtandó parancsot!");
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            chooseCommand(command);
        }

        System.out.println("Viszlát!");

    }

    public static void chooseCommand(String command) {

        switch (command.toLowerCase(Locale.ROOT)) {
            case "help" -> helpCommand();
            case "create" -> createCommand();
            case "read" -> readCommand();
            case "update" -> updateCommand();
            case "delete" -> deleteCommand();
            default -> System.out.println("Ismeretlen parancs!");
        }
    }

    public static void helpCommand() {
        System.out.println(
                """
                        Lehetséges parancsok:
                        help \t: lehetséges parancsok kiírása.
                        create \t: új bejegyzés készítése.
                        read \t: adat lekérdezése.
                        update \t: adat módosítása.
                        delete \t: adat törlése.
                        exit \t: kilépés."""
                );
    }

    public static void createCommand() {
        System.out.println("CREATE");
    }

    public static void readCommand() {
        System.out.println("READ");
    }

    public static void updateCommand() {
        System.out.println("UPDATE");
    }

    public static void deleteCommand() {
        System.out.println("DELETE");
    }

}
