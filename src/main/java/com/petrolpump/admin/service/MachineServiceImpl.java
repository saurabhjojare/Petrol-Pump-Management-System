package com.petrolpump.admin.service;

import com.petrolpump.admin.model.MachineModel;
import com.petrolpump.admin.repository.MachineRepository;
import com.petrolpump.admin.repository.MachineRepositoryImpl;

public class MachineServiceImpl implements MachineService {
	
	MachineRepository m = new MachineRepositoryImpl();
	public boolean isAddNewMachine(MachineModel model) {
		return m.isAddNewMachine(model);
	}

}
