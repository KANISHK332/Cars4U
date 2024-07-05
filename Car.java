public class Car {
    private String carid;
    private String Model;
    private String brand;
    private double Priceperday;
    private boolean isAvailable;

    public Car(String carid, String model, String brand, double priceperday) {
        this.carid = carid;
        Model = model;
        this.brand = brand;
        Priceperday = priceperday;
        this.isAvailable = true;
    }

    public String getCarid() {
        return carid;
    }
    public String getModel() {
        return Model;
    }

    public String getBrand() {
        return brand;
    }
    public double getPriceperday() {
        return Priceperday;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public double Calculatetotal(int days){
        return Priceperday*days;
    }
    public void rent(){
        isAvailable= false;
    }
    public void returncar(){
        isAvailable=true;
    }
}
