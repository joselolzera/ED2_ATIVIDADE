package ed2.hash2.encadeamentoSeparado;

import ed2.hash.encadeamentoSeparado.TabelaHash;

import java.util.Arrays;

public class TabelaHashSondagemLinear<K, V> implements TabelaHash<K, V> {

    private K[] chaves;
    private V[] valores;
    private EstadoPosicao[] estados;
    private int capacidade;
    private int quantidadeElementos;

    public TabelaHashSondagemLinear(int capacidade) {
        this.capacidade = capacidade;
        this.chaves = (K[]) new Object[capacidade];
        this.valores = (V[]) new Object[capacidade];
        this.estados = new EstadoPosicao[capacidade];
        Arrays.fill(this.estados, EstadoPosicao.VAZIO);
        this.quantidadeElementos = 0;
    }

    private int calcularIndice(K chave) {
            int hash = (chave == null) ? 0 : chave.hashCode();
            hash = Math.abs(hash);
            return hash % capacidade;
    }

    public int inserir(K chave, V valor) {
        if (quantidadeElementos == capacidade) {
            throw new IllegalStateException("Tabela cheia");
        }
        int indiceInicial = calcularIndice(chave);
        for (int i = 0; i < capacidade; i++) {
            int posicao = (indiceInicial + i) % capacidade;
            if (estados[posicao] == EstadoPosicao.VAZIO || estados[posicao] == EstadoPosicao.REMOVIDO) {

                chaves[posicao] = chave;
                valores[posicao] = valor;
                estados[posicao] = EstadoPosicao.OCUPADO;
                quantidadeElementos++;
                return indiceInicial;
            }
            if (estados[posicao] == EstadoPosicao.OCUPADO) {
                boolean mesmaChave = (chave == null && chaves[posicao] == null) || (chave != null && chave.equals(chaves[posicao]));
                if (mesmaChave) {
                    valores[posicao] = valor;
                    return indiceInicial;
                }
            }
        }
        throw new IllegalStateException("Não há posição adequada para inserir");
    }
    public V buscar(K chave) {
        int indiceInicial = calcularIndice(chave);
        for (int i = 0; i < capacidade; i++) {
            int posicao = (indiceInicial + i) % capacidade;
            if (estados[posicao] == EstadoPosicao.VAZIO) {
                return null;
            }
            if (estados[posicao] == EstadoPosicao.OCUPADO) {
                boolean mesmaChave =
                        (chave == null && chaves[posicao] == null) ||
                                (chave != null && chave.equals(chaves[posicao]));
                if (mesmaChave) {
                    return valores[posicao];
                }
            }
        }


        return null;
    }
    public V remover(K chave) {
        int indiceInicial = calcularIndice(chave);
        for (int i = 0; i < capacidade; i++) {
            int posicao = (indiceInicial + i) % capacidade;
            if (estados[posicao] == EstadoPosicao.VAZIO) {
                return null;
            }
            if (estados[posicao] == EstadoPosicao.OCUPADO) {
                boolean mesmaChave = (chave == null && chaves[posicao] == null) || (chave != null && chave.equals(chaves[posicao]));
                if (mesmaChave) {
                    V valorAntigo = valores[posicao];
                    chaves[posicao] = null;
                    valores[posicao] = null;
                    estados[posicao] = EstadoPosicao.REMOVIDO;
                    quantidadeElementos--;
                    return valorAntigo;
                }
            }
        }
        return null;
    }
    public int tamanho() {
        return quantidadeElementos;
    }
    public double fatorDeCarga() {
        return (double) quantidadeElementos / capacidade;
    }
}
