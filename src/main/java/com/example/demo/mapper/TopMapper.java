package com.example.demo.mapper;

import com.example.demo.entity.TopLine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopMapper implements RowMapper<TopLine> {

    @Override
    public TopLine mapRow(ResultSet resultSet, int i) throws SQLException {
        TopLine topLine = new TopLine();
        topLine.setFormId(resultSet.getString("formid"));
        topLine.setCount(resultSet.getLong("cnt"));

        return topLine;
    }
}