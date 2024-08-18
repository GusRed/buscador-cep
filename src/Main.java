import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        String busca = "";
        while (busca.length() != 8) {
            System.out.print("Digite o CEP do endereço que você quer consultar: ");
            busca = leitura.nextLine().replace("-", "");;

            if (busca.length() != 8) {
                System.out.println("Você digitou um CEP com " + busca.length() + " dígitos, o CEP precisa de 8 dígitos!\n");
            }
        }

        ConsultaCep consultaCep = new ConsultaCep();

        try {
            Endereco endereco = consultaCep.buscaEndereco(busca);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(endereco);
            System.out.println("Arquivo gerado com sucesso!");
        } catch (RuntimeException | IOException e) {
            System.out.println("Erro encontrado: " + e.getMessage());
            System.out.println("\nAplicação encerrada!");
        }

    }

}
