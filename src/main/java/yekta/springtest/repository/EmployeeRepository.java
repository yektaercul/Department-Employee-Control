package yekta.springtest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import yekta.springtest.model.Employee;

import java.util.List;


//JpaRepository<Employee,Long> birincisi kullanacağımız entity nin türü 2.si PK in türü.
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {

    List<Employee> findByName(String name);

    List<Employee> findByNameAndLocation(String name, String location);

    List<Employee> findByNameContaining(String name, Sort sort);



}
