package com.petrolpump.admin.service;

import java.util.List;

import com.petrolpump.admin.model.MachineModel;
import com.petrolpump.admin.repository.MachineRepository;
import com.petrolpump.admin.repository.MachineRepositoryImpl;

public class MachineServiceImpl implements MachineService {

	MachineRepository m = new MachineRepositoryImpl();

	public boolean isAddNewMachine(MachineModel model, String typeid[], String capacity[]) {
		return m.isAddNewMachine(model, typeid, capacity);
	}

	@Override
	public List<Object[]> getAllMachines() {
		return m.getAllMachine();
	}

	@Override
	public boolean isDeleteMachineById(int mid) {
		return m.isDeleteMachineById(mid);
	}

	@Override
	public boolean isUpdateMachine(MachineModel model) {
		return m.isUpdateMachine(model);
	}

}
