package com.petrolpump.admin.service;

import java.util.List;

import com.petrolpump.admin.model.MachineModel;
import com.petrolpump.admin.repository.MachineRepository;
import com.petrolpump.admin.repository.MachineRepositoryImpl;

public class MachineServiceImpl implements MachineService {
	
	MachineRepository m = new MachineRepositoryImpl();
	public boolean isAddNewMachine(MachineModel model) {
		return m.isAddNewMachine(model);
	}
	@Override
	public List<MachineModel> getAllMachines() {
		return m.getAllMachine();
	}

}
