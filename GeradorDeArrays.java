import java.util.Random;

public class GeradorDeArrays {

    // --- Métodos de Geração ---

    /**
     * Gera uma sequência de inteiros estritamente ordenada (1, 2, 3, ... N).
     * @param N Tamanho do array.
     * @return Array ordenado.
     */
    public static int[] gerarOrdenado(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    /**
     * Gera uma sequência de inteiros inversamente ordenada (N, N-1, ..., 1).
     * @param N Tamanho do array.
     * @return Array inversamente ordenado.
     */
    public static int[] gerarInversamenteOrdenado(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = N - i;
        }
        return array;
    }

    /**
     * Gera uma sequência de inteiros aleatórios sem repetição.
     * Usa o algoritmo Fisher-Yates para embaralhar um array ordenado.
     * @param N Tamanho do array.
     * @return Array aleatório.
     */
    public static int[] gerarAleatorio(int N) {
        int[] array = gerarOrdenado(N);
        Random rand = new Random();
        for (int i = N - 1; i > 0; i--) {
            // Gera um índice aleatório de 0 até i (inclusive)
            int randomIndexToSwap = rand.nextInt(i + 1); 
            
            // Troca array[i] com o elemento no índice aleatório
            int temp = array[i];
            array[i] = array[randomIndexToSwap];
            array[randomIndexToSwap] = temp;
        }
        return array;
    }

    /**
     * Gera uma sequência quase ordenada (ordenada com poucas trocas).
     *Garante pelo menos 1 troca para que nunca esteja 100% ordenado.
     * @param N Tamanho do array.
     * @return Array quase ordenado.
     */
    public static int[] gerarQuaseOrdenado(int N) {
        if (N <= 1) {
             // Arrays com 0 ou 1 elemento são sempre ordenados/quase ordenados
            return gerarOrdenado(N);
        }
        
        int[] array = gerarOrdenado(N);
        Random rand = new Random();
        
        // Garante PELO MENOS 1 TROCA (no mínimo), mas prioriza 10% de N
        int numSwaps = N / 10;
        if (numSwaps == 0) {
            numSwaps = 1; 
        }

        for (int i = 0; i < numSwaps; i++) {
            int idx1 = rand.nextInt(N);
            int idx2;

            // Garante que o índice de troca (idx2) seja diferente de idx1
            // para que a troca tenha efeito (a menos que N=1, mas já tratamos acima)
            do {
                idx2 = rand.nextInt(N);
            } while (idx1 == idx2);
            
            // Troca
            int temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        // O método main está em branco (vazio), conforme solicitado.
        // As funções de geração acima podem ser chamadas a partir de outras classes ou de código de teste.
        
        // Exemplo de uso em outras partes do código:
        // int N = 10000;
        // int[] meuArray = GeradorDeArrays.gerarAleatorio(N);

        int[] teste = gerarAleatorio(100);
        for (int num : teste) {
            System.out.print(num + " ");
        }
    }
}