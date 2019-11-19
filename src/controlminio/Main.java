package controlminio;

import controlminio.domminio.Condominio;
import controlminio.domminio.Pessoa;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
	// Metodos do diagrama

        Pessoa usuario;
        usuario = new Pessoa("Jean Carlos","021.142.150-05","12345678910","M", new Date(1994,03,25));

        public Condominio cadastrarCondominio(){
            Condominio novoCondominio;
            novoCondominio = new Condominio();

        }

        public void editarCondominio(){}

        public void excluirCondominio(){}

        public void visualizarCondominio(){}

        public void tecladoString(){
            Scanner leitura = new Scanner();
             leitura.hasNext();
             String dado = leitura.nextLine();
        }
        public int tecladoInt(){
            Scanner leitura = new Scanner(System.in);
            int dado = leitura.nextInt();
        }

        public void tecladoData(){
            Scanner leitura = new Scanner(System.in);
            String dataRecebida = leitura.nextLine();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dt = df.parse(dataRecebida);
        }



    }
}
