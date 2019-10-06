package com.cput.lakey.services.classes.Impli;

import com.cput.lakey.domain.classes.Classs;
import com.cput.lakey.repositories.classes.ClassRepository;
import com.cput.lakey.services.classes.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpli implements ClassService {

    private ClassRepository classRepository;
    private static ClassService classService = null;

    private ClassServiceImpli() {
    }

    public ClassService getClassService() {
        if (classService == null) classService = new ClassServiceImpli();
        return classService;
    }

    @Override
    public Classs create(Classs d) {
        return this.classRepository.save(d);
    }

    @Override
    public Classs read(Integer genderId) {
        Optional<Classs> optGender = this.classRepository.findById(genderId);
        return optGender.orElse(null);
    }

    @Override
    public Classs update(Classs gender) {
        return this.classRepository.save(gender);
    }

    @Override
    public void delete(Integer genderId) {
        this.classRepository.deleteById(genderId);
    }

    @Override
    public List<Classs> getAll() {
        return this.classRepository.findAll();
    }
}

