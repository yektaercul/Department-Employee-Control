package yekta.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yekta.springtest.model.Employee;


//JpaRepository<Employee,Long> birincisi kullanacağımız entity nin türü 2.si PK in türü.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
