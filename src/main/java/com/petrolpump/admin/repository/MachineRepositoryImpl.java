package com.petrolpump.admin.repository;

import java.util.*;
import java.util.List;

import com.petrolpump.admin.config.DBConfig;
import com.petrolpump.admin.model.MachineModel;
import com.petrolpump.admin.repository.MachineRepository;
import com.petrolpump.admin.repository.MachineRepositoryImpl;

public class MachineRepositoryImpl extends DBConfig implements MachineRepository {

	List<MachineModel> list;

	@Override
	public boolean isAddNewMachine(MachineModel model) {
		try {
			stmt = conn.prepareStatement("insert into machineinfo values ('0',?)");
			stmt.setString(1, model.getMachineCode());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("error is" + ex);
			return false;
		}
	}

	@Override
	public List<MachineModel> getAllMachine() {
		try {
			list = new ArrayList<MachineModel>();
			stmt=conn.prepareStatement("select * from machineinfo");
			rs = stmt.executeQuery();
			while (rs.next()) {
				MachineModel model = new MachineModel();
				model.setId(rs.getInt(1));
				model.setMachineCode(rs.getString(2));
				list.add(model);
			}
			return list.size()>0?list:null;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
}
