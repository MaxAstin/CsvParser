package com.example.demo.service;

import com.example.demo.dao.FormDao;
import com.example.demo.entity.Form;
import com.example.demo.entity.Step;
import com.example.demo.entity.TopLine;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FormServiceImpl implements FormService {

    @Autowired
    public FormDao formDao;

    @Override
    public List<Form> findAll(String date) {
        return formDao.findAll(date);
    }

    @Override
    public List<Step> findUnfinished() {
        return formDao.findUnfinished();
    }

    @Override
    public List<TopLine> findTopForms() {
        return formDao.findTopForms();
    }
}
