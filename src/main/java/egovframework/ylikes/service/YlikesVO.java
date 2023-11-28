package egovframework.ylikes.service;

/**
 * @Class Name : YlikesVO.java
 * @Description : Ylikes VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YlikesVO extends YlikesDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** lno */
    private int lno;
    
    /** bno */
    private int bno;
    
    /** userid */
    private java.lang.String userid;
    
    public int getLno() {
        return this.lno;
    }
    
    public void setLno(int lno) {
        this.lno = lno;
    }
    
    public int getBno() {
        return this.bno;
    }
    
    public void setBno(int bno) {
        this.bno = bno;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
}
