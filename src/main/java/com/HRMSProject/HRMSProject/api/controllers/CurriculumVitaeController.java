/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.api.controllers;

import com.HRMSProject.HRMSProject.business.abstracts.CurriculumVitaeService;
import com.HRMSProject.HRMSProject.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oguz.turkaslan
 */
@RestController
@RequestMapping("/api/cv")
public class CurriculumVitaeController {

    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CurriculumVitae curriculumVitae) {
        return ResponseEntity.ok(curriculumVitaeService.add(curriculumVitae));
    }
}
