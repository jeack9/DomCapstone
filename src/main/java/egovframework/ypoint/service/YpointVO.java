package egovframework.ypoint.service;

/**
 * @Class Name : YpointVO.java
 * @Description : Ypoint VO class
 * @Modification Information
 *
 * @author capstone
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YpointVO extends YpointDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** pointno */
    private int pointno;
    
    /** userid */
    private java.lang.String userid;
    
    /** manager */
    private java.lang.String manager;
    
    /** pointreason */
    private java.lang.String pointreason;
    
    /** pointchange */
    private int pointchange;
    
    /** pointdate */
    private java.lang.String pointdate;
    
    public int getPointno() {
        return this.pointno;
    }
    
    public void setPointno(int pointno) {
        this.pointno = pointno;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getManager() {
        return this.manager;
    }
    
    public void setManager(java.lang.String manager) {
        this.manager = manager;
    }
    
    public java.lang.String getPointreason() {
        return this.pointreason;
    }
    
    public void setPointreason(java.lang.String pointreason) {
        this.pointreason = pointreason;
    }
    
    public int getPointchange() {
        return this.pointchange;
    }
    
    public void setPointchange(int pointchange) {
        this.pointchange = pointchange;
    }
    
    public java.lang.String getPointdate() {
        return this.pointdate;
    }
    
    public void setPointdate(java.lang.String pointdate) {
        this.pointdate = pointdate;
    }
    
}
