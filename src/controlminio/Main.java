    package controlminio;

import controlminio.domminio.Apartamento;
import controlminio.domminio.ApartamentoLuxo;
import controlminio.fabrica.FactoryApartamento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static controlminio.repositorio.BancoCondominio.*;
import static controlminio.repositorio.BancoEdificio.*;
import static controlminio.repositorio.BancoApartamento.*;

public class Main {

    static FactoryApartamento factoryApartamento;
    static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        int escolha = 99, escolha_condominio = 99, escolha_apto = 99, escolha_edificio;

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

                        Scanner leitor = new Scanner(System.in);
                        
                        System.out.print("Nome do condom�nio: ");
                        String nome = leitor.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = leitor.nextLine();
                        System.out.print("Bairro: ");
                        String bairro = leitor.nextLine();
                        System.out.print("Endereco: ");
                        String endereco = leitor.nextLine();
                        System.out.print("Numero: ");
                        Integer numero = leitor.nextInt();

                        Long idCondominio = adicionarCondominio(nome, cidade, bairro, endereco, numero);
                        System.out.println("Adiconado o condomínio " + idCondominio);
                        3

                    }else if(escolha_condominio == 3) {
                        System.out.println("Listagem de condominios:");
                        listarCondominios();
                        System.out.println("Digite o ID do condominio que deseja deletar");
                        Long idCondominio = leitor.nextLong();
                        if (deletarCondominio(idCondominio)) {
                            System.out.println("Condominio " + idCondominio + " deletado!");
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
                        listarEdificios();
                        Scanner leitor = new Scanner(System.in);

                    }else if(escolha_edificio == 2) {
                        System.out.println("Listagem de condominio");
                        listarCondominios();
                        System.out.println("Digite o ID do condominio");
                        Long idCondominio = leitor.nextLong();
                        System.out.println("Digite a cor do edificio");
                        String cor = leitor.nextLine();
                        System.out.println("Digite a quantidade do numero de andares do edificio");
                        Integer qntAndar = leitor.nextInt();
                        System.out.println("Digite o numero do edificio");
                        Integer numero = leitor.nextInt();
                        Long idEdificio = adicionarEdificio(idCondominio, numero, cor, qntAndar);
                        System.out.println("Edificio " + idEdificio + " adicionado com sucesso!");

                    }else if(escolha_edificio == 3) {
                        System.out.println("Listagem de edificios:");
                        listarEdificios();
                        Scanner leitor = new Scanner(System.in);

                        System.out.println("Digite o ID do edificio que deseja deletar");
                        Long idEdificio = leitor.nextLong();
                        if (deletarEdificio(idEdificio)) {
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

                        listarApartamentos();
                    }else if(escolha_apto == 2) {

                        Scanner leitor = new Scanner(System.in);        

                        System.out.println("ADICIONAR DE APARTAMENTOS");
                        System.out.println("Qual o tipo de apartamento que deseja adicionar? Luxo(1) ou Padrao(2)?");
                        Integer tipoAp = leitor.nextInt();
                        Apartamento apartamento = validaApartamento(tipoAp);
                        Long idApartamento = adicionarApartamento(apartamento);
                        System.out.println("Apartamento " + idApartamento + " adicionado!");
                    }else if(escolha_apto == 3) {
                        System.out.println("Deleta APARTAMENTO");
                        listarApartamentos();
                        System.out.println("Digite o ID do apartamento que deseja deletar");
                        Long idApartamento = leitor.nextLong();
                        if (deletarApartamento(idApartamento)) {
                            System.out.println("Apartamento " + idApartamento + " deletado!");
                        } else {
                            System.out.println("Erro ao deletar apartamento");
                        }

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
    private static Apartamento validaApartamento(Integer tipoAp) throws SQLException {
        Apartamento apartamento = null;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Listagem de edificios");
        listarEdificios();
        System.out.println("Digite o ID do Edificio");
        Long idEdificio = leitor.nextLong();
        System.out.println("Digite o andar do apartamento");
        Integer andar = leitor.nextInt();
        System.out.println("Digite o numero do apartamento");
        Integer numero = leitor.nextInt();
        if (tipoAp == 1) {
            System.out.println("Digite o modelo das luminarias");
            String luminarias = leitor.nextLine();
            System.out.println("O apartamento possui geladeira? Sim(1) ou Nao(2)?");
            Integer geladeira = leitor.nextInt();
            System.out.println("O apartamento possui Fogao? Sim(1) ou Nao(2)?");
            Integer fogao = leitor.nextInt();

            boolean boolGeladeira = false;
            boolean boolFogao = false;
            if (geladeira == 1) { boolGeladeira = true; }
            if (fogao == 1) { boolFogao = true; }

            apartamento = factoryApartamento.getApartamento(getEdificioById(idEdificio), andar, luminarias, numero, boolGeladeira, boolFogao);
        } else if (tipoAp == 2) {
            System.out.println("Digite o tipo de piso");
            String tipoPiso = leitor.nextLine();
            System.out.println("Digite o tipo de armario");
            String tipoArmario = leitor.nextLine();

            apartamento = factoryApartamento.getApartamento(getEdificioById(idEdificio), andar, numero, tipoPiso, tipoArmario);
        }

        return apartamento;

    }

}