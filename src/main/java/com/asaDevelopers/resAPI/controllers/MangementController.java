package com.asaDevelopers.resAPI.controllers;

import com.asaDevelopers.resAPI.dbModel.*;
import com.asaDevelopers.resAPI.model.*;
import com.asaDevelopers.resAPI.services.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/branchApi")
public class MangementController {

    // Company
    @Autowired
    private CompanyService cp;

    @PostMapping("/addCompany")
    public ResponseEntity<ApiResponse<Company>> saveCompany(@RequestBody Iterable<Company> c) {
        return cp.save(c);
    }

    @GetMapping("/companies")
    public ResponseEntity<ApiResponse<List<Company>>> company() {
        return cp.getAll();
    }

    @PostMapping("/deleteCompany/{id}")
    public ResponseEntity<ApiResponse<String>> deleteComp(@PathVariable Integer id){
        return cp.delete(id);
    }

    // Branches
    @Autowired
    private BranchService branchService;

    @PostMapping("/addBranch")
    public ResponseEntity<ApiResponse<Branch>> saveBranch(@RequestBody Iterable<Branch> branches) {
         return branchService.save(branches);
    }

    @GetMapping("/branches")
    public ResponseEntity<ApiResponse<List<Branch>>> showBranches() {
                return branchService.getAll();
    }

    @GetMapping("/branchById/{id}")
    public ResponseEntity<ApiResponse<Optional<Branch>>> showBranchesById(@PathVariable Integer id) {
        return branchService.getById(id);
    }

    //Inventory
    @Autowired
    private InventoryService is;

    @GetMapping("/inventory")
    public ResponseEntity<ApiResponse<List<Inventory>>> getInventory() {
        return is.getAll();
    }

    @GetMapping("/inventoryByBranchId")
    public ResponseEntity<ApiResponse<List<Inventory>>> getInventory(Integer id){
        return is.getAllByBranchId(id);
    }

    @PostMapping("/addInventory")
    public ResponseEntity<ApiResponse<Inventory>> saveInventory(Iterable<Inventory> i){
        return is.save(i);
    }

    //InventoryLog
    @Autowired
    private InventoryLogService ils;

    @GetMapping("/inventoryLog")
    public ResponseEntity<ApiResponse<List<InventoryLog>>> getInventoryL() {
        return ils.getAll();
    }

    @GetMapping("/inventoryLogByBranchId")
    public ResponseEntity<ApiResponse<List<InventoryLog>>> getInventoryL(Integer id){
        return ils.getAllByBranchId(id);
    }

    @PostMapping("/addInventoryLog")
    public ResponseEntity<ApiResponse<InventoryLog>> saveInventoryL(Iterable<InventoryLog> i){
        return ils.save(i);
    }

    //TablesInBranch
    @Autowired
    private TableService ts;

    @GetMapping("/table")
    public ResponseEntity<ApiResponse<List<TableEntity>>> gettable() {
        return ts.getAll();
    }

    @GetMapping("/tableByBranchId")
    public ResponseEntity<ApiResponse<List<TableEntity>>> getTableById(Integer id){
        return ts.getAllByBranchId(id);
    }

    @PostMapping("/addTable")
    public ResponseEntity<ApiResponse<TableEntity>> saveTable(Iterable<TableEntity> i){
        return ts.save(i);
    }

    //Customer
    @Autowired
    private CustomerService cs;

    @GetMapping("/customer")
    public ResponseEntity<ApiResponse<List<Customer>>> getCustomer() {
        return cs.getAll();
    }

    @GetMapping("/customerByPhone")
    public ResponseEntity<ApiResponse<Optional<Customer>>> getCustomerPhone(@RequestBody CustomerPhone c){
        return cs.getAllByPhone(c.getPhone());
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<ApiResponse<Customer>> saveCustomer(@RequestBody Iterable<Customer> c){
        return cs.save(c);
    }

    @PostMapping("/updateCustomerPoints")
    public ResponseEntity<ApiResponse<Customer>> updatePoints(@RequestBody CustomerPoints c){
        return cs.updatePoints(c.getPhone(),c.getAvailblePoints() ,c.getTotalPoints());
    }

    @PostMapping("/updateCustomerName")
    public ResponseEntity<ApiResponse<Customer>> updateName(@RequestBody CustomerName c){
        return cs.updateName(c.getPhone() , c.getName());
    }

    // Employee
    @Autowired
    private EmployeeService es;

    @GetMapping("/employees")
    public ResponseEntity<ApiResponse<List<Employee>>> getEmp() {
        return es.getAll();
    }

    @GetMapping("/employeeByBranchId/{id}")
    public ResponseEntity<ApiResponse<List<Employee>>> getEmpById(@PathVariable Integer id){
        return es.getAllByBranchId(id);
    }

    @GetMapping("/employeeByCnic")
    public ResponseEntity<ApiResponse<Optional<Employee>>> getEmpByCnic(@RequestBody HashMap<String,Integer> c){
        return es.getByCnic(c.get("cnic"));
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<ApiResponse<Employee>> saveEmp(Iterable<Employee> e){
        return es.save(e);
    }

    @PostMapping("/deleteEmployeeById/{i}")
    public ResponseEntity<ApiResponse<String>> delEmp(@PathVariable Integer i){
        return es.delete(i);
    }





}
