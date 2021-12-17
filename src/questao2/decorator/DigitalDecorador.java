package questao2.decorator;

public class DigitalDecorador extends DecoradorAbstrato {

    public DigitalDecorador(ILegivel legivel) {
        super(legivel);
    }

    @Override
    public double getPreco() {
        double precoReferencia = super.getPreco();
        return precoReferencia * 0.85;
    }
    
}
