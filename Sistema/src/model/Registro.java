package model;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;

public class Registro {

    private static Registro instancia;

    private ArrayList<Venda> vendas;

    private Registro() {
        vendas = new ArrayList<>();
    }

    public static Registro getInstancia() {
        if (instancia == null) {
            instancia = new Registro();
        }
        return instancia;
    }
    public void adicionarVenda(Venda venda){
        vendas.add(venda);
    }

    
}
