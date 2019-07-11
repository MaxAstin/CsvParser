package com.example.demo.mapper;

import com.example.demo.entity.Form;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormMapper implements RowMapper<Form> {

    @Override
    public Form mapRow(ResultSet resultSet, int i) throws SQLException {
        Form form = new Form();
        form.setFormId(resultSet.getString("formid"));
        form.setSsoId(resultSet.getString("ssoid"));

        return form;
    }
}
