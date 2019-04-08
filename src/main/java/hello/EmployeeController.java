package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @GetMapping("/employees")
    public List<Employee> employees() {
    	 return repository.findAll();
    }
	
    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable String id) {

	return repository.findById(id).get();
    }
	
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
	return repository.save(newEmployee);
    }
	
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable String id) {
		repository.deleteById(id);
     }
	
}
