package com.example.demo.service;

import com.example.demo.entity.Form;
import com.example.demo.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    private static final String DELIMITER = ";";

    @Autowired
    public FormRepository repository;

    @Override
    public Collection<String[]> findAll(String date) {
        System.out.println(repository.getRecentForms(date).iterator().next());
        return repository.getRecentForms(date);
    }

    @Override
    public Collection<Form> findUnfinished() {
        Form f = repository.getUnfinishedForms().iterator().next();
        System.out.println(f);
        return repository.getUnfinishedForms();
    }

    @Override
    public Collection<Form> findTopForms() {
        return repository.getTopForms();
    }

    public void updateDatabase(MultipartFile mFile) {
        File file = covertToFile(mFile);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirst = true;
            ArrayList<Form> insertList = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                // пропускаем первую строку
                if (isFirst) {
                    isFirst = false;
                    continue;
                }
                String[] values = line.split(DELIMITER);
                // выполняем очередной insert
                if (values.length == 12) {
                    Form form = new Form();
                    form.setSsoId(values[0]);
                    form.setTs(values[1]);
                    form.setGrp(values[2]);
                    form.setType(values[3]);
                    form.setSubType(values[4]);
                    form.setUrl(values[5]);
                    form.setOrgId(values[6]);
                    form.setFormId(values[7]);
                    form.setCode(values[8]);
                    form.setLtpa(values[9]);
                    form.setSudirResponse(values[10]);
                    form.setYmdh(values[11]);
                    insertList.add(form);
                }
            }
            System.out.println(insertList.get(0));
            repository.saveAll(insertList);
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
