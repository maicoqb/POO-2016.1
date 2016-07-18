package model;

import java.util.UUID;

public class Caixa {

    private String id;

    public Caixa(int i) {
        this.id = Integer.toString(i);
    }

    @Override
    public String toString() {
        return "Caixa " + id;
    }
}
