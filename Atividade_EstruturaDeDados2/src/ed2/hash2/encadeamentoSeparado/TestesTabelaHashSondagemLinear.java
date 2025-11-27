package ed2.hash2.encadeamentoSeparado;

public class TestesTabelaHashSondagemLinear {
    public static void main(String[] args) {
        TabelaHashSondagemLinear<Integer, String> tabela = new TabelaHashSondagemLinear<>(11);

        System.out.println("Inserções :");

        tabela.inserir(10, "A");
        System.out.println("Inseriu (10, A)");
        tabela.inserir(21, "B");
        System.out.println("Inseriu (21, B)");
        tabela.inserir(32, "C");
        System.out.println("Inseriu (32, C)");
        tabela.inserir(43, "D");
        System.out.println("Inseriu (43, D)");
        tabela.inserir(54, "E");
        System.out.println("Inseriu (54, E)");
        tabela.inserir(65, "F");
        System.out.println("Inseriu (65, F)");

        System.out.println("\nBuscas :");

        System.out.println("Buscar 10 = " + tabela.buscar(10));
        System.out.println("Buscar 21 = " + tabela.buscar(21));
        System.out.println("Buscar 32 = " + tabela.buscar(32));
        System.out.println("Buscar 43 = " + tabela.buscar(43));
        System.out.println("Buscar 54 = " + tabela.buscar(54));
        System.out.println("Buscar 65 = " + tabela.buscar(65));
        System.out.println("Buscar 99 (não existe) = " + tabela.buscar(99));

        System.out.println("\nRemoção :");

        System.out.println("Removendo chave 32: " + tabela.remover(32));
        System.out.println("Buscar 32 após remoção :" + tabela.buscar(32));

        System.out.println("\nEstado final :");
        System.out.println("Tamanho da tabela : " + tabela.tamanho());
        System.out.println("Fator de carga : " + tabela.fatorDeCarga());
    }
}

