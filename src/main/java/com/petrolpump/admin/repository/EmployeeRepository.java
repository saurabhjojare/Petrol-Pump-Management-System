package com.petrolpump.admin.repository;

import com.petrolpump.admin.model.EmployeeModel;
import java.util.*;

public interface EmployeeRepository {
	public boolean isAddNewEmployee(EmployeeModel model);
	public List<EmployeeModel> getAllEmployees();
	public boolean allocateMachine(int eid, int mid, String ...x);
	
}
