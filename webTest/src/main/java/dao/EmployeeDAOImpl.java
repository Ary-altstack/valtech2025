package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Collectors;

import jakarta.servlet.ServletContext;

public class EmployeeDAOImpl implements EmployeeDAO {
	
//		static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//	  }
//	}
	
	ServletContext sc ;
	
	

	public EmployeeDAOImpl(ServletContext sc) {
		this.sc = sc;
		
	}

	private Connection getConnection(ServletContext sc) throws SQLException {
		String url = (String)sc.getAttribute("url");
		String user = (String)sc.getAttribute("user");
		String password = (String)sc.getAttribute("password");
		
		return DriverManager.getConnection
				(url,user,password);
		}

	@Override
	public void save(Employee e) {
	try(Connection conn = getConnection(this.sc)){
		PreparedStatement ps = conn.prepareStatement
				("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)");
		setValuesToPreparedStatement(e, ps);
		
		int rowsAffected = ps.executeUpdate();
		System.out.println("Rows Inserted = " + rowsAffected);
		
	
	} catch (Exception ex) {
		throw new RuntimeException(ex);
		}
	}

	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2,e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExp());
		ps.setInt(6, e.getLevel());
		ps.setLong(7, e.getId());
	}

	@Override
	public void update(Employee e) {
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("UPDATE EMPLOYEE SET NAME =? ,AGE =? ,GENDER =? ,SALARY =? ,EXPERIENCE =? ,LEVEL =? WHERE ID = ?");
					setValuesToPreparedStatement(e, ps);
					
					int rowsAffected = ps.executeUpdate();
					System.out.println("Rows Updated = "+rowsAffected);
					} catch(Exception ex) {
					throw new RuntimeException(ex);
		}
		
	}

	@Override
	public void delete(int id) { 
		
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement 
					("DELETE FROM EMPLOYEE WHERE ID =?");
				ps.setInt(1, id);
				int rows = ps.executeUpdate();
				System.out.println("Rows Deleted =" +rows);
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
			
	}

	@Override
	public Employee get(int id) {
		
	try (Connection conn = getConnection(this.sc)){
		PreparedStatement ps = conn.prepareStatement
				("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,LEVEL,GENDER FROM EMPLOYEE WHERE ID =?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			// if this next returns true then we have another row. next return false, we are at end the resultset
			Employee e = populateEmployee(rs);
			return e;
		} else {
			new RuntimeException("No Employee with Id "+id+" Found.");
		}
		
	} catch(Exception ex) {
		throw new RuntimeException(ex);
	}
		
		return null;
	}
	
	private Employee populateEmployee (ResultSet rs) throws SQLException {
		return Employee.builder().id(rs.getLong(1)).name(rs.getString(2)).age(rs.getInt(3))
				.gender(rs.getString(7)).salary(rs.getFloat(4)).exp(rs.getInt(5)).level(rs.getInt(6)).build();
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		try(Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,LEVEL,GENDER FROM EMPLOYEE");
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
				
			}
			
			
		}catch(Exception ex) {
			throw new RuntimeException(ex);
			
		}
		
		
		return emps;
	}
	
//	@Override
//	public List<Employee> sortedEmployees(){
//		EmployeeDAO empl = new EmployeeDAOImpl();
//		return empl.getAll().stream()
//        .sorted(Comparator.comparingLong(Employee::getId))  
//        .collect(Collectors.toList());
//	}
	
	@Override
	public List<Employee> sortedEmployeesById(){
//		EmployeeDAO empl = new EmployeeDAOImpl();
// 		.sorted(Comparator.comparingLong(Employee.getId)).collect(Collectors.toList)
		return getAll().stream()
        .sorted(Comparator.comparingLong(Employee::getId))  
        .collect(Collectors.toList());
	}
	
	
	// Employyees by id (Desc)
	public List<Employee> sortedEmployeesByIdDesc(){
//		EmployeeDAO empl = new EmployeeDAOImpl();
		return getAll().stream()
        .sorted(Comparator.comparingLong(Employee::getId).reversed())  
        .collect(Collectors.toList());
	}
	
	public List<Employee> sortedEmployeesByName(){
		return getAll().stream()
				.sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
	}
	
	// Employees by name(desc)
	
	public List<Employee> sortedEmployeesByNameDesc(){
		return getAll().stream()
				.sorted(Comparator.comparing(Employee::getName).reversed())
				.collect(Collectors.toList());
	}
	
	
	
	public List<Employee> sortedEmployeesByAge(){
		return getAll().stream()
				.sorted(Comparator.comparingInt(Employee::getAge))
				.collect(Collectors.toList());
	}
	
	// Employees by age(desc)

	public List<Employee> sortedEmployeesByAgeDesc(){
		return getAll().stream()
				.sorted(Comparator.comparingInt(Employee::getAge).reversed())
				.collect(Collectors.toList());
	}
	
	
	
	public List<Employee> sortedEmployeesByGender(){
		return getAll().stream()
				.sorted(Comparator.comparing(Employee::getGender))
				.collect(Collectors.toList());
		
	}
	
	// Employees by Gender(desc)
	
	public List<Employee> sortedEmployeesByGenderDesc(){
		return getAll().stream()
				.sorted(Comparator.comparing(Employee::getGender).reversed())
				.collect(Collectors.toList());
		
	}
	
	
	public List<Employee> sortedEmployeesBySalary(){	
		return getAll().stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary))
				.collect(Collectors.toList());
	
	}
	
	
	// Employees by Salary(desc)

	public List<Employee> sortedEmployeesBySalaryDesc(){	
		return getAll().stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.collect(Collectors.toList());
	
	}
	
	public List<Employee> sortedEmployeesByExperience(){
		return getAll().stream()
				.sorted(Comparator.comparingInt(Employee::getExp))
				.collect(Collectors.toList());

	}
	
	
	// Employees by exppe(desc)

	public List<Employee> sortedEmployeesByExperienceDesc(){
		return getAll().stream()
				.sorted(Comparator.comparingInt(Employee::getExp).reversed())
				.collect(Collectors.toList());

	}
	
	public List<Employee> sortedEmployeesByLevel(){
		return getAll().stream()
				.sorted(Comparator.comparingInt(Employee::getLevel))
				.collect(Collectors.toList());
	
		
	}
	
	public List<Employee> sortedEmployeesByLevelDesc(){
		return getAll().stream()
				.sorted(Comparator.comparingInt(Employee::getLevel).reversed())
				.collect(Collectors.toList());
	
	}

	@Override
	public List<Employee> sortedEmployeesByDept_id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> sortedEmployeesByDept_idDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> searchEmployeesByName(String name){
		return getAll().stream()
				.filter(employee->employee.getName().contains(name))
				.collect(Collectors.toList());
	}
	////////// By ID //////////////
	public List<Employee> searchEmployeesById(Long id){
		return getAll().stream()
				.filter(employee->employee.getId()==id)
				.collect(Collectors.toList());
	}
	////////////// By Age ///////
	public List<Employee> searchEmployeesByAge(int age){
		return getAll().stream().filter(employee->employee.getAge()==age).collect(Collectors.toList());
	}
	///////////////By Salary/////////
	public List<Employee> searchEmployeesBySalary(Double sal){
		return getAll().stream().filter(employee->employee.getSalary()==sal).collect(Collectors.toList());
	}
	
	////////////////By Level /////////////
	public List<Employee> searchEmployeesByLevel(int level){
		return getAll().stream()
				.filter(employee->employee.getLevel()== level)
				.collect(Collectors.toList());
	}
	
	
	////////////////// By exp //////////
	
	public List<Employee> searchEmployeesByExperience(int exp){
		return getAll().stream()
				.filter(employee->employee.getExp()== exp)
				.collect(Collectors.toList());
	}

	
	

}
