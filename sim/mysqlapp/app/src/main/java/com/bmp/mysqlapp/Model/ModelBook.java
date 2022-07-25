package com.bmp.mysqlapp.Model;
import com.bmp.mysqlapp.DB.ActionDB;

import java.sql.*;
public class ModelBook implements ActionDB {
    private String bid;
    private String bname;
    private int price;
    private int page;
    Connection c;

    public ModelBook(Connection c) {
        this.c = c;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public ResultSet SelectData() throws Exception {
        String sql="select * from tbbook";
        ResultSet rs =c.createStatement().executeQuery(sql);
        return rs;



    }

    @Override
    public int InsertData() throws Exception {
        String sql="Insert into tbbook(bid,name,price,page) values(?,?,?,?)";
        PreparedStatement psm =c.prepareStatement(sql);
        psm.setString(1,bid);
        psm.setString(2,bname);
        psm.setInt(3,price);
        psm.setInt(4,page);
        return psm.executeUpdate();
    }

    @Override
    public int UpdateData() throws Exception {
        return 0;
    }

    @Override
    public int DeleteData() throws Exception {
        return 0;
    }
}
