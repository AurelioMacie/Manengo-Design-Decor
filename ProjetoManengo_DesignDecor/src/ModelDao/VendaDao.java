/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.VendaBeans;
import ModelConexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aurelio Macie Junior
 */
public class VendaDao {
    ConexaoBD conex = new ConexaoBD();
    VendaBeans venda = new VendaBeans();
    
    
        public void vender(VendaBeans mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into venda (usuario, cliente, contacto, endereco, produto, qtd, precoun, vapagar, pagamento, data, hora) values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getUsuario());
            pst.setString(2, mod.getCliente());
            pst.setString(3, mod.getContacto());
            pst.setString(4, mod.getEndereco());
            pst.setString(5, mod.getProduto());
            pst.setInt(6, mod.getQtd());
            pst.setFloat(7, mod.getPrecoun());
            pst.setFloat(8, mod.getVapagar());
            pst.setFloat(9, mod.getPagamento());
            pst.setString(10, mod.getData());
            pst.setString(11, mod.getHora());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venda Realizada Com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Efectuar Venda! \n Error: "+ex);
        }
        conex.desconexao();
    }
    
}
