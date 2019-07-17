package com.example.demo.dao;

import com.example.demo.entity.Form;

import java.util.ArrayList;
import java.util.List;

public interface FormDao {

    List<Form> findAll(String date);

    List<Form> findUnfinished();

    List<Form> findTopForms();

    /*void createTable();

    void addForm(String[] args);*/

    public void fillTable(ArrayList<String[]> insertList);
}
