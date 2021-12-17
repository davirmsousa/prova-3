package questao1.builders;

import questao1.composite.IComponente;
import questao1.produtos.Livro;

public interface IBuilder<T> {
    IBuilder<T> resetar();
    IBuilder<T> setNome(String nome);
    IBuilder<T> setCodigo(String codigo);
    IBuilder<T> addComponente(IComponente componente);
    IBuilder<T> addLivro(Livro livro);
    T construir();
}