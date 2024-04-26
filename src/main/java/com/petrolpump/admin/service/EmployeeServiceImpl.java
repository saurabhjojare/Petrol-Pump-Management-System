package com.petrolpump.admin.service;

import java.util.List;

import com.petrolpump.admin.model.EmployeeModel;
import com.petrolpump.admin.repository.EmployeeRepository;
import com.petrolpump.admin.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeRepository empRepo = new EmployeeRepositoryImpl();

	@Override
	public boolean isAddNewEmployee(EmployeeModel model) {
		return empRepo.isAddNewEmployee(model);
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		return empRepo.getAllEmployees();
	}

	@Override
	public boolean allocateMachine(int eid, int mid, String... x) {
		return empRepo.allocateMachine(eid, mid, x);
	}

}
 
