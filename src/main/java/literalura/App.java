package literalura;

import com.google.gson.Gson;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Database.init();
        Scanner scanner = new Scanner(System.in);
        BookService service = new BookService();
        String json = service.getAllBooks();

        Gson gson = new Gson();
        BookResponse response = gson.fromJson(json, BookResponse.class);
        List<Book> books = response.getResults();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Catálogo LiterAlura ===");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Mostrar todos los autores");
            System.out.println("3. Buscar libro por título");
            System.out.println("4. Buscar autor por nombre");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    books.forEach(book -> System.out.println(book.getTitle()));
                    try (var conn = Database.getConnection();
                         var stmt = conn.prepareStatement(
                                 "INSERT INTO books (id, title, author) VALUES (?, ?, ?)")) {

                        for (Book book : books) {
                            stmt.setInt(1, book.getId());
                            stmt.setString(2, book.getTitle());
                            stmt.setString(3, book.getAuthors().get(0).getName());
                            stmt.executeUpdate();
                        }
                        System.out.println("Libros guardados ✅");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    books.stream()
                            .flatMap(book -> book.getAuthors().stream())
                            .map(Author::getName)
                            .distinct()
                            .forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Título a buscar: ");
                    String title = scanner.nextLine().toLowerCase();
                    books.stream()
                            .filter(book -> book.getTitle().toLowerCase().contains(title))
                            .forEach(b -> System.out.println(b.getTitle()));
                    break;
                case 4:
                    System.out.print("Autor a buscar: ");
                    String author = scanner.nextLine().toLowerCase();
                    books.stream()
                            .filter(book -> book.getAuthors()
                                    .stream()
                                    .anyMatch(a -> a.getName().toLowerCase().contains(author)))
                            .forEach(b -> System.out.println(b.getTitle() + " - " +
                                    b.getAuthors().get(0).getName()));
                    break;
                case 5:
                    running = false;
                    System.out.println("Hasta luego :)");
                    break;


                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
