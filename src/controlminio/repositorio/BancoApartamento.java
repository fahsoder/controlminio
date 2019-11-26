package controlminio.repositorio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.Apartamento;
import controlminio.domminio.Condominio;
import controlminio.domminio.Edificio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BancoApartamento {
    public static void listarApartamentos() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        ResultSet resultSet = conn.query("SELECT * FROM Apartamento");

        while(resultSet.next()) {
            HashMap<String, String> apartamento = new HashMap<>();
            apartamento.put("idApartamento", resultSet.getString("idApartamento"));
            apartamento.put("idEdificio", resultSet.getString("idEdificio"));
            apartamento.put("numero", resultSet.getString("numero"));
            result.add(apartamento);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(" ");
            System.out.println("ID Apartamento - " + result.get(i).get("idApartamento"));
            System.out.println("ID Edificio - " + result.get(i).get("idEdificio"));
            System.out.println("Numero - " + result.get(i).get("numero"));
        }
    }


    public static Long adicionarApartamento(Apartamento apartamento) throws SQLException {
        saveApartamento(apartamento);
        return apartamento.getIdApartamento();
    }

    public static Boolean deletarApartamento(Long idApartamento) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        try {
            conn.query("DELETE FROM Apartamento WHERE idApartamento = " + idApartamento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private static void saveApartamento(Apartamento apartamento) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        apartamento.setIdApartamento((Long) (long) conn.insert("INSERT INTO Apartamento (idEdificio, andar, numero, tipo) " +
                "VALUES ('" + apartamento.getEdificio().getIdEdificio() + "', '" + apartamento.getAndar() + "', '" + apartamento.getNumero() +
                "', '" + apartamento.getTipoApartamento().name() + "')"));
    }

}
