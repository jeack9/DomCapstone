package egovframework.ycomment.service;

/**
 * @Class Name : YcommentVO.java
 * @Description : Ycomment VO class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YcommentVO extends YcommentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** cno */
    private int cno;
    
    /** content */
    private java.lang.String content;
    
    /** ref */
    private int ref;
    
    /** re_step */
    private int reStep;
    
    /** re_level */
    private int reLevel;
    
    
    /** bno */
    private int bno;
    
    /** isremove */
    private int isremove;
    
    
    /** userid */
    private java.lang.String userid;
    
    /** regdate */
    private java.lang.String regdate;
    
    public int getCno() {
        return this.cno;
    }
    
    public void setCno(int cno) {
        this.cno = cno;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public int getRef() {
        return this.ref;
    }
    
    public void setRef(int ref) {
        this.ref = ref;
    }
    
    public int getIsremove() {
        return this.isremove;
    }
    
    public void setIsremove(int isremove) {
        this.isremove = isremove;
    }
    
    public int getReStep() {
        return this.reStep;
    }
    
    public void setReStep(int reStep) {
        this.reStep = reStep;
    }
    
    
    public int getBno() {
        return this.bno;
    }
    
    public void setBno(int bno) {
        this.bno = bno;
    }
    
    public int getReLevel() {
        return this.reLevel;
    }
    
    public void setReLevel(int reLevel) {
        this.reLevel = reLevel;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(java.lang.String regdate) {
        this.regdate = regdate;
    }
    
}
