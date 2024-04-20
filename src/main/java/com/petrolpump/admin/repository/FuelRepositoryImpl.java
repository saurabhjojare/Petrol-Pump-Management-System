package com.petrolpump.admin.repository;

import java.util.ArrayList;
import java.util.List;

import com.petrolpump.admin.config.DBConfig;
import com.petrolpump.admin.model.FuelTypeModel;

public class FuelRepositoryImpl extends DBConfig implements FuelRepository {
	List<FuelTypeModel> list = new ArrayList<FuelTypeModel>();
	@Override
	public boolean isAddFuelType(FuelTypeModel model) {
		try {
			stmt = conn.prepareStatement("insert into fueltype values('0',?)");
			stmt.setString(1, model.getName());
			int value= stmt.executeUpdate();
			return value>0?true:false;
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public List<FuelTypeModel> getAllFuelTypes() {
		try {
			stmt = conn.prepareStatement("select * from fueltype");
			rs = stmt.executeQuery();
			while(rs.next()) {
				FuelTypeModel model = new FuelTypeModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				list.add(model);
			}
			return list.size()>0?list:null;
		} catch(Exception e) {
			return null;
		}
	}

}
