package hu.progmatic.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

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

    private static void helpCommand() {
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

    private static void createCommand() {
        // stringben tombben elmentem a parametereket amit vissza adok es utanna valami masik metodus szetszedi

        Scanner sc = new Scanner(System.in);
        Client newClient = new Client(createNewClientId());
        TyreSet newTyreSet = new TyreSet();
        StoredSet newStoredSet = new StoredSet();


        for (int i = 0; i < 15; i++) {
            if (i < 4) {
                System.out.println("Kérem az ügyfél " + getClientFieldName(i));
                String data = sc.nextLine();
                setCorrectClientField(i, newClient, data);
            } else if (4 <= i && i < 11) {
                // TODO
                // garnitura fieldjeit beállító metódus
            } else {
                // TODO
                // tárolás adatait beállító metódus
            }
        }

    }

    private static void readCommand() {
        System.out.println("READ");
    }

    private static void updateCommand() {
        System.out.println("UPDATE");
    }

    private static void deleteCommand() {
        System.out.println("DELETE");
    }

    private static Client getClient(int index) {
        List<Client> clients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("docs/Clients.txt"))){
            String line;

            while ((line = reader.readLine()) != null) {
                clients.add(new Client(line, true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (clients.size() > index) {
            return clients.get(index);
        } else if (index == -1) {
            return clients.get(clients.size() - 1);
        } else {
            return null;
        }
    }

    private static String createNewClientId() {
        Client lastClient = getClient(-1);
        String id;
        String[] idParts = new  String[5];

        try {
            id = lastClient.getId();
        } catch (NullPointerException e) {
            return "Hiba";
        }

        for (int i = 0; i < idParts.length; i++) {
            idParts[i] = Character.toString(id.charAt(i));
        }

        String idNumber = idParts[1] + idParts[2] + idParts[3] + idParts[4];
        int number = Integer.parseInt(idNumber);

        if (number != 9999) {
            return idParts[0] + (number + 1);
        } else {
            return "B" + "0001";
        }
    }

    private static String getClientFieldName(int number) {
        return switch (number) {
            case 0 -> "nevét";
            case 1 -> "címét";
            case 2 -> "telefonszámát";
            case 3 -> "e-mail címét";
            default -> "következő adatot";
        };
    }

    private static void setCorrectClientField(int number, Client client, String data) {
        switch (number) {
            case 0 -> client.setName(data);
            case 1 -> client.setAddress(data);
            case 2 -> client.setPhoneNumber(data);
            case 3 -> client.setEmail(data);
            default -> System.out.println("Hiba történt!");
        }
    }
}
