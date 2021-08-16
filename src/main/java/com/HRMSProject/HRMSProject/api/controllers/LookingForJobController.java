/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package com.HRMSProject.HRMSProject.api.controllers;

import com.HRMSProject.HRMSProject.business.abstracts.LookingForJobsService;
import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.entities.concretes.LookingForJobs;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/lookingforjobs")
public class LookingForJobController {

    private LookingForJobsService lookingForJobsService;

    @Autowired
    public LookingForJobController(LookingForJobsService lookingForJobsService) {
        this.lookingForJobsService = lookingForJobsService;
    }

    @GetMapping("/getall")
    public DataResult<List<LookingForJobs>> getAll() {
        return lookingForJobsService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody LookingForJobs lookinForJobs,@RequestParam String passwordRepeat) {
        return ResponseEntity.ok(lookingForJobsService.add(lookinForJobs, passwordRepeat));
    }

}
