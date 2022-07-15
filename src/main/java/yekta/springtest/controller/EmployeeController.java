package yekta.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yekta.springtest.model.Employee;
import yekta.springtest.service.EmployeeService;

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
    public List<Employee> getEmployees (){
        return eService.getEmployees();
    }

    @GetMapping("/employees/{id}")
//    @PathVariable("id") deki id kısmı parametredeki id ile aynı adda olduğu
//    için silebilirsin deleteEmployee kısmında da silicez.
    public String getEmployee (@PathVariable("id") Long id) {
        return " Fetching the details for the employee with id " + id;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
        return "saving the employee details to the database" + employee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee (@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("updating the employee data for the id " + id);
        return employee;
    }


    //localhost:8080/employees?id=34   id yi burdan alıp RequestParam a yazıyor
    @DeleteMapping("/employees")
//    @RequestParam("id") normalde böyle
    public String deleteEmployee(@RequestParam Long id) {
        return "Deleting the employee with id " + id ;
    }
}
