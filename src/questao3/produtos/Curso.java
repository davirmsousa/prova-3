package questao3.produtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import questao3.composite.IComponente;
import questao3.prototype.IPrototipavel;

public class Curso extends Produto implements IComponente {

    private Collection<IComponente> componentes;
    private Collection<Livro> livros;

    public Curso(String codigo, String nome, Collection<Livro> livros, Collection<IComponente> componentes) {
        super(codigo, nome);
        this.livros = new ArrayList<Livro>(livros);
        this.componentes = new ArrayList<IComponente>(componentes);
    }

    public Curso(String codigo, String nome) {
        super(codigo, nome);
    }

    public Curso(Curso produto) {
        super(produto);
        this.livros = new ArrayList<Livro>();
        this.componentes = new ArrayList<IComponente>();

        for (Livro livro : produto.livros) {
            this.addLivro(livro.clonar());
        }
    }

    public void addComponente(IComponente componente) {
        this.componentes.add(componente);
    }

    public void removeComponente(IComponente componente) {
        this.componentes.remove(componente);
    }

    public Collection<Disciplina> getDisciplinas() {
        return this.componentes.stream()
            .filter(c -> c instanceof Disciplina)
            .map(c -> (Disciplina)c)
            .collect(Collectors.toList());
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    @Override
    public double getPreco() {
        double precoDosLivros = 0;
        if (livros != null && livros.size() > 0) {
            for (Livro livro : livros) {
                precoDosLivros += livro.getPreco();
            }
        }
        precoDosLivros *= 0.9;
        
        double precoDosComponentes = 0;
        if (componentes != null && componentes.size() > 0) {
            for (IComponente componente : componentes) {
                precoDosComponentes += componente.getPreco();
            }
        }
        precoDosComponentes *= 0.8;

        return precoDosLivros + precoDosComponentes;
    }

    public int getChTotal() {
        int chTotal = 0;

        if (componentes != null && componentes.size() > 0) {
            for (IComponente componente : componentes) {
                chTotal += componente.getChTotal();
            }
        }

        return chTotal;
    }

    public int getCHCumprida() {
        int chCumprida = 0;

        if (componentes != null && componentes.size() > 0) {
            for (IComponente componente : componentes) {
                chCumprida += componente.getCHCumprida();
            }
        }

        return chCumprida;
    }

    public double getPctChCumprida() {
        return (this.getCHCumprida() * 100) / this.getChTotal();
    }
    
    @Override
    public IPrototipavel clonar() {
        return new Curso(this);
    }

    @Override
    public String toString() {
        return "[Curso] [" + super.toString() + "]";
    }

}
