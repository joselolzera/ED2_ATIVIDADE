package ed2.hash.encadeamentoSeparado;



public class TesteTabelaHashEncadeada {
    public static void main(String[] args) {
        TabelaHashEncadeada<Integer, String> tabela =
                new TabelaHashEncadeada<>(11);

        tabela.inserir(1, "Ana");
        tabela.inserir(12, "Bruno");
        tabela.inserir(23, "Carla");

        System.out.println("Chave 23: " + tabela.buscar(23));
        System.out.println("Chave 12: " + tabela.buscar(12));
        System.out.println("Chave Removida: " + tabela.remover(12));
        tabela.remover(12);
        System.out.println("Tamanho final: " + tabela.tamanho());
        System.out.println("Fator de carga: " + tabela.fatorDeCarga());
    }
}