package services;

/*  进行员工注册

 *  selectPosition(String number)   通过员工号从allinfo表中查询对应职位
 *  Regist()  将合理注册信息插入数据库 admininfo表
 *  searchZH1(String number)  判断通过传入的某员工号是否可以查询到该员工
 *
 * */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConnDb;

public class Regist {



    //注册信息
    public static String Regist(String Password, String Name, String Sex,
                                String PhoneNumber,String Email) {


        String insql4 = "insert into user values ('"+Name
                +"','"+Password+"','"+PhoneNumber+"',"+Email+",'"+Sex
                +"','"+System.currentTimeMillis()+"')";
        System.out.println(insql4);
        ConnDb connDb1 = new ConnDb();
        try {


                PreparedStatement ps1 =  connDb1.conn().prepareStatement(insql4);
                int rs1 =  ps1.executeUpdate();
                if(rs1==1)
                {
                    ps1.close();
                    return "注册成功";
                }
                else
                {
                    ps1.close();
                    return "该员工号已注册！";
                }

        }
        catch (SQLException e) {

            e.printStackTrace();
            System.out.println("该员工号已注册！  catch抛出");
            return "该员工号已注册！";
        }

    }


}


	

