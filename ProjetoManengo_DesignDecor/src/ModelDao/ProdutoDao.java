/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.FuncionarioBeans;
import ModelBeans.ProdutoBeans;
import ModelConexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior Macie
 */
public class ProdutoDao {
ConexaoBD conex = new ConexaoBD();
    ProdutoBeans mod = new ProdutoBeans();

    //Metodo que efectua a accao de Gravar os dados do material no banco de dados;
    public void salvar(ProdutoBeans mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into produto (nome, qtd, valor) values(?,?,?)");
            pst.setString(1, mod.getNmproduto());
            pst.setInt(2, mod.getQtd());
            pst.setFloat(3, mod.getValor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Material Inserido Com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Inserir Produto! \n Error: "+ex);
        }
        conex.desconexao();
    }

    public void editar(ProdutoBeans mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update produto set nome=?, qtd=?, valor=? where id=?");
            pst.setString(1, mod.getNmproduto());
            pst.setInt(2, mod.getQtd());
            pst.setFloat(3, mod.getValor());
            pst.setInt(4, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados Com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar Dados! \n Error: "+ex);
        }
        conex.desconexao();
    }
    
public void aumentar(int aumento, int codigo){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update produto set qtd=? where id=?");
            pst.setInt(1, aumento);
            pst.setInt(2, codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto Adicionado Ao Estoque!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Adicionar Dados! \n Error: "+ex);
        }
        conex.desconexao();
    }

public void remocao(int reducao, int codigo){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update produto set qtd=? where id=?");
            pst.setInt(1, reducao);
            pst.setInt(2, codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto Reduzido Do Stoque!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar Dados! \n Error: "+ex);
        }
        conex.desconexao();
    }

public void remocaoVenda(int reducao, int codigo){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update produto set qtd=? where id=?");
            pst.setInt(1, reducao);
            pst.setInt(2, codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto Reduzido Do Stoque Para Venda!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar Dados! \n Error: "+ex);
        }
        conex.desconexao();
    }

    
    public void excluir(ProdutoBeans mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from produto where id=?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos Com Sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro Na Exclusão De Dados! \n Error:" + ex);
        }
        
        conex.desconexao();
    }
    
    public ProdutoBeans buscaProduto(ProdutoBeans mod) {
        conex.conexao();
        conex.executaSql("select * from produto where nome like '%" + mod.getPesquisa() + "%'");

           try { 
            conex.rs.first();
            mod.setId(conex.rs.getInt("id"));
            mod.setNmproduto(conex.rs.getString("nome"));
            mod.setQtd(conex.rs.getInt("qtd"));
            mod.setValor(conex.rs.getFloat("valor"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Produto Sem Registo! \n Busque Novamente, Certifique Que Escreve Correctamente");
        }

        conex.desconexao();
        return mod;
    }            

}
