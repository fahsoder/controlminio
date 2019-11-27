package controlminio.repositorio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.*;

import java.net.IDN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static controlminio.repositorio.BancoEdificio.getEdificioById;

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
            ResultSet resultSet = conn.query("SELECT * FROM Apartamento WHERE idApartamento = " + idApartamento);
            TipoApartamento tipoApartamento = null;
            while (resultSet.next()) {
                if (resultSet.getString("tipo") == TipoApartamento.PADRAO.name()) {
                    tipoApartamento = TipoApartamento.PADRAO;
                } else if (resultSet.getString("tipo") == TipoApartamento.LUXO.name()) {
                    tipoApartamento = TipoApartamento.LUXO;
                }
            }
            conn.insert("DELETE FROM Apartamento WHERE idApartamento = " + idApartamento);
            if (tipoApartamento == TipoApartamento.PADRAO) {
                conn.insert("DELETE FROM ApartamentoPadrao WHERE idApartamento = " + idApartamento);
            } else if (tipoApartamento == TipoApartamento.LUXO) {
                conn.insert("DELETE FROM ApartamentoLuxo WHERE idApartamento = " + idApartamento);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Apartamento getApartamentoById(Long idApartamento) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        Apartamento apartamento = null;
        ResultSet resultSet = conn.query("SELECT * FROM Apartamento WHERE idApartamento = " + idApartamento);
        Long idEdificio = null;
        Integer andar = null;
        Integer numero = null;
        TipoApartamento tipoApartamento = null;
        while (resultSet.next()) {
            idEdificio = Long.parseLong(resultSet.getString("idEdificio"));
            andar = Integer.parseInt(resultSet.getString("andar"));
            numero = Integer.parseInt(resultSet.getString("numero"));
            tipoApartamento = TipoApartamento.valueOf(resultSet.getString("tipo"));
        }
        if (tipoApartamento == TipoApartamento.LUXO) {
            resultSet = conn.query("SELECT * FROM ApartamentoLuxo WHERE idApartamento = " + idApartamento);
            String luminarias = null;
            boolean fogao = false;
            boolean geladeira = false;
            while (resultSet.next()) {
                luminarias = resultSet.getString("luminarias");
                fogao = resultSet.getBoolean("fogao");
                geladeira = resultSet.getBoolean("geladeira");
            }
            apartamento = new ApartamentoLuxo(getEdificioById(idEdificio), andar, luminarias, numero, geladeira, fogao);
            apartamento.setIdApartamento(idApartamento);
        } else if (tipoApartamento == TipoApartamento.PADRAO) {
            resultSet = conn.query("SELECT * FROM ApartamentoPadrao WHERE idApartamento = " + idApartamento);
            String tipoPiso = null;
            String tipoArmario = null;
            while (resultSet.next()) {
                tipoPiso = resultSet.getString("piso");
                tipoArmario = resultSet.getString("armario");
            }
            apartamento = new ApartamentoPadrao(getEdificioById(idEdificio), andar, numero, tipoPiso, tipoArmario);
            apartamento.setIdApartamento(idApartamento);
        }
        return apartamento;

    }


    private static void saveApartamento(Apartamento apartamento) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        apartamento.setIdApartamento((Long) (long) conn.insert("INSERT INTO Apartamento (idEdificio, andar, numero, tipo) " +
                "VALUES ('" + apartamento.getEdificio().getIdEdificio() + "', '" + apartamento.getAndar() + "', '" + apartamento.getNumero() +
                "', '" + apartamento.getTipoApartamento().name() + "')"));
        if (apartamento.getTipoApartamento() == TipoApartamento.LUXO) {
            saveApartamentoLuxo((ApartamentoLuxo) apartamento);
        } else if (apartamento.getTipoApartamento() == TipoApartamento.PADRAO) {
            saveApartamentoPadrao((ApartamentoPadrao) apartamento);
        }
    }


    private static void saveApartamentoLuxo(ApartamentoLuxo apartamentoLuxo) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        Integer geladeira = 0;
        Integer fogao = 0;

        if (apartamentoLuxo.getGeladeira()) { geladeira = 1;}
        if (apartamentoLuxo.getFogao()) { fogao = 1;}
        conn.insert("INSERT INTO ApartamentoLuxo (idApartamento, luminaria, geladeira, fogao)" +
                "VALUES ('" + apartamentoLuxo.getIdApartamento() + "', '" + apartamentoLuxo.getLuminarias() + "', '" + geladeira + "', '" + fogao + "')");
    }


    private static void saveApartamentoPadrao(ApartamentoPadrao apartamentoPadrao) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        conn.insert("INSERT INTO ApartamentoPadrao (idApartamento, armario, piso)" +
                "VALUES ('" + apartamentoPadrao.getIdApartamento() + "', '" + apartamentoPadrao.getTipoArmario() + "', '" + apartamentoPadrao.getTipoPiso() + "')");
    }


}
