import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MaquinaPilha {

    public static void main(String[] args) {
        String nomeArquivo = args[0];

        try {
            List<String> comandos = MaquinaPilha.read(nomeArquivo);
            double resultadoFinal = MaquinaPilha.process(comandos);
			
            System.out.println("Resultado: " +resultadoFinal);
        } catch (Exception e) {
            System.out.println("Erro de compilação:\n" + e);
        }
    }

    public static List<String> read(String nomeArquivo) {
        List<String> linhas = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

            String linha;

            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return linhas;
    }

    public static double process(List<String> comandos) {
        Stack<Double> pilha = new Stack<>();

        for (String comando : comandos) {
            if (comando.startsWith("PUSH")) {
                double valor = Double.parseDouble(comando.split(" ")[1]);

                pilha.push(valor);
            }

            if (comando.startsWith("SOMA")) {
                double n2 = pilha.pop();
                double n1 = pilha.pop();

                double result = n1 + n2;

                pilha.push(result);
            }
            if (comando.startsWith("MULT")) {
                double n2 = pilha.pop();
                double n1 = pilha.pop();

                double result = n1 * n2;

                pilha.push(result);

            }
            if (comando.startsWith("SUB")) {
                double n2 = pilha.pop();
                double n1 = pilha.pop();

                double result = n1 - n2;

                pilha.push(result);

            }
            if (comando.startsWith("DIV")) {
                double n2 = pilha.pop();
                double n1 = pilha.pop();

                double result = n1 / n2;

                pilha.push(result);
            }
        }

        double resultadoFinal = pilha.pop();

        return resultadoFinal;

    }
}
