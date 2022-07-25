package com.example.mysql;
import java.sql.*;
public class ModelFriend implements ActionDB {
    private String id;
    private String name;
    private String surname;
    private  String tel;

    Connection c;

    public ModelFriend(Connection c) {
        this.c = c;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public ResultSet SelectData() throws Exception {
        String sql ="select * from tb_friends";
        ResultSet rs = c.createStatement().executeQuery(sql);

        return rs;
    }
    public ResultSet selectDataById() throws Exception{
        String sql = "select * from tb_friends where id =?";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1,id);
        ResultSet rs = stm.executeQuery();
        return rs;
    }

    @Override
    public int InsertData() throws Exception {
        String sql = "insert into tb_friends(fname,fsurname,tel) values(?,?,?)";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1,name);
        stm.setString(2,surname);
        stm.setString(3,tel);
        int r = stm.executeUpdate();
        return r;
    }

    @Override
    public int UpdateData() throws Exception {
        String sql = "update tb_friends set fname=?,fsurname=?,tel=? where id =?";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1,name);
        stm.setString(2,surname);
        stm.setString(3,tel);
        stm.setString(4,id);
        int r = stm.executeUpdate();
        return r;
    }

    @Override
    public int DeleteData() throws Exception {
        String sql = "Delete from tb_friends where id =?";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1,id);
        int r = stm.executeUpdate();
        return r;
    }
}
