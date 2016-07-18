package lib;

import javax.swing.JFrame;
import model.Estoque;
import model.Registro;

import view.ViewInicial;


public class Sistema {

    public static void main(String[] args) {

        Estoque.init();
        Registro.init();

        JFrame telaInicial = new ViewInicial();
    }

}
