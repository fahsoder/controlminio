package controlminio.repositorio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.Condominio;
import controlminio.domminio.Edificio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static controlminio.repositorio.BancoCondominio.getCondominioById;

public class BancoEdificio {
    public static void listarEdificios() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        ResultSet resultSet = conn.query("SELECT * FROM Edificio");

        while(resultSet.next()) {
            HashMap<String, String> condominio = new HashMap<>();
            condominio.put("idEdificio", resultSet.getString("idEdificio"));
            condominio.put("idCondominio", resultSet.getString("idCondominio"));
            condominio.put("numero", resultSet.getString("numero"));
            result.add(condominio);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(" ");
            System.out.println("ID Edificio - " + result.get(i).get("idEdificio"));
            System.out.println("ID Condominio - " + result.get(i).get("idCondominio"));
            System.out.println("Numero - " + result.get(i).get("numero"));
        }
    }


    public static Long adicionarEdificio(Long idCondominio, Integer numero, String cor, Integer qntAndar) throws SQLException {
        Condominio condominio = getCondominioById(idCondominio);

        Edificio edificio = new Edificio(condominio, numero, cor, qntAndar);
        saveEdificio(edificio);
        return edificio.getIdEdificio();
    }

    public static Boolean deletarEdificio(Long idEdificio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        try {
            conn.insert("DELETE FROM Edificio WHERE idEdificio = " + idEdificio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Edificio getEdificioById(Long idEdificio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ResultSet resultSet = conn.query("SELECT * FROM Edificio WHERE idEdificio = " + idEdificio);
        Condominio condominio = null;
        Integer numero = null;
        String cor = null;
        Integer qntAndar = null;
        while (resultSet.next()) {
            numero = Integer.parseInt(resultSet.getString("numero"));
            cor = resultSet.getString("cor");
            qntAndar = Integer.parseInt(resultSet.getString("quantidadeAndar"));
            condominio = getCondominioById(Long.parseLong(resultSet.getString("idCondominio")));
        }
        Edificio edificio = new Edificio(condominio, numero, cor, qntAndar);
        edificio.setIdEdificio(idEdificio);
        return edificio;
    }

    private static void saveEdificio(Edificio edificio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        edificio.setIdEdificio((Long) (long) conn.insert("INSERT INTO Edificio (numero, cor, quantidadeAndar, idCondominio) " +
                "VALUES ('" + edificio.getNumero() + "', '" + edificio.getCor() + "', '" + edificio.getQntAndar() +  "', '" + edificio.getCondominio().getIdCondominio() + "')"));
    }
}
