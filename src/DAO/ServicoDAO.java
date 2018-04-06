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
    
    //Método para inserir Servico
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
    
    //Consultar codigo do Servico
    public List<Servico> ConsultarCodigoServico(String nome){
        String sql = "SELECT idservico FROM servicos WHERE nome = '"+nome+"'";
        List<Servico> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Servico a = new Servico();
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
    
    //Consultar codigo do Servico
    public List<Servico> ConsultarDescontoECodServico(String nome){
        String sql = "SELECT idservico,preco,desconto FROM servicos WHERE nome = '"+nome+"'";
        List<Servico> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Servico a = new Servico();
                    a.setCod(rs.getInt(1));
                    a.setPreco(rs.getDouble(2));
                    a.setDesconto(rs.getDouble(3));
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
    
    //Excluir Servico
    public String Excluir_Servico(Servico s){
        String sql = "DELETE FROM servicos WHERE idservico = ? and nome = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, s.getCod());
            ps.setString(2, s.getNome());
            
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
    
    //Listar combo do Servico
    public List<Servico> ListarComboServico(){
        String sql = "SELECT nome FROM servicos order by nome";
        List<Servico> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Servico a = new Servico();
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
    
    //Pesquisar Servico por Nome
    public List<Servico> Pesquisar_Nome_Servico(String nome){
        String sql = "SELECT idservico,nome,indicacao,preco,disponibilidade,desconto FROM servicos where nome LIKE'"+nome+"'";
        List<Servico> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
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
        
        }
        catch(SQLException e){
            return null;
        }
    }
    
    //Pesquisar Servico por Codigo
    public List<Servico> Pesquisar_Codigo_Servico(int cod){
        String sql = "SELECT idservico,nome,indicacao,preco,disponibilidade,desconto FROM servicos where idservico LIKE'"+cod+"'";
        List<Servico> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
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
        
        }
        catch(SQLException e){
            return null;
        }
    }
    
    //Pesquisar Todos Servicos
    public List<Servico> ListarServico(){
        String sql = "SELECT idservico,nome,indicacao,preco,disponibilidade,desconto FROM servicos";
        List<Servico> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
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
        
        }
        catch(SQLException e){
            return null;
        }
    }
    
    //Promoção
    public String Promocao(Servico s){
        String sql = " UPDATE servicos set desconto = ? WHERE idservico = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setDouble(1, s.getDesconto());
            ps.setInt(2, s.getCod());
            
            if (ps.executeUpdate() > 0) {
                return "Promoção feita com sucesso";
            }
            else{
                return "Erro ao Promocionar";
            }
        }
        catch(SQLException e){
            return e.getMessage();
        }
    }
    
}
