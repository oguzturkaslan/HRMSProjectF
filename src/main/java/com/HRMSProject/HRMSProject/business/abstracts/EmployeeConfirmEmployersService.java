/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.abstracts;

import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.entities.concretes.Employers;

/**
 *
 * @author oguz.turkaslan
 */
public interface EmployeeConfirmEmployersService {

    Result confirmApplication(int employerId);
}
