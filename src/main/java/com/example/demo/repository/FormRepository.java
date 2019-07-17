package com.example.demo.repository;

import com.example.demo.entity.Form;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EntityResult;
import javax.persistence.SqlResultSetMapping;
import java.util.Collection;
import java.util.List;

public interface FormRepository extends CrudRepository<Form, Long> {

    @Query(value = "SELECT DISTINCT ssoId, formId, ts " +
            "FROM Form " +
            "WHERE date_trunc('hour', to_timestamp(:date, 'yyyy-MM-dd-HH24')) = date_trunc('hour', to_timestamp(cast(ts as double))) " +
            "AND ssoId != '' " +
            "AND formId != '' " +
            "ORDER BY ssoId")
    Collection<String[]> getRecentForms(@Param("date") String date);

    @Query("SELECT f " +
            "FROM Form f " +
            "WHERE f.ssoId != '' " +
            "AND f.formId != '' " +
            "AND f.subType != '' " +
            "ORDER BY f.ssoId, f.formId, f.ts")
    Collection<Form> getUnfinishedForms();

    @Query( "SELECT COUNT(ssoId) AS cnt, formId" +
            " FROM Form " +
            " WHERE formId != ''" +
            " GROUP BY formId" +
            " ORDER BY cnt DESC " /*+
            " LIMIT 5"*/ )
    Collection<Form> getTopForms();

    @Override
    <S extends Form> Iterable<S> saveAll(Iterable<S> forms);
}
