package questao3.decorator;

public class ColoridoDecorador extends DecoradorAbstrato {

    public ColoridoDecorador(ILegivel legivel) {
        super(legivel);
    }

    @Override
    public double getPreco() {
        double precoReferencia = super.getPreco();
        return precoReferencia * 1.05;
    }
    
}
