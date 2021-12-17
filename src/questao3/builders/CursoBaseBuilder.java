package questao3.builders;

import java.util.ArrayList;
import java.util.Collection;

import questao3.composite.IComponente;
import questao3.produtos.Livro;

public abstract class CursoBaseBuilder<T> implements IBuilder<T> {
	protected Collection<IComponente> componentes;
	protected Collection<Livro> livros;	
    protected String codigo;
	protected String nome;

	public CursoBaseBuilder() {
		this.resetar();
	}

	@Override
	public IBuilder<T> resetar() {
		this.componentes = new ArrayList<IComponente>();
		this.livros = new ArrayList<Livro>();	
		this.codigo = "";
		this.nome = "";
		return this;
	}

	@Override
	public IBuilder<T> setNome(String nome) {
		this.nome = nome;
		return this;
	}

	@Override
	public IBuilder<T> setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	@Override
	public IBuilder<T> addLivro(Livro livro) {
		this.livros.add(livro);
		return this;
	}

	@Override
	public IBuilder<T> addComponente(IComponente componente) {
		this.componentes.add(componente);
		return null;
	}
}
