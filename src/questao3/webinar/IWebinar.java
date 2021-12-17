package questao3.webinar;

public interface IWebinar {
    public String getId();
	public String getTitle();
	public double getPrice();
	public void play();
	public String getHoster();
	public long getMinutes();
	public boolean wasWatched();
}
