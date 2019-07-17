package com.example.demo.mapper;


import com.example.demo.entity.FormOld;
import com.example.demo.entity.Step;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StepMapper implements RowMapper<Step> {

    @Override
    public Step mapRow(ResultSet resultSet, int i) throws SQLException {
        FormOld formOld = new FormOld();
        formOld.setFormId(resultSet.getString("formid"));
        formOld.setSsoId(resultSet.getString("ssoid"));

        Step step = new Step();
        step.setFormOld(formOld);
        step.setSubType(resultSet.getString("subtype"));

        return step;
    }
}