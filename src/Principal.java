import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Introduce el autor del libro:");
        String autor = scanner.nextLine();
        System.out.println("Introduce el ISBN del libro:");
        String isbn = scanner.nextLine();

        Libro libro = new Libro(titulo, autor, isbn);
        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Ver Información del Libro");
            System.out.println("2. Modificar Título");
            System.out.println("3. Modificar Autor");
            System.out.println("4. Modificar ISBN");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nInformación del Libro:");
                    System.out.println("Título: " + libro.getTitulo());
                    System.out.println("Autor: " + libro.getAutor());
                    System.out.println("ISBN: " + libro.getIsbn());
                    break;

                case 2:
                    System.out.println("\nIntroduce el nuevo título:");
                    String nuevoTitulo = scanner.nextLine();
                    libro.setTitulo(nuevoTitulo);
                    System.out.println("Título actualizado.");
                    break;

                case 3:
                    System.out.println("\nIntroduce el nuevo autor:");
                    String nuevoAutor = scanner.nextLine();
                    libro.setAutor(nuevoAutor);
                    System.out.println("Autor actualizado.");
                    break;

                case 4:
                    System.out.println("\nIntroduce el nuevo ISBN:");
                    String nuevoISBN = scanner.nextLine();
                    if (libro.setISBN(nuevoISBN)) {
                        System.out.println("ISBN actualizado.");
                    } else {
                        System.out.println("ISBN no válido. No se ha actualizado.");
                    }
                    break;

                case 5:
                    System.out.println("Salir del programa");
                    break;

                default:
                    System.out.println("Opción no válida.");

            }
        } while (opcion != 5);

        scanner.close();
    }
}
