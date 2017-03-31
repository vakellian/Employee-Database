package com.vic.springcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vic.springcrud.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployees() {
		
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query for all employees
		Query<Employee> theQuery = currentSession.createQuery("from Employee order by lastName", Employee.class);
		
		// execute and get result list
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public Employee getEmployee(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieves the employee from db using pk
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the employee using pk
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
	}

}
