package controlminio.domminio;

public enum TipoApartamento {

    LUXO("Apartamento de Luxo"),
    PADRAO("Apartamento padrao");

    public String descricao;

    TipoApartamento(String descricao) {
        this.descricao = descricao;
    }
}
