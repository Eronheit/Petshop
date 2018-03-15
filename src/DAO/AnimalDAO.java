
package DAO;

import java.sql.*;
import Modelo.Animal;
import java.util.*;
import java.util.ArrayList;
import javax.swing.JTextField;

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
    
    //Consultar Código do Animal
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

    //Listar o Nome do Animal, Tipo, Raça no ComboBox
    public List<Animal> ListarComboAnimal(){
        String sql = "SELECT nome,tipo,raca FROM animal order by nome";
        List<Animal> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Animal a = new Animal();
                    a.setNome(rs.getString(1));
                    a.setTipo(rs.getString(2));
                    a.setRaca(rs.getString(3));
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
    
    //Método para Alterar Cliente
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
    
}
