package SCRUMProject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Members {
	private JDBCConnections jdbcConn = new JDBCConnections();
	Scanner scan = new Scanner(System.in);
	public void showAll(String memberType) 
	{
		if(memberType.toLowerCase() == "employees")
		{
			System.out.println("Here is a list of all of the employees:\n");
			this.getEmployees();
		}
		else if(memberType.toLowerCase() == "stakeholders")
		{
			System.out.println("Here is a list of all the stakeholders:\n");
			this.getStakeholders();
		}		
	}
	
	public void getEmployees() 
	{
		jdbcConn.setStatment(jdbcConn.getConnection());
		ResultSet results;
		try {
			results = jdbcConn.getStatment().executeQuery("select EmployeeID,concat(lName,', ',fName) AS 'Last, First',Role,TeamName from Members natural join Teams natural join Roles;");
		
		ResultSetMetaData rsmd = results.getMetaData();
		int cols = rsmd.getColumnCount();
		
		for(int i = 1; i <= cols; i++)
		{
			System.out.print(rsmd.getColumnLabel(i)+"\t");
		}
		
		System.out.println("\n-----------------------------------------------------------");
		
		while(results.next())
		{
			int employeeID = results.getInt(1);
			String employeeName = results.getString(2);
			String Role = results.getString(3);
			String TeamName = results.getString(4);
	
			
			System.out.format("%8d %16s %13s %4s\n",employeeID,employeeName,Role,TeamName);
		}
		
		System.out.println("\n");
		results.close();
		rsmd = null;
		jdbcConn.getStatment().close();
		jdbcConn.getConnection().close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getStakeholders() 
	{
		//sql select * from stakeholders 
	}

	public void showAssignedEmployees() 
	{
		//Need to select a particular project by id
		//sql select * from employees where proj id = ?
	}

	public void showScrumTeam() 
	{
		//Need to be able to select a particular team by id
		//sql select * from employees where team id= ?
	}

	public void addEmployee() 
	{
		jdbcConn.setStatment(jdbcConn.getConnection());
		ResultSet results;
		System.out.println("Enter members first name:");
		String fName = scan.nextLine();
		System.out.println("Enter members last name:");
		String lName = scan.nextLine();
		System.out.println("Enter role option");
		System.out.println("1. Employeee");
		System.out.println("2. Owner");
		System.out.println("3. Stakeholder");
		int role = scan.nextInt();
		if(role == 1){
			try {
				results = jdbcConn.getStatment().executeQuery("select TeamName, TeamID from Teams ;");
				ResultSetMetaData rsmd = results.getMetaData();
				int cols = rsmd.getColumnCount();
				
				for(int i = 1; i <= cols; i++)
				{
					System.out.print(rsmd.getColumnLabel(i)+"\t");
				}
				System.out.println("\n");
				while(results.next())
				{
					String TeamName = results.getString(1);
					int TeamID = results.getInt(2);
					System.out.format("%8s %13d\n",TeamName, TeamID);
				}
				System.out.println("\n");
				results.close();
				rsmd = null;
				jdbcConn.getStatment().close();
				jdbcConn.getConnection().close();
				System.out.println("\n-----------------------------------------------------------");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jdbcConn.setStatment(jdbcConn.getConnection());
			System.out.println("Enter team ID");
			int teamID = scan.nextInt();
			try {
				jdbcConn.getStatment().executeUpdate("INSERT INTO Members ("
						+ "FName,LName,RoleID,TeamID) VALUES ('"+fName+"','"+lName+"'"
								+ ",'"+role+"','"+teamID+"')");
				System.out.println("Employee added");
				jdbcConn.getStatment().close();
				jdbcConn.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if(role == 2){
			try {
				results = jdbcConn.getStatment().executeQuery("select TeamName, TeamID from Teams ;");
				ResultSetMetaData rsmd = results.getMetaData();
				int cols = rsmd.getColumnCount();
				
				for(int i = 1; i <= cols; i++)
				{
					System.out.print(rsmd.getColumnLabel(i)+"\t");
				}
				System.out.println("\n");
				while(results.next())
				{
					String TeamName = results.getString(1);
					int TeamID = results.getInt(2);
					System.out.format("%8s %13d\n",TeamName, TeamID);
				}
				System.out.println("\n");
				results.close();
				rsmd = null;
				jdbcConn.getStatment().close();
				jdbcConn.getConnection().close();
				System.out.println("\n-----------------------------------------------------------");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jdbcConn.setStatment(jdbcConn.getConnection());
			System.out.println("Enter team ID");
			int teamID = scan.nextInt();
			try {
				jdbcConn.getStatment().executeUpdate("INSERT INTO Members ("
						+ "FName,LName,RoleID,TeamID) VALUES ('"+fName+"','"+lName+"'"
								+ ",'"+role+"','"+teamID+"')");
				System.out.println("Employee added");
				jdbcConn.getStatment().close();
				jdbcConn.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(role == 3){
			try {
				results = jdbcConn.getStatment().executeQuery("select TeamName, TeamID from Teams ;");
				ResultSetMetaData rsmd = results.getMetaData();
				int cols = rsmd.getColumnCount();
				
				for(int i = 1; i <= cols; i++)
				{
					System.out.print(rsmd.getColumnLabel(i)+"\t");
				}
				System.out.println("\n");
				while(results.next())
				{
					String TeamName = results.getString(1);
					int TeamID = results.getInt(2);
					System.out.format("%8s %13d\n",TeamName, TeamID);
				}
				System.out.println("\n");
				results.close();
				rsmd = null;
				jdbcConn.getStatment().close();
				jdbcConn.getConnection().close();
				System.out.println("\n-----------------------------------------------------------");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jdbcConn.setStatment(jdbcConn.getConnection());
			System.out.println("Enter team ID");
			int teamID = scan.nextInt();
			try {
				jdbcConn.getStatment().executeUpdate("INSERT INTO Members ("
						+ "FName,LName,RoleID,TeamID) VALUES ('"+fName+"','"+lName+"'"
								+ ",'"+role+"','"+teamID+"')");
				System.out.println("Employee added");
				jdbcConn.getStatment().close();
				jdbcConn.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void modifyEmployee() 
	{
		//Need to be able to select a particular employee by id
		//sql update employee set () values() where employee id = ?
	}

	public void addStakeholder() 
	{
		//sql insert into stakeholders
	}

	public void modifyStakeholder() 
	{
		//Need to be able to select a particular stakeholder by id
		//sql update stakeholders set () values() where stakeholder id = ?
	}
}
