package com.cput.lakey.controller.session;

import com.cput.lakey.domain.session.Session;
import com.cput.lakey.services.session.SessionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    SessionServices service;

    @PostMapping(value ="/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Session create(@RequestBody Session session) {
        session = service.create(session);
        return session;
    }

    @PostMapping("/update")
    @ResponseBody
    public Session update(Session session) {
        return service.update(session);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Session read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Session> getAll() {
        return service.getAll();
    }


}
