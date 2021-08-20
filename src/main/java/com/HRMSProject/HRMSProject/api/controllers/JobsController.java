/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.api.controllers;

import com.HRMSProject.HRMSProject.business.abstracts.JobsService;
import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.entities.concretes.Jobs;
import com.HRMSProject.HRMSProject.entities.dtos.JobsWithEmployerDto;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oguz.turkaslan
 */
@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @GetMapping("/getall")
    public DataResult<List<Jobs>> getAll() {
        return jobsService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Jobs jobs) {
        return ResponseEntity.ok(jobsService.add(jobs));
    }

    @GetMapping("/getallactivejobs")
    public DataResult<List<JobsWithEmployerDto>> getAllActiveJobs() {
        return jobsService.getAllActiveJobs();
    }

    @GetMapping("/getalljobswithcompanyname")
    public DataResult<List<JobsWithEmployerDto>> getAlljobsWithCompanyName(String companyName) {
        return jobsService.getAlljobsWithCompanyName(companyName);
    }
}
