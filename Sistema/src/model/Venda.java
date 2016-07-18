package model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import lib.Helpers;
import model.Produto;

/**
 *
 * @author User
 */
public class Venda {
    private ArrayList<Produto> produtos;
    private float valorVenda;
    private String caixa;
    private String funcionario;
    private Date data;

    public Venda(DefaultTableModel lista) {
        this.produtos = new ArrayList<>();
        this.valorVenda=0;
        Produto p;
        String codigo;
        String nome;
        float valorProduto;
        float quantidade;
        String tipoQuantidade;
        int linhas = lista.getRowCount();
        for (int i = 0; i < linhas; i++) {
            codigo = (String) lista.getValueAt(i,1);
            nome = (String) lista.getValueAt(i,2);
            valorProduto=Helpers.toFloat((String) lista.getValueAt(i,3));
            quantidade=Helpers.toFloat((String) lista.getValueAt(i,4));
            tipoQuantidade=(String) lista.getValueAt(i,4);
            this.valorVenda+=valorProduto;
            p = new Produto(codigo,nome,valorProduto,quantidade,tipoQuantidade);
            produtos.add(p);
        }
//        Date now = new Date();
//        this.data.setTime(now);
          this.data = new Date();
    }
}
