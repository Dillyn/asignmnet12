package com.cput.lakey.controller.privateSession;

import com.cput.lakey.domain.privateSession.PrivateSession;
import com.cput.lakey.services.privateSession.PrivateSessionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/privateSession")
public class PrivateSessionController {

    @Autowired
    PrivateSessionServices service;

    @PostMapping(value ="/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PrivateSession create(@RequestBody PrivateSession privateSession) {
        privateSession = service.create(privateSession);
        return privateSession;
    }

    @PostMapping("/update")
    @ResponseBody
    public PrivateSession update(PrivateSession privateSession) {
        return service.update(privateSession);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public PrivateSession read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<PrivateSession> getAll() {
        return service.getAll();
    }


}
