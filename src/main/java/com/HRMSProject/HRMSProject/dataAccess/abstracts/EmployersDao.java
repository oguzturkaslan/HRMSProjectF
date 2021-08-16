/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.dataAccess.abstracts;

import com.HRMSProject.HRMSProject.entities.concretes.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oguz.turkaslan
 */
public interface EmployersDao extends JpaRepository<Employers, Integer> {

    Employers findByEmail(String email);

    Employers findById(int employerId);
}
