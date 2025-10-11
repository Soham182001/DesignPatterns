package CarRentalSystemLLD.Product;

import java.time.LocalDate;

public class Vehicle {

    int VehicleId;
    String vehicleNumber;
    VehicleType vehicleType;
    String companyName;
    String modelName;
    LocalDate manufactureDate;
    String color;
    int seatingCapacity;
    String fuelType;
    int mileage;
    int dailyRentalPrice;
    int hourlyRentalPrice;
    Status status;

    public int getVehicleId() {
        return VehicleId;
    }
    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public LocalDate getManufactureDate() {
        return manufactureDate;
    }
    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public int getDailyRentalPrice() {
        return dailyRentalPrice;
    }
    public void setDailyRentalPrice(int dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }
    public int getHourlyRentalPrice() {
        return hourlyRentalPrice;
    }
    public void setHourlyRentalPrice(int hourlyRentalPrice) {
        this.hourlyRentalPrice = hourlyRentalPrice;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
