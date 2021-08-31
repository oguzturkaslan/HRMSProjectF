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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "curriculum_vitae")

public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "looking_for_jobs_id")
    private LookingForJobs lookingForJobs;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private List<School> school;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "languages_id")
    private List<Languages> languages;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_links_id")
    private PersonelLinks personelLinks;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "introduction")
    private String introduction;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id")
    private List<Experience> experience;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "programming_skills_id")
    private List<ProgrammingSkills> programmingSkills;

}
