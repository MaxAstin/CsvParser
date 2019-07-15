package com.example.demo.service;

import com.example.demo.dao.FormDao;
import com.example.demo.entity.Form;
import com.example.demo.entity.Step;
import com.example.demo.entity.TopLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FormServiceImpl implements FormService {

    private static final String DELIMITER = ";";

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

    /*public void updateDatabase(MultipartFile mFile) {
        // создаём таблицу
        formDao.createTable();

        File file = covertToFile(mFile);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirst = true;
            int c = 0;
            while ((line = br.readLine()) != null) {
                // пропускаем первую строку
                if (isFirst) {
                    isFirst = false;
                    continue;
                }

                String[] args = line.split(DELIMITER);
                // выполняем очередной insert
                if (args.length == 12) {
                    System.out.println(++c);
                    formDao.addForm(args);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void updateDatabase(MultipartFile mFile) {
        File file = covertToFile(mFile);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirst = true;
            ArrayList<String[]> insertList = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                // пропускаем первую строку
                if (isFirst) {
                    isFirst = false;
                    continue;
                }

                String[] values = line.split(DELIMITER);
                // выполняем очередной insert
                if (values.length == 12) {
                    insertList.add(values);
                }
            }
            formDao.fillTable(insertList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File covertToFile(MultipartFile mFile) {
        File newFile = new File(mFile.getOriginalFilename());
        try {
            newFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(mFile.getBytes());
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return newFile;
    }
}
