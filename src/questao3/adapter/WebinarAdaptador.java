package questao3.adapter;

import java.lang.Math;
import questao3.composite.IComponente;
import questao3.webinar.IWebinar;

public class WebinarAdaptador implements IComponente {

    private IWebinar webinar;

    public WebinarAdaptador(IWebinar webinar) {
        this.webinar = webinar;
    }

    @Override
    public double getPreco() {
        return this.webinar.getPrice();
    }

    @Override
    public int getChTotal() {
        return Math.toIntExact(this.webinar.getMinutes());
    }

    @Override
    public int getCHCumprida() {
        return this.webinar.wasWatched() ? this.getChTotal() : 0;
    }

    @Override
    public double getPctChCumprida() {
        return this.webinar.wasWatched() ? 100 : 0;
    }
    
}
