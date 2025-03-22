public class Ordenacao {

    // Merge Sort
    public static void mergeSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(array, esquerda, meio);
            mergeSort(array, meio + 1, direita);
            merge(array, esquerda, meio, direita);
        }
    }

    private static void merge(int[] array, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] esquerdaArray = new int[n1];
        int[] direitaArray = new int[n2];

        for (int i = 0; i < n1; i++)
            esquerdaArray[i] = array[esquerda + i];
        for (int j = 0; j < n2; j++)
            direitaArray[j] = array[meio + 1 + j];

        int i = 0, j = 0, k = esquerda;
        while (i < n1 && j < n2) {
            if (esquerdaArray[i] <= direitaArray[j]) {
                array[k] = esquerdaArray[i];
                i++;
            } else {
                array[k] = direitaArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = esquerdaArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = direitaArray[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    public static void quickSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int pivo = particiona(array, esquerda, direita);
            quickSort(array, esquerda, pivo - 1);
            quickSort(array, pivo + 1, direita);
        }
    }

    private static int particiona(int[] array, int esquerda, int direita) {
        int pivo = array[direita];
        int i = esquerda - 1;
        for (int j = esquerda; j < direita; j++) {
            if (array[j] <= pivo) {
                i++;
                trocar(array, i, j);
            }
        }
        trocar(array, i + 1, direita);
        return i + 1;
    }

    private static void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Selection Sort
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            trocar(array, i, minIndex);
        }
    }

    // Método para exibir o array
    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método principal para testar os algoritmos
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Array original:");
        imprimirArray(array);

        // Testando Merge Sort
        int[] arrayMerge = array.clone();
        mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        System.out.println("\nMerge Sort:");
        imprimirArray(arrayMerge);

        // Testando Quick Sort
        int[] arrayQuick = array.clone();
        quickSort(arrayQuick, 0, arrayQuick.length - 1);
        System.out.println("\nQuick Sort:");
        imprimirArray(arrayQuick);

        // Testando Selection Sort
        int[] arraySelection = array.clone();
        selectionSort(arraySelection);
        System.out.println("\nSelection Sort:");
        imprimirArray(arraySelection);
    }
}