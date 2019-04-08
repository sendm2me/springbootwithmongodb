package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Customer, String> {

    public Employee findByFirstName(String firstName);
    public Employee<Customer> findByLastName(String lastName);

}
