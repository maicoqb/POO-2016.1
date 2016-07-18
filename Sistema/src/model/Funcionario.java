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

    public Funcionario() {
        this.id = UUID.randomUUID().toString().substring(1, 8);
    }

    @Override
    public String toString() {
        return "Funcionario{" + id + '}';
    }
}
