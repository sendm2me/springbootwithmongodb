package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public Employee findByFirstName(String firstName);
    public List<Emplopyee> findByLastName(String lastName);

}
