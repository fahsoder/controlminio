package controlminio;

import controlminio.bdConnection.MysqlConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
                        System.out.println("LISTA DE CONDOMINIO");
                        ArrayList<Map> condominios = listarCondominios();

                    }else if(escolha_condominio == 2) {
                        System.out.println("Adicona condomínio");

                    }else if(escolha_condominio == 3) {
                        System.out.println("Deleta condominio");

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


                    }else if(escolha_edificio == 2) {
                        System.out.println("Adicona EDIFICIO");

                    }else if(escolha_edificio == 3) {
                        System.out.println("Deleta EDIFICIO");

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

    private ArrayList<Map> listarCondominios() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ArrayList<Map> result = new ArrayList<>();
        ResultSet resultSet = conn.query("SELECT * FROM Condominio");

        while(resultSet.next()) {
            Map<Integer, String> condominio = new HashMap();
            condominio.put(Integer.parseInt(resultSet.getString("idCondominio")), resultSet.getString("nome"));
            result.add(condominio);
        }

        return result;
    }

}