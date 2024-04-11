package com.petrolpump.admin.repository;

import com.petrolpump.admin.config.DBConfig;
import com.petrolpump.admin.model.MachineModel;
import com.petrolpump.admin.repository.MachineRepository;
import com.petrolpump.admin.repository.MachineRepositoryImpl;

public class MachineRepositoryImpl extends DBConfig implements MachineRepository{
	

	@Override
	public boolean isAddNewMachine(MachineModel model) {
		try {
			stmt = conn.prepareStatement("insert into machineinfo values ('0',?)");
			stmt.setString(1, model.getMachineCode());
			int value = stmt.executeUpdate();
			return value>0?true:false;
		} catch(Exception ex) {
			System.out.println("error is"+ex);
			return false;
		}
	}

	
}
