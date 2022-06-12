package hu.progmatic.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Controller {

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

    public static List<SavedData> createCommand() {

        Scanner sc = new Scanner(System.in);
        Client newClient = new Client(createNewClientId());
        TyreSet newTyreSet = new TyreSet();
        StoredSet newStoredSet = new StoredSet();
        List<SavedData> newData = new ArrayList<>();


        for (int i = 0; i < 13; i++) {
            if (i < 4) {
                System.out.println("Kérem az ügyfél " + getClientFieldName(i));
                String data = sc.nextLine();
                setCorrectClientField(i, newClient, data);
            } else if (i < 10) {
                newTyreSet.setOwner(newClient);
                System.out.println(getTyreSetFieldNameQuestion(i));
                String data = sc.nextLine();
                setCorrectTyreSetField(i, newTyreSet, data);
            } else {
                newStoredSet.setClient(newClient);
                newStoredSet.setTyreSet(newTyreSet);
                System.out.println(getStoredSetQuestion(i));
                String data = sc.nextLine();
                setCorrectStoredSetField(i, newStoredSet, data);
            }
        }

        newData.add(newClient);
        newData.add(newTyreSet);
        newData.add(newStoredSet);

        return newData;
    }

    public static void sortNewData(List<Client> clientList, List<TyreSet> tyreSetList, List<StoredSet> storedSetList, List<SavedData> newData) {

        Iterator<SavedData> itr = newData.iterator();

        while (itr.hasNext()) {
            SavedData current = itr.next();

            if (current.getClass().getSimpleName().equalsIgnoreCase("client")) {
                clientList.add((Client) current);
            } else if (current.getClass().getSimpleName().equalsIgnoreCase("tyreset")) {
                tyreSetList.add((TyreSet) current);
            } else {
                storedSetList.add((StoredSet) current);
            }

            itr.remove();
        }


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

        if (index == -1) {
            return clients.get(clients.size() - 1);
        } else if (clients.size() > index) {
            return clients.get(index);
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

    private static String getTyreSetFieldNameQuestion(int number) {
        return switch (number) {
            case 4 -> "Komplett kerék? (i/n)";
            case 5 -> "Mi a gumi márkája?";
            case 6 -> "Mekkora a minta mélysége?";
            case 7 -> "Nyári gumi? (i/n)";
            case 8 -> "Hány gumi/kerék tartozik a garnitúrához?";
            case 9 -> "Írja le ha található valami sérülés a garnitúrán!";
            default -> "Kérem a következő adatot";
        };
    }

    private static String getStoredSetQuestion(int number) {
        return switch (number) {
            case 10 -> "Flottakezelt? (i/n)";
            case 11 -> "Ha flotta kezelt kérem adja meg a flotta nevét! (ha nem üssön entert)";
            case 12 -> "Meddig van fizetve a tárolás?";
            default -> "Kérem a következő adatot";
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

    private static void setCorrectTyreSetField(int number, TyreSet tyreSet, String data) {
        switch (number) {
            case 4 -> tyreSet.setWheel(data.equalsIgnoreCase("i"));
            case 5 -> tyreSet.setBrand(data);
            case 6 -> tyreSet.setTreadDepht(Double.parseDouble(data));
            case 7 -> tyreSet.setSummerTread(data.equalsIgnoreCase("i"));
            case 8 -> tyreSet.setNumOfTyresInSet(Integer.parseInt(data));
            case 9 -> tyreSet.setDamages(data);
        }
    }

    private static void setCorrectStoredSetField(int number, StoredSet storedSet, String data) {
        switch (number) {
            case 10:
                storedSet.setFleet(data.equalsIgnoreCase("i"));
                break;
            case 11:
                if (data.length() > 0) {
                    storedSet.setFleetInfo(data);
                }
                break;
            case 12:
                storedSet.setPaidUntil(data);
                break;
        }
    }
}
