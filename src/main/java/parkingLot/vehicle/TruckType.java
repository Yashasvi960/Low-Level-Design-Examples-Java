package parkingLot.vehicle;

public class TruckType extends Vehicle {
    public TruckType(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
