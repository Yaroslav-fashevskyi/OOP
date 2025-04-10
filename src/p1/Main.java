// Інтерфейс, який успадковуватимуть усі ті дочірні класи
interface IVehicleControl {
    void start();
    void stop();
}

// Інтерфейс для класів, що мають двигун
interface IEngineControl {
    void startEngine();
    void refuel(double fuelAmount);
    void displayMaxRoute();
}

// Базовий клас транспорту
abstract class Vehicle implements IVehicleControl {
    protected String brand;
    protected String model;
    protected int maxSpeed;
    protected int capacity;
    protected int currentSpeed;

    public Vehicle(String brand, String model, int maxSpeed, int capacity) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
        this.currentSpeed = 0;
    }

    public void displayInfo() {
        System.out.println("Бренд: " + brand + ", Модель: " + model + ", Максимальна швидкість: " + maxSpeed + " км/год");
    }

    public void displayCurrentSpeed() {
        System.out.println("Поточна швидкість: " + currentSpeed + " км/год");
    }

    public void displayCapacity() {
        System.out.println("Місткість: " + capacity + " міс.");
    }
}

class Car extends Vehicle implements IEngineControl {
    private double fuelLevel;

    public Car(String brand, String model, int maxSpeed, int capacity, double fuelLevel) {
        super(brand, model, maxSpeed, capacity);
        this.fuelLevel = fuelLevel;
    }

    // Реалізація методу старт
    @Override
    public void start() {
        startEngine();
        System.out.println("Автомобіль запущений.");
        currentSpeed = 10;
    }

    // Реалізація методу стоп
    @Override
    public void stop() {
        System.out.println("Автомобіль зупинено.");
        currentSpeed = 0;
    }

    // Реалізація методу для запуску двигуна
    @Override
    public void startEngine() {
        System.out.println("Двигун автомобіля запущено.");
    }

    // Метод для заправки
    @Override
    public void refuel(double fuelAmount) {
        fuelLevel += fuelAmount;
        System.out.println("Автомобіль заправлено. Поточний рівень палива: " + fuelLevel);
    }

    // Відображення максимальної довжини маршруту 1 згначення палива дає 15 км
    @Override
    public void displayMaxRoute() {
        double maxRoute = fuelLevel * 15;
        System.out.println("Максимальна довжина маршруту: " + maxRoute + " км");
    }
}

// Клас Motorcycle
class Motorcycle extends Vehicle implements IEngineControl {
    private double fuelLevel;

    public Motorcycle(String brand, String model, int maxSpeed, int capacity, double fuelLevel) {
        super(brand, model, maxSpeed, capacity);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void start() {
        startEngine();
        System.out.println("Мотоцикл запущено.");
        currentSpeed = 15;
    }

    @Override
    public void stop() {
        System.out.println("Мотоцикл зупинено.");
        currentSpeed = 0;
    }

    @Override
    public void startEngine() {
        System.out.println("Двигун мотоцикла запущено.");
    }

    @Override
    public void refuel(double fuelAmount) {
        fuelLevel += fuelAmount;
        System.out.println("Мотоцикл заправлено. Поточний рівень палива: " + fuelLevel);
    }

    // Відображення максимальної довжини маршруту 1 згначення палива дає 25 км
    @Override
    public void displayMaxRoute() {
        double maxRoute = fuelLevel * 25;
        System.out.println("Максимальна довжина маршруту: " + maxRoute + " км");
    }
}

// Клас Bicycle
class Bicycle extends Vehicle {
    public Bicycle(String brand, String model, int maxSpeed, int capacity) {
        super(brand, model, maxSpeed, capacity);
    }

    @Override
    public void start() {
        System.out.println("Розпочато поїздку на велосипеді.");
        currentSpeed = 5;
    }

    @Override
    public void stop() {
        System.out.println("Велосипед зупинено.");
        currentSpeed = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        // обєкт
        Car car = new Car("Tesla", "X", 262, 95, 10);
        Motorcycle moto = new Motorcycle("Motorcycle", "1", 300, 10, 5);
        Bicycle bike = new Bicycle("A", "1", 320, 1);

        // обєкт в масив
        Vehicle[] vehicles = { car, moto, bike };

        // Метод для демонстрації роботи всіх методів кожного обєкта
        for (Vehicle v : vehicles) {
            System.out.println("=================================");
            v.displayInfo();
            v.displayCurrentSpeed();
            v.displayCapacity();
            v.start();
            v.displayCurrentSpeed();

            // Якщо транспорт має двигун буде IEngineControl
            if (v instanceof IEngineControl) {
                IEngineControl engineVehicle = (IEngineControl) v;
                engineVehicle.displayMaxRoute();
                // Наприклад, заправляємо транспорт на 5 одиниць палива
                engineVehicle.refuel(5);
                engineVehicle.displayMaxRoute();
            }

            v.stop();
            v.displayCurrentSpeed();
            System.out.println("=================================\n");
        }
    }
}
