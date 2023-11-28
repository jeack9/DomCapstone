package egovframework.yrepair.service;

/**
 * @Class Name : YrepairVO.java
 * @Description : Yrepair VO class
 * @Modification Information
 *
 * @author aa
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YrepairVO extends YrepairDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** reno */
    private int reno;
    
    /** roomnum */
    private java.lang.String roomnum;
    
    /** subject */
    private java.lang.String subject;
    
    /** writer */
    private java.lang.String writer;
    
    /** userid */
    private java.lang.String userid;
    
    /** content */
    private java.lang.String content;
    
    /** regdate */
    private java.lang.String regdate;
    
    /** state */
    private java.lang.String state;
    
    public int getReno() {
        return this.reno;
    }
    
    public void setReno(int reno) {
        this.reno = reno;
    }
    
    public java.lang.String getRoomnum() {
        return this.roomnum;
    }
    
    public void setRoomnum(java.lang.String roomnum) {
        this.roomnum = roomnum;
    }
    
    public java.lang.String getSubject() {
        return this.subject;
    }
    
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }
    
    public java.lang.String getWriter() {
        return this.writer;
    }
    
    public void setWriter(java.lang.String writer) {
        this.writer = writer;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(java.lang.String regdate) {
        this.regdate = regdate;
    }
    
    public java.lang.String getState() {
        return this.state;
    }
    
    public void setState(java.lang.String state) {
        this.state = state;
    }
    
}
