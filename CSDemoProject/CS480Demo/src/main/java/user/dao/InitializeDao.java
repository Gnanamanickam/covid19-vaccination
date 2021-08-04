package user.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class InitializeDao {
	
	
	/**
	 * get the search result with username
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void initDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			Statement statement;
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_vaccination?"
				              + "user=root&password=mysqlroot");
			statement = connect.createStatement();
		      // Result set get the result of the SQL query
		    statement.executeUpdate("DROP TABLE IF EXISTS vaccine");
		    
		    
		    String sqlstmt = "create table vaccine(\r\n"
		    		+ "id int auto_increment,\r\n"
		    		+ "vaccine_name varchar(100) not null,\r\n"
		    		+ "doses int not null check (doses in (1,2,3)),\r\n"
		    		+ "type varchar(100),\r\n"
		    		+ "primary key(id)\r\n"
		    		+ ");\r\n"
		    		+ "\r\n"
		    		+ "create table user(\r\n"
		    		+ "ssn int,\r\n"
		    		+ "name char(100) not null,\r\n"
		    		+ "phone_number int not null,\r\n"
		    		+ "email varchar(100) not null,\r\n"
		    		+ "`password` char(100) not null,\r\n"
		    		+ "county char(100),\r\n"
		    		+ "state char(100),\r\n"
		    		+ "primary key(ssn)\r\n"
		    		+ ");\r\n"
		    		+ "\r\n"
		    		+ "create table vaccination_center(\r\n"
		    		+ "id int,\r\n"
		    		+ "name char(100),\r\n"
		    		+ "county char(100),\r\n"
		    		+ "state char(100),\r\n"
		    		+ "vaccinated int,\r\n"
		    		+ "primary key(id)\r\n"
		    		+ ");\r\n"
		    		+ "\r\n"
		    		+ "create table receiver(\r\n"
		    		+ "id varchar(5),\r\n"
		    		+ "user_id int,\r\n"
		    		+ "vaccine_id int,\r\n"
		    		+ "center_id int,\r\n"
		    		+ "primary key(id),\r\n"
		    		+ "foreign key(user_id) references user(ssn) on delete cascade on update cascade,\r\n"
		    		+ "foreign key(vaccine_id) references vaccine(id) on delete cascade on update cascade,\r\n"
		    		+ "foreign key(center_id) references vaccination_center(id) on delete cascade on update cascade\r\n"
		    		+ ");\r\n"
		    		+ "\r\n"
		    		+ "create table side_effects (\r\n"
		    		+ "`index` int auto_increment,\r\n"
		    		+ "user_id int,\r\n"
		    		+ "vaccine_id int,\r\n"
		    		+ "side_effect varchar(1000),\r\n"
		    		+ "duration int,\r\n"
		    		+ "primary key(`index`),\r\n"
		    		+ "foreign key(user_id) references user(ssn) on delete cascade on update cascade,\r\n"
		    		+ "foreign key(vaccine_id) references vaccine(id) on delete cascade on update cascade\r\n"
		    		+ ")\r\n"
		    		+ "\r\n"
		    		+ "create table stock(\r\n"
		    		+ "stock_id varchar(5),\r\n"
		    		+ "vaccine_id int,\r\n"
		    		+ "center_id int,\r\n"
		    		+ "stock bigint,\r\n"
		    		+ "primary key(stock_id),\r\n"
		    		+ "foreign key(vaccine_id) references vaccine(id) on delete cascade on update cascade,\r\n"
		    		+ "foreign key(center_id) references vaccination_center(id) on delete cascade on update cascade\r\n"
		    		+ ");\r\n"
		    		+ "\r\n"
		    		+ "insert into `user` values (22312,\"user 1\",3127772134,\"user1@gmail.com\",\"password1\",\"cook\",\"Illinois\");\r\n"
		    		+ "insert into `user` values (22313,\"user 2\",3127772135,\"user2@gmail.com\",\"password2\",\"cook\",\"Illinois\");\r\n"
		    		+ "insert into `user` values (22314,\"user 3\",3127772136,\"user3@gmail.com\",\"password3\",\"cook\",\"Illinois\");\r\n"
		    		+ "\r\n"
		    		+ "alter table vaccine auto_increment=1000;\r\n"
		    		+ "insert into vaccine (vaccine_name,doses,`type`) values (\"Pfizer\",2,\"type1\");\r\n"
		    		+ "insert into vaccine (vaccine_name,doses,`type`) values (\"Pfizer\",2,\"type1\");\r\n"
		    		+ "insert into vaccine (vaccine_name,doses,`type`) values (\"Pfizer\",2,\"type2\");\r\n"
		    		+ "\r\n"
		    		+ "insert into vaccination_center values (101,\"center1\",\"cook\",\"Illinois\",5000);\r\n"
		    		+ "insert into vaccination_center values (102,\"center2\",\"cook\",\"Illinois\",5000);\r\n"
		    		+ "insert into vaccination_center values (103,\"center3\",\"cook\",\"Illinois\",5000);\r\n"
		    		+ "\r\n"
		    		+ "insert into side_effects(user_id,vaccine_id,side_effect,duration) values(22312,1001,\"Body pain\",24);\r\n"
		    		+ "insert into side_effects(user_id,vaccine_id,side_effect,duration) values(22312,1001,\"Headache\",24);\r\n"
		    		+ "insert into side_effects(user_id,vaccine_id,side_effect,duration) values(22313,1002,\"Body pain\",24);\r\n"
		    		+ "\r\n"
		    		+ "insert into receiver values(\"rec11\",22312,1001,103);\r\n"
		    		+ "insert into receiver values(\"rec12\",22313,1002,101);\r\n"
		    		+ "insert into receiver values(\"rec13\",22312,1001,103);\r\n"
		    		+ "\r\n"
		    		+ "insert into stock values(\"sto11\",1002,103,600000);\r\n"
		    		+ "insert into stock values(\"sto12\",1002,101,600000);\r\n"
		    		+ "insert into stock values(\"sto13\",1001,102,600000); ";
			
				
			statement.executeUpdate(sqlstmt);
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
	
	
	
	
