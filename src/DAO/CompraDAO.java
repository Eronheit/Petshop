/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Animal;
import Modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Euxz
 */
public class CompraDAO extends ExecuteSQL{
    public CompraDAO(Connection con){
        super(con);
    }
    
    //Cadastrar Venda 
    public String Vender(Compra a){
      String sql = "INSERT INTO compra VALUES (0,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getCpf());
            ps.setInt(2, a.getCodanimal());
            ps.setInt(3, a.getServico());
            ps.setDouble(4, a.getDesconto());
            ps.setDouble(5, a.getTotal());
            ps.setString(6, a.getPagamento());
            
            if (ps.executeUpdate() > 0) {
                return "Serviço vendido com sucesso";
            }
            else{
                return "Erro ao vender serviço";
            }          
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    //Pesquisar Compra por CPF
    public List<Compra> Pesquisar_CPF_Cliente(String cpf){
        String sql = "SELECT idcompra,cpfcliente,codanimal,servico,desconto,total,formapagamento FROM compra where cpfcliente LIKE'"+cpf+"'";
        List<Compra> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Compra a = new Compra();
                    a.setCod(rs.getInt(1));
                    a.setCpf(rs.getString(2));
                    a.setCodanimal(rs.getInt(3));
                    a.setServico(rs.getInt(4));
                    a.setDesconto(rs.getDouble(5));
                    a.setTotal(rs.getDouble(6));
                    a.setPagamento(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            }
            else{
                return null;
            }
        
        }
        catch(SQLException e){
            return null;
        }
    }
    
    //Pesquisar Compra pelo Código da Compra
    public List<Compra> Pesquisar_Codigo_Compra(int cod){
        String sql = "SELECT idcompra,cpfcliente,codanimal,servico,desconto,total,formapagamento FROM compra where idcompra LIKE'"+cod+"'";
        List<Compra> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Compra a = new Compra();
                    a.setCod(rs.getInt(1));
                    a.setCpf(rs.getString(2));
                    a.setCodanimal(rs.getInt(3));
                    a.setServico(rs.getInt(4));
                    a.setDesconto(rs.getDouble(5));
                    a.setTotal(rs.getDouble(6));
                    a.setPagamento(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            }
            else{
                return null;
            }
        
        }
        catch(SQLException e){
            return null;
        }
    }
    
    //Pesquisar Compra pelo Código do Animal
    public List<Compra> Pesquisar_Codigo_Animal(int cod){
        String sql = "SELECT idcompra,cpfcliente,codanimal,servico,desconto,total,formapagamento FROM compra where codanimal LIKE'"+cod+"'";
        List<Compra> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Compra a = new Compra();
                    a.setCod(rs.getInt(1));
                    a.setCpf(rs.getString(2));
                    a.setCodanimal(rs.getInt(3));
                    a.setServico(rs.getInt(4));
                    a.setDesconto(rs.getDouble(5));
                    a.setTotal(rs.getDouble(6));
                    a.setPagamento(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            }
            else{
                return null;
            }
        
        }
        catch(SQLException e){
            return null;
        }
    }
    
    //Pesquisar Todas as Compras
    public List<Compra> ListarCompra(){
        String sql = "SELECT idcompra,cpfcliente,codanimal,servico,desconto,total,formapagamento FROM compra";
        List<Compra> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Compra a = new Compra();
                    a.setCod(rs.getInt(1));
                    a.setCpf(rs.getString(2));
                    a.setCodanimal(rs.getInt(3));
                    a.setServico(rs.getInt(4));
                    a.setDesconto(rs.getDouble(5));
                    a.setTotal(rs.getDouble(6));
                    a.setPagamento(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            }
            else{
                return null;
            }
        
        }
        catch(SQLException e){
            return null;
        }
    }
}
