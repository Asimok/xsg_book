package services;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.ConnDb;

public class Regist {

    public static String Regist(String Password, String Name, String Sex,
                                         String PhoneNumber, String Email) {


        String insql4 = "insert into user values ('" + Name
                + "','" + Password + "','" + PhoneNumber + "'," + Email + ",'" + Sex
                + "','" + System.currentTimeMillis() + "')";
        System.out.println(insql4);
        ConnDb connDb1 = new ConnDb();
        try {


            PreparedStatement ps1 = connDb1.conn().prepareStatement(insql4);
            int rs1 = ps1.executeUpdate();
            if (rs1 == 1) {
                ps1.close();
                return "0";
            } else {
                ps1.close();
                System.out.println("1 注册失败！  catch抛出");
                return "-1";
            }

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("2 注册失败！  catch抛出");
            return "-1";
        }

    }


}


	

