public class trabalhoTerceiraAvaliacao {

    /**
     * Imprime o array no console
     * @param array Array de inteiros a ser impresso
     */
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Implementação do algoritmo Bubble Sort
     * @param array Array de inteiros a ser ordenado
     * @return Array ordenado
     */
    public static int[] bubbleSort(int[] array){
        int n = array.length; // n é o tamanho do array
        for (int i = 0; i < n - 1; i++) { // Loop externo: controla as passagens
            for (int j = 0; j < n - 1 - i; j++) { // Loop interno: compara ADJACENTES e borbulha o maior
                if (array[j] > array[j + 1]) { // Compara j com j + 1
                    // Troca
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Implementação do algoritmo Insertion Sort
     * @param array Array de inteiros a ser ordenado
     * @return Array ordenado
     */
    public static int[] insertionSort(int[] array){
        int n = array.length; // n é o tamanho do array
        for (int i = 1; i < n; i++) { // Loop externo: começa em 1, pega o elemento a ser inserido (chave)
            int key = array[i]; // key é o elemento atual a ser comparado e inserido
            int j = i - 1; // j é o índice do elemento anterior a 'key'

            // Move os elementos do array[0...i-1] que são MAIORES que 'key'
            // para uma posição à frente da sua posição atual
            while (j >= 0 && array[j] > key) { 
                array[j + 1] = array[j]; // Desloca o elemento maior para a direita
                j = j - 1; // Move para o elemento anterior na sub-lista ordenada
            }
            array[j + 1] = key; // Insere 'key' na posição correta na sub-lista ordenada
        }
        return array;
    }

    /**
     * Implementação do algoritmo Selection Sort
     * @param array Array de inteiros a ser ordenado
     * @return Array ordenado
     */
    public static int[] selectionSort(int[] array){
        int n = array.length; // n é o tamanho do array

        // Loop externo: Percorre o array para preencher a sub-lista ordenada
        for (int i = 0; i < n - 1; i++) { 
            // Encontra o menor elemento na sub-lista não ordenada (do índice 'i' até o final)
            int min_idx = i; 
            
            // Loop interno: Encontra o índice do menor elemento restante
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }

            // Troca o menor elemento encontrado (no índice min_idx) com o elemento atual (no índice i)
            // Isso move o menor elemento para sua posição correta na frente
            
            // Troca
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
 * Implementação do algoritmo Quick Sort
 * @param array Array de inteiros a ser ordenado
 * @return Array ordenado
 */
public static int[] quickSort(int[] array) {
    // Chama o método auxiliar recursivo que faz a ordenação
    quickSortHelper(array, 0, array.length - 1);
    return array;
}

/**
 * Método auxiliar recursivo para realizar o QuickSort
 * @param array O array a ser ordenado
 * @param low O índice inicial da sub-lista
 * @param high O índice final da sub-lista
 */
private static void quickSortHelper(int[] array, int low, int high) {
    if (low < high) {
        // Encontra o índice do pivô após o particionamento
        int pi = partition(array, low, high);

        // Chama recursivamente para a sub-lista à esquerda do pivô
        quickSortHelper(array, low, pi - 1);

        // Chama recursivamente para a sub-lista à direita do pivô
        quickSortHelper(array, pi + 1, high);
    }
}

/**
 * Método de particionamento que coloca o pivô em sua posição correta.
 * Usaremos o último elemento como pivô.
 * @param array O array a ser particionado
 * @param low O índice inicial
 * @param high O índice final (onde o pivô está)
 * @return O índice onde o pivô foi colocado
 */
private static int partition(int[] array, int low, int high) {
    int pivot = array[high]; // Escolhe o último elemento como pivô
    int i = (low - 1); // Índice do menor elemento (que indica o ponto de troca)

    // Percorre todos os elementos, comparando-os com o pivô
    for (int j = low; j < high; j++) {
        // Se o elemento atual for menor ou igual ao pivô
        if (array[j] <= pivot) {
            i++; // Incrementa o índice do menor elemento
            
            // Troca array[i] e array[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Troca o pivô (array[high]) com o elemento em array[i + 1]
    // Isso coloca o pivô em sua posição final correta
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return i + 1; // Retorna o índice do pivô
}

/**
 * Implementação do algoritmo Heap Sort
 * @param array Array de inteiros a ser ordenado
 * @return Array ordenado
 */
public static int[] heapSort(int[] array) {
    int n = array.length;

    // 1. Constrói o Max Heap (reorganiza o array)
    // Começa do último nó pai (n/2 - 1)
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(array, n, i);
    }

    // 2. Extrai elementos um por um do Heap
    for (int i = n - 1; i > 0; i--) {
        // O elemento atual (raiz) é o maior. Move a raiz atual para o final do array.
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;

        // Chama heapify no heap reduzido (array de 0 a i-1)
        // para restaurar a propriedade Max Heap na nova raiz
        heapify(array, i, 0);
    }
    return array;
}

/**
 * Função para 'heapificar' uma sub-árvore com a raiz no índice 'i'.
 * Assume que as sub-árvores esquerda e direita já são heaps.
 * @param array O array que representa o Heap
 * @param n O tamanho do Heap
 * @param i O índice da raiz da sub-árvore
 */
private static void heapify(int[] array, int n, int i) {
    int largest = i; // Inicializa o maior como raiz
    int left = 2 * i + 1; // Índice do filho esquerdo
    int right = 2 * i + 2; // Índice do filho direito

    // Se o filho esquerdo for maior que a raiz
    if (left < n && array[left] > array[largest]) {
        largest = left;
    }

    // Se o filho direito for maior que o maior até agora
    if (right < n && array[right] > array[largest]) {
        largest = right;
    }

    // Se o maior não for a raiz
    if (largest != i) {
        // Troca a raiz (i) com o maior elemento (largest)
        int swap = array[i];
        array[i] = array[largest];
        array[largest] = swap;

        // Chama recursivamente heapify na sub-árvore afetada
        heapify(array, n, largest);
    }
}

/**
 * Implementação do algoritmo Merge Sort
 * @param array Array de inteiros a ser ordenado
 * @return Array ordenado
 */
public static int[] mergeSort(int[] array) {
    // Chama o método auxiliar recursivo que faz a ordenação
    mergeSortHelper(array, 0, array.length - 1);
    return array;
}

/**
 * Método auxiliar recursivo para dividir o array
 * @param array O array a ser ordenado
 * @param left O índice inicial da sub-lista
 * @param right O índice final da sub-lista
 */
private static void mergeSortHelper(int[] array, int left, int right) {
    if (left < right) {
        // Encontra o ponto médio
        int mid = left + (right - left) / 2;

        // Ordena recursivamente a primeira e a segunda metade
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid + 1, right);

        // Combina as metades ordenadas
        merge(array, left, mid, right);
    }
}

/**
 * Método para combinar (merge) duas sub-listas ordenadas
 * @param array O array contendo as duas sub-listas
 * @param left O índice inicial da primeira sub-lista
 * @param mid O índice final da primeira sub-lista
 * @param right O índice final da segunda sub-lista
 */
private static void merge(int[] array, int left, int mid, int right) {
    int n1 = mid - left + 1; // Tamanho da primeira sub-lista
    int n2 = right - mid; // Tamanho da segunda sub-lista

    // Cria arrays temporários
    int[] L = new int[n1];
    int[] R = new int[n2];

    // Copia dados para os arrays temporários L[] e R[]
    for (int i = 0; i < n1; ++i) {
        L[i] = array[left + i];
    }
    for (int j = 0; j < n2; ++j) {
        R[j] = array[mid + 1 + j];
    }

    // Mescla os arrays temporários de volta para o array original
    int i = 0, j = 0; // Índices iniciais dos sub-arrays
    int k = left; // Índice inicial do array mesclado

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            array[k] = L[i];
            i++;
        } else {
            array[k] = R[j];
            j++;
        }
        k++;
    }

    // Copia os elementos restantes de L[] (se houver)
    while (i < n1) {
        array[k] = L[i];
        i++;
        k++;
    }

    // Copia os elementos restantes de R[] (se houver)
    while (j < n2) {
        array[k] = R[j];
        j++;
        k++;
    }
}

    public static void main(String[] args) {
        int array[] = {5, 3, 8, 4, 2};
        System.out.print("Array original: ");
        printArray(array);
        int[] sortedArray = quickSort(array);
        System.out.print("Array ordenado: ");
        printArray(sortedArray);
    }
}