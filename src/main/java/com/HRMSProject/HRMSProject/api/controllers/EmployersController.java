/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.api.controllers;

import com.HRMSProject.HRMSProject.business.abstracts.EmployersService;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.entities.concretes.Employers;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oguz.turkaslan
 */
@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployersService employersService;

    public EmployersController(EmployersService employersService) {
        this.employersService = employersService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Employers employers, @RequestParam String passwordRepeat) {
        return ResponseEntity.ok(employersService.add(employers, passwordRepeat));
    }

}
