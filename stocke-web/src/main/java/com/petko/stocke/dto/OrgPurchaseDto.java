package com.petko.stocke.dto;

public class OrgPurchaseDto {
    private Long   orgId;
    private String orgName;
    private boolean show;

    public OrgPurchaseDto(Long orgId, String orgName, boolean show) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.show = show;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
