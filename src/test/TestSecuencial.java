package test;

import algoritmos.QuickSort;
import algoritmos.QuickSortConcurrente;
import array.Array;

public class TestSecuencial {

	public static void main(String[] args) {
		final int CASO_1 = 1000000;
		final int CASO_2 = 500000;
		final int CASO_3 = 100000;
		final int CASO_4 = 1000;
		final int CASO_5 = 10;
		int[] array;
		long tiempoInicial, tiempoFinal, tiempoMenor = 9999999;
		for(int i = 0 ; i < 10 ; i++) {
			array = Array.generar(CASO_5, -1000, 1000);
			tiempoInicial = System.nanoTime();
			QuickSort.ordenar(array);
			tiempoFinal = System.nanoTime() - tiempoInicial;
			System.out.println("("+(i+1)+") El ordenamiento secuencial tardó "+tiempoFinal+" nanosegundos.");		
			if(tiempoFinal < tiempoMenor) tiempoMenor = tiempoFinal;
		}
		System.out.println("La ejecución más rápida ocurrió en "+tiempoMenor+" milisegundos.");
	}

}
