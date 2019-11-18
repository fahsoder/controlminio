package controlminio.domminio;

public class ApartamentoLuxo extends Apartamento {
    private String luminarias;
    private boolean geladeira;
    private boolean fogao;

    public ApartamentoLuxo(Edificio edificio, int andar, Pessoa proprietario, String luminarias, boolean geladeira, boolean fogao) {
        super(edificio, andar, proprietario);
        this.luminarias = luminarias;
        this.geladeira = geladeira;
        this.fogao = fogao;
    }

    public String getLuminarias() {
        return this.luminarias;
    }

    public void setLuminarias() {
        this.luminarias = luminarias;
    }

    public boolean isGeladeira() {
        return this.geladeira;
    }

    public void setGeladeira(boolean geladeira) {
        this.geladeira = geladeira;
    }

     public boolean getFogao(){
        return this.fogao;
     }

     public void setFogao( boolean fogao){
        this.fogao = fogao;
     }

}
