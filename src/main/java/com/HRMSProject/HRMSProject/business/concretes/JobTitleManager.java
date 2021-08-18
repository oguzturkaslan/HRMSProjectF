/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.concretes;

import com.HRMSProject.HRMSProject.business.abstracts.JobTitleService;
import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.ErrorResult;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessDataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessResult;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.JobTitlesDao;
import com.HRMSProject.HRMSProject.entities.concretes.JobTitles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class JobTitleManager implements JobTitleService {

    @Autowired
    private JobTitlesDao jobTitlesDao;

    @Override
    public DataResult<List<JobTitles>> getAll() {
        return new SuccessDataResult<>(this.jobTitlesDao.findAll(), "Başlıklar Listelendi");
    }

    @Override
    public Result add(JobTitles jobTitles) {
        if(jobTitlesDao.getByTitle(jobTitles.getTitle())!=null){
        return new ErrorResult("Bu İş Tanımı Zaten Mevcut !");
        }
        jobTitlesDao.save(jobTitles);
        return new SuccessResult("Yeni İş Tanımı Eklendi !");

    }

}
