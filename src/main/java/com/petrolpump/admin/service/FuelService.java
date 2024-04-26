package com.petrolpump.admin.service;

import java.util.List;

import com.petrolpump.admin.model.FuelTypeModel;

public interface FuelService {
	public boolean isAddFuelModel(FuelTypeModel model);
	public List<FuelTypeModel> getAllFuelTypes();
}
