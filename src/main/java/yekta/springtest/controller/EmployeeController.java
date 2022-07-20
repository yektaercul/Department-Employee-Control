package yekta.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yekta.springtest.model.Employee;
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


//    @Value("${app.name}")  // application.properties dosyasının içindeki
//                            // bilgileri bu sayede okuyabilirsin
//    private String appName;



//    @RequestMapping(value = "/employees", method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees (){
        return new ResponseEntity<>(eService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
//    @PathVariable("id") deki id kısmı parametredeki id ile aynı adda olduğu
//    için silebilirsin deleteEmployee kısmında da silicez.
    public ResponseEntity<Employee> getEmployee (@PathVariable("id") Long id) {
        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(eService.saveEmployee(employee),HttpStatus.CREATED);
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

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<>(eService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<>(eService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
    }

}
