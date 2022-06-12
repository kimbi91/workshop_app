package hu.progmatic;


import hu.progmatic.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Client> savedClientData = new ArrayList<>();
        List<TyreSet> savedTyreSetData = new ArrayList<>();
        List<StoredSet> savedStoredSetData = new ArrayList<>();


        while (true) {
            System.out.println("Írd be a végrehajtandó parancsot!");
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            List<Object> newData;

            switch (command.toLowerCase(Locale.ROOT)) {
                case "help" -> Controller.helpCommand();
                case "create" -> {
                    newData = Controller.createCommand();
                    Controller.sortNewData(savedClientData, savedTyreSetData, savedStoredSetData, newData);
                }
                case "read" -> Controller.readCommand();
                case "update" -> Controller.updateCommand();
                case "delete" -> Controller.deleteCommand();
                default -> System.out.println("Ismeretlen parancs!");
            }
        }

        System.out.println("Viszlát!");

    }

}
