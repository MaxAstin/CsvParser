package com.example.demo.dao;

import com.example.demo.entity.Form;
import com.example.demo.entity.Step;
import com.example.demo.entity.TopLine;

import java.util.ArrayList;
import java.util.List;

public interface FormDao {

    List<Form> findAll(String date);

    List<Step> findUnfinished();

    List<TopLine> findTopForms();

    /*void createTable();

    void addForm(String[] args);*/

    public void fillTable(ArrayList<String[]> insertList);
}
