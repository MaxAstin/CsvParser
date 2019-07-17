package com.example.demo.service;

import com.example.demo.entity.Form;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@Service
public interface FormService {
    Collection<String[]> findAll(String date);

    Collection<Form> findUnfinished();

    Collection<Form> findTopForms();

    void updateDatabase(MultipartFile file);
}
