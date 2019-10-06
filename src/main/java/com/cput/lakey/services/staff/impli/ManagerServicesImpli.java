package com.cput.lakey.services.staff.impli;

import com.cput.lakey.domain.staff.Manager;
import com.cput.lakey.repositories.staff.ManagerRepository;
import com.cput.lakey.services.staff.ManagerServices;

import java.util.List;
import java.util.Optional;

public class ManagerServicesImpli implements ManagerServices {

    private ManagerRepository staffRepository;
    private static ManagerServices staffService = null;

    private ManagerServicesImpli() {

    }

    public ManagerServices getsManagerService() {
        if (staffService == null) staffService = new ManagerServicesImpli();
        return staffService;
    }

    @Override
    public Manager create(Manager d) {
        return this.staffRepository.save(d);
    }

    @Override
    public Manager read(Integer staffId) {
        Optional<Manager> optGender = this.staffRepository.findById(staffId);
        return optGender.orElse(null);    }

    @Override
    public Manager update(Manager manager) {
        return this.staffRepository.save(manager);
    }

    @Override
    public void delete(Integer staffId) {
        this.staffRepository.deleteById(staffId);
    }

    @Override
    public List<Manager> getAll() { return this.staffRepository.findAll();
    }
}
