package egovframework.yuser.service;

/**
 * @Class Name : YuserVO.java
 * @Description : Yuser VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YuserVO extends YuserDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** userno */
    private int userno;
    
    /** userid */
    private java.lang.String userid;
    
    /** userpw */
    private java.lang.String userpw;
    
    /** username */
    private java.lang.String username;
    
    /** userphone */
    private java.lang.String userphone;
    
    /** useraddr */
    private java.lang.String useraddr;
    
    /** appendix */
    private java.lang.String appendix;
    
    /** admin */
    private java.lang.String admin;
    
    /** usergrade */
    private java.lang.String usergrade;
    
    /** userpoint */
    private int userpoint;
    
    /** departno */
    private int departno;
    
    /** roomno */
    private java.lang.String roomno;
    
    public int getUserno() {
        return this.userno;
    }
    
    public void setUserno(int userno) {
        this.userno = userno;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getUserpw() {
        return this.userpw;
    }
    
    public void setUserpw(java.lang.String userpw) {
        this.userpw = userpw;
    }
    
    public java.lang.String getUsername() {
        return this.username;
    }
    
    public void setUsername(java.lang.String username) {
        this.username = username;
    }
    
    public java.lang.String getUserphone() {
        return this.userphone;
    }
    
    public void setUserphone(java.lang.String userphone) {
        this.userphone = userphone;
    }
    
    public java.lang.String getUseraddr() {
        return this.useraddr;
    }
    
    public void setUseraddr(java.lang.String useraddr) {
        this.useraddr = useraddr;
    }
    
    public java.lang.String getAppendix() {
        return this.appendix;
    }
    
    public void setAppendix(java.lang.String appendix) {
        this.appendix = appendix;
    }
    
    public java.lang.String getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(java.lang.String admin) {
        this.admin = admin;
    }
    
    public java.lang.String getUsergrade() {
        return this.usergrade;
    }
    
    public void setUsergrade(java.lang.String usergrade) {
        this.usergrade = usergrade;
    }
    
    public int getUserpoint() {
        return this.userpoint;
    }
    
    public void setUserpoint(int userpoint) {
        this.userpoint = userpoint;
    }
    
    public int getDepartno() {
        return this.departno;
    }
    
    public void setDepartno(int departno) {
        this.departno = departno;
    }
    
    public java.lang.String getRoomno() {
        return this.roomno;
    }
    
    public void setRoomno(java.lang.String roomno) {
        this.roomno = roomno;
    }
    
}
