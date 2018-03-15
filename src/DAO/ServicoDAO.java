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
            ps.setString(2, s.getIndicacao());
            ps.setString(3, s.getPreco());
            ps.setString(4, s.getDisponibilidade());
            ps.setString(5, "");
            
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
    
    
    
}
