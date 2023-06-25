package com.petko.stocke.dto;

public class GradeProductDto {
    Long value;
    String label;
    Long idOrgCP;
    Double remainderGrade;

    public GradeProductDto(Long value, String label, Long idOrgCP, Double remainderGrade) {
        this.value = value;
        this.label = label;
        this.idOrgCP = idOrgCP;
        this.remainderGrade = remainderGrade;
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

    public Long getIdOrgCP() {
        return idOrgCP;
    }

    public void setIdOrgCP(Long idOrgCP) {
        this.idOrgCP = idOrgCP;
    }

    public Double getRemainderGrade() {
        return remainderGrade;
    }

    public void setRemainderGrade(Double remainderGrade) {
        this.remainderGrade = remainderGrade;
    }
}
