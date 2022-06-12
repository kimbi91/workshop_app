package hu.progmatic.models;

public class TyreSet implements SavedData{

    private Client owner;
    private boolean isWheel;
    private String brand;
    private double treadDepht;
    private boolean isSummerTread;
    private int numOfTyresInSet;
    private String damages;

    public TyreSet() {
    }

    public TyreSet(Client owner, boolean isWheel, String brand, double treadDepht, boolean isSummerTread, int numOfTyresInSet, String damages) {
        this.owner = owner;
        this.isWheel = isWheel;
        this.brand = brand;
        this.treadDepht = treadDepht;
        this.isSummerTread = isSummerTread;
        this.numOfTyresInSet = numOfTyresInSet;
        this.damages = damages;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public boolean isWheel() {
        return isWheel;
    }

    public void setWheel(boolean wheel) {
        isWheel = wheel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getTreadDepht() {
        return treadDepht;
    }

    public void setTreadDepht(double treadDepht) {
        this.treadDepht = treadDepht;
    }

    public boolean isSummerTread() {
        return isSummerTread;
    }

    public void setSummerTread(boolean summerTread) {
        isSummerTread = summerTread;
    }

    public int getNumOfTyresInSet() {
        return numOfTyresInSet;
    }

    public void setNumOfTyresInSet(int numOfTyresInSet) {
        this.numOfTyresInSet = numOfTyresInSet;
    }

    public String getDamages() {
        return damages;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }

}
