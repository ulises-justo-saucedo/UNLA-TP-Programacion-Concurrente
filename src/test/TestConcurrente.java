package test;

import algoritmos.QuickSortConcurrente;
import array.Array;

public class TestConcurrente {

	public static void main(String[] args) {
		int[] array = null;
		long tiempoInicial, tiempoFinal, tiempoMenor = 9999999;
		for(int i = 0 ; i < 200 ; i++) {
			array = Array.generar(1000000, 1, 100);
			tiempoInicial = System.currentTimeMillis();
			QuickSortConcurrente.ordenar(array);
			tiempoFinal = System.currentTimeMillis() - tiempoInicial;
			System.out.println("("+(i+1)+") El ordenamiento concurrente tardó "+tiempoFinal+" milisegundos.");
			if(tiempoFinal < tiempoMenor){
				tiempoMenor = tiempoFinal;
			}
		}
		System.out.println("La ejecución más rápida ocurrió en "+tiempoMenor+" milisegundos.");
	}

}
