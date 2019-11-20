package controlminio;

import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.Condominio;
import controlminio.domminio.Edificio;
import controlminio.fabrica.FactoryApartamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    FactoryApartamento factoryApartamento;

    public static void main(String[] args) throws SQLException {

        int escolha = 99, escolha_condominio = 99, escolha_apto = 99, escolha_edificio;
        Scanner leitor = new Scanner(System.in);

        while(escolha != 0) {
            escolha = 99; escolha_condominio = 99; escolha_apto = 99; escolha_edificio = 99;
            System.out.println("");
            System.out.println("MENU: ");
            System.out.println("1) Condomínio");
            System.out.println("2) Edifício");
            System.out.println("3) Apartamento");
            System.out.println("0) Sair");

            escolha = leitor.nextInt();

            if(escolha == 1) {

                while(escolha_condominio != 0) {
                    System.out.println("");
                    System.out.println("O que você deseja fazer em Condomínio?");
                    System.out.println("1) Consultar lista de condomínio");
                    System.out.println("2) Adicionar condomínio");
                    System.out.println("3) Deletar condomínio");
                    System.out.println("0) Voltar");
                    escolha_condominio = leitor.nextInt();

                    if(escolha_condominio == 1) {
                        System.out.println("==== LISTA DE CONDOMINIO ====");
                        ArrayList<Map<String, String>> condominios = listarCondominios();
                        for (int i = 0; i < condominios.size(); i++) {
                            System.out.println(" ");
                            System.out.println("Id - " + condominios.get(i).get("idCondominio"));
                            System.out.println("Nome - " + condominios.get(i).get("nome"));
                        }

                    }else if(escolha_condominio == 2) {
                    	System.out.print("Nome do condomínio: ");
                        String nome = leitor.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = leitor.nextLine();
                        System.out.print("Bairro: ");
                        String bairro = leitor.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = leitor.nextLine();
                        System.out.print("Número: ");
                        Integer numero = leitor.nextInt();

                        Long idCondominio = adicionarCondominio(nome, cidade, bairro, endereco, numero);
                        System.out.println("Adiconadp o condomínio " + idCondominio);

                    }else if(escolha_condominio == 3) {
                        Long idCondominio = 0L;
                        if (deletarCondominio(idCondominio)) {
                            System.out.println("Condominio " + idCondominio + "deletado!");
                        } else {
                            System.out.println("Erro ao deletar o condomínio!");
                        }
                    }else if(escolha_condominio == 0) {


                    }else {
                        System.out.println("Opção inválida");

                    }
                }


            }else if(escolha == 2){

                while(escolha_edificio != 0) {
                    System.out.println("");
                    System.out.println("O que você deseja fazer em Edificio?");
                    System.out.println("1) Consultar lista de edificios");
                    System.out.println("2) Adicionar edificio");
                    System.out.println("3) Deletar edificio");
                    System.out.println("0) Voltar");
                    escolha_edificio = leitor.nextInt();
                    if(escolha_edificio == 1) {
                        System.out.println("LISTA DE EDIFICIO");
                        ArrayList<Map<String, String>> edificios = listarEdificios();
                        for (int i = 0; i < edificios.size(); i++) {
                            System.out.println(" ");
                            System.out.println("Id - " + edificios.get(i).get("idEdificio"));
                            System.out.println("Numero - " + edificios.get(i).get("numero"));
                            System.out.println("Id Condominio - " + edificios.get(i).get("idCondominio"));
                        }


                    }else if(escolha_edificio == 2) {
                        Long idCondominio = adicionarCondominio(nome, cidade, bairro, endereco, numero);
                        System.out.println("Adiconadp o condomínio " + idCondominio);

                    }else if(escolha_edificio == 3) {
                        Long idEdificio = 0L;
                        if (deletarCondominio(idEdificio)) {
                            System.out.println("Edificio " + idEdificio + "deletado!");
                        } else {
                            System.out.println("Erro ao deletar o edificio!");
                        }

                    }else if(escolha_edificio == 0) {


                    }else {
                        System.out.println("Opção inválida");

                    }
                }

            }else if(escolha == 3){

                while(escolha_apto != 0) {
                    System.out.println("");
                    System.out.println("O que você deseja fazer em Apartamento?");
                    System.out.println("1) Consultar lista de apartamentos");
                    System.out.println("2) Adicionar apartamento");
                    System.out.println("3) Deletar apartamento");
                    System.out.println("0) Voltar");
                    escolha_apto = leitor.nextInt();
                    if(escolha_apto == 1) {
                        System.out.println("LISTA DE APARTAMENTOS");

                        // depois de fazer tudo que precisava, escolha_APTO vai para 0 para poder sair do loop
                        //escolha_apto = 0;
                    }else if(escolha_apto == 2) {
                        System.out.println("Adicona APARTAMENTO");

                    }else if(escolha_apto == 3) {
                        System.out.println("Deleta APARTAMENTO");

                    }else if(escolha_apto == 0) {

                    }else {
                        System.out.println("Opção inválida");

                    }
                }

            }else if(escolha == 0) {
                System.out.println("SAIU DO SISTEMA");

            }else {
                System.out.println("Opção inválida");

            }


        }

    }

    private static ArrayList<Map<String, String>> listarCondominios() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        ResultSet resultSet = conn.query("SELECT * FROM Condominio");

        while(resultSet.next()) {
            HashMap<String, String> condominio = new HashMap<>();
            condominio.put("idCondominio", resultSet.getString("idCondominio"));
            condominio.put("nome", resultSet.getString("nome"));
            result.add(condominio);
        }

        return result;
    }

    private static Long adicionarCondominio(String nome, String cidade, String bairro, String endereco, Integer numero) throws SQLException {
        Condominio condominio = new Condominio(nome, cidade, bairro, endereco, numero);

        return condominio.getIdCondominio();
    }

    private static Boolean deletarCondominio(Long idConcodminio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        try {
            conn.query("DELETE FROM Condominio WHERE idCondominio = " + idConcodminio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static ArrayList<Map<String, String>> listarEdificios() throws SQLException {
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

        return result;
    }


    private static Long adicionarEdificio(Condominio condominio, Integer numero, String cor, Integer qtdAndar) throws SQLException {
        Edificio edificio = new Edificio(condominio, numero, cor, qtdAndar);

        return edificio.getIdEdificio();
    }

    private static Boolean deletarEdificio(Long idEdificio) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        try {
            conn.query("DELETE FROM Edificio WHERE idEdificio = " + idEdificio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}