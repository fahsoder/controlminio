package controlminio.domminio;

public class ApartamentoLuxo extends Apartamento {
    private String luminarias;
    private boolean geladeira;
    private boolean fogao;

    public ApartamentoLuxo() {
        super(idApartamento);
    }

    public String getLuminarias() {
        return luminarias;
    }

    public boolean isGeladeira() {
        return geladeira;
    }

    public void setGeladeira(boolean geladeira) {
        this.geladeira = geladeira;
    }

     public boolean getFogao(){
        return fogao;
     }

     public void setFogao( boolean fogao){
        this.fogao = fogao;
     }
}
