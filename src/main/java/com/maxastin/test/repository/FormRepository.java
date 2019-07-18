package com.maxastin.test.repository;

import com.maxastin.test.entity.Form;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FormRepository extends CrudRepository<Form, Long> {

    @Query(value = "FROM Form f " +
            "WHERE date_trunc('hour', to_timestamp(:date, 'yyyy-MM-dd-HH24')) = date_trunc('hour', to_timestamp(cast(f.ts as double))) " +
            "AND f.ssoId != '' " +
            "AND f.formId != '' " +
            "ORDER BY f.ssoId")
    Collection<Form> getRecentForms(@Param("date") String date);

    @Query( "FROM Form f " +
            "WHERE f.ssoId != '' " +
            "AND f.formId != '' " +
            "AND f.subType != '' " +
            "ORDER BY f.ssoId, f.formId, f.ts")
    Collection<Form> getUnfinishedForms();

    @Query( value = "SELECT f.formId, COUNT(f.ssoId) AS cnt " +
            " FROM Form f " +
            " WHERE f.formId != ''" +
            " GROUP BY f.formId" +
            " ORDER BY cnt DESC " +
            " LIMIT 5" , nativeQuery = true)
    Collection<Object[]> getTopForms();

    @Override
    <S extends Form> Iterable<S> saveAll(Iterable<S> forms);
}
