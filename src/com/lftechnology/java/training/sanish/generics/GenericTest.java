package com.lftechnology.java.training.sanish.generics;

import com.lftechnology.java.training.niraj.fibonacci.Constant;
import com.lftechnology.java.training.sanish.generics.constants.*;
import com.lftechnology.java.training.sanish.generics.customer.BankCustomer;
import com.lftechnology.java.training.sanish.generics.customer.Customer;
import com.lftechnology.java.training.sanish.generics.customer.RestaurantCustomer;
import com.lftechnology.java.training.sanish.generics.product.Computer;
import com.lftechnology.java.training.sanish.generics.product.Mouse;
import com.lftechnology.java.training.sanish.generics.product.Product;
import com.lftechnology.java.training.sanish.generics.vehicle.Car;
import com.lftechnology.java.training.sanish.generics.vehicle.VehicleList;
import com.lftechnology.java.training.sanish.generics.vehicle.VehicleListImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generic class, interface & function test
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class GenericTest {
    private static final Logger LOGGER = Logger.getLogger(VehicleListImpl.class.getName());

    private GenericTest() {
    }

    public static void main(String[] args) {
        // add two number using generic function
        addIntegerNumbers(2, 5);
        addDoubleNumbers(3.5, 7.75);

        // add / remove vehicle list of diffenrent type with generic class
        workOnCarList();
        workOnBikeList();

        //Instantiate an object of Product using different data types.
        Product computerProduct = new Product(new Computer("Dell", "Intel® Core™ i5-3337U CPU @ 1.80GHz × 4 ", "7.7 GiB", "500.0 GB"));
        computerProduct.displayProductInfo();

        Product mouseProduct = new Product(new Mouse("Delux", "Optical mouse"));
        mouseProduct.displayProductInfo();

        // display customers information using wildcard function
        List<BankCustomer> bankCustomers = new ArrayList<BankCustomer>();
        bankCustomers.add(new BankCustomer(1, PersonList.ID_1.getName(), PersonList.ID_1.getContactNumber(), 145258696,
                BankName.ID_1.getBankName(), BankAccountType.SAVING.getAccountType()));
        displayList(bankCustomers);

        List<RestaurantCustomer> restaurantCustomers = new ArrayList<RestaurantCustomer>();
        restaurantCustomers.add(new RestaurantCustomer(1, PersonList.ID_2.getName(), PersonList.ID_2.getContactNumber(),
                RestaurentName.ID_1.getRestaurantName()));
        restaurantCustomers.add(new RestaurantCustomer(2, PersonList.ID_3.getName(), PersonList.ID_3.getContactNumber(),
                RestaurentName.ID_2.getRestaurantName()));
        displayList(restaurantCustomers);
    }

    /**
     * Add two integer number using generic function
     *
     * @param num1 {@link Integer}
     * @param num2 {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void addIntegerNumbers(int num1, int num2) {
        NumberOperator<Integer> intNumOperator = new NumberOperator<Integer>();
        Number sumIntNumber = intNumOperator.addTwoNumbers(num1, num2);
        LOGGER.log(Level.INFO, "Sum of {0} + {1} = {2}", new Object[] { num1, num2, sumIntNumber });
    }

    /**
     * Add two double number using generic function
     *
     * @param num1 {@link Double}
     * @param num2 {@link Double}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void addDoubleNumbers(double num1, double num2) {
        NumberOperator<Double> doubleNumOperator = new NumberOperator<Double>();
        Number sumDoubleNumber = doubleNumOperator.addTwoNumbers(num1, num2);
        LOGGER.log(Level.INFO, "Sum of {0} + {1} = {2}", new Object[] { num1, num2, sumDoubleNumber });
    }

    /**
     * Add / remove cars form car list using generic class
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void workOnCarList() {
        VehicleList<Car> carList = new VehicleListImpl<Car>();
        carList.addVehicle(new Car(VehicleBrand.BMW.getBrandName(), Color.BLACK.getColor()));
        carList.addVehicle(new Car(VehicleBrand.FERRARI.getBrandName(), Color.RED.getColor()));
        carList.addVehicle(new Car(VehicleBrand.KIA.getBrandName(), Color.BLACK.getColor()));
        carList.addVehicle(new Car(VehicleBrand.FERRARI.getBrandName(), Color.WHITE.getColor()));
        carList.addVehicle(new Car(VehicleBrand.BMW.getBrandName(), Color.RED.getColor()));

        carList.listVehicles();
        carList.removeVehicle(2);
        carList.removeVehicle(2);
        carList.listVehicles();
    }

    /**
     * Add / remove cars form car list using generic class
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void workOnBikeList() {
        VehicleList<Car> bikeList = new VehicleListImpl<Car>();
        bikeList.addVehicle(new Car(VehicleBrand.YAMAHA.getBrandName(), Color.BLACK.getColor()));
        bikeList.addVehicle(new Car(VehicleBrand.HONDA.getBrandName(), Color.RED.getColor()));
        bikeList.addVehicle(new Car(VehicleBrand.KIA.getBrandName(), Color.WHITE.getColor()));
        bikeList.addVehicle(new Car(VehicleBrand.ATK.getBrandName(), Color.BLACK_WHITE.getColor()));
        bikeList.addVehicle(new Car(VehicleBrand.BAJAJ.getBrandName(), Color.RED.getColor()));

        bikeList.listVehicles();
        bikeList.removeVehicle(2);
        bikeList.removeVehicle(2);
        bikeList.listVehicles();
    }

    /**
     * Method which takes List of any subclass of object Customer. (use wildcard)
     *
     * @param customers {@link Customer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void displayList(List<? extends Customer> customers) {
        String customerListText = "";
        for (Customer customer : customers) {
            customerListText += customer.toString() + "\n";
        }

        LOGGER.log(Level.INFO, "Car list : \n" +
                "==================================== \n" +
                "{0}", new Object[] { customerListText });
    }

}
