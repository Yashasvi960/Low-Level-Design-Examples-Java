package parkingLot.spot;

import parkingLot.vehicle.SpotType;
import parkingLot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String spotId;
    private SpotType spotType;

    private boolean isFree;

    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public String getSpotId() {
        return spotId;
    }

    public void parkVehicle(Vehicle vehicle) {
       isFree = false;
       parkedVehicle = vehicle;
    }

    public void unParkVehicle() {
        isFree = true;
        parkedVehicle = null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }


}
