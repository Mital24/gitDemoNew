import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		String host="localhost";
		String port="3306";
		
		System.setProperty("webdriver.chrome.driver", "C:\\MyWork\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		
		System.out.println("HELLO...HAve A nice time");
		System.out.println("HELLO...HAve A nice time");
		
		System.out.println("HELLO...HAve A nice time");
		System.out.println("HELLO...HAve A nice time");
		System.out.println("HELLO...HAve A nice time");
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":" +port+"/MyQADBT", "root", "Mital@123");
		//When you are using JDBC outside of an application server, 
		//the DriverManager class manages the establishment of connections.
		
		//"jdbc:mysql://localhost:3306/Demo1"
		
		Statement s=con.createStatement();
		//Statement objects allow you to execute basic SQL queries and retrieve the results through the ResultSet class, 
		//which is described later. To create a Statement instance, you call the createStatement() method on the Connection object you have ...To ...

		
		ResultSet rs=s.executeQuery("Select * from EmployeeTbl ");
		while(rs.next())
		{
		//System.out.println(rs.getString("EName")+"\t"+rs.getString(5)+"\t"+rs.getString(6));
		//System.out.print(rs.getString(5));
		//System.out.println(rs.getString(6));
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("UserName"));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("password"));
			driver.findElement(By.id("Login")).click();
		}
		
		
	}

}
