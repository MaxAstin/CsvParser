package com.example.demo.mapper;


import com.example.demo.entity.Form;
import com.example.demo.entity.Step;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StepMapper implements RowMapper<Step> {

    @Override
    public Step mapRow(ResultSet resultSet, int i) throws SQLException {
        Form form = new Form();
        form.setFormId(resultSet.getString("formid"));
        form.setSsoId(resultSet.getString("ssoid"));

        Step step = new Step();
        step.setForm(form);
        step.setSubType(resultSet.getString("subtype"));

        return step;
    }
}