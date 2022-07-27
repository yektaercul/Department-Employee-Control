package yekta.springtest.model;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import yekta.springtest.request.EmployeeRequest;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id yi mysqlun taktiğine göre 1er 1er arttırıcak
    private Long id;

//    @JsonProperty("full_name")  // when you want to use another name "alias name"
                                // you need to change it on JSON body too. (Postman)
//    @NotBlank(message = "Name cannot be null!")
    private String name;


    @JoinColumn(name = "department_id")
    @OneToOne
    private Department department;

    public Employee(EmployeeRequest req){
        this.name = req.getName();
    }











////    @JsonIgnore   // In this way when you update the employee it won't show its age in response body
//    private Long age = 0L ;
//
////    @Column(name= "location")  Column annotationi sadece ismini degistirmek istiyosan yaz yoksa zorunlu degil
//    private String location;
//
//    @Email(message = "Please enter a valid email address!")
//    private String email;
//
//    @NotBlank(message = "Department cannot be null!")
//    private String department;
//
//    @CreationTimestamp    //JPA kendisi algiliyor JSON formatinda yazarken oraya bu fieldlari eklemene gerek yok.
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private Date createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private Date updatedAt;

}
