package data;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

	public static List<Employee> getEmployees(){		
		List<Employee> employeeList =  new ArrayList<>();		
		employeeList.add(new Employee("Lisa", "Abel", 24));
		employeeList.add(new Employee("Bruce", "Urman", 25));
		employeeList.add(new Employee("Diana", "Lorentz", 26));
		employeeList.add(new Employee("Alexander", "Hunold", 23));
		employeeList.add(new Employee("Karen", "Vargas", 28));
		employeeList.add(new Employee("Alexander", "Hunold", 27));
		employeeList.add(new Employee("Janette", "Olsen", 29));		
		
		return employeeList;
	}
}
