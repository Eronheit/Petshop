
package DAO;

import Modelo.Administrador;
import java.sql.*;
import Modelo.Funcionario;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO extends ExecuteSQL{
    public FuncionarioDAO(Connection con){
        super(con);
    }
    
    //Cadastrar Funcionário
    public String Inserir_Funcionario(Funcionario a){
      String sql = "INSERT INTO funcionario VALUES (0,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getUsuario());
            ps.setString(3, a.getSenha());
            ps.setString(4, a.getEndereco());
            ps.setString(5, a.getCpf());
            ps.setString(6, a.getRg());
            ps.setString(7, a.getTelefone());
            ps.setString(8, "1");
            
            if (ps.executeUpdate() > 0) {
                return "Funcionário Inserido com sucesso";
            }
            else{
                return "Erro ao inserir funcionário";
            }          
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    //Logar Funcionário
    public boolean Logar_Funcionario(String usuario, String senha){
        boolean finalResult = false;
    
    try{
        String consulta = "select usuario, senha from funcionario where usuario = '"+usuario+"' and senha ='"+senha+"' and level = 1";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                Funcionario a = new Funcionario();
                a.setUsuario(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
            }
        }
    }catch(Exception e){
    }
    return finalResult;
  }
    
    //Logar ADM
    public boolean Logar_Administrador(String usuario, String senha){
        boolean finalResult = false;
    
    try{
        String consulta = "select usuario, senha from administrador where usuario = '"+usuario+"' and senha ='"+senha+"' and level = 0";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                Administrador a = new Administrador();
                a.setUsuario(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
            }
        }
    }catch(Exception e){
    }
    return finalResult;
  }
    
    //Método para capturar Funcionario para inserir Funcionario para Alterar
    public List<Funcionario> CapturarFuncionario(int cod){
        String sql = "SELECT * FROM funcionario WHERE idfuncionario ="+ cod +" ";
        List<Funcionario> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setUsuario(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    a.setEndereco(rs.getString(5));
                    a.setCpf(rs.getString(6));
                    a.setRg(rs.getString(7));
                    a.setTelefone(rs.getString(8));
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
    
    //Método para testar se o código do Funcionario existe no banco
    public boolean Testar_Funcionario(int cod){
        boolean Resultado = false;
        
        try {
            String sql = "SELECT * FROM funcionario WHERE idfuncionario =" + cod + "";
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
    
    //Método para Alterar Funcionario
    public String Alterar_Funcionario(Funcionario a){
        String sql = " UPDATE funcionario set nome = ?, usuario = ?,"
                + " senha = ?, endereco = ?, cpf = ?, rg = ?, telefone = ? WHERE idfuncionario = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getUsuario());
            ps.setString(3, a.getSenha());
            ps.setString(4, a.getEndereco());
            ps.setString(5, a.getCpf());
            ps.setString(6, a.getRg());
            ps.setString(7, a.getTelefone());
            ps.setInt(8, a.getCod());
            
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
    public List<Funcionario> ConsultarCodigoFuncionario(String nome){
        String sql = "SELECT idfuncionario FROM funcionario WHERE nome = '"+nome+"'";
        List<Funcionario> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Funcionario a = new Funcionario();
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
    
    //Excluir Funcionario
    public String Excluir_Funcionario(Funcionario a){
        String sql = "DELETE FROM funcionario WHERE idfuncionario = ? and nome = ?";
        
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
}
