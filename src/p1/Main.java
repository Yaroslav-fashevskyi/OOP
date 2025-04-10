public class Main {
    public static void main(String[] args) {
        // Створення об’єктів для кожного персонажа
        Character warrior = new Warrior("Воїн", 100);
        Character priest = new Priest("Жрець", 80);
        Character thief = new Thief("Грабіжник", 70);
        Character mage = new Mage("Маг", 60);

        // Виклик перевантажених методів атаки
        System.out.println("=== Атаки ===");
        warrior.attack();
        warrior.attack("меч");

        priest.attack();
        priest.attack("пішли за капличку");

        thief.attack();
        thief.attack("ніж");

        mage.attack();
        mage.attack("супер-палиця");

        // Виклик перевантажених методів захисту
        System.out.println("\n=== Захист ===");
        warrior.defend();
        warrior.defend("щит");

        priest.defend();
        priest.defend("молитва");

        thief.defend();
        thief.defend("тінь");

        mage.defend();
        mage.defend("магічний бар'єр");

        // Виклик спеціальних атак
        System.out.println("\n=== Спеціальні атаки ===");
        warrior.specialAttack();
        priest.specialAttack();
        thief.specialAttack();
        mage.specialAttack();
    }
}

// Базовий клас Character
class Character {
    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Перевантаження методу атаки
    public void attack() {
        System.out.println(name + " атакує звичайною атакою!");
    }

    public void attack(String weapon) {
        System.out.println(name + " атакує з використанням зброї: " + weapon);
    }

    // Перевантаження методу захисту
    public void defend() {
        System.out.println(name + " захищається звичайним способом!");
    }

    public void defend(String shield) {
        System.out.println(name + " захищається за допомогою " + shield + "!");
    }

    // Метод спеціальної атаки, який перевизначається у дочірніх класах
    public void specialAttack() {
        System.out.println(name + " виконує спеціальну атаку!");
    }
}

// Дочірній клас Warrior (воїн)
class Warrior extends Character {
    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    public void specialAttack() {
        System.out.println(name + " виконує потужний удар мечем!");
    }
}

// Дочірній клас Priest (жрець)
class Priest extends Character {
    public Priest(String name, int health) {
        super(name, health);
    }

    @Override
    public void specialAttack() {
        System.out.println(name + " використовує священну силу для зцілення супротивника!");
    }
}

// Дочірній клас Thief (грабіжник)
class Thief extends Character {
    public Thief(String name, int health) {
        super(name, health);
    }

    @Override
    public void specialAttack() {
        System.out.println(name + " виконує стрімкий удар зі спини!");
    }
}


class Mage extends Character {
    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void specialAttack() {
        System.out.println(name + " виконує могутню магічну атаку!");
    }
}
