package yekta.springtest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yekta.springtest.model.Employee;
import yekta.springtest.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if (employee.isPresent())
            return employee.get();
        throw new RuntimeException("Employee is not found for the id "+ id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);  //saveEmployee ile aynı methodu kullandı
                                            //eğer id halihazırda varsa update eder yoksa create
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return eRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeesByKeyword(String name) {
        return eRepository.findByNameContaining(name);
    }
}
