/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroaluno;

import java.sql.*;
/**
 *
 * @author tuane
 */
class Conexao {
    
    String driver = "com.mysql.jdbc.Driver";// Driver para Conexao com banco 
    String banco = "cadaluno"; // Nome do Banco de dados
    String host = "localhost";// servidor de banco de dados
    String stringDeConexao = "jdbc:mysql://" + host + ":3306/" + banco + "?serverTimezone=UTC"; // String de Conexao com o banco de dados
    String usuario = "root"; //usuario do banco 
    String senha = "1234";// senha de usuario
    
    public Connection conexao;
    
    //cria nova instancia de Conexao
    public Conexao(){
        
    }
    
    public Connection getConexao(){
        try {
            Class.forName(driver);//carrega o driver
            return DriverManager.getConnection(this.stringDeConexao,usuario,senha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return conexao;
        
        }
    }    
    public ResultSet getResultSet(String sentenca){
        try {
          Statement statement  = new ConexaoBanco().getInstanceStatement();
          ResultSet resultSet = statement.executeQuery(sentenca);
          return resultSet;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return  null;
        }
    }
    
    public String atualizarBanco(String sentenca){
        try {
           Statement statement = new ConexaoBanco().getInstanceStatement();
           statement.executeUpdate(sentenca);
           return "1";
        } catch (SQLException e) {
           return e.getMessage(); 
        }catch(Exception ex){
            return ex.getMessage();
        }
        
    }
    
}
