/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.abstracts;

import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.entities.concretes.Employers;
import java.util.List;

/**
 *
 * @author oguz.turkaslan
 */
public interface EmployersService {

    Result add(Employers employers, String passwordRepeat);

    DataResult<List<Employers>> getAll();
}
