/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Animal;
import java.sql.*;
import Modelo.Servico;
import java.util.ArrayList;
import java.util.*;


/**
 *
 * @author Euxz
 */
public class ServicoDAO extends ExecuteSQL{

    public ServicoDAO(Connection con) {
        super(con);
    }
    public String Inserir_Servico(Servico s){
        String sql = "INSERT INTO servicos VALUES(0,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, s.getNome());
            ps.setInt(2, s.getIndicacao());
            ps.setDouble(3, s.getPreco());
            ps.setString(4, s.getDisponibilidade());
            ps.setDouble(5, s.getDesconto());
            
            if (ps.executeUpdate() > 0) {
                return "Serviço inserido com sucesso";
            }
            else{
                return "Erro ao inserir Serviço";
            }
        } 
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    //Método para Alterar Serviço
    public String Alterar_Servico(Servico s){
        String sql = " UPDATE servicos set nome = ?, indicacao = ?,"
                + " preco = ?, disponibilidade = ?, desconto = ? WHERE idservico = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, s.getNome());
            ps.setInt(2, s.getIndicacao());
            ps.setDouble(3, s.getPreco());
            ps.setString(4, s.getDisponibilidade());
            ps.setDouble(5, s.getDesconto());
            ps.setInt(6, s.getCod());
            
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
    
    //Método para capturar Servico para inserir Servico para Alterar
    public List<Servico> CapturarServico(int cod){
        String sql = "SELECT * FROM servicos WHERE idservico ="+ cod +" ";
        List<Servico> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Servico a = new Servico();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setIndicacao(rs.getInt(3));
                    a.setPreco(rs.getDouble(4));
                    a.setDisponibilidade(rs.getString(5));
                    a.setDesconto(rs.getDouble(6));                 
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
    
    //Método para testar se o código do Servico existe no banco
    public boolean Testar_Servico(int cod){
        boolean Resultado = false;
        
        try {
            String sql = "SELECT * FROM servicos WHERE idservico =" + cod + "";
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
    
}
