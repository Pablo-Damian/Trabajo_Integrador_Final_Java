import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    private List<String> palabras;
    private String palabraSecreta;
    private StringBuilder palabraAdivinada;
    private int intentos;

    public Ahorcado() {
        palabras = new ArrayList<>();
        palabraSecreta = "";
        palabraAdivinada = new StringBuilder();
        intentos = 9; // NÚMERO MÁXIMO DE INTENTOS

        cargarPalabrasDesdeArchivo("listaPalabras.txt");
        seleccionarPalabraSecreta();
        inicializarPalabraAdivinada();
    }

    private void cargarPalabrasDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                palabras.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void seleccionarPalabraSecreta() {
        Random rand = new Random();
        int indice = rand.nextInt(palabras.size());
        palabraSecreta = palabras.get(indice).toUpperCase();
    }

    private void inicializarPalabraAdivinada() {
        palabraAdivinada.setLength(0);
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraAdivinada.append("_");
        }
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean jugarDeNuevo = true;
        while (jugarDeNuevo) {
            System.out.println("¡Adivina la palabra!");
            while (intentos > 0) {
                System.out.println("Palabra: " + palabraAdivinada.toString());
                System.out.println("Intentos restantes: " + intentos);
                System.out.print("Ingresa una letra: ");
                String letra = scanner.nextLine().toUpperCase();
                if (letra.length() != 1) {
                    System.out.println("Por favor, ingresa una única letra.");
                    continue;
                }
                if (palabraSecreta.contains(letra)) {
                    actualizarPalabraAdivinada(letra);
                    if (palabraAdivinada.toString().equals(palabraSecreta)) {
                        System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                        break;
                    }
                } else {
                    intentos--;
                    System.out.println("¡Letra incorrecta!");
                }
            }
            if (intentos == 0) {
                System.out.println("¡Oh no! Has perdido. La palabra secreta era: " + palabraSecreta);
            }

            jugarDeNuevo = solicitarJugarDeNuevo(scanner);
            if (jugarDeNuevo) {
                reiniciarJuego();
            }
        }
    }

    private void actualizarPalabraAdivinada(String letra) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra.charAt(0)) {
                palabraAdivinada.setCharAt(i, letra.charAt(0));
            }
        }
    }

    // SE CREÓ UN NUEVO MÉTODO PARA VOLVER A JUGAR AL PULSAR "S" Y NO CON CUALQUIER OTRO CARACTER
    private boolean solicitarJugarDeNuevo(Scanner scanner) {
        while (true) {
            System.out.print("¿Quieres jugar de nuevo? (S/N): ");
            String opcion = scanner.nextLine().toUpperCase();
            if (opcion.equals("N")) {
                return false;
            } else if (opcion.equals("S")) {
                return true;
            } else {
                System.out.println("Opción inválida. Por favor, ingresa S para seguir jugando o N para salir.");
            }
        }
    }

    private void reiniciarJuego() {
        seleccionarPalabraSecreta();
        inicializarPalabraAdivinada();
        intentos = 9;
    }

    public static void ejecutar() {
        Ahorcado juego = new Ahorcado();
        juego.jugar();
    }
}