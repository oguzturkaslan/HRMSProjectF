/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.abstracts;

import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.entities.concretes.JobTitles;
import java.util.List;

/**
 *
 * @author oguz.turkaslan
 */
public interface JobTitleService {

    DataResult<List<JobTitles>> getAll();
}
