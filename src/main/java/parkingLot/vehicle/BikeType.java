package parkingLot.vehicle;

public class BikeType extends Vehicle {
    public BikeType(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
