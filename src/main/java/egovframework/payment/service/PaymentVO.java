package egovframework.payment.service;

/**
 * @Class Name : PaymentVO.java
 * @Description : Payment VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PaymentVO extends PaymentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** pno */
    private int pno;
    
    /** username */
    private java.lang.String username;
    
    /** roomtype */
    private java.lang.String roomtype;
    
    /** pdate */
    private java.util.Date pdate;
    
    public int getPno() {
        return this.pno;
    }
    
    public void setPno(int pno) {
        this.pno = pno;
    }
    
    public java.lang.String getUsername() {
        return this.username;
    }
    
    public void setUsername(java.lang.String username) {
        this.username = username;
    }
    
    public java.lang.String getRoomtype() {
        return this.roomtype;
    }
    
    public void setRoomtype(java.lang.String roomtype) {
        this.roomtype = roomtype;
    }
    
    public java.util.Date getPdate() {
        return this.pdate;
    }
    
    public void setPdate(java.util.Date pdate) {
        this.pdate = pdate;
    }
    
}
