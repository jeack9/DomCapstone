package egovframework.ypayment.service;

/**
 * @Class Name : YpaymentVO.java
 * @Description : Ypayment VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YpaymentVO extends YpaymentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** pno */
    private int pno;
    
    /** userid */
    private java.lang.String userid;
    
    /** name */
    private java.lang.String name;
    
    /** pdate */
    private java.util.Date pdate;
    
    /** price */
    private java.lang.String price;
    
    public int getPno() {
        return this.pno;
    }
    
    public void setPno(int pno) {
        this.pno = pno;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.util.Date getPdate() {
        return this.pdate;
    }
    
    public void setPdate(java.util.Date pdate) {
        this.pdate = pdate;
    }
    
    public java.lang.String getPrice() {
        return this.price;
    }
    
    public void setPrice(java.lang.String price) {
        this.price = price;
    }
    
}
