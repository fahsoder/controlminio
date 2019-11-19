package controlminio.domminio;

import java.util.Random;

public class Utilitarios {
    public Long criarId() {
        Random rand = new Random();
        return rand.nextLong();
    }
}
