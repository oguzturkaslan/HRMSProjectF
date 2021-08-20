/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.dataAccess.abstracts;

import com.HRMSProject.HRMSProject.entities.concretes.Jobs;
import com.HRMSProject.HRMSProject.entities.dtos.JobsWithEmployerDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author oguz.turkaslan
 */
public interface JobsDao extends JpaRepository<Jobs, Integer> {

    @Query("SELECT new com.HRMSProject.HRMSProject.entities.dtos.JobsWithEmployerDto"
            + " (j.id,\n"
            + "e.companyName, \n"
            + "j.numberOfPositions,\n"
            + "jt.title,\n"
            + "j.lastDateOfApplicate) \n "
            + "FROM Jobs j\n"
            + "INNER JOIN j.employers e \n"
            + "INNER JOIN j.jobTitle jt \n"
            + "WHERE j.is_active = TRUE \n"
            + "ORDER BY j.id ASC")
    List<JobsWithEmployerDto> getJobsDetails();

    @Query("SELECT new com.HRMSProject.HRMSProject.entities.dtos.JobsWithEmployerDto"
            + " (j.id,\n"
            + "e.companyName, \n"
            + "j.numberOfPositions,\n"
            + "jt.title,\n"
            + "j.lastDateOfApplicate) \n "
            + "FROM Jobs j\n"
            + "INNER JOIN j.employers e \n"
            + "INNER JOIN j.jobTitle jt \n"
            + "WHERE j.is_active = TRUE and e.companyName = :companyName \n"
            + "ORDER BY j.id ASC")
    List<JobsWithEmployerDto> getJobsDetailsWithCompanyName(String companyName);

    /*
    @Query("SELECT new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
            + "(p.id,p.productName,c.categoryName) "
            + "FROM Category c INNER JOIN c.products p")//JPA da INNER JOIN de "on" koşulunu belirtmeye gerek yok
     */
}
