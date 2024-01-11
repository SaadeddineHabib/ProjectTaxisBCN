import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseDeDatosPersona {

    static class Persona {
        String nombre;
        int identificacion;
        String numeroTelefono;

        public Persona(String nombre, int identificacion, String numeroTelefono) {
            this.nombre = nombre;
            this.identificacion = identificacion;
            this.numeroTelefono = numeroTelefono;
        }
    }

    static List<Persona> BaseDeDatosPersonaPorIdentificacion(ArrayList<Persona> baseDatos, int identificacion) {

        List<Persona> usuariosEncontrados = new ArrayList<>();

        for (Persona persona : baseDatos) {
            if (persona.identificacion == identificacion) {
                usuariosEncontrados.add(persona);
            }
        }

        return usuariosEncontrados;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Persona> baseDatosPersonas = new ArrayList<>();
        baseDatosPersonas.add(new Persona("Juan", 12345, "123-456-7890"));
        baseDatosPersonas.add(new Persona("Maria", 67890, "987-654-3210"));
        baseDatosPersonas.add(new Persona("Carlos", 54321, "456-789-0123"));

        System.out.println("Escribe numero de Identificador para buscar baseDeDote de persona");
        int identificacionBuscar = sc.nextInt();

        List<Persona> usuariosEncontrados = BaseDeDatosPersonaPorIdentificacion(baseDatosPersonas, identificacionBuscar);

        if (!usuariosEncontrados.isEmpty()) {
            System.out.println("Usuarios encontrados " + identificacionBuscar + ":");
            for (Persona usuario : usuariosEncontrados) {
                System.out.println("Nombre: " + usuario.nombre);
                System.out.println("Identificación: " + usuario.identificacion);
                System.out.println("Número de Teléfono: " + usuario.numeroTelefono);
                System.out.println("--------------------");
            }
        } else {
            System.out.println("No se encontraron usuarios " + identificacionBuscar);
        }
    }
}