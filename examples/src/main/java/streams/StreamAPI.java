package streams;

import java.util.List;

import data.Employee;
import data.EmployeeService;

public class StreamAPI {

	public static void main(String[] args) {
		
		List<Employee> employees = EmployeeService.getEmployees();
		
		//employees.forEach(System.out::println);
		
		employees.stream().filter(e -> e.getAge()>25).forEach(System.out::println);
	}
}
