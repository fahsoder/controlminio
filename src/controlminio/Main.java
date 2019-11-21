package controlminio;

import controlminio.Repositorio.CondominioBanco;
import controlminio.Repositorio.EdificioBanco;
import controlminio.bdConnection.MysqlConnect;
import controlminio.domminio.Condominio;
import controlminio.fabrica.FactoryApartamento;

import java.sql.SQLException;
import java.util.Scanner;

import static controlminio.Repositorio.EdificioBanco.*;
import static controlminio.Repositorio.CondominioBanco.*;

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
                        listarCondominios();

                    }else if(escolha_condominio == 2) {
                        String unusedVar = leitor.nextLine();
                    	System.out.print("Nome do condomínio: ");
                        String nomeCondominio = leitor.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = leitor.nextLine();
                        System.out.print("Bairro: ");
                        String bairro = leitor.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = leitor.nextLine();
                        System.out.print("Número: ");
                        Integer numero = leitor.nextInt();

                        CondominioBanco.adicionarCondominio(nomeCondominio, cidade, bairro, endereco, numero);
                        System.out.println("Adiconadp o condomínio ");

                    }else if(escolha_condominio == 3) {
                        System.out.print("Digite o ID do condominio que voce deseja: ");
                        Long idCondominio = leitor.nextLong();
                        
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
                        EdificioBanco.listarEdificios();


                    }else if(escolha_edificio == 2) {
                        System.out.println("Abaixo a listagem de condomínios: ");
                        listarCondominios();

                        System.out.println("Digite o ID de um dos condomínios para deletá-lo: ");
                        Long idCondominio = leitor.nextLong();
                        Condominio condominio = getCondominio(idCondominio);

                        System.out.println("Digite o numero do edifício: ");
                        Integer numero = leitor.nextInt();

                        System.out.println("Digite a cor de edifício: ");
                        String cor = leitor.nextLine();

                        System.out.println("Digite a quantidade de andares do edifício: ");
                        Integer qntAndar = leitor.nextInt();

                        adicionarEdificio(condominio, numero, cor, qntAndar);
                        System.out.println("Edifício adicionado!");

                    }else if(escolha_edificio == 3) {
                        System.out.print("Digite o ID do edifício que voce deseja: ");
                        Long idEdificio = leitor.nextLong();
                        if (deletarCondominio(idEdificio)) {
                            System.out.println("Edificio " + idEdificio + " deletado!");
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