package algoritmos;

public class QuickSort {
	public static void ordenar(int[] array) {
		ordenar(array, 0, array.length - 1);
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
