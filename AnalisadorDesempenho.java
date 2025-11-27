import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AnalisadorDesempenho {

    private long startTime;
    private static final String NOME_ARQUIVO_CSV = "resultados_ordenacao.csv";

    // --- Métodos de Contagem de Tempo ---

    /**
     * Inicia a contagem do tempo em nanossegundos.
     */
    public void iniciarContagem() {
        this.startTime = System.nanoTime();
    }

    /**
     * Para a contagem do tempo e retorna o tempo decorrido em milissegundos.
     * @return Tempo decorrido em milissegundos (ms).
     */
    public long pararContagem() {
        long endTime = System.nanoTime();
        // Converte nanossegundos para milissegundos
        return (endTime - this.startTime) / 1_000_000; 
    }

    // --- Método de Escrita no CSV ---

    /**
     * Escreve uma linha de dados de desempenho no arquivo CSV.
     * Cria o arquivo e o cabeçalho se ele não existir.
     * * @param nomeAlgoritmo Nome do algoritmo (ex: "Quick Sort")
     * @param N Tamanho da sequência de entrada
     * @param tipoEntrada Tipo de ordenação da sequência (ex: "Aleatoria")
     * @param tempoMs Tempo de execução em milissegundos
     * @param stats Objeto Contadores com as métricas
     */
    public static void escreverResultadosCSV(
            String nomeAlgoritmo, 
            int N, 
            String tipoEntrada,
            long tempoMs) {

        // Verifica se o arquivo existe para decidir se o cabeçalho deve ser escrito
        boolean arquivoExiste = new java.io.File(NOME_ARQUIVO_CSV).exists();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO_CSV, true))) {
            
            // 1. Escreve o cabeçalho se o arquivo for novo
            if (!arquivoExiste) {
                writer.println("Algoritmo;N;Tipo_Entrada;Tempo_ms;");
            }
            
            // 2. Escreve os dados (separados por ponto e vírgula, para melhor compatibilidade com Excel)
            String linha = String.format("%s;%d;%s;%d;",
                nomeAlgoritmo,
                N,
                tipoEntrada,
                tempoMs
            );
            writer.println(linha);

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}