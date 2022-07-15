package yekta.springtest.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //id yi mysqlun taktiğine göre 1er 1er arttırıcak
    @Column(name="id")
    private Long id;

//    @JsonProperty("full_name")  // when you want to use another name "alias name"
                                // you need to change it on JSON body too. (Postman)
    @Column(name= "name")
    private String name;

//    @JsonIgnore   // In this way when you update the employee it won't show its age in response body
    @Column(name= "age")
    private Long age;

    @Column(name= "location")
    private String location;

    @Column(name= "email")
    private String email;

    @Column(name= "department")
    private String department;


}
