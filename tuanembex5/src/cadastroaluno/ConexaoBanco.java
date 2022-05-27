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
public class ConexaoBanco {
    public ConexaoBanco(){
    }
    
    private static Connection connection = null;
    private static Statement db_Statement = null;
    
    public static Connection getInstanceConnection(){
        try {
            if (connection == null || connection.isClosed()) {
               connection = null;
               Conexao conexao = new  Conexao();
               connection = conexao.getConexao();
               connection.setAutoCommit(true);
               db_Statement = connection.createStatement();
            }
        } catch (Exception e) {
            System.out.println("0.Erro ao conectar com o banco. Erro " + e.getMessage());
        }
        return connection;
    }
    
    public static Statement getInstanceStatement() throws Exception {
        if (db_Statement == null) {
            getInstanceConnection();
        }
        return db_Statement;
    }
    
    public static  void closeInstanceConnection() throws Exception{
        if (connection != null) 
            if(!connection.isClosed())
                connection.close();
        connection = null;
        db_Statement = null;
        
    }
}
