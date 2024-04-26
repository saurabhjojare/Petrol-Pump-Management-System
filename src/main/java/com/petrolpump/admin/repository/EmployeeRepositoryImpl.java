package com.petrolpump.admin.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.petrolpump.admin.config.DBConfig;
import com.petrolpump.admin.model.EmployeeModel;

public class EmployeeRepositoryImpl extends DBConfig implements EmployeeRepository {
	List<EmployeeModel> list = new ArrayList<EmployeeModel>();
	@Override
	public boolean isAddNewEmployee(EmployeeModel model) {
		
		try {		
			stmt = conn.prepareStatement("insert into employee values ('0',?,?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4, model.getAddress());
			stmt.setInt(5, model.getSal());
			
			int value = stmt.executeUpdate();
			return value>0?true:false;
		} catch(Exception ex) {
			System.out.println();
			return false;
		}
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
	    try {
	        stmt = conn.prepareStatement("select * from employee");
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            EmployeeModel emp = new EmployeeModel();
	            emp.setId(rs.getInt("eid"));
	            emp.setName(rs.getString("name"));
	            emp.setEmail(rs.getString("email"));
	            emp.setContact(rs.getString("contact"));
	            emp.setAddress(rs.getString("address"));
	            emp.setSal(rs.getInt("salary"));
	            list.add(emp);
	        }
	        return list.size() > 0 ? list : null;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return null;
	    } finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public boolean allocateMachine(int eid, int mid, String... x) {
		try {
			stmt = conn.prepareStatement("insert into employeemachinejoin values (?,?,?,?,?)");
			stmt.setInt(1, eid);
			stmt.setInt(2, mid);
			stmt.setString(3, x[0]);
			stmt.setString(4, x[1]);
			String split[]=x[2].split("-");
			LocalDate date = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
			stmt.setDate(5, java.sql.Date.valueOf(date));
			int value = stmt.executeUpdate();
			return value> 0 ? true : false;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
