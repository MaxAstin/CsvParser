package com.example.demo.service;

import com.example.demo.entity.Form;
import com.example.demo.entity.Step;
import com.example.demo.entity.TopLine;

import java.util.List;

public interface FormService {
    List<Form> findAll(String date);

    List<Step> findUnfinished();

    List<TopLine> findTopForms();
}
