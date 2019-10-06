package com.cput.lakey.controller.users.staff;

import com.cput.lakey.domain.staff.Staff;
import com.cput.lakey.factories.staff.StaffFactory;
import com.cput.lakey.services.staff.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/api/admin/staff")
public class StaffController {
    @Autowired
    private StaffServices service;

    @PostMapping(value ="/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff createStaff(@RequestBody Staff staff) {
        //Staff staff1 = StaffFactory.getStaff(staff.getIdStaff(), staff.getName(), staff.getLastName(), staff.getTitle());
        return service.create(staff);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public Staff update(@RequestBody Staff staff) {
        return service.update(staff);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Staff read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Staff> getAll() {
        return service.getAll();
    }
}
