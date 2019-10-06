package com.cput.lakey.controller.studio;

import com.cput.lakey.domain.studio.Studio;
import com.cput.lakey.services.studio.StudioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/studio")
public class StudioController {

    @Autowired
    StudioServices service;

    @PostMapping(value ="/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Studio create(@RequestBody Studio studio) {
        studio = service.create(studio);
        return studio;
    }

    @PostMapping("/update")
    @ResponseBody
    public Studio update(Studio studio) {
        return service.update(studio);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Studio read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Studio> getAll() {
        return service.getAll();
    }


}

