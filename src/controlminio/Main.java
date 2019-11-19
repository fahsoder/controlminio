package controlminio;

import controlminio.domminio.Condominio;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Condominio condominio = new Condominio("condominio", "cidade", "bairro", "endereco", 11);

        System.out.println(condominio.getIdCondominio());
    }
}
