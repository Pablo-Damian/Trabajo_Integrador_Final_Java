import java.util.Scanner;

public class FactorialNumero {

	public static void ejecutar() {
		
		int numero, contador, acumulador;
		Scanner teclado;
		
		System.out.println("Ingrese un número entero");
		teclado = new Scanner(System.in);
		
		numero = teclado.nextInt();
		
		contador = 1;
		acumulador = 1;
		//factorial de 5 = 5*4*3*2*1 = 120
		do {
			acumulador = acumulador * contador;
			contador++;
			
		} while (contador <= numero);
		System.out.println("El Factorial de " + numero + " es " + acumulador);
	}
}