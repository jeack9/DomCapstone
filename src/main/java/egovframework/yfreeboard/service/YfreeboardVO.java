package egovframework.yfreeboard.service;

/**
 * @Class Name : YfreeboardVO.java
 * @Description : Yfreeboard VO class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YfreeboardVO extends YfreeboardDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** bno */
    private int bno;
    
    /** subject */
    private java.lang.String subject;
    
    /** content */
    private java.lang.String content;
    
    /** writer */
    private java.lang.String writer;
    
    /** regdate */
    private java.lang.String regdate;
    
    /** moddate */
    private java.lang.String moddate;
    
    /** onlytext */
    private java.lang.String onlytext;
    
    /** userid */
    private java.lang.String userid;
    
    /** likes */
    private int likes;
    
    /** visitors */
    private int visitors;
    
    public int getBno() {
        return this.bno;
    }
    
    public void setBno(int bno) {
        this.bno = bno;
    }
    
    public java.lang.String getSubject() {
        return this.subject;
    }
    
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getWriter() {
        return this.writer;
    }
    
    public void setWriter(java.lang.String writer) {
        this.writer = writer;
    }
    
    public java.lang.String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(java.lang.String regdate) {
        this.regdate = regdate;
    }
    
    public java.lang.String getModdate() {
        return this.moddate;
    }
    
    public void setModdate(java.lang.String moddate) {
        this.moddate = moddate;
    }
    
    public java.lang.String getOnlytext() {
        return this.onlytext;
    }
    
    public void setOnlytext(java.lang.String onlytext) {
        this.onlytext = onlytext;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public int getLikes() {
        return this.likes;
    }
    
    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    public int getVisitors() {
        return this.visitors;
    }
    
    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }
    
}
