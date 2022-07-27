package yekta.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yekta.springtest.model.Department;
import yekta.springtest.model.Employee;
import yekta.springtest.repository.DepartmentRepository;
import yekta.springtest.repository.EmployeeRepository;
import yekta.springtest.request.EmployeeRequest;
import yekta.springtest.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

//@Controller
@RestController // this combines @Controller and @ResponseBody
//@RequestMapping("/api/v1") // bu sayede hepsi v1/... şeklinde yazılacak
// Bu request mappingi bütün controllerlara uygulamak istersen bunu
// app.properties dosyasına yazman gerekir.
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

    @Autowired
    private EmployeeRepository eRepo;

    @Autowired
    private DepartmentRepository dRepo;

//    @Value("${app.name}")  // application.properties dosyasının içindeki
//                            // bilgileri bu sayede okuyabilirsin
//    private String appName;



//    @RequestMapping(value = "/employees", method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees (@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
//    @PathVariable("id") deki id kısmı parametredeki id ile aynı adda olduğu
//    için silebilirsin deleteEmployee kısmında da silicez.
    public ResponseEntity<Employee> getEmployee (@PathVariable("id") Long id) {
        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest){


        // OneToMany
//        Employee employee = new Employee(eRequest);
//
//        employee = eRepo.save(employee);
//
//        for (String s : eRequest.getDepartment()) {
//            Department d = new Department();
//            d.setName(s);
//            d.setEmployee(employee);
//
//            dRepo.save(d);
//        }
//
//        return new ResponseEntity<>("Record saved successfully", HttpStatus.CREATED);


        // OneToOne
        Department dept = new Department();
        dept.setName(eRequest.getDepartment());

        dept = dRepo.save(dept);

        Employee employee = new Employee(eRequest);
        employee.setDepartment(dept);

        employee = eRepo.save(employee);   // service i kullanmak yerine direkt repository i buraya cagirdik
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<>(eService.updateEmployee(employee), HttpStatus.OK);
    }


    //localhost:8080/employees?id=34   id yi burdan alıp RequestParam a yazıyor
    @DeleteMapping("/employees")
//    @RequestParam("id") normalde böyle
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        // bu id yi siler ve diğer id ler sabit kalır.
//        eService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/employees/filter/{name}")
//    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String name){
////        return new ResponseEntity<>(eRepo.findByDepartmentName(name), HttpStatus.OK);
//        return new ResponseEntity<>(eRepo.getEmployeeByDeptName(name), HttpStatus.OK);
//    }














//    @GetMapping("/employees/filterByName")
//    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
//        return new ResponseEntity<>(eService.getEmployeesByName(name), HttpStatus.OK);
//    }
//
//    @GetMapping("/employees/filterByNameAndLocation")
//    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
//        return new ResponseEntity<>(eService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
//    }
//
//    @GetMapping("/employees/filterByKeyword")
//    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
//        return new ResponseEntity<>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
//    }
//
//    @GetMapping("/employees/{name}/{location}")
//    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name, @PathVariable String location){
//        return new ResponseEntity<>(eService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("/employees/delete/{name}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable String name) {
//        return new ResponseEntity<>(eService.deleteByEmployeeName(name) + " No of records affected",HttpStatus.OK);
//    }

}
