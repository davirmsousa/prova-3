package questao1.produtos;

import questao1.composite.IComponente;

public class Disciplina extends Produto implements IComponente {
    private int chCumprida;
	private double preco;
    private int chTotal;

    public Disciplina(String codigo, String nome, int chCumprida, double preco, int chTotal) {
        super(codigo, nome);
        this.setPreco(preco);
        this.setChTotal(chTotal);
        this.setCHCumprida(chCumprida);
    }

    public Disciplina(String codigo, String nome) {
        super(codigo, nome);
    }

    public Disciplina(Disciplina produto) {
        super(produto);
        this.setPreco(produto.getPreco());
        this.setChTotal(produto.getChTotal());
        this.setCHCumprida(produto.getCHCumprida());
    }

    public int getCHCumprida() {
        return this.chCumprida;
    }

    private void setCHCumprida(int chCumprida) {
        this.chCumprida = chCumprida;
    }

    public int getChTotal() {
        return this.chTotal;
    }

    public void setChTotal(int chTotal) {
        this.chTotal = chTotal;
    }

    public double getPctChCumprida() {
        return (this.chCumprida * 100) / this.chTotal;
    }

    @Override
    public Disciplina clonar() {
        return new Disciplina(this);
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    private void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "[Disciplina] [" + super.toString() + "]";
    }
    
}
