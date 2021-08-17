/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.dataAccess.abstracts;

import com.HRMSProject.HRMSProject.entities.concretes.EmployeeConfirmEmployers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oguz.turkaslan
 */
public interface EmployeeConfirmEmployersDao extends JpaRepository<EmployeeConfirmEmployers, Integer> {

    EmployeeConfirmEmployers getByEmployers_Id(int employerId);
}
