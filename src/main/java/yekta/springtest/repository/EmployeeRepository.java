package yekta.springtest.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yekta.springtest.model.Employee;

import java.util.List;


//JpaRepository<Employee,Long> birincisi kullanacağımız entity nin türü 2.si PK in türü.
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {

//    List<Employee> findByDepartmentName(String name);

//    @Query("FROM Employee where department.name = :name")
//    List<Employee> getEmployeeByDeptName(String name);

















//    List<Employee> findByName(String name);
//
//    List<Employee> findByNameAndLocation(String name, String location);
//
//    List<Employee> findByNameContaining(String name, Sort sort);
//
//    @Query("FROM Employee WHERE name = :name OR location = :location")
//    List<Employee> getEmployeesByNameAndLocation(String name, String location);
//
//    @Transactional
//    @Modifying  // update delete gibi queryyi degistiren requestlerde bu anot u kullanmalisin
//    @Query("DELETE FROM Employee WHERE name = :name")
//    Integer deleteEmployeeByName(String name);    // returned Integer is the number of affected rows

}
