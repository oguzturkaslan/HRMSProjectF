/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.abstracts;

import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.entities.concretes.CurriculumVitae;

/**
 *
 * @author oguz.turkaslan
 */
public interface CurriculumVitaeService {

    Result add(CurriculumVitae curriculumVitae);
}
