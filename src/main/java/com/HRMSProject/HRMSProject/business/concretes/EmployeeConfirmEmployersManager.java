/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.concretes;

import com.HRMSProject.HRMSProject.business.abstracts.EmployeeConfirmEmployersService;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessResult;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.EmployeeConfirmEmployersDao;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.UserDao;
import com.HRMSProject.HRMSProject.entities.concretes.EmployeeConfirmEmployers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class EmployeeConfirmEmployersManager implements EmployeeConfirmEmployersService {

    private UserDao userDao;
    private EmployeeConfirmEmployersDao employeeConfirmEmployersDao;

    @Autowired
    public EmployeeConfirmEmployersManager(UserDao userDao, EmployeeConfirmEmployersDao employeeConfirmEmployersDao) {
        this.userDao = userDao;
        this.employeeConfirmEmployersDao = employeeConfirmEmployersDao;
    }

    @Override
    public Result confirmApplication(int employerId) {
        EmployeeConfirmEmployers employeeConfirmEmployers = employeeConfirmEmployersDao.getByEmployers_Id(employerId);
        employeeConfirmEmployers.setConfirmed(true);
        employeeConfirmEmployers.setUser(userDao.getById(1));
        employeeConfirmEmployersDao.save(employeeConfirmEmployers);
        return new SuccessResult("Personel Onayı HRMS Personelimiz " + employeeConfirmEmployers.getUser().getEmail() + " Tarafından Onaylandı! -> " + employeeConfirmEmployers.getEmployers().getCompanyName());
    }

}
