import java.util.Scanner;

public class ParImpar {
	public static void ejecutar() {
		int numero;
		Scanner teclado;
		System.out.println("Ingrese un número entero:");
		teclado = new Scanner(System.in);
		numero = teclado.nextInt();		
		if (numero != 0) {
			if (numero % 2 == 0) {
				System.out.println("El número " + numero + " es par.");
			}
			else {
				System.out.println("El número " + numero + " es impar.");
			}
		}
		else {
			System.out.println("El 0 no es par ni impar.");
		}
	}
}