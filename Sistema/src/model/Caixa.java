package model;

import java.util.UUID;

/**
 *
 * @author User
 */
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
