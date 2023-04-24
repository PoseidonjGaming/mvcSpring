package fr.perso.mvc.model;

public class VehiculeDto {
    private long id;

    private long owner;

    private int wheelCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long ownerId) {
        this.owner = ownerId;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }
}
