package questao1;
import questao1.builders.CursoBuilder;
import questao1.builders.IBuilder;
import questao1.produtos.Curso;
import questao1.produtos.Disciplina;
import questao1.produtos.Livro;

public class App {

    public void executar() {
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
