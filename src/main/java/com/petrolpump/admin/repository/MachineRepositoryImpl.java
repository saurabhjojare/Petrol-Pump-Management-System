
package com.petrolpump.admin.repository;
import java.util.ArrayList;
import java.util.List;
import com.petrolpump.admin.config.DBConfig;
import com.petrolpump.admin.model.MachineModel;
import com.petrolpump.admin.repository.MachineRepository;

public class MachineRepositoryImpl extends DBConfig implements MachineRepository {

    List<Object[]> list;
    int mid;

    public int getMachineIdAutomatic() {
        try {
            stmt = conn.prepareStatement("SELECT MAX(mid) FROM machineinfo");
            rs = stmt.executeQuery();
            if (rs.next()) {
                mid = rs.getInt(1);
            }
            ++mid;
            return mid;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    @Override
    public boolean isAddNewMachine(MachineModel model, String typeid[], String capacity[]) {
        try {
            mid = this.getMachineIdAutomatic();
            String machineCode = model.getMachineCode();
            stmt = conn.prepareStatement("INSERT INTO machineinfo (mid, machine_code) VALUES (?, ?)");
            stmt.setInt(1, mid);
            stmt.setString(2, machineCode);
            int value = stmt.executeUpdate();
            if (value > 0) {
                for (int i = 0; i < capacity.length; i++) {
                    if (capacity[i] != null) {
                        stmt = conn.prepareStatement("INSERT INTO machinetypejoin VALUES (?, ?, ?)");
                        stmt.setInt(1, mid);
                        stmt.setInt(2, Integer.parseInt(typeid[i]));
                        stmt.setInt(3, Integer.parseInt(capacity[i]));
                        value = stmt.executeUpdate();
                    }
                }
                return value > 0;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error is" + ex);
            return false;
        }
    }

    @Override
    public List<Object[]> getAllMachine() {
        try {
            list = new ArrayList<Object[]>();
            stmt = conn.prepareStatement("select m.machine_code, f.type,  mtj.capacity, m.mid from machineinfo m  left join machinetypejoin mtj on m.mid =  mtj.mid left join fueltype f on f.typeid = mtj.typeid;");
            rs = stmt.executeQuery();
            while (rs.next()) {
            	Object obj[] = new Object[] {rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)};
                list.add(obj);
            }
            return list.isEmpty() ? null : list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public boolean isDeleteMachineById(int mid) {
        try {
            stmt = conn.prepareStatement("DELETE FROM machineinfo WHERE mid = ?");
            stmt.setInt(1, mid);
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public boolean isUpdateMachine(MachineModel model) {
        try {
            stmt = conn.prepareStatement("UPDATE machineinfo SET machine_code = ? WHERE mid = ?");
            stmt.setString(1, model.getMachineCode());
            stmt.setInt(2, model.getId());
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
}
