package controlminio.domminio;

public class ApartamentoLuxo extends Apartamento {
    private String luminarias;
    private boolean geladeira;
    private boolean fogao;

    public ApartamentoLuxo(int idApartamento, Edificio edificio, int andar, Pessoa proprietario, String luminarias, boolean geladeira, boolean fogao) {
        super(idApartamento, edificio, andar, proprietario);
        this.luminarias = luminarias;
        this.geladeira = geladeira;
        this.fogao = fogao;
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
