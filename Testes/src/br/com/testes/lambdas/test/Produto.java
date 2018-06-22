package br.com.testes.lambdas.test;

public class Produto {

    private String nome;
    private Integer valor;

    public Produto(String nome, Integer valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void aplicarDesconto() {
        valor = valor * 90 / 100;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
