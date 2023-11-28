package egovframework.yrepairask.service;

/**
 * @Class Name : YrepairaskVO.java
 * @Description : Yrepairask VO class
 * @Modification Information
 *
 * @author aa
 * @since 2023-06-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YrepairaskVO extends YrepairaskDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** reno */
    private int reno;
    
    /** content */
    private java.lang.String content;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getReno() {
        return this.reno;
    }
    
    public void setReno(int reno) {
        this.reno = reno;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
}
