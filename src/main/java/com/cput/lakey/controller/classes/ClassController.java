package com.cput.lakey.controller.classes;

import com.cput.lakey.domain.classes.Classs;
import com.cput.lakey.services.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/admin/class")

public class ClassController {

    @Autowired
    ClassService service;


    @PostMapping(value ="/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Classs create(@RequestBody Classs classs) {
        classs = service.create(classs);
        System.out.println(classs.toString());
        return classs;
    }

    @PostMapping("/update")
    @ResponseBody
    public Classs update(Classs classs) {
        return service.update(classs);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Classs read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Classs> getAll() {
        return service.getAll();
    }


}
