import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAplicaciones {

    public static void main(String[] args) {
        Scanner validar = new Scanner(System.in);
        int opcion = -1; // SE INICIALIZA LA VARIABLE "OPCION" CON UN VALOR PREDETERMINADO
        do {
            mostrarMenu();
            boolean mostrarMenu = true;

            try { // "CAPTURADOR" DE ERRORES
                opcion = validar.nextInt(); // SE LEE LA OPCIÓN INGRESADA
                if (opcion == 0) { // SI LA OPCIÓN ES 0: SALE DE LA APLICACIÓN
                    System.out.println("Cerrando la Aplicación...");
                    System.exit(0); // CIERRA TODAS LAS APLICACIONES (INCLUYENDO LAS VENTANAS GRÁFICAS) Y FINALIZA LA EJECUCIÓN
                } else if (opcion >= 1 && opcion <= 10) {
                    switch (opcion) {
                        case 1:
                            ParImpar.ejecutar();
                            break;
                        case 2:
                            FactorialNumero.ejecutar();
                            break;
                        case 3:
                            PromedioNotas.ejecutar();
                            break;
                        case 4:
                            PiedraPapelTijera.ejecutar();
                            break;
                        case 5:
                            SimuladorCajero.ejecutar();
                            break;
                        case 6:
                            ListadeCompras.ejecutar();
                            break;
                        case 7:
                            Ahorcado.ejecutar();
                            break;
                        case 8:
                            Conversor.ejecutar();
                            break;
                        case 9:
                            CalculadoraGUI.ejecutar();
                            break;
                        case 10:
                            GeneradorPass.ejecutar();
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("La Opción elegida no es válida (Por favor seleccione un valor entre 0 y 10).");
                    mostrarMenu = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("La Opción elegida no es válida (Por favor seleccione un valor entre 0 y 10).");
                mostrarMenu = false;
                validar.next(); // SE LIMPIA EL VALOR NO VÁLIDO DEL SCANNER
            }
        } while (opcion != 0); // EL BUCLE SE REPITE HASTA QUE SE INGRESA LA OPCIÓN DE SALIDA (0)
    }

    public static void mostrarMenu() { // SE MUESTRA EL MENÚ DE OPCIONES
        System.out.println("____________________________________________");
        System.out.println("    ********  Mis Aplicaciones  ********    |");
        System.out.println("--------------------------------------------|");
        System.out.println(" Elegir una de las siguientes opciones:     |");
        System.out.println("--------------------------------------------|");
        System.out.println("1.  Número Par o Impar                      |");
        System.out.println("2.  Cuál es el factorial de un Número ?     |");
        System.out.println("3.  El promedio de las Notas                |");
        System.out.println("4.  Juego 'Piedra, Papel o Tijera'          |");
        System.out.println("5.  Simulador de Cajero Automático          |");
        System.out.println("6.  Lista de Compras                        |");
        System.out.println("7.  Jugar al 'Ahorcado' ;(                  |");
        System.out.println("8.  Conversor de Temperatura y Divisas GUI  |");
        System.out.println("9.  Calculadora GUI                         |");
        System.out.println("10. Generador de Contraseñas GUI            |");
        System.out.println("0.  SALIR                                   |");
        System.out.println("____________________________________________|");
        System.out.print("Ingrese la opción deseada: ");
    }
} // FIN DEL CÓDIGO ;)