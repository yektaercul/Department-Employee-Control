package yekta.springtest.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeResponse {

    private Long id;

    private String employeeName;

    private List<String> department;

}
