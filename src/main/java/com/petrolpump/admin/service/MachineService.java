package com.petrolpump.admin.service;

import java.util.*;

import com.petrolpump.admin.model.*;

public interface MachineService {

	public boolean isAddNewMachine(MachineModel model, String typeid[], String capacity[]);

	public List<Object[]> getAllMachines();

	public boolean isDeleteMachineById(int mid);

	public boolean isUpdateMachine(MachineModel model);
}
