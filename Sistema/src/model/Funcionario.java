package model;

import java.util.UUID;

/**
 *
 * @author User
 */
public class Funcionario {

    private String nome;
    private String senha;
    private String id;

    public Funcionario(int i) {
        this.id = Integer.toString(i);
    }

    @Override
    public String toString() {
        return "Funcionario " + id;
    }
}
