/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.entities.concretes;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author oguz.turkaslan
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_title_id")
    private JobTitles jobTitle;

    @Column(name = "start_date")
    private int start_date;

    @Column(name = "end_date")
    private int end_date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_id")
    private List<CurriculumVitae> curriculumVitae;

}
