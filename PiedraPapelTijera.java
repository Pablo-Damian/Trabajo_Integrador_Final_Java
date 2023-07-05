import java.util.Scanner;

public class PiedraPapelTijera {

    static int pedirDatoUsuarioInt(String texto) {
        int opcionUsuario;
        Scanner teclado = new Scanner(System.in);

        System.out.println(texto);
        opcionUsuario = teclado.nextInt();

        return opcionUsuario;
    }

    static String pasarOpcionAElemento(int opcion) {
        String[] elementos = {"PIEDRA", "PAPEL", "TIJERA"};
        String elemento = "";

        if (opcion == 1) {
            elemento = elementos[0];
        } else if (opcion == 2) {
            elemento = elementos[1];
        } else if (opcion == 3) {
            elemento = elementos[2];
        }
        return elemento;
    }

    static int aleatorioEntre(int min, int max) {
        int numAleat = (int) (Math.random() * (3 - 1 + 1)) + min;
        return numAleat;
    }

    static void mostrarOpciones(String opcion1, String opcion2) {
        System.out.println("**************");
        System.out.println("USUARIO: " + opcion1);
        System.out.println("COMPUTADORA: " + opcion2);
        System.out.println("**************");
    }

    public static void ejecutar() {

        int opcionUsuario, opcionComputadora, opcionSalir;
        String opcionUsuarioStr, opcionComputadoraStr;
        Scanner teclado = new Scanner(System.in);

        System.out.println("********************************");
        System.out.println("     PIEDRA, PAPEL O TIJERA     ");
        System.out.println("********************************");

        do {
            opcionUsuario = pedirDatoUsuarioInt("ELEGÍ UNA OPCIÓN:  1-PIEDRA ● | 2-PAPEL ▢ | 3-TIJERA ✄");

            opcionComputadora = aleatorioEntre(1, 3);

            opcionUsuarioStr = pasarOpcionAElemento(opcionUsuario);
            opcionComputadoraStr = pasarOpcionAElemento(opcionComputadora);

            if (opcionUsuarioStr.equals(opcionComputadoraStr)) {
                System.out.println("¡¡¡EMPATASTE :| SEGUI JUGANDO!!!");
                mostrarOpciones(opcionUsuarioStr, opcionComputadoraStr);
            } else if ((opcionUsuarioStr.equals("PIEDRA") && opcionComputadoraStr.equals("TIJERA"))
                    || (opcionUsuarioStr.equals("PAPEL") && opcionComputadoraStr.equals("PIEDRA"))
                    || (opcionUsuarioStr.equals("TIJERA") && opcionComputadoraStr.equals("PAPEL"))) {
                System.out.println("¡¡¡GANASTE :) !!!");
                mostrarOpciones(opcionUsuarioStr, opcionComputadoraStr);
            } else {
                System.out.println("¡¡¡PERDISTE ;( INTENTALO DE NUEVO!!!");
                mostrarOpciones(opcionUsuarioStr, opcionComputadoraStr);
            }

            opcionSalir = pedirDatoUsuarioInt("Deseas Jugar de nuevo ? 1-SI 2-NO");

        } while (opcionSalir != 2);

        System.out.println("¡¡¡GRACIAS POR JUGAR, ADIOOS!!!");
    }
}