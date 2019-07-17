package com.example.demo.mapper;

import com.example.demo.entity.FormOld;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormMapper implements RowMapper<FormOld> {

    @Override
    public FormOld mapRow(ResultSet resultSet, int i) throws SQLException {
        FormOld formOld = new FormOld();
        formOld.setFormId(resultSet.getString("formid"));
        formOld.setSsoId(resultSet.getString("ssoid"));

        return formOld;
    }
}
