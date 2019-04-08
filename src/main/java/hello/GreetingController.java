package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class GreetingController {

	@Autowired
	private EmployeeRepository repository;
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

	@RequestMapping("/employees")
    public List<Employee> employee(@RequestParam(value="name", defaultValue="World") String name) {
        	repository.save(new Employee("Alice", "Smith"));
		repository.save(new Employee("Bob", "Smith"));
	    return repository.findAll();
    }
	
	@GetMapping("/employees/{id}")
     public Employee one(@PathVariable Long id) {

		return repository.findById(id);
	}
}
