package lambdas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data.Employee;
import data.EmployeeService;

public class Sorting {
	public static void main(String[] args) {
		
		List<Employee> employees = EmployeeService.getEmployees();		
		employees.forEach(System.out::println);
		
		Comparator<Employee> ageComparator = Comparator.comparing(e -> e.getAge());
		
		Collections.sort(employees, ageComparator.reversed());
		
		System.out.println("After sorting:");
		employees.forEach(System.out::println);
		
	}
}
