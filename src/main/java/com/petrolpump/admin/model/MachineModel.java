package com.petrolpump.admin.model;

public class MachineModel {
    private int id;
    private String machineCode;

    // Getter method for retrieving the ID of the machine
    public int getId() {
        return id;
    }

    // Setter method for setting the ID of the machine
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for retrieving the machine code
    public String getMachineCode() {
        return machineCode;
    }

    // Setter method for setting the machine code
    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }
}
