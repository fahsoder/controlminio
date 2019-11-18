package controlminio.domminio;

import java.util.Random;

public class Utilitários {
    public Long criarId() {
        Random rand = new Random();
        return rand.nextLong();
    }
}
