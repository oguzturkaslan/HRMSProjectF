/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.concretes;

import com.HRMSProject.HRMSProject.business.abstracts.JobsService;
import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessDataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessResult;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.JobsDao;
import com.HRMSProject.HRMSProject.entities.concretes.Jobs;
import com.HRMSProject.HRMSProject.entities.dtos.JobsWithEmployerDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class JobsManager implements JobsService {

    private JobsDao jobsDao;

    @Autowired
    public JobsManager(JobsDao jobsDao) {
        this.jobsDao = jobsDao;
    }

    @Override
    public DataResult<List<Jobs>> getAll() {
        return new SuccessDataResult<>(jobsDao.findAll(), "İlanlar Listelendi");
    }

    @Override
    public Result add(Jobs jobs) {
        jobsDao.save(jobs);
        return new SuccessResult("İş İlanı Başarılı Şekilde Eklendi !");
    }

    @Override
    public DataResult<List<JobsWithEmployerDto>> getAllActiveJobs() {
        return new SuccessDataResult<>(jobsDao.getJobsDetails(), "Aktif İlanlar Listelendi !");
    }

    @Override
    public DataResult<List<JobsWithEmployerDto>> getAlljobsWithCompanyName(@RequestParam String companyName) {
        return new SuccessDataResult<>(jobsDao.getJobsDetailsWithCompanyName(companyName), " Şirkete Ait Aktif İlanlar Listelendi !");
    }

}
