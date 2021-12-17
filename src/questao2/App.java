package questao2;
import questao2.decorator.CapaDuraDecorador;
import questao2.decorator.ColoridoDecorador;
import questao2.decorator.DigitalDecorador;
import questao2.decorator.ILegivel;
import questao2.produtos.Livro;

public class App {

    public void executar() {
        ILegivel legivel1 = new ColoridoDecorador(
            new DigitalDecorador(
                new Livro("L001", "L001", 100, "L001-ISBN")
            )
        );
        System.out.println(legivel1.getPreco());

        ILegivel legivel2 = new CapaDuraDecorador(
            new Livro("L002", "L002", 100, "L002-ISBN")
        );
        System.out.println(legivel2.getPreco());
    }

    public static void main(String[] args) throws Exception {
        new App().executar();
    }
}
