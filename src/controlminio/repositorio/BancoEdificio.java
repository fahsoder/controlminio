package controlminio.repositorio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.Condominio;
import controlminio.domminio.Edificio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BancoEdificio {
    public static void listarEdificios() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        ResultSet resultSet = conn.query("SELECT * FROM Edificio");

        while(resultSet.next()) {
            HashMap<String, String> condominio = new HashMap<>();
            condominio.put("idCondominio", resultSet.getString("idCondominio"));
            condominio.put("nome", resultSet.getString("nome"));
            result.add(condominio);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(" ");
            System.out.println("ID Edificio - " + result.get(i).get("idEdificio"));
            System.out.println("ID Condominio - " + result.get(i).get("idCondominio"));
            System.out.println("Numero - " + result.get(i).get("numero"));
        }
    }


    public static Long adicionarEdificio(String nome, String cidade, String bairro, String endereco, Integer numero) throws SQLException {
        Condominio condominio = new Condominio(nome, cidade, bairro, endereco, numero);

        return condominio.getIdCondominio();
    }

    public static Boolean deletarEdificio(Long idCondominio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        try {
            conn.query("DELETE FROM Condominio WHERE idCondominio = " + idCondominio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void saveEdificio(Edificio edificio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        edificio.setIdEdificio((Long) (long) conn.insert("INSERT INTO Edificio (numero, cor, quantidadeAndar, idCondominio) " +
                "VALUES ('" + edificio.getNumero() + "', '" + edificio.getCor() + "', '" + edificio.getQntAndar() +  "', '" + edificio.getCondominio().getIdCondominio() + "')"));
    }
}
