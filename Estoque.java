
import java.util.Scanner;

public class Estoque {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String[] nome = new String[100];
        String[] tipoCabelo = new String[100];
        String[] subcategoria = new String[100];

        double[] precoCusto = new double[100];
        double[] imposto = new double[100];
        double[] precoFinal = new double[100];

        int[] validade = new int[100];

        int totalProdutos = 0;
        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\nSISTEMA DE ESTOQUE");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar estoque");
            System.out.println("3 - Relatorio fiscal");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();

            if (opcao == 1) {

                if (totalProdutos < 100) {

                    entrada.nextLine();

                    System.out.print("Nome do produto: ");
                    nome[totalProdutos] = entrada.nextLine();

                    System.out.print("Tipo de cabelo: ");
                    tipoCabelo[totalProdutos] = entrada.nextLine();

                    System.out.print("Subcategoria: ");
                    subcategoria[totalProdutos] = entrada.nextLine();

                    System.out.print("Preco de custo: ");
                    precoCusto[totalProdutos] = entrada.nextDouble();

                    System.out.print("Validade (AAAAMMDD): ");
                    validade[totalProdutos] = entrada.nextInt();

                    imposto[totalProdutos] = precoCusto[totalProdutos] * 0.27;

                    precoFinal[totalProdutos] = precoCusto[totalProdutos] + imposto[totalProdutos];

                    precoFinal[totalProdutos] = precoFinal[totalProdutos] * 1.50;

                    totalProdutos++;

                    // Organizar os produtos pela validade
                    for (int i = 0; i < totalProdutos; i++) {

                        for (int j = 0; j < totalProdutos - 1; j++) {

                            if (validade[j] > validade[j + 1]) {

                                int aux = validade[j];
                                validade[j] = validade[j + 1];
                                validade[j + 1] = aux;

                                String auxNome = nome[j];
                                nome[j] = nome[j + 1];
                                nome[j + 1] = auxNome;

                                auxNome = tipoCabelo[j];
                                tipoCabelo[j] = tipoCabelo[j + 1];
                                tipoCabelo[j + 1] = auxNome;

                                auxNome = subcategoria[j];
                                subcategoria[j] = subcategoria[j + 1];
                                subcategoria[j + 1] = auxNome;

                                double auxPreco = precoCusto[j];
                                precoCusto[j] = precoCusto[j + 1];
                                precoCusto[j + 1] = auxPreco;

                                auxPreco = imposto[j];
                                imposto[j] = imposto[j + 1];
                                imposto[j + 1] = auxPreco;

                                auxPreco = precoFinal[j];
                                precoFinal[j] = precoFinal[j + 1];
                                precoFinal[j + 1] = auxPreco;
                            }
                        }
                    }

                    System.out.println("Produto cadastrado!");

                } else {
                    System.out.println("Estoque cheio!");
                }

            } else if (opcao == 2) {

                if (totalProdutos == 0) {

                    System.out.println("Estoque vazio!");

                } else {

                    System.out.println("\nLISTA DE PRODUTOS");

                    for (int i = 0; i < totalProdutos; i++) {

                        System.out.println("Produto: " + nome[i]);
                        System.out.println("Tipo de cabelo: " + tipoCabelo[i]);
                        System.out.println("Subcategoria: " + subcategoria[i]);
                        System.out.println("Validade: " + validade[i]);

                        System.out.printf("Preco de custo: R$ %.2f\n", precoCusto[i]);
                        System.out.printf("Imposto: R$ %.2f\n", imposto[i]);
                        System.out.printf("Preco final: R$ %.2f\n", precoFinal[i]);

                        System.out.println("-------------------------");
                    }
                }

            } else if (opcao == 3) {

                double totalImposto = 0;

                for (int i = 0; i < totalProdutos; i++) {
                    totalImposto = totalImposto + imposto[i];
                }

                System.out.println("\nRELATORIO FISCAL");
                System.out.println("Total de produtos: " + totalProdutos);
                System.out.printf("Total de impostos: R$ %.2f\n", totalImposto);

            } else if (opcao != 4) {

                System.out.println("Opcao invalida!");
            }
        }

        System.out.println("Sistema encerrado!");

        entrada.close();
    }
}
