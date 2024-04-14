package com.petrolpump.admin.service;

import java.util.*;

import com.petrolpump.admin.model.*;

public interface MachineService {

	public boolean isAddNewMachine(MachineModel model);

	public List<MachineModel> getAllMachines();

	public boolean isDeleteMachineById(int mid);

	public boolean isUpdateMachine(MachineModel model);
}
