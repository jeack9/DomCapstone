package egovframework.testboard.service;

/**
 * @Class Name : TestboardVO.java
 * @Description : Testboard VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class TestboardVO extends TestboardDefaultVO{
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
    
    /** likes */
    private int likes;
    
    
    
    public int getLikes() {
        return this.likes;
    }
    
    public void setLikes(int likes) {
        this.likes = likes;
    }
    
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
    
}
