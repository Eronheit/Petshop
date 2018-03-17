/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import Modelo.Cliente;
import java.util.*;
import java.util.ArrayList;
import javax.rmi.CORBA.Util;
import javax.swing.JTextField;

/**
 *
 * @author Euxz
 */
public class ClienteDAO extends ExecuteSQL{

    public ClienteDAO(Connection con) {
        super(con);
    }
    
    //Método para Cadastrar Cliente
    public String Inserir_Cliente(Cliente a){
        String sql = "INSERT INTO cliente VALUES(0,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getCpf());
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getEndereco());
            ps.setString(6, "2");
            
            if (ps.executeUpdate() > 0) {
                return "Cliente inserido com sucesso";
            }
            else{
                return "Erro ao inserir Cliente";
            }
        } 
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    //Método para capturar Cliente para inserir Cliente para Alterar
    public List<Cliente> CapturarCliente(int cod){
        String sql = "SELECT * FROM cliente WHERE idcliente ="+ cod +" ";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Cliente a = new Cliente();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setEmail(rs.getString(3));
                    a.setCpf(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEndereco(rs.getString(6));                 
                    lista.add(a);
                }
                return lista;
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    //Método para testar se o código do Cliente existe no banco
    public boolean Testar_Cliente(int cod){
        boolean Resultado = false;
        
        try {
            String sql = "SELECT * FROM cliente WHERE idcliente =" + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Resultado = true;
                }
            }
            
        }
        catch (SQLException ex) {
            ex.getMessage();
        }
        return Resultado;
    }
    
    //Método para Alterar Cliente
    public String Alterar_Cliente(Cliente a){
        String sql = " UPDATE cliente set nome = ?, email = ?,"
                + " cpf = ?, telefone = ?, endereco = ? WHERE idcliente = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getCpf());
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getEndereco());
            ps.setInt(6, a.getCod());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com suceeso";
            }
            else{
                return "Erro ao atualizar";
            }
        }
        catch(SQLException e){
            return e.getMessage();
        }
    }
    
    //Consultar codigo do Cliente
    public List<Cliente> ConsultarCodigoCliente(String nome){
        String sql = "SELECT idcliente FROM cliente WHERE nome = '"+nome+"'";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Cliente a = new Cliente();
                    a.setCod(rs.getInt(1));
                    lista.add(a);
                    
                }
                return lista;
            }
            else{
                return null;
            }
        }
        catch (Exception e) {
            return null;
        }
        
    }
    
    //Excluir Cliente
    public String Excluir_Cliente(Cliente a){
        String sql = "DELETE FROM cliente WHERE idcliente = ? and nome = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            }
            else{
                return "Erro ao excluir";
            }
        } 
        catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    //Listar combo dos Clientes
    public List<Cliente> ListarComboCliente(){
        String sql = "SELECT nome FROM cliente order by nome";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Cliente a = new Cliente();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                    
                }
                return lista;
            }
            else{
                return null;
            }
        }
        catch (Exception e) {
            return null;
        }
    }
    
}
