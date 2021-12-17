import questao3.adapter.WebinarAdaptador;
import questao3.builders.CursoBuilder;
import questao3.builders.IBuilder;
import questao3.composite.IComponente;
import questao3.decorator.CapaDuraDecorador;
import questao3.decorator.ColoridoDecorador;
import questao3.decorator.DigitalDecorador;
import questao3.decorator.ILegivel;
import questao3.produtos.Curso;
import questao3.produtos.Disciplina;
import questao3.produtos.Livro;
import questao3.webinar.IWebinar;
import questao3.webinar.Webinar;

public class App {

    public void executar() {
        System.out.println("\n-----Q1-----");
        questao1();

        System.out.println("\n-----Q2-----");
        questao2();

        System.out.println("\n-----Q3-----");
        questao3();
    }

    private void questao1() {
        Curso curso = criarCurso();

        /*
            subcurso:   disc 80 -> 64,0  (-20%)
                        livr 47 -> 42,3  (-10%)
                        total      106,3
            
            maincurso:  disc 50 + disc 30-> 80,0
                        subcruso         -> 106,3
                                            149,04  (-20%)
                        livr 15 ->          13,5    (-10%)
                        total               162,54
        */

        System.out.println(curso.getPreco());
    }

    private void questao2() {
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

    private void questao3() {
        IWebinar webinar = new Webinar("WebnarId", "WebnarTitle", "WebnarHoster", 250, 600);

        IComponente adaptadorWebinar = new WebinarAdaptador(webinar);

        Curso curso = criarCurso();
        curso.addComponente(adaptadorWebinar);

        /*
            subcurso:   disc 80 -> 64,0  (-20%)
                        livr 47 -> 42,3  (-10%)
                        total      106,3
            
            maincurso:  disc 50 + disc 30-> 80,0
                        subcruso         -> 106,3
                        webinar          -> 250,0
                                            349,04  (-20%)
                        livr 15 ->          13,5    (-10%)
                        total               362,54
        */

        System.out.println(curso.getPreco());
    }

    private Curso criarCurso() {
        IBuilder<Curso> mainCursoBuilder = CursoBuilder.obter().resetar()
            .setCodigo("MAINCURSO")
            .setNome("MAINCURSO");

        mainCursoBuilder.addComponente(new Disciplina("D11", "D11", 0, 50, 120));
        mainCursoBuilder.addComponente(new Disciplina("D12", "D12", 0, 30, 80));

        mainCursoBuilder.addLivro(new Livro("L11", "L11", 15, "L11-ISBN"));

        //------------------------------------------------------------------------
        IBuilder<Curso> subCursoBuilder = CursoBuilder.obter().resetar()
            .setCodigo("SUBCURSO")
            .setNome("SUBCURSO");

        subCursoBuilder.addComponente(new Disciplina("D21", "D21", 0, 80, 160));

        subCursoBuilder.addLivro(new Livro("L21", "L21", 47, "L21-ISBN"));
        //------------------------------------------------------------------------

        mainCursoBuilder.addComponente(subCursoBuilder.construir());
        
        return mainCursoBuilder.construir();
    }

    public static void main(String[] args) throws Exception {
        new App().executar();
    }
}
