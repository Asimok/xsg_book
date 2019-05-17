package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConnDb;

/*
 * selectNumber(String number) 通过账号查数据库密码
 * InsertToken(String zhanghu,String Token)  插入账户 token
 * UpdateToken(String zhanghu,String Token) 通过账户更新 token
 * selectadminpower(String number) 通过账户查权限
 * selectNumberin(String number)  判断账户是否存在
 *
 * */
public class Login {

    public static String selectNumber(String number) {
        String Number = null;
        String Password = null;
        String sql = "select * from user  where  user = '" + number + "'";
        //查询该账户信息
        ConnDb connDb = new ConnDb();
        try {
//            执行SQL语句
            PreparedStatement ps = connDb.conn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Number = rs.getString("user");
                Password = rs.getString("password");
                System.out.println("  password " + Password);
                //获取账号密码
                ps.close();
                return Password;//返回正确密码
            } else {
                ps.close();
                return null;//没有此人信息。提示未注册
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("执行SQL语句出错！");
        }
        return null;
    }

    public static boolean selectNumberin(String number) {

        String sql = "select * from user  where  user = '" + number + "'";
        //查询该账户信息
        ConnDb connDb = new ConnDb();
        try {
//            执行SQL语句
            PreparedStatement ps = connDb.conn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                return true;
            } else {
                ps.close();
                return false;//没有此人信息。提示未注册
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("执行SQL语句出错！");
        }
        return false;
    }


}