package parkingLot.vehicle;

public class CarType extends Vehicle {

    public CarType(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
