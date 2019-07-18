package com.maxastin.test.service;

import com.maxastin.test.entity.Form;
import com.maxastin.test.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class FormServiceImpl implements FormService {

    private static final String DELIMITER = ";";

    @Autowired
    private FormRepository repository;

    @Override
    public Collection<Form> findRecentForms(String date) {
        return repository.getRecentForms(date);
    }

    @Override
    public Collection<Form> findUnfinishedForms() {
        return repository.getUnfinishedForms();
    }

    @Override
    public Collection<Object[]> findTopForms() {
        return repository.getTopForms();
    }

    public void updateDatabase(MultipartFile mFile) {
        File file = covertToFile(mFile);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirst = true;
            ArrayList<Form> insertList = new ArrayList<>();

            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Skip first line
                if (isFirst) {
                    isFirst = false;
                    continue;
                }
                String[] values = line.split(DELIMITER);
                // Fill Form entity
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

                    // Add Form exemplar to list
                    insertList.add(form);
                }
            }
            // Save all forms
            repository.saveAll(insertList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File covertToFile(MultipartFile mFile) {
        // Write received file to a new file
        File newFile = new File(mFile.getOriginalFilename());
        try {
            newFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(mFile.getBytes());
            fos.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return newFile;
    }
}
