
package DAO;
    import java.sql.*;
    import javax.swing.JOptionPane;
public class Conexao {
    //Abre a conexao com o banco
    public static Connection AbrirConexao(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/petshop";
            con = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        }
        return con;
    }
    //Fecha a conexao com o banco
    public static void FecharConexao(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        }
    }
}
