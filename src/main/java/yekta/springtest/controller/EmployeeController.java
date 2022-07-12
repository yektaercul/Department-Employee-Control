package yekta.springtest.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController // this combines @Controller and @ResponseBody
public class EmployeeController {


//    @RequestMapping(value = "/employees", method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/employees")
    public String getEmployees (){
        return "displaying the list of employees";
    }

    @GetMapping("/employees/{id}")
//    @PathVariable("id") deki id kısmı parametredeki id ile aynı adda olduğu
//    için silebilirsin deleteEmployee kısmında da silicez.
    public String getEmployee (@PathVariable("id") Long id) {
        return " Fetching the details for the employee with id " + id;
    }

    //localhost:8080/employees?id=34   id yi burdan alıp RequestParam a yazıyor
    @DeleteMapping("/employees")
//    @RequestParam("id") normalde böyle
    public String deleteEmployee(@RequestParam Long id) {
        return "Deleting the employee with id " + id ;
    }
}
