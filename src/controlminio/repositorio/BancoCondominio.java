package controlminio.repositorio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.Condominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BancoCondominio {

    public static void listarCondominios() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        ResultSet resultSet = conn.query("SELECT * FROM Condominio");

        while(resultSet.next()) {
            HashMap<String, String> condominio = new HashMap<>();
            condominio.put("idCondominio", resultSet.getString("idCondominio"));
            condominio.put("nome", resultSet.getString("nome"));
            result.add(condominio);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(" ");
            System.out.println("ID - " + result.get(i).get("idCondominio"));
            System.out.println("Nome - " + result.get(i).get("nome"));
        }
    }


    public static Long adicionarCondominio(String nome, String cidade, String bairro, String endereco, Integer numero) throws SQLException {
        Condominio condominio = new Condominio(nome, cidade, bairro, endereco, numero);
        saveCondominio(condominio);
        return condominio.getIdCondominio();
    }

    public static Boolean deletarCondominio(Long idCondominio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        try {
            conn.insert("DELETE FROM Condominio WHERE idCondominio = " + idCondominio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Condominio getCondominioById(Long idCondominio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ResultSet resultSet = conn.query("SELECT * FROM Condominio WHERE idCondominio = " + idCondominio);
        String nome = null;
        String cidade = null;
        String bairro = null;
        String endereco = null;
        Integer numero = null;
        while(resultSet.next()) {
            nome = resultSet.getString("nome");
            cidade = resultSet.getString("cidade");
            bairro = resultSet.getString("bairro");
            endereco = resultSet.getString("endereco");
            numero = Integer.parseInt(resultSet.getString("numero"));
        }
        Condominio condominio = new Condominio(nome, cidade, bairro, endereco, numero);
        condominio.setIdCondominio(idCondominio);
        return condominio;
    }

    private static void saveCondominio(Condominio condominio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        condominio.setIdCondominio((Long) (long) conn.insert("INSERT INTO Condominio (endereco, nome, cidade, bairro, numero) " +
                "VALUES ('" + condominio.getEndereco() + "', '" + condominio.getNome() + "', '" + condominio.getCidade() + "', '" + condominio.getBairro() + "', '" + condominio.getNumero() + "')"));
    }

}
