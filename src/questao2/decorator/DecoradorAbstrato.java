package questao2.decorator;

public abstract class DecoradorAbstrato implements ILegivel {
    
    protected ILegivel legivel;

    public DecoradorAbstrato(ILegivel legivel) {
        this.legivel = legivel;
    }

    @Override
    public double getPreco() {
        return legivel.getPreco();
    }
}
