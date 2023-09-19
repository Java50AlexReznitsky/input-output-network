package telran.employees.service;

import java.util.List;

import telran.employees.dto.Employee;

public interface Company {
	boolean addEmployee(Employee empl); // adds a given employee object, returns true if added, otherwise false
										// (if employee with the id is already exist)

	Employee removeEmployee(long id); // return reference to an employee to be removed,
										// otherwise returns null if no such employee found

	Employee getEmployee(long id);// return null if no such employee found

	List<Employee> getEmployees();// returns list of all employee objects, in the case of none exists, it returns
									// empty list

	default void restore(String dataFile) {
		// TODO
		// restore all employees from a given file
		// if there is no file, it just means that application doesn't have any saved
		// data, that is no exception should be thrown
		// all possible exception should be propagated as a RunTimeException
	}

	default void save(String dataFile) {
		// TODO
		// saving all current employee objects to a given file
		// Implementation hint: use getEmployees() method to get a list of all employee objects,
		// and to serialize whole list to the file
		// all possible exception should be propagated as a RunTimeException
	}

}
