package test;

import algoritmos.QuickSort;
import algoritmos.QuickSortConcurrente;
import array.Array;

public class TestSecuencial {

	public static void main(String[] args) {
		int[] array;
		long tiempoInicial, tiempoFinal, tiempoMenor = 9999999;
		for(int i = 0 ; i < 200 ; i++) {
			array = Array.generar(1000000, 1, 100);
			tiempoInicial = System.currentTimeMillis();
			QuickSort.ordenar(array);
			tiempoFinal = System.currentTimeMillis() - tiempoInicial;
			System.out.println("("+(i+1)+") El ordenamiento secuencial tardó "+tiempoFinal+" milisegundos.");		
			if(tiempoFinal < tiempoMenor) tiempoMenor = tiempoFinal;
		}
		System.out.println("La ejecución más rápida ocurrió en "+tiempoMenor+" milisegundos.");
	}

}
