package ed2.hash.encadeamentoSeparado;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class TabelaHashEncadeada<K, V> implements TabelaHash<K, V> {
    private static final int CAPACIDADE_PADRAO = 11;
    private List<List<Par<K, V>>> buckets;
    private int quantidadeElementos;
    public TabelaHashEncadeada() {
        this(CAPACIDADE_PADRAO);
    }
    public TabelaHashEncadeada(int capacidade) {
        buckets = new ArrayList<>(capacidade);
        for (int i = 0; i < capacidade; i++) {
            buckets.add(new LinkedList<>());
        }
        quantidadeElementos = 0;
    }
    private int calcularIndice(K chave) {
            int hash = (chave == null) ? 0 : chave.hashCode();
            hash = Math.abs(hash);
            return hash % buckets.size();
    }
    public int inserir(K chave, V valor) {
        int indice = calcularIndice(chave);
        List<Par<K, V>> bucket = buckets.get(indice);
        for (Par<K, V> par : bucket) {
            boolean mesmaChave = (chave == null && par.getChave() == null)
                    || (chave != null && chave.equals(par.getChave()));
            if (mesmaChave) {
                par.setValor(valor);
                return indice;
            }
        }
        bucket.add(new Par<>(chave, valor));
        quantidadeElementos++;
        return indice;
    }
    public V buscar(K chave) {
        int indice = calcularIndice(chave);
        List<Par<K, V>> bucket = buckets.get(indice);
        for (Par<K, V> par : bucket) {
            boolean mesmaChave = (chave == null && par.getChave() == null)
                    || (chave != null && chave.equals(par.getChave()));
            if (mesmaChave) {
                return par.getValor();
            }
        }
        return null;
    }
    public V remover(K chave) {
        int indice = calcularIndice(chave);
        List<Par<K, V>> bucket = buckets.get(indice);
        Par<K, V> alvo = null;
        for (Par<K, V> par : bucket) {
            boolean mesmaChave = (chave == null && par.getChave() == null)
                    || (chave != null && chave.equals(par.getChave()));
            if (mesmaChave) {
                alvo = par;
                break;
            }
        }
        if (alvo != null) {
            bucket.remove(alvo);

            quantidadeElementos--;
            return alvo.getValor();
        }
        return null;
    }
    public int tamanho() {
        return quantidadeElementos;
    }

    public double fatorDeCarga() {
        return (double) quantidadeElementos / buckets.size();
    }
}
