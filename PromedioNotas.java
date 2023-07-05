import java.util.Scanner;

public class PromedioNotas {

    public static void ejecutar() {
        double nota1, nota2, nota3, respuesta;

        Scanner Teclado;

        System.out.println("INGRESA TU PRIMERA NOTA ");
        Teclado = new Scanner(System.in);
        nota1 = Teclado.nextDouble();

        System.out.println("INGRESA TU SEGUNDA NOTA ");
        Teclado = new Scanner(System.in);
        nota2 = Teclado.nextDouble();

        System.out.println("INGRESA TU TERCERA NOTA");
        Teclado = new Scanner(System.in);
        nota3 = Teclado.nextDouble();

        respuesta = (nota1 + nota2 + nota3) / 3;

        System.out.println("************");
        System.out.println("TU PROMEDIO ES  = " + respuesta);
        System.out.println("************");

    }
}