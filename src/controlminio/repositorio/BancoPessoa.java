package controlminio.repositorio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BancoPessoa {
    public static void listarPessoas() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        ResultSet resultSet = conn.query("SELECT * FROM Pessoa");

        while(resultSet.next()) {
            HashMap<String, String> pessoa = new HashMap<>();
            pessoa.put("idPessoa", resultSet.getString("idPessoa"));
            pessoa.put("idApartamento", resultSet.getString("idApartamento"));
            pessoa.put("nome", resultSet.getString("nome"));
            result.add(pessoa);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(" ");
            System.out.println("ID Pessoa - " + result.get(i).get("idPessoa"));
            System.out.println("ID Apartamento - " + result.get(i).get("idApartamento"));
            System.out.println("Nome - " + result.get(i).get("nome"));
        }
    }


    public static Long adicionarPessoa(Pessoa pessoa) throws SQLException {
        savePessoa(pessoa);
        return pessoa.getIdUsuario();
    }

    public static Boolean deletarPessoa(Long idPessoa) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        try {
            conn.insert("DELETE FROM Pessoa WHERE idPessoa = " + idPessoa);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void savePessoa(Pessoa pessoa) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        pessoa.setIdUsuario((Long) (long) conn.insert("INSERT INTO Pessoa (nome, cpf, rg, sexo, nascimento, idApartamento) " +
                "VALUES ('" + pessoa.getNome() + "', '" + pessoa.getCpf() + "', '" + pessoa.getRg() + "', '" + pessoa.getSexo() +  "', '" + pessoa.getDataNascimento().toString() +  "', '" + pessoa.getApartamento().getIdApartamento() + "')"));
    }


}
