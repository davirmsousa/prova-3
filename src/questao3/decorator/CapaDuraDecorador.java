package questao3.decorator;

public class CapaDuraDecorador extends DecoradorAbstrato {

    public CapaDuraDecorador(ILegivel legivel) {
        super(legivel);
    }

    @Override
    public double getPreco() {
        double precoReferencia = super.getPreco();
        return precoReferencia * 1.2;
    }
    
}
