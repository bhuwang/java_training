package com.lftechnology.java.training.niraj.vehiclelist;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Adds, Removes,list vehicles using Generic class
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class GenericVehicleList {

    private static final Logger LOGGER = Logger.getLogger(GenericVehicleList.class.getName());
    private VehiclesDaoImpl<Car> carDao;
    private VehiclesDaoImpl<MotorBikes> motorBikeDao;
    private VehicleServiceImpl<Car> carService;
    private VehicleServiceImpl<MotorBikes> motorBikeService;
    private String[] carBrands = { "BMW", "Mercedes", "Volkswagon", "AUDI" };
    private String[] motorbikeBrands = { "Ducati", "Honda", "Yamaha", "Sujuki" };

    private GenericVehicleList() {
        carDao = new VehiclesDaoImpl<Car>();
        motorBikeDao = new VehiclesDaoImpl<MotorBikes>();
        carService = new VehicleServiceImpl<Car>(carDao);
        motorBikeService = new VehicleServiceImpl<MotorBikes>(motorBikeDao);
    }

    public static void main(String[] args) {
        GenericVehicleList genericVehicleList = new GenericVehicleList();
        genericVehicleList.addBikes();
        List<MotorBikes> bikeList = genericVehicleList.motorBikeService.list();
        LOGGER.log(Level.INFO, "\n\nMotor Bike Brands:\n{0}\n\n", bikeList);

        genericVehicleList.addCars();

        List<Car> carList = genericVehicleList.carService.list();
        LOGGER.log(Level.INFO, "\n\nCar Brands:\n{0}\n\n", carList);

        genericVehicleList.removeCar("BMW");
        carList = genericVehicleList.carService.list();
        LOGGER.log(Level.INFO, "\n\nCar Brands after removing BMW:\n{0}\n\n", carList);

        genericVehicleList.removeBike("Ducati");
        bikeList = genericVehicleList.motorBikeService.list();
        LOGGER.log(Level.INFO, "\n\nMotor Bike Brands after removing Ducati:\n{0}\n\n", bikeList);
    }

    /**
     * Adds bike
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * 
     */
    private void addBikes() {
        for (int i = 0; i < motorbikeBrands.length; i++) {
            MotorBikes motorBike = addMotorBikeBrand(motorbikeBrands[i]);
            LOGGER.log(Level.INFO, "Motorbike of Brand : \"{0}\" is added", motorBike.getBrand());
        }
    }

    /**
     * Adds cars
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     */
    private void addCars() {
        for (int i = 0; i < carBrands.length; i++) {
            Car car = addCarBrand(carBrands[i]);
            LOGGER.log(Level.INFO, "Car of Brand : \"{0}\" is added", car.getBrand());
        }
    }

    /**
     * Add a motorbike
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param brand
     *            {@link String}
     * @return {@link MotorBikes}
     */
    private MotorBikes addMotorBikeBrand(String brand) {
        MotorBikes bike = new MotorBikes();
        bike.setBrand(brand);
        motorBikeService.add(bike);
        return bike;
    }

    /**
     * Add a car
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param brand
     *            {@link String}
     * @return {@link Car}
     */
    private Car addCarBrand(String brand) {
        Car car = new Car();
        car.setBrand(brand);
        carService.add(car);
        return car;
    }

    /**
     * Removes car
     * 
     * @author Niraj Rajbhandari<nirajrajbhandari@lftechnology.com>
     * @param brand
     *            String
     */
    private void removeCar(String brand) {
        Car car = carService.findByBrand(brand);
        if (car != null) {
            boolean removeCar = carService.remove(car);
            if (removeCar) {
                LOGGER.log(Level.INFO, "Successfully removed car brand : {0}", brand);
            } else {
                LOGGER.log(Level.SEVERE, "Failed to remove car brand : {0}", brand);
            }
        } else {
            LOGGER.log(Level.WARNING, "Car with brand {0} is not available", brand);
        }
    }

    /**
     * Removes motorbike
     * @param brand
     */
    private void removeBike(String brand) {
        MotorBikes bike = motorBikeService.findByBrand(brand);
        if (bike != null) {
            boolean removeBike = motorBikeService.remove(bike);
            if (removeBike) {
                LOGGER.log(Level.INFO, "Successfully removed motor bike brand : {0}", brand);
            } else {
                LOGGER.log(Level.SEVERE, "Failed to remove motor bike brand : {0}", brand);
            }
        } else {
            LOGGER.log(Level.WARNING, "Motor bike with brand {0} is not available", brand);
        }
    }
}
