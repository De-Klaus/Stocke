package com.petko.stocke.dao;

public class GradeCoal {
    Long value;
    String label;
    Long idOrgBP;
    Double remainderGradeCoal;

    public GradeCoal(Long value, String label, Long idOrgBP, Double remainderGradeCoal) {
        this.value = value;
        this.label = label;
        this.idOrgBP = idOrgBP;
        this.remainderGradeCoal = remainderGradeCoal;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getIdOrgBP() {
        return idOrgBP;
    }

    public void setIdOrgBP(Long idOrgBP) {
        this.idOrgBP = idOrgBP;
    }

    public Double getRemainderGradeCoal() {
        return remainderGradeCoal;
    }

    public void setRemainderGradeCoal(Double remainderGradeCoal) {
        this.remainderGradeCoal = remainderGradeCoal;
    }
}
