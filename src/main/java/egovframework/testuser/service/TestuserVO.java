package egovframework.testuser.service;

/**
 * @Class Name : TestuserVO.java
 * @Description : Testuser VO class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class TestuserVO extends TestuserDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** userid */
    private java.lang.String userid;
    
    /** userpw */
    private java.lang.String userpw;
    
    /** userphone */
    private java.lang.String userphone;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    public java.lang.String getUserphone() {
        return this.userphone;
    }
    
    public void setUserphone(java.lang.String userphone) {
        this.userphone = userphone;
    }
    
}
