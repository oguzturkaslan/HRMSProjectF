/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.api.controllers;

import com.HRMSProject.HRMSProject.business.abstracts.EmployeeConfirmEmployersService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oguz.turkaslan
 */
@RestController
@RequestMapping("/api/adminconfirm")
public class EmployeeConfirmEmployersController {

    private EmployeeConfirmEmployersService employeeConfirmEmployersService;

    @Autowired
    public EmployeeConfirmEmployersController(EmployeeConfirmEmployersService employeeConfirmEmployersService) {
        this.employeeConfirmEmployersService = employeeConfirmEmployersService;
    }

    @PutMapping("/verify/{id}")
    public ResponseEntity<?> verifyEmployer(@Valid @PathVariable int id) {
        return ResponseEntity.ok(employeeConfirmEmployersService.confirmApplication(id));
    }
}
