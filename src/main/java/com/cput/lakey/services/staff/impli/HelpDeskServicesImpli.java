package com.cput.lakey.services.staff.impli;

import com.cput.lakey.domain.staff.HelpDesk;
import com.cput.lakey.repositories.staff.HelpDeskRepository;
import com.cput.lakey.services.staff.HelpDeskServices;

import java.util.List;
import java.util.Optional;

public class HelpDeskServicesImpli implements HelpDeskServices {

    private HelpDeskRepository staffRepository;
    private static HelpDeskServices staffService = null;

    private HelpDeskServicesImpli() {
    }

    public HelpDeskServices getsHelpDeskService() {
        if (staffService == null) staffService = new HelpDeskServicesImpli();
        return staffService;
    }

    @Override
    public HelpDesk create(HelpDesk d) {
        return this.staffRepository.save(d);
    }

    @Override
    public HelpDesk read(Integer staffId) {
        Optional<HelpDesk> optGender = this.staffRepository.findById(staffId);
        return optGender.orElse(null);    }

    @Override
    public HelpDesk update(HelpDesk helpDesk) {
        return this.staffRepository.save(helpDesk);
    }

    @Override
    public void delete(Integer staffId) {
        this.staffRepository.deleteById(staffId);
    }

    @Override
    public List<HelpDesk> getAll() { return this.staffRepository.findAll();
    }
}
