package hu.progmatic.models;

public class StoredSet implements SavedData{

    private Client client;
    private TyreSet tyreSet;
    private boolean isFleet;
    private String fleetInfo;
    private String paidUntil;

    public StoredSet() {
    }

    public StoredSet(Client client, TyreSet tyreSet, boolean isFleet, String paidUntil) {
        this.client = client;
        this.tyreSet = tyreSet;
        this.isFleet = isFleet;
        this.paidUntil = paidUntil;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TyreSet getTyreSet() {
        return tyreSet;
    }

    public void setTyreSet(TyreSet tyreSet) {
        this.tyreSet = tyreSet;
    }

    public boolean isFleet() {
        return isFleet;
    }

    public void setFleet(boolean fleet) {
        isFleet = fleet;
    }

    public String getFleetInfo() {
        if (isFleet) {
            return fleetInfo;
        } else {
            return "Nem tartozik flottához!";
        }
    }

    public void setFleetInfo(String fleetInfo) {
        if (isFleet) {
            this.fleetInfo = fleetInfo;
        }
    }

    public String getPaidUntil() {
        return paidUntil;
    }

    public void setPaidUntil(String paidUntil) {
        this.paidUntil = paidUntil;
    }
}
