package com.petko.stocke.dto;

public class GradeProductDto {
    Long value;
    String label;
    Long idOrgCP;
    Double remainderGradeCoal;

    public GradeProductDto(Long value, String label, Long idOrgCP, Double remainderGradeCoal) {
        this.value = value;
        this.label = label;
        this.idOrgCP = idOrgCP;
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

    public Long getIdOrgCP() {
        return idOrgCP;
    }

    public void setIdOrgCP(Long idOrgCP) {
        this.idOrgCP = idOrgCP;
    }

    public Double getRemainderGradeCoal() {
        return remainderGradeCoal;
    }

    public void setRemainderGradeCoal(Double remainderGradeCoal) {
        this.remainderGradeCoal = remainderGradeCoal;
    }
}
