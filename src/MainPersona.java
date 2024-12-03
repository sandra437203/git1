import java.util.Scanner;

public class MainPersona {
    public static void main(String[] args) {
        Persona.GestorPersonas gestor = new Persona.GestorPersonas();

        Persona p1 = new Persona("Juan", "Pérez", "12345678Z", 30);
        Persona p2 = new Persona("Ana", "García", "19801234L");

        gestor.agregarPersona(p1);
        gestor.agregarPersona(p2);

        System.out.println("Personas actuales:");
        gestor.mostrarPersonas();

        gestor.modificarPersona("19801234L", "Ana", "Rodríguez", 35);

        gestor.borrarPersona("12345678Z");

        System.out.println("Personas después de modificaciones:");
        gestor.mostrarPersonas();
    }
}
