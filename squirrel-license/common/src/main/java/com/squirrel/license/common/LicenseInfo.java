package com.squirrel.license.common;

import java.util.Date;

/**
 * @Author: JoinHan
 * @Date: Created in 16:53 2018/2/12
 * @Modified By：
 */
public class LicenseInfo {
    private Date startTime;
    private Date endTime;
    private LicenseEnum type;
    private String equipmentInfo;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public LicenseEnum getType() {
        return type;
    }

    public void setType(LicenseEnum type) {
        this.type = type;
    }

    public String getEquipmentInfo() {
        return equipmentInfo;
    }

    public void setEquipmentInfo(String equipmentInfo) {
        this.equipmentInfo = equipmentInfo;
    }
}
