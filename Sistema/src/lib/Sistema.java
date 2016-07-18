package lib;

import javax.swing.JFrame;
import model.Estoque;
import model.Registro;
import view.ViewBuscaProduto;
import view.ViewCadastroProduto;
import view.ViewCaixa;
<<<<<<< HEAD
=======
import view.ViewGerente;
import view.ViewRelatorioVenda;
>>>>>>> d5ce29df45b01b582d95249a0fbbb5467998e8d8

/**
 *
 * @author User
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Estoque.init();
        Registro.init();

        JFrame telaGerente = new ViewGerente();

        // Iniciar 1 tela de estoque
        // Iniciar 3 telas de caixa
        // Iniciar 1 tela de busca de produto
        // JFrame buscaDeProduto = new ViewBuscaProduto();
//        JFrame telaGerente = new ViewCadastroProduto();
//
//        JFrame telaBuscaProduto = new ViewBuscaProduto();
//
//        JFrame telaCaixa = new ViewCaixa();
////
     //   JFrame telaRelatorio = new ViewRelatorioVenda();
//        JFrame telaCaixa2 = new ViewCaixa();
        // Inicia o Sistema
    }

}
