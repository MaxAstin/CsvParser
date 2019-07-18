package com.maxastin.test.service;

import com.maxastin.test.entity.Form;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface FormService {
    Collection<Form> findRecentForms(String date);

    Collection<Form> findUnfinishedForms();

    Collection<Object[]> findTopForms();

    void updateDatabase(MultipartFile file);
}
