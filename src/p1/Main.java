package src.p1;

import java.util.ArrayList;
import java.util.List;

// Enum для типів тварин
enum AnimalType {
    PREDATOR("Хижак"),
    HERBIVORE("Травоїдна"),
    OMNIVORE("Всеїдна");

    private final String description;

    AnimalType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

// Enum для типів їжі
enum FoodType {
    MEAT("М'ясо"),
    VEGETABLE("Овочі"),
    FRUIT("Фрукти");

    private final String description;

    FoodType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

// Абстрактний клас Animal з інкапсуляцією
abstract class Animal {
    private String name;
    private AnimalType animalType;
    private int age;
    private double weight;
    private int hungerLevel;
    private String location;

    public Animal(String name, AnimalType animalType, int age, double weight, int hungerLevel, String location) {
        this.name = name;
        this.animalType = animalType;
        this.age = age;
        this.weight = weight;
        this.hungerLevel = hungerLevel;
        this.location = location;
    }

    // Геттери для всіх полів
    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public String getLocation() {
        return location;
    }

    // Абстрактні методи
    public abstract void makeSound();
    public abstract void move();

    // Метод годування
    public void feed(Food food) {
        if (this.animalType == AnimalType.HERBIVORE && food.getFoodType() == FoodType.MEAT) {
            System.out.println(name + " - травоїдна і відмовляється від "
                    + food.getName() + " (" + food.getFoodType().getDescription() + ")");
        } else {
            int newHunger = Math.max(0, this.hungerLevel - food.getSatiety());
            this.hungerLevel = newHunger;
            System.out.println(name + " з'їв " + food.getName() + ". Рівень голоду тепер: " + this.hungerLevel);
        }
    }

    // Метод повернення повної інформації про тварину
    public String getInfo() {
        return "Назва: " + name + ", Вид: " + animalType.getDescription() +
                ", Вік: " + age + ", Вага: " + weight + " кг, Рівень голоду: " + hungerLevel +
                ", Місце: " + location;
    }
}

// Дочірній клас Lion клас, який наслідує від Animal і перевизначає його методи, щоб відобразити поведінку саме лева.
class Lion extends Animal {
    public Lion(String name, int age, double weight, int hungerLevel, String location) {
        super(name, AnimalType.PREDATOR, age, weight, hungerLevel, location);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " ричить!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " біжить велично по савані.");
    }
}

// Дочірній клас Elephant поведінку для слона
class Elephant extends Animal {
    public Elephant(String name, int age, double weight, int hungerLevel, String location) {
        super(name, AnimalType.HERBIVORE, age, weight, hungerLevel, location);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " трубає!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " повільно крокує своїм важким тілом.");
    }
}

// Дочірній клас Monkey для цеї мавпи.
class Monkey extends Animal {
    public Monkey(String name, int age, double weight, int hungerLevel, String location) {
        super(name, AnimalType.OMNIVORE, age, weight, hungerLevel, location);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " пищить і кричить!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " стрибає з гілки на гілку.");
    }
}

// Клас Food з інкапсуляцією
class Food {
    private String name;
    private FoodType foodType;
    private int satiety;

    public Food(String name, FoodType foodType, int satiety) {
        this.name = name;
        this.foodType = foodType;
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public int getSatiety() {
        return satiety;
    }
}

// Абстрактний клас ZooEmployee з інкапсуляцією
abstract class ZooEmployee {
    private int id;
    private String name;
    private int experience; // від 1 до 4
    private String activity;

    public ZooEmployee(int id, String name, int experience, String activity) {
        if (experience < 1 || experience > 4) {
            throw new IllegalArgumentException("Досвід має бути від 1 до 4");
        }
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.activity = activity;
    }

    // Геттери і сеттер для досвіду
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int newExperience) {
        if (newExperience < 1 || newExperience > 4) {
            throw new IllegalArgumentException("Досвід має бути від 1 до 4");
        }
        this.experience = newExperience;
    }

    public String getActivity() {
        return activity;
    }

    // Метод, що розповідає про тварину
    public void tellAboutAnimal(Animal animal) {
        System.out.println("Працівник " + name + " розповідає про тварину: " + animal.getInfo());
    }
}

// Працівник, що вміє годувати тварин  (але це не точно (треба перевірити чи він не ))
class Feeder extends ZooEmployee {
    public Feeder(int id, String name, int experience) {
        super(id, name, experience, "Годування");
    }

    // Метод годування; перевіряємо, чи має достатній досвід для роботи з хижаками
    public void feedAnimal(Animal animal, Food food) {
        if(animal.getAnimalType() == AnimalType.PREDATOR && getExperience() == 1) {
            System.out.println("Недостатній досвід для годування хижаків!");
            return;
        }
        System.out.println("Працівник " + getName() + " годує " + animal.getName() + " їжею " + food.getName() + ".");
        animal.feed(food);
    }
}

// Працівник, що вміє тренувати тварин (але це не точно))
class Trainer extends ZooEmployee {
    public Trainer(int id, String name, int experience) {
        super(id, name, experience, "Тренування");
    }

    // Метод тренування; перевіряємо, чи має достатній досвід для роботи з хижаками
    public void trainAnimal(Animal animal) {
        if(animal.getAnimalType() == AnimalType.PREDATOR && getExperience() == 1) {
            System.out.println("Недостатній досвід для тренування хижаків!");
            return;
        }
        System.out.println("Працівник " + getName() + " тренує " + animal.getName() + ".");
        animal.makeSound();
        animal.move();
    }
}

// Основний клас Zoo для керуванням цим  зоопарком
class Zoo {
    private List<Animal> animals;
    private List<ZooEmployee> employees;

    public Zoo() {
        animals = new ArrayList<>();
        employees = new ArrayList<>();
    }

    // Метод додавання тварин
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Додано тварину: " + animal.getName());
    }

    // Метод додавання працівників
    public void addEmployee(ZooEmployee employee) {
        employees.add(employee);
        System.out.println("Додано працівника: " + employee.getName());
    }

    // Метод зміни досвіду працівника за ID
    public void changeEmployeeExperience(int employeeId, int newExperience) {
        for (ZooEmployee emp : employees) {
            if (emp.getId() == employeeId) {
                emp.setExperience(newExperience);
                System.out.println("Змінено досвід для " + emp.getName() + " на " + newExperience);
                return;
            }
        }
        System.out.println("Працівника з таким ID не знайдено.");
    }

    // Виведення списку тварин
    public void listAnimals() {
        System.out.println("Список тварин:");
        for (Animal animal : animals) {
            System.out.println(animal.getInfo());
        }
    }

    // Виведення списку працівників
    public void listEmployees() {
        System.out.println("Список працівників:");
        for (ZooEmployee emp : employees) {
            System.out.println("ID: " + emp.getId() + ", Ім'я: " + emp.getName() +
                    ", Досвід: " + emp.getExperience() + ", Діяльність: " + emp.getActivity());
        }
    }
}

// Головний клас для запуску програми
public class Main {
    public static void main(String[] args) {
        //  об'єкти їжі (мінімум два)
        Food meat = new Food("М'ясо яловичини", FoodType.MEAT, 30);
        Food vegetables = new Food("Свіжі овочі", FoodType.VEGETABLE, 20);

        // Створюємо зоопарк
        Zoo zoo = new Zoo();

        // Додаємо тварин
        Animal lion = new Lion("Левище", 5, 190, 50, "Савана");
        Animal elephant = new Elephant("Наш Слоняра", 10, 5400, 40, "Африканська савана");
        Animal monkey = new Monkey("Мавпочка", 3, 35, 25, "Тропічний ліс");

        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);
        zoo.addAnimal(monkey);

        // Додаємо працівників
        ZooEmployee feeder = new Feeder(1, "Ярослав", 3);
        ZooEmployee trainer = new Trainer(2, "Ярік", 4);

        zoo.addEmployee(feeder);
        zoo.addEmployee(trainer);

        // Працівники розповідають про тварин
        feeder.tellAboutAnimal(lion);
        trainer.tellAboutAnimal(elephant);

        // Виконуємо завдання співробітників
        ((Feeder)feeder).feedAnimal(lion, meat);      // Лев — хижак, досвід достатній (3)
        ((Feeder)feeder).feedAnimal(elephant, meat);    // Слон — травоїдна, відмовляється від м'яса
        ((Trainer)trainer).trainAnimal(monkey);          // Тренування мавпи

        // Зміна досвіду працівника
        zoo.changeEmployeeExperience(1, 4);

        // Виведення списку тварин та працівників
        zoo.listAnimals();
        zoo.listEmployees();
    }
}
