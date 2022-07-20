package yekta.springtest.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id yi mysqlun taktiğine göre 1er 1er arttırıcak
    private Long id;

//    @JsonProperty("full_name")  // when you want to use another name "alias name"
                                // you need to change it on JSON body too. (Postman)
    @NotBlank(message = "Name cannot be null!")
    private String name;

//    @JsonIgnore   // In this way when you update the employee it won't show its age in response body
    private Long age = 0L ;

//    @Column(name= "location")  Column annotationi sadece ismini degistirmek istiyosan yaz yoksa zorunlu degil
    private String location;

    @Email(message = "Please enter a valid email address!")
    private String email;

    @NotBlank(message = "Department cannot be null!")
    private String department;

    @CreationTimestamp    //JPA kendisi algiliyor JSON formatinda yazarken oraya bu fieldlari eklemene gerek yok.
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

}
