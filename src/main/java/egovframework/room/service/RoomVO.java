package egovframework.room.service;

/**
 * @Class Name : RoomVO.java
 * @Description : Room VO class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-05-15
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RoomVO extends RoomDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** num */
    private int num;
    
    private String floor;
    
    /** state */
    private java.lang.String state;
    
    /** row */
    private java.lang.String row;
    
    /** col */
    private java.lang.String col;
    
    /** people */
    private int people;
    
    private java.lang.String userone;
    private java.lang.String usertwo;
    private java.lang.String roomno;
    public int getNum() {
        return this.num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public java.lang.String getState() {
        return this.state;
    }
    
    public void setState(java.lang.String state) {
        this.state = state;
    }
    
    public java.lang.String getRow() {
        return this.row;
    }
    
    public void setRow(java.lang.String row) {
        this.row = row;
    }
    
    public java.lang.String getCol() {
        return this.col;
    }
    
    public void setCol(java.lang.String col) {
        this.col = col;
    }
    public java.lang.String getUserone() {
        return this.userone;
    }
    
    public void setUserone(java.lang.String userone) {
        this.userone = userone;
    }
    public java.lang.String getUsertwo() {
        return this.usertwo;
    }
    
    public void setUsertwo(java.lang.String usertwo) {
        this.usertwo = usertwo;
    }
    public java.lang.String getRoomno() {
        return this.roomno;
    }
    
    public void setRoomno(java.lang.String roomno) {
        this.roomno = roomno;
    }
    
    public int getPeople() {
        return this.people;
    }
    
    public void setPeople(int people) {
        this.people = people;
    }
    public void setFloor(String floor) {
    	this.floor = floor;
    }
    public String getFloor() {
        return floor;
    }
    
}
