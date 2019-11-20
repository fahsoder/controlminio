package controlminio.fabrica;

import controlminio.domminio.*;

import java.sql.SQLException;

public class FactoryApartamento {
    public Apartamento getApartamento(Edificio edificio, Integer andar, String luminarias, Integer numero, boolean geladeira, boolean fogao) throws SQLException {
        return new ApartamentoLuxo(edificio, andar, luminarias, numero, geladeira, fogao);
    }

    public Apartamento getApartamento(Edificio edificio, int andar, Integer numero, String tipoPiso, String tipoArmario) throws SQLException {
        return new ApartamentoPadrao(edificio, andar, numero, tipoPiso, tipoArmario);
    }
}
