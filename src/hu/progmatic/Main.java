package hu.progmatic;


import hu.progmatic.models.Controller;
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
            Controller.chooseCommand(command);
        }

        System.out.println("Viszlát!");

    }

}
