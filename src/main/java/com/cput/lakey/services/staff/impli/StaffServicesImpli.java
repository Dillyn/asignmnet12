package com.cput.lakey.services.staff.impli;

import com.cput.lakey.domain.staff.Staff;
import com.cput.lakey.repositories.staff.StaffRepository;
import com.cput.lakey.services.staff.StaffServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServicesImpli implements StaffServices {

    private StaffRepository staffRepository;
    private static StaffServices staffService = null;

    private StaffServicesImpli() {

    }

    public StaffServices getStaffService() {
        if (staffService == null) staffService = new StaffServicesImpli();
        return staffService;
    }

    @Override
    public Staff create(Staff d) {
        return this.staffRepository.save(d);
    }

    @Override
    public Staff read(Integer staffId) {
        Optional<Staff> optGender = this.staffRepository.findById(staffId);
        return optGender.orElse(null);    }

    @Override
    public Staff update(Staff staff) {
        return this.staffRepository.save(staff);
    }

    @Override
    public void delete(Integer staffId) {
        this.staffRepository.deleteById(staffId);
    }

    @Override
    public List<Staff> getAll() { return this.staffRepository.findAll();
    }
}
