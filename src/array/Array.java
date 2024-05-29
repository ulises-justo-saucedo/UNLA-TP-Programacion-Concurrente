package array;

import java.util.Random;

public class Array {
	public static int[] generar(int tamanio, int numeroMinimo, int numeroMaximo) {
		int[] array = new int[tamanio];
		Random aleatorio = new Random();
		for (int i = 0; i < tamanio; i++)
			array[i] = aleatorio.nextInt(numeroMinimo, numeroMaximo);
		return array;
	}

	public static void mostrar(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("{" + array[i] + "} ");
		}
		System.out.println();
	}
}
