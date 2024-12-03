import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        setDni(dni);
        setEdad(edad);
    }

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        setDni(dni);
        this.edad = calcularEdad(dni);
    }

    private int calcularEdad(String dni) {
        if (dni != null && dni.length() >= 4) {
            try {
                int añoNacimiento = Integer.parseInt(dni.substring(0, 4));
                int añoActual = LocalDate.now().getYear();
                return añoActual - añoNacimiento;
            } catch (NumberFormatException e) {
                System.err.println("ERROR: Formato de DNI no válido para calcular la edad.");
            }
        }
        return 0;
    }

    private boolean compruebaDni(String dni) {
        if (dni.matches("^\\d{8}[A-Za-z]$")) {
            char letraDni = dni.charAt(dni.length() - 1);
            int numeroDni = Integer.parseInt(dni.substring(0, 8));
            return letraDni == obtenerLetraDni(numeroDni);
        }
        return false;
    }

    private char obtenerLetraDni(int numeroDni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.charAt(numeroDni % 23);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (compruebaDni(dni)) {
            this.dni = dni;
        } else {
            this.dni = "";
            System.err.println("ERROR: DNI inválido.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0 && edad <= 120) {
            this.edad = edad;
        } else {
            this.edad = 0;
            System.err.println("ERROR: Edad inválida.");
        }
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + (dni.isEmpty() ? "No válido" : dni));
        System.out.println("Edad: " + edad);
    }

    public static class GestorPersonas {
        private List<Persona> personas;

        public GestorPersonas() {
            this.personas = new ArrayList<>();
        }

        public void agregarPersona(Persona persona) {
            personas.add(persona);
            System.out.println("Persona añadida: " + persona.getNombre());
        }

        public void modificarPersona(String dni, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
            for (Persona persona : personas) {
                if (persona.getDni().equals(dni)) {
                    persona.setNombre(nuevoNombre);
                    persona.setApellido(nuevoApellido);
                    persona.setEdad(nuevaEdad);
                    System.out.println("Persona modificada: " + persona.getNombre());
                    return;
                }
            }
            System.out.println("No se encontró una persona con ese DNI.");
        }

        public void borrarPersona(String dni) {
            Persona personaAEliminar = null;
            for (Persona persona : personas) {
                if (persona.getDni().equals(dni)) {
                    personaAEliminar = persona;
                    break;
                }
            }

            if (personaAEliminar != null) {
                personas.remove(personaAEliminar);
                System.out.println("Persona eliminada: " + personaAEliminar.getNombre());
            } else {
                System.out.println("No se encontró una persona con ese DNI.");
            }
        }

        public void mostrarPersonas() {
            if (personas.isEmpty()) {
                System.out.println("No hay personas registradas.");
            } else {
                for (Persona persona : personas) {
                    persona.mostrarInfo();
                    System.out.println();
                }
            }
        }
    }
}


