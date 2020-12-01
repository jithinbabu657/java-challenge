package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableCaching
@RequestMapping("/api/v1")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @return List of Employee info
     */
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    /**
     * @param employeeId
     * @return Single Employee info
     */
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    /**
     * @param employee
     */
    @PostMapping("/employees")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        log.info("Employee Saved Successfully");
    }

    /**
     * @param employeeId
     */
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        log.info("Employee Deleted Successfully");
    }

    /**
     * @param employee
     * @param employeeId
     */
    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name = "employeeId") Long employeeId) {
        Employee emp = employeeService.getEmployee(employeeId);
        if (Optional.of(emp).isPresent()) {
            employeeService.updateEmployee(employee);
        }

    }

}
