package parkingLot.vehicle;

public abstract class Vehicle {
  public abstract VehicleType getType();
  private final String licensePlate;

  public Vehicle(String licensePlate) {
      this.licensePlate = licensePlate;
  }

  public String getLicensePlate() {
      return licensePlate;
  }

}
