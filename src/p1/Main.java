import java.util.ArrayList;
import java.util.List;

// Інтерфейс для спостерігачів
interface Observer {
    // Метод для отримання сповіщень про новий допис
    void update(String creatorNick, String postContent);
}

// Інтерфейс для об'єктів, які можуть мати підписників (Observeble)
interface Observable {
    // Додавання спостерігача
    void add(Observer observer);
    // Видалення спостерігача
    void remove(Observer observer);
    // Сповіщення підписників про новий допис
    void notify(String postContent);
}

// Клас Creator – реалізує Observable
class Creator implements Observable {
    private String nick;
    private int postCount;
    private List<Observer> subscribers;

    // Конструктор
    public Creator(String nick) {
        this.nick = nick;
        this.postCount = 0;
        this.subscribers = new ArrayList<>();
    }

    // Геттери
    public String getNick() {
        return nick;
    }

    public int getPostCount() {
        return postCount;
    }

    // Повертає кількість підписників
    public int getSubscriberCount() {
        return subscribers.size();
    }

    // Метод публікації нового посту: збільшує лічильник постів та сповіщає підписників
    public void publishPost(String postContent) {
        postCount++;
        System.out.println("Творець " + nick + " опублікував допис: " + postContent);
        notify(postContent);
    }

    // Додавання спостерігача
    @Override
    public void add(Observer observer) {
        subscribers.add(observer);
    }

    // Видалення спостерігача
    @Override
    public void remove(Observer observer) {
        subscribers.remove(observer);
    }

    // Сповіщення всіх підписників про новий допис
    @Override
    public void notify(String postContent) {
        for (Observer o : subscribers) {
            o.update(nick, postContent);
        }
    }
}

// Клас User – реалізує Observer
class User implements Observer {
    private String username;

    // Конструктор
    public User(String username) {
        this.username = username;
    }

    // Метод сповіщення – викликається при публікації нового допису творцем
    @Override
    public void update(String creatorNick, String postContent) {
        System.out.println("Користувач " + username + " отримав повідомлення: " +
                "Новий допис від " + creatorNick + " -> " + postContent);
    }

    public String getUsername() {
        return username;
    }
}

// Головний клас з методом main
public class Main {
    public static void main(String[] args) {
        // Створення 3-х творців
        Creator creator1 = new Creator("CreatorOne");
        Creator creator2 = new Creator("CreatorTwo");
        Creator creator3 = new Creator("CreatorThree");

        // Створення 7-ми користувачів
        User user1 = new User("UserOne");
        User user2 = new User("UserTwo");
        User user3 = new User("UserThree");
        User user4 = new User("UserFour");
        User user5 = new User("UserFive");
        User user6 = new User("UserSix");
        User user7 = new User("UserSeven");

        // Підписка користувачів на творців
        // CreatorOne має 3 підписники: UserOne, UserTwo, UserThree
        creator1.add(user1);
        creator1.add(user2);
        creator1.add(user3);

        // CreatorTwo має 3 підписники: UserTwo, UserFour, UserFive
        creator2.add(user2);
        creator2.add(user4);
        creator2.add(user5);

        // CreatorThree має 3 підписники: UserThree, UserSix, UserSeven
        creator3.add(user3);
        creator3.add(user6);
        creator3.add(user7);

        // Додаткові підписки: деякі користувачі підписані на більше ніж одного творця
        creator3.add(user1); // UserOne тепер підписаний і на CreatorOne, і на CreatorThree
        creator2.add(user7); // UserSeven тепер підписаний і на CreatorTwo, і на CreatorThree

        // Публікація постів творцями - сповіщення надходитимуть їх підписникам
        System.out.println("\n--- Публікація постів ---");
        creator1.publishPost("Новий допис від CreatorOne.");
        creator2.publishPost("Оновлення від CreatorTwo.");
        creator3.publishPost("Свіжі новини від CreatorThree.");
    }
}
