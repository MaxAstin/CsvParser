package com.example.demo.dao;

import com.example.demo.entity.Form;
import com.example.demo.entity.Step;
import com.example.demo.entity.TopLine;
import com.example.demo.mapper.FormMapper;
import com.example.demo.mapper.StepMapper;
import com.example.demo.mapper.TopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormDaoImpl implements FormDao {

    private static final String TABLE_NAME = "mydata";

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public FormDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Form> findAll(String date) {
        long sec = getSeconds(date);

        String formQuery =
                "SELECT DISTINCT ssoid, formid, ts" +
                        " FROM " + TABLE_NAME +
                        " WHERE (" + sec + " - CAST (ts AS INTEGER)) > 0" +
                        " AND (" + sec + " - CAST (ts AS INTEGER)) < 60*60" +
                        " AND ssoid != ''" +
                        " AND formid != ''" +
                        " ORDER BY ssoid";

        return jdbcTemplate.query(formQuery, new FormMapper());
    }

    @Override
    public List<Step> findUnfinished() {
        String stepQuery =
                "SELECT ssoid, formid, subtype, ts" +
                        " FROM " + TABLE_NAME +
                        " WHERE ssoid != ''" +
                        " AND formid != ''" +
                        " AND subtype != ''" +
                        " ORDER BY ssoid, formid, ts";

        return jdbcTemplate.query(stepQuery, new StepMapper());
    }

    @Override
    public List<TopLine> findTopForms() {
        String topQuery =
                "SELECT COUNT(ssoid) AS cnt, formid" +
                        " FROM " + TABLE_NAME +
                        " WHERE formid != ''" +
                        " GROUP BY formid" +
                        " ORDER BY cnt DESC" +
                        " LIMIT 5";

        return jdbcTemplate.query(topQuery, new TopMapper());
    }

    @Override
    public void fillTable(ArrayList<String[]> insertList) {
        StringBuilder sql = new StringBuilder("DROP TABLE IF EXISTS ").append(TABLE_NAME)
                .append("; CREATE TABLE ").append(TABLE_NAME).append("(")
                .append("ssoid VARCHAR(256),")
                .append("ts VARCHAR(256), ")
                .append("grp VARCHAR(256), ")
                .append("type VARCHAR(256), ")
                .append("subtype VARCHAR(256), ")
                .append("url VARCHAR(256), ")
                .append("orgid VARCHAR(256), ")
                .append("formid VARCHAR(256), ")
                .append("code VARCHAR(256), ")
                .append("ltpa VARCHAR(256), ")
                .append("sudirresponse VARCHAR(256), ")
                .append("ymdh VARCHAR(256));");

        for(String[] values : insertList) {
            StringBuilder insertLine = new StringBuilder(" INSERT INTO ").append(TABLE_NAME)
                    .append("(ssoid, ts, grp, type, subtype, url, orgid, formid, code, ltpa, sudirresponse, ymdh) VALUES (");

            // добавляем значения из разрезанной строки
            for (String value : values) {
                insertLine.append("'")
                        .append(value)
                        .append("', ");
            }
            insertLine = insertLine.deleteCharAt(insertLine.length() - 2);
            insertLine.append("); ");

            sql.append(insertLine);
        }
        jdbcTemplate.execute(sql.toString());
    }

    /*@Override
    public void createTable() {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME
                + "; CREATE TABLE " + TABLE_NAME + "(" +
                "ssoid VARCHAR(256)," +
                "ts VARCHAR(256), " +
                "grp VARCHAR(256), " +
                "type VARCHAR(256), " +
                "subtype VARCHAR(256), " +
                "url VARCHAR(256), " +
                "orgid VARCHAR(256), " +
                "formid VARCHAR(256), " +
                "code VARCHAR(256), " +
                "ltpa VARCHAR(256), " +
                "sudirresponse VARCHAR(256), " +
                "ymdh VARCHAR(256))";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void addForm(String[] args) {
        String sql = "INSERT INTO " + TABLE_NAME
                + "(ssoid, ts, grp, type, subtype, url, orgid, formid, code, ltpa, sudirresponse, ymdh)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, args);
    }
*/
    private static long getSeconds(String strDate) {
        long seconds;

        if (!strDate.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
            Date date = null;
            try {
                date = sdf.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            seconds = date.getTime() / 1000;
        } else {
            seconds = System.currentTimeMillis() / 1000;
        }

        return seconds;
    }
}
