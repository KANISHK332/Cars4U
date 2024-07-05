// Car Renting System
public class main {
    public static void main(String[] args) {
       carrentalsys crs= new carrentalsys();
       Car c1= new Car("C001","Thar","Mahindra",600.0);
       Car c2= new Car("C002","Amaze","Honda",200.0);
       Car c3= new Car("C003","Q7","Audi",5000.0);

       crs.addcars(c1);
       crs.addcars(c2);
       crs.addcars(c3);

       crs.menu();
    }
}
