/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.api.controllers;

import com.HRMSProject.HRMSProject.business.abstracts.JobTitleService;
import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.entities.concretes.JobTitles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oguz.turkaslan
 */
@RestController
@RequestMapping("/api/jobtitles")
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/getall")
    public DataResult<List<JobTitles>> getAll() {
        return this.jobTitleService.getAll();
    }

}
