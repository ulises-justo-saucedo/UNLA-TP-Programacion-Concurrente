package algoritmos;

public class QuickSortConcurrente {
	public static void ordenar(int[] array) {
		int posicionFinalPivote = particionarArray(array, 0, array.length - 1);
		int contador = 0;
		for(int i = 0 ; i < posicionFinalPivote ; i++) contador++;
		System.out.println("CARGA DE TRABAJO: Hilo 1 -> "+contador+" | Hilo 2 -> "+(array.length - contador));
		Thread hilo1 = new Thread(() -> {
			ordenar(array, 0, posicionFinalPivote - 1);
		});
		Thread hilo2 = new Thread(() -> {
			ordenar(array, posicionFinalPivote + 1, array.length - 1);
		});
		hilo1.start();
		hilo2.start();
		try {
			hilo1.join();
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void ordenar(int[] array, int indiceInferior, int indiceSuperior) {
		if (indiceInferior >= indiceSuperior) return;
		int posicionFinalPivote = particionarArray(array, indiceInferior, indiceSuperior);
		ordenar(array, indiceInferior, posicionFinalPivote - 1);
		ordenar(array, posicionFinalPivote + 1, indiceSuperior);
	}

	private static int particionarArray(int[] array, int indiceInferior, int indiceSuperior) {
		int pivote = array[indiceSuperior];
		int punteroIzquierdo = indiceInferior;
		int punteroDerecho = indiceSuperior;
		while (punteroIzquierdo < punteroDerecho) {
			while (array[punteroIzquierdo] <= pivote && punteroIzquierdo < punteroDerecho) {
				punteroIzquierdo++;
			}
			while (array[punteroDerecho] >= pivote && punteroDerecho > punteroIzquierdo) {
				punteroDerecho--;
			}
			intercambiarValores(array, punteroIzquierdo, punteroDerecho);
		}
		intercambiarValores(array, indiceSuperior, punteroIzquierdo);
		return punteroIzquierdo;
	};

	private static void intercambiarValores(int[] array, int primerPosicion, int segundaPosicion) {
		int auxiliar = array[primerPosicion];
		array[primerPosicion] = array[segundaPosicion];
		array[segundaPosicion] = auxiliar;
	}
}
