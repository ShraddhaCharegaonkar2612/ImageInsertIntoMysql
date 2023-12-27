package example1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class favActorImg {


	public static void main(String[] args)
	{

		String url ="jdbc:mysql://localhost:3306/db";
		String username="root";
		String password="Root";
		String filepath="d:/shraddha/rohitSaraf.webp";
		
			try{
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql ="INSERT INTO withImage2(name,img)values(?,?)";
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, "Rohit_Saraf");
			
			InputStream inputStream = new FileInputStream(new File(filepath));
			statement.setBlob(2, inputStream);
			int row = statement.executeUpdate();
			if(row>0)
			{
				System.out.println("Idol was interested with photo image");
			}
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}


}