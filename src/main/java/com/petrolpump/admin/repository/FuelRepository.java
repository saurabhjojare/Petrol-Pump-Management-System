package com.petrolpump.admin.repository;

import java.util.List;

import com.petrolpump.admin.model.FuelTypeModel;

public interface FuelRepository {
	public boolean isAddFuelType(FuelTypeModel model);
	public List<FuelTypeModel> getAllFuelTypes();
}
