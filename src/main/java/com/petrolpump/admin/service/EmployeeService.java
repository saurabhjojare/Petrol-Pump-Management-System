package com.petrolpump.admin.service;

import java.util.List;

import com.petrolpump.admin.model.EmployeeModel;

public interface EmployeeService {
	public boolean isAddNewEmployee(EmployeeModel model);
	public List<EmployeeModel> getAllEmployees();
	public boolean allocateMachine(int eid, int mid, String ...x);

}
