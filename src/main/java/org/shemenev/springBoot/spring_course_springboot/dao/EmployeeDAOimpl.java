package org.shemenev.springBoot.spring_course_springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import jakarta.persistence.Query;
import org.shemenev.springBoot.spring_course_springboot.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO{

    // этот бин создается самостоятельно; функционал JPA
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

            // для того, чтобы в респонсе получать адекватный id из базы
            Employee newEmployee = entityManager.merge(employee);
            employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {

//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeID");
//        query.setParameter("employeeID", id);
//        query.executeUpdate();


        Query query = entityManager.createQuery("delete from Employee where id =:employeeID");
        query.setParameter("employeeID", id);
        query.executeUpdate();

    }
}
