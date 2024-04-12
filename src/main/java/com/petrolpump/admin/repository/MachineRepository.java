package com.petrolpump.admin.repository;

import java.util.List;

import com.petrolpump.admin.model.MachineModel;

public interface MachineRepository {
	
	public boolean isAddNewMachine(MachineModel model);
	public List<MachineModel> getAllMachine();

}
