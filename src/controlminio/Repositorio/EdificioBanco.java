package controlminio.Repositorio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.Condominio;
import controlminio.domminio.Edificio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EdificioBanco {

    public static void listarEdificios() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        ResultSet resultSet = conn.query("SELECT * FROM Edificio");

        while(resultSet.next()) {
            HashMap<String, String> edificio = new HashMap<>();
            edificio.put("idEdificio", resultSet.getString("idEdificio"));
            edificio.put("numero", resultSet.getString("numero"));
            edificio.put("idCondominio", resultSet.getString("idCondominio"));
            result.add(edificio);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(" ");
            System.out.println("Id - " + result.get(i).get("idEdificio"));
            System.out.println("Numero - " + result.get(i).get("numero"));
            System.out.println("Id Condominio - " + result.get(i).get("idCondominio"));
        }
    }


    public static Long adicionarEdificio(Condominio condominio, Integer numero, String cor, Integer qtdAndar) throws SQLException {
        Edificio edificio = new Edificio(condominio, numero, cor, qtdAndar);

        return edificio.getIdEdificio();
    }


    private void save(Edificio edificio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        edificio.setIdEdificio((Long) (long) conn.insert("INSERT INTO Edificio (numero, cor, quantidadeAndar, idCondominio) " +
                "VALUES ('" + edificio.getNumero() + "', '" + edificio.getCor() + "', '" + edificio.getQntAndar() +  "', '" + edificio.getCondominio().getIdCondominio() + "')"));
    }
}
