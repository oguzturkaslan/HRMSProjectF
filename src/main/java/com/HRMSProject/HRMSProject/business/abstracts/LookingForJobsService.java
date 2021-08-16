/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.abstracts;

import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.entities.concretes.LookingForJobs;
import java.util.List;

/**
 *
 * @author oguz.turkaslan
 */
public interface LookingForJobsService {

    DataResult<List<LookingForJobs>> getAll();

    Result add(LookingForJobs lookingForJobs,String passwordRepeat);

    boolean checkEmail(String email);

    boolean checkID(int id);

}
