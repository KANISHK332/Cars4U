//import java.util.List;
import java.util.*;

public class carrentalsys {
    private List<Car> cars;
    private List<customer> customerList;
    private List<Rental> rentals;

    public carrentalsys() {
        cars= new ArrayList<>();
        customerList= new ArrayList<>();
        rentals= new ArrayList<>();
    }

    public void addcars(Car car){
        cars.add(car);
    }
    public void addcustomer(customer cus){
        customerList.add(cus);
    }
    public void rentcar(Car car, customer cus,int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,cus,days));
        }
        else{
            System.out.println("Car is not available for rent...");
        }
    }

    public void returncar(Car car){
        Rental rentalToRemove = null;
        for(Rental rental:rentals){
            if(rental.getCar()==car){
                car.returncar();
                rentalToRemove= rental;
                break;
            }
        }
        if(rentalToRemove!=null){
            rentals.remove(rentalToRemove);
//            System.out.println("Car returned successfully...");
        } else{
            System.out.println("Car was not rented...");
        }

    }
    public void menu(){
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println(" ====== Car Rental System ====== ");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choices: ");

            int choice = sc.nextInt();
            sc.nextLine();// consume nextline

            if(choice==1){
                System.out.println("\n== Rent a Car ==\n");
                System.out.print("Enter your name: ");
                String customername= sc.nextLine();
                System.out.println("\nAvailable Cars:");
                for(Car car: cars){
                    if(car.isAvailable()) {
                        System.out.println(car.getCarid() + " - " + car.getBrand() + " " + car.getModel());
                    }
                }
                System.out.print("\nEnter the car ID you want to rent: ");
                String carId= sc.nextLine();
                System.out.print("Enter the number of days for rental: ");
                int rentaldays= sc.nextInt();
                sc.nextLine();

                customer newcustomer= new customer("CUS"+(customerList.size()+1),customername);
                addcustomer(newcustomer);

                Car selectedCar= null;
                for(Car car:cars){
                    if(car.getCarid().equals(carId)&& car.isAvailable()){
                        selectedCar=car;
                        break;
                    }
                }
                if(selectedCar!=null){
                    double totalPrice= selectedCar.Calculatetotal(rentaldays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: "+newcustomer.getId());
                    System.out.println("Customer Name: "+newcustomer.getName());
                    System.out.println("Car: "+selectedCar.getBrand()+" "+selectedCar.getModel());
                    System.out.println("Rental days: "+rentaldays);
                    System.out.println("Total Price: "+"$"+totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm= sc.nextLine();
                    if(confirm.equalsIgnoreCase("Y")){
                        rentcar(selectedCar,newcustomer,rentaldays);
                        System.out.println("\nCar rented Successfully.");

                    } else{
                        System.out.println("Rental Cancelled!!");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not available for rent...");
                }
            } else if (choice==2) {
                System.out.println("\n == Return a Car == \n");
                System.out.print("Enter the Car ID you want to return: ");
                String carId= sc.nextLine();

                Car cartoreturn= null;
                for(Car car:cars){
                    if(car.getCarid().equals(carId)&& !car.isAvailable()){
                        cartoreturn= car;
                        break;
                    }
                }
                if(cartoreturn!=null){
                    customer cus= null;
                    for(Rental rental:rentals){
                        if(rental.getCar()==cartoreturn){
                            cus= rental.getCus();
                            break;
                        }
                    }
                    if(cus!=null){
                        returncar(cartoreturn);
                        System.out.println("Car returned Successfully by "+cus.getName());
                    } else{
                        System.out.println("Car was not rented or rental information is missing...");
                    }
                }
                else{
                    System.out.println("Invalid car ID or car not rented...");
                }
            } else if(choice==3){
                System.out.println("\nThank you for using car rental systum");
                break;
            } else{
                System.out.println("Invalid choice. Please enter a valid option...");
            }

        }
    }
}
