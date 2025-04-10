import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {

    // Список для збереження книг бібліотеки
    private List<Book> books;

    // Конструктор класу Library
    public Library() {
        books = new ArrayList<>();
    }

    // Внутрішній клас Book, який представляє книгу
    public class Book {
        private String title;
        private String author;

        // Конструктор класу Book
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // Метод для відображення інформації про книгу
        public void printInfo() {
            System.out.println("Книга: " + title + ", Автор: " + author);
        }

        // Геттери для отримання значень полів
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }

    // Інтерфейс для фільтрації книг
    public interface BookFilter {
        boolean filter(Book book);
    }

    // Метод для додавання нової книги до бібліотеки
    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Додано книгу: " + title + " (" + author + ")");
    }

    // Метод для відображення всіх книг бібліотеки
    public void displayBooks() {
        System.out.println("\nСписок книг бібліотеки:");
        for (Book book : books) {
            book.printInfo();
        }
    }

    // Метод для сортування книг за назвою (без врахування регістру)
    public void sortBooks() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });
        System.out.println("\nСписок книг відсортовано за назвою.");
    }

    // Метод для фільтрації книг із застосуванням анонімного класу
    public void filterBooks() {
        // Анонімний клас, що реалізовує інтерфейс BookFilter.
        // Фільтрація здійснюється за умовою: назва книги містить літеру "а"
        BookFilter filter = new BookFilter() {
            @Override
            public boolean filter(Book book) {
                return book.getTitle().toLowerCase().contains("а");
            }
        };

        List<Book> filtered = new ArrayList<>();
        for (Book book : books) {
            if (filter.filter(book)) {
                filtered.add(book);
            }
        }

        System.out.println("""
                Список фільтрованих книг (назва містить 'а'):
                """);
        for (Book book : filtered) {
            book.printInfo();
        }
    }

    // Метод main для демонстрації роботи програми
    public static void main(String[] args) {
        Library lib = new Library();

        // Додавання книг
        lib.addBook("назва книги", "Автор");
        lib.addBook("Посібник рейнджера", "US Army");
        lib.addBook("1984", "Джордж Орвелл");
        lib.addBook("Ідеальний шторм", "Дірк Райнгардт");

        // Відображення списку книг
        lib.displayBooks();

        // Сортування книг і повторне відображення відсортованого списку
        lib.sortBooks();
        lib.displayBooks();

        // Фільтрація книг з використанням анонімного класу
        lib.filterBooks();
    }
}
