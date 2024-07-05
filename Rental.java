public class Rental {
    private Car car;
    private customer cus;
    private int day;

    public Rental(Car car, customer cus, int day) {
        this.car = car;
        this.cus = cus;
        this.day = day;
    }

    public Car getCar() {
        return car;
    }

    public customer getCus() {
        return cus;
    }

    public int getDay() {
        return day;
    }
}
