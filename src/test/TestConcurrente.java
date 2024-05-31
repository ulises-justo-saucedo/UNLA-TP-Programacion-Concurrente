package test;

import algoritmos.QuickSortConcurrente;
import array.Array;

public class TestConcurrente {

	public static void main(String[] args) throws InterruptedException {
		final int CASO_1 = 1000000;
		final int CASO_2 = 500000;
		final int CASO_3 = 100000;
		final int CASO_4 = 1000;
		final int CASO_5 = 10;
		int[] array = null;
		long tiempoInicial, tiempoFinal, tiempoMenor = 9999999;
		for(int i = 0 ; i < 10 ; i++) {
			array = Array.generar(CASO_1, -1000, 1000);
			tiempoInicial = System.currentTimeMillis();
			QuickSortConcurrente.ordenar(array);
			tiempoFinal = System.currentTimeMillis() - tiempoInicial;
			System.out.println("("+(i+1)+") El ordenamiento concurrente tardó "+tiempoFinal+" milisegundos.\n");
			if(tiempoFinal < tiempoMenor) tiempoMenor = tiempoFinal;
		}
		System.out.println("La ejecución más rápida ocurrió en "+tiempoMenor+" milisegundos.");
	}

}
