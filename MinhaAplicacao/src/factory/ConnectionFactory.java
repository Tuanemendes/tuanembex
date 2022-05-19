/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author tuane
 */
import java.sql.Connection; 
// conexão SQL para Java 
import java.sql.DriverManager; 
// driver de conexão SQL para Java 
import java.sql.SQLException; 
public class ConnectionFactory {
    
    public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost/projetojava?serverTimezone=UTC","root","1234");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
    
}
