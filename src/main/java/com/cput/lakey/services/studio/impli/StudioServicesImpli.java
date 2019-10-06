package com.cput.lakey.services.studio.impli;

import com.cput.lakey.domain.studio.Studio;
import com.cput.lakey.repositories.studio.StudioRepository;
import com.cput.lakey.services.studio.StudioServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioServicesImpli implements StudioServices {

    private StudioRepository studioRepository;
    private static StudioServices StudioService = null;

    private StudioServicesImpli(){
    }

    public StudioServices getsStudioService() {
        if (StudioService == null) StudioService = new StudioServicesImpli();
        return StudioService;
    }

    @Override
    public Studio create(Studio d) {
        return this.studioRepository.save(d);
    }

    @Override
    public Studio read(Integer studioId) {
        Optional<Studio> optGender = this.studioRepository.findById(studioId);
        return optGender.orElse(null);    }

    @Override
    public Studio update(Studio studio) {
        return this.studioRepository.save(studio);
    }

    @Override
    public void delete(Integer studioId) {
        this.studioRepository.deleteById(studioId);
    }

    @Override
    public List<Studio> getAll() { return this.studioRepository.findAll();
    }
}
