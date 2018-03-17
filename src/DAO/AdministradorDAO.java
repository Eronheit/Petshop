
package DAO;

import java.sql.*;
import Modelo.Administrador;
import java.util.*;
import java.util.ArrayList;
import javax.swing.JTextField;

public class AdministradorDAO extends ExecuteSQL{
    public AdministradorDAO(Connection con){
        super(con);
    }
    
    //Cadastrar ADM
    public String Inserir_Administrador(Administrador a){
      String sql = "INSERT INTO administrador VALUES (0,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getSenha());
            ps.setString(3, a.getSenhaextra());
            ps.setString(4, "0");
            
            if (ps.executeUpdate() > 0) {
                return "Administrador inserido com sucesso";
            }
            else{
                return "Erro ao inserir administrador";
            }          
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
   
    //Método para capturar ASM para inserir ADM para Alterar
    public List<Administrador> CapturarAdministrador(int cod){
        String sql = "SELECT * FROM administrador WHERE idadministrador ="+ cod +" ";
        List<Administrador> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Administrador a = new Administrador();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setUsuario(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    a.setSenhaextra(rs.getString(5));
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
    
    //Método para testar se o código do ADM existe no banco
    public boolean Testar_Administrador(int cod){
        boolean Resultado = false;
        
        try {
            String sql = "SELECT * FROM administrador WHERE idadministrador =" + cod + "";
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
    public String Alterar_Administrador(Administrador a){
        String sql = " UPDATE administrador set nome = ?, usuario = ?,"
                + " senha = ?, senhaextra = ? WHERE idadministrador = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getUsuario());
            ps.setString(3, a.getSenha());
            ps.setString(4, a.getSenhaextra());
            ps.setInt(5, a.getCod());
            
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
    
    //Consultar codigo do Administrador
    public List<Administrador> ConsultarCodigoAdministrador(String nome){
        String sql = "SELECT idadministrador FROM administrador WHERE nome = '"+nome+"'";
        List<Administrador> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Administrador a = new Administrador();
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
    
    //Excluir Administrador
    public String Excluir_Administrador(Administrador a){
        String sql = "DELETE FROM administrador WHERE idadministrador = ? and nome = ?";
        
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
    
    //Listar combo do ADM
    public List<Administrador> ListarComboAdministrador(){
        String sql = "SELECT nome FROM administrador order by nome";
        List<Administrador> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Administrador a = new Administrador();
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
