package yekta.springtest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yekta.springtest.model.Department;
import yekta.springtest.repository.DepartmentRepository;
import yekta.springtest.response.DepartmentResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentRepository dRepo;

    @GetMapping("/departments")
    public List<DepartmentResponse> getDepartments(){
        List<Department> depts = dRepo.findAll();
        List<DepartmentResponse> list = new ArrayList<>();
        depts.forEach(d -> {
            DepartmentResponse dResponse = new DepartmentResponse();
            dResponse.setDepartmentName(d.getName());
            dResponse.setId(d.getId());
            dResponse.setEmployeeName(d.getEmployee().getName());
            list.add(dResponse);
        });
        return list;
    }

}
