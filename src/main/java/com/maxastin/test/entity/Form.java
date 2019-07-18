package com.maxastin.test.entity;

import javax.persistence.*;

@Entity
@Table(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "ssoid", length = 50, nullable = false)
    private String ssoId;

    @Column(name = "ts", length = 50, nullable = false)
    private String ts;

    @Column(name = "grp", length = 50, nullable = false)
    private String grp;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "subtype", length = 50, nullable = false)
    private String subType;

    @Column(name = "url", length = 200, nullable = false)
    private String url;

    @Column(name = "orgid", length = 50, nullable = false)
    private String orgId;

    @Column(name = "formid", length = 50, nullable = false)
    private String formId;

    @Column(name = "code", length = 50, nullable = false)
    private String code;

    @Column(name = "ltpa", length = 50, nullable = false)
    private String ltpa;

    @Column(name = "sudirresponse", length = 50, nullable = false)
    private String sudirResponse;

    @Column(name = "ymdh", length = 50, nullable = false)
    private String ymdh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirResponse() {
        return sudirResponse;
    }

    public void setSudirResponse(String subResponse) {
        this.sudirResponse = subResponse;
    }

    public String getYmdh() {
        return ymdh;
    }

    public void setYmdh(String ymdh) {
        this.ymdh = ymdh;
    }

    @Override
    public String toString() {
        return this.getSsoId() + "  :  " + this.getFormId();
    }
}
