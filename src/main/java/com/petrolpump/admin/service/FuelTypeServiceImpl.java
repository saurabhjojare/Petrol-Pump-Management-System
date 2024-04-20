package com.petrolpump.admin.service;

import java.util.List;

import com.petrolpump.admin.config.DBConfig;
import com.petrolpump.admin.model.FuelTypeModel;
import com.petrolpump.admin.repository.FuelRepository;
import com.petrolpump.admin.repository.FuelRepositoryImpl;

public class FuelTypeServiceImpl implements FuelService {
	FuelRepository fuelRepo = new FuelRepositoryImpl();
	@Override
	public boolean isAddFuelModel(FuelTypeModel model) {
		return fuelRepo.isAddFuelType(model);
	}
	@Override
	public List<FuelTypeModel> getAllFuelTypes() {
		// TODO Auto-generated method stub
		return fuelRepo.getAllFuelTypes();
	}
	
}
