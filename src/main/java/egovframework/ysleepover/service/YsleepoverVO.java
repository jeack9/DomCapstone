package egovframework.ysleepover.service;

/**
 * @Class Name : YsleepoverVO.java
 * @Description : Ysleepover VO class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YsleepoverVO extends YsleepoverDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** issignoff */
    private int issignoff;
    
    /** place */
    private java.lang.String place;
    
    /** startdate */
    private java.lang.String startdate;
    
    /** enddate */
    private java.lang.String enddate;
    
    /** userid */
    private java.lang.String userid;
    
    /** phone */
    private java.lang.String phone;
    
    /** applydate */
    private java.lang.String applydate;
    
    /** reason */
    private java.lang.String reason;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getIssignoff() {
        return this.issignoff;
    }
    
    public void setIssignoff(int issignoff) {
        this.issignoff = issignoff;
    }
    
    public java.lang.String getPlace() {
        return this.place;
    }
    
    public void setPlace(java.lang.String place) {
        this.place = place;
    }
    
    public java.lang.String getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(java.lang.String startdate) {
        this.startdate = startdate;
    }
    
    public java.lang.String getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(java.lang.String enddate) {
        this.enddate = enddate;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getPhone() {
        return this.phone;
    }
    
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
    
    public java.lang.String getApplydate() {
        return this.applydate;
    }
    
    public void setApplydate(java.lang.String applydate) {
        this.applydate = applydate;
    }
    
    public java.lang.String getReason() {
        return this.reason;
    }
    
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }
    
}
