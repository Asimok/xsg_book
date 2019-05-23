package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnDb;

public class main_interface {
    public static List<requirements_info> selectallinfo() {


        String sql = "select * from requirements ";
        System.out.println(sql);
        //查询该账户信息
        ConnDb connDb = new ConnDb();
        try {
//            执行SQL语句
            PreparedStatement ps = connDb.conn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<requirements_info> info=new ArrayList<requirements_info>();


                while(rs.next()) {
                    requirements_info rsmeg= new requirements_info();
                    String user         = rs.getString("user");
                    String telephone    = rs.getString("telephone");
                    String province     = rs.getString("province");
                    String city         = rs.getString("city");
                    String xian         = rs.getString("xian");
                    String detailedad = rs.getString("detailedad");
                    String bookclass = rs.getString("bookclass");
                    String booknum   = rs.getString("booknum");
                    String suitage   = rs.getString("suitage");
                    String bookname   = rs.getString("bookname");
                    String detailbook = rs.getString("detailbook");

                    rsmeg.setUser           (user);
                    rsmeg.setTelephone (telephone);
                    rsmeg.setProvince       (province);
                    rsmeg.setCity           (city);
                    rsmeg.setXian           (xian);
                    rsmeg.setDetailedad          (detailedad);
                    rsmeg.setBookclass      (bookclass );
                    rsmeg.setBooknum        (booknum   );
                    rsmeg.setSuitage        (suitage   );
                    rsmeg.setBookname       (bookname  );
                    rsmeg.setDetailbook     (detailbook);

                    info.add(rsmeg);


            }

            ps.close();
            System.out.println("info  "+info.get(0).getCity());
           return info;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("执行SQL语句出错！");
        }
        return null;
    }


    public static List<requirements_info> selectallinfo_1() {
        ArrayList<requirements_info> info=new ArrayList<requirements_info>();
                requirements_info rsmeg= new requirements_info();
                rsmeg.setUser      ("-1");
                rsmeg.setTelephone ("-1");
                rsmeg.setProvince  ("-1");
                rsmeg.setCity      ("-1");
                rsmeg.setXian      ("-1");
                rsmeg.setDetailedad("-1");
                rsmeg.setBookclass ("-1");
                rsmeg.setBooknum   ("-1");
                rsmeg.setSuitage   ("-1");
                rsmeg.setBookname  ("-1");
                rsmeg.setDetailbook("-1");
                info.add(rsmeg);

 return info;
    }
}
