package controlminio.Repositorio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.Condominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CondominioBanco {

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
            System.out.println("Id - " + result.get(i).get("idCondominio"));
            System.out.println("Nome - " + result.get(i).get("nome"));
        }
    }

    public static Long adicionarCondominio(String nome, String cidade, String bairro, String endereco, Integer numero) throws SQLException {
        Condominio condominio = new Condominio(nome, cidade, bairro, endereco, numero);
        saveCondominio(condominio);
        return condominio.getIdCondominio();
    }

    public static Boolean deletarCondominio(Long idConcodminio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        try {
            conn.delete("DELETE FROM Condominio WHERE idCondominio = " + idConcodminio);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


    public static void saveCondominio(Condominio condominio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        condominio.setIdCondominio((Long) (long) conn.insert("INSERT INTO Condominio (endereco, nome, cidade, bairro, numero) " +
                "VALUES ('" + condominio.getEndereco() + "', '" + condominio.getNome() + "', '" + condominio.getCidade() + "', '" + condominio.getBairro() + "', '" + condominio.getNumero() + "')"));
    }



    public static Condominio getCondominio(Long idCondominio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ResultSet resultSet = conn.query("SELECT * FROM Condominio WHERE idCondomino = " + idCondominio);
        Condominio condominio = null;
        while(resultSet.next()) {
            Condominio c2 = new Condominio(resultSet.getString("nome"), resultSet.getString("cidade"), resultSet.getString("bairro"), resultSet.getString("endereco"), Integer.parseInt(resultSet.getString("numero")));
            condominio = c2;
        }
        return condominio;
    }
}
