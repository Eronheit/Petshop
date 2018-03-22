
package DAO;


import Modelo.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.ArrayList;

public class AnimalDAO extends ExecuteSQL{
    public AnimalDAO(Connection con){
        super(con);
    }
    
    //Cadastrar Animal
    public String Inserir_Animal(Animal a){
      String sql = "INSERT INTO animal VALUES (0,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getTipo());
            ps.setString(3, a.getRaca());
            ps.setDouble(4, a.getTamanho());
            ps.setDouble(5, a.getPeso());
            ps.setInt(6, a.getIdade());
            
            if (ps.executeUpdate() > 0) {
                return "Animal Inserido com sucesso";
            }
            else{
                return "Erro ao inserir Animal";
            }          
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    

    //Método para capturar Animal para inserir Animal para Alterar
    public List<Animal> CapturarAnimal(int cod){
        String sql = "SELECT * FROM animal WHERE idanimal ="+ cod +" ";
        List<Animal> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Animal a = new Animal();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setTipo(rs.getString(3));
                    a.setRaca(rs.getString(4));
                    a.setTamanho(rs.getDouble(5));
                    a.setPeso(rs.getDouble(6));                 
                    a.setIdade(rs.getInt(7));                 
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
    
    //Método para testar se o código do Animal existe no banco
    public boolean Testar_Animal(int cod){
        boolean Resultado = false;
        
        try {
            String sql = "SELECT * FROM animal WHERE idanimal =" + cod + "";
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
    
    //Método para Alterar Animal
    public String Alterar_Animal(Animal a){
        String sql = " UPDATE animal set nome = ?, tipo = ?,"
                + " raca = ?, tamanho = ?, peso = ?, idade = ? WHERE idanimal = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getTipo());
            ps.setString(3, a.getRaca());
            ps.setDouble(4, a.getTamanho());
            ps.setDouble(5, a.getPeso());
            ps.setInt(6, a.getIdade());
            ps.setInt(7, a.getCod());
            
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
    
    //Consultar codigo do Animal
    public List<Animal> ConsultarCodigoAnimal(String nome){
        String sql = "SELECT idanimal FROM animal WHERE nome = '"+nome+"'";
        List<Animal> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Animal a = new Animal();
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
    
    //Excluir Animal
    public String Excluir_Animal(Animal a){
        String sql = "DELETE FROM animal WHERE idanimal = ? and nome = ?";
        
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
    
    //Listar combo do Animal
    public List<Animal> ListarComboAnimal(){
        String sql = "SELECT nome FROM animal order by nome";
        List<Animal> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Animal a = new Animal();
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
    
    //Pesquisar Animal por Nome
    public List<Animal> Pesquisar_Nome_Animal(String nome){
        String sql = "SELECT idanimal,nome,tipo,raca,tamanho,peso,idade FROM animal where nome LIKE'"+nome+"'";
        List<Animal> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Animal a = new Animal();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setTipo(rs.getString(3));
                    a.setRaca(rs.getString(4));
                    a.setTamanho(rs.getDouble(5));
                    a.setPeso(rs.getDouble(6));
                    a.setIdade(rs.getInt(6));
                    
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
    
    //Pesquisar Animal por Codigo
    public List<Animal> Pesquisar_Codigo_Animal(int cod){
        String sql = "SELECT idanimal,nome,tipo,raca,tamanho,peso,idade FROM animal where idanimal LIKE'"+cod+"'";
        List<Animal> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Animal a = new Animal();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setTipo(rs.getString(3));
                    a.setRaca(rs.getString(4));
                    a.setTamanho(rs.getDouble(5));
                    a.setPeso(rs.getDouble(6));
                    a.setIdade(rs.getInt(6));
                    
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
    
    //Pesquisar Todos Animal
    public List<Animal> ListarAnimal(){
        String sql = "SELECT idanimal,nome,tipo,raca,tamanho,peso,idade FROM animal";
        List<Animal> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Animal a = new Animal();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setTipo(rs.getString(3));
                    a.setRaca(rs.getString(4));
                    a.setTamanho(rs.getDouble(5));
                    a.setPeso(rs.getDouble(6));
                    a.setIdade(rs.getInt(6));
                    
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
