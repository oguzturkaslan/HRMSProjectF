/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.core.adapters.concretes;

import com.HRMSProject.HRMSProject.core.adapters.abstracts.CloudinaryService;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class CloudinaryServiceAdapter implements CloudinaryService {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryServiceAdapter() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "deta9l5dz",
                "api_key", "372518546935349",
                "api_secret", "sMNXDAjYCvmf3QTEXTQIed-Kh9A"));
    }

    @Override
    public Map<String, Object> uploadImage(File file) {
        try {
            Map<String, Object> upload = cloudinary.uploader().upload(new File("https://upload.wikimedia.org/wikipedia/commons/a/ae/Olympic_flag.jpg"),
                    ObjectUtils.asMap("public_id", "olympic_flag"));
            return upload;
        } catch (IOException ex) {
            Logger.getLogger(CloudinaryServiceAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
