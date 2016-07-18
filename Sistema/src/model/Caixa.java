package model;

import java.util.UUID;

/**
 *
 * @author User
 */
public class Caixa {

    private String id;

    public Caixa() {
        this.id = UUID.randomUUID().toString().substring(1, 8);
    }

    @Override
    public String toString() {
        return "Caixa{" + id + '}';
    }
}
