package ed2.hash.encadeamentoSeparado;

public interface TabelaHash<K, V> {
    int inserir(K chave, V valor);
    V buscar(K chave);
    V remover(K chave);
    int tamanho();
    double fatorDeCarga();
}
