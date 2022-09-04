/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.FuncionarioBeans;
import ModelConexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior Macie
 */
  public class FuncionarioDao {
    ConexaoBD conex = new ConexaoBD();
    FuncionarioBeans mod = new FuncionarioBeans();

    public void salvar(FuncionarioBeans mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into funcionario (nome, sexo, funcao, contacto,  identificacao, faltas) values(?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getSexo());
            pst.setString(3, mod.getFuncao());
            pst.setString(4, mod.getContacto());
            pst.setString(5, mod.getIdentificacao());
            pst.setInt(6, mod.getFaltas());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Funcionario Inserido Com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Inserir Funcionário! \n Funcionário Já Existe Registado!");
        }
        conex.desconexao();
    }

    public void editar(FuncionarioBeans mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update funcionario set nome=?, sexo=?, funcao=?, contacto=?, identificacao=?, faltas=? where id=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getSexo());
            pst.setString(3, mod.getFuncao());
            pst.setString(4, mod.getContacto());
            pst.setString(5, mod.getIdentificacao());
            pst.setInt(6, mod.getFaltas());
            pst.setInt(7, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados Com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar Dados! \n Funcionário Já Existe Registado!");
        }
        conex.desconexao();
    }

    
    public void excluir(FuncionarioBeans mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from funcionario where id=?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos Com Sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro Na Exclusão De Dados!\n Error:" + ex);
        }
        
        conex.desconexao();
    }
    
    public FuncionarioBeans buscaFuncionario(FuncionarioBeans mod) {
        conex.conexao();
        conex.executaSql("select * from funcionario where nome like '%" + mod.getPesquisa() + "%'");

           try { 
            conex.rs.first();
            mod.setId(conex.rs.getInt("id"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setSexo(conex.rs.getString("sexo"));
            mod.setFuncao(conex.rs.getString("funcao"));
            mod.setContacto(conex.rs.getString("contacto"));
            mod.setIdentificacao(conex.rs.getString("identificacao"));
            mod.setFaltas(conex.rs.getInt("faltas"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Funcionário Sem Registo \n Busque Novamente, Certifique Que Escreve Correctamente");
        }

        conex.desconexao();
        return mod;
    } 
    
    public void aumentar(int aumento, int codigo){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update funcionario set faltas=? where id=?");
            pst.setInt(1, aumento);
            pst.setInt(2, codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Uma Falta Adicionada Ao Funcionario!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar Dados! \n Error: "+ex);
        }
        conex.desconexao();
    }
    
    public void remocao(int reducao, int codigo){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update funcionario set faltas=? where id=?");
            pst.setInt(1, reducao);
            pst.setInt(2, codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Uma Falta Removida Do Funcionario!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar Dados! \n Error: "+ex);
        }
        conex.desconexao();
    }
}
