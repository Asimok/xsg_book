package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnDb;
import tools.tojson;

public class mine {
    public static List<requirements_info> selectinfo(String user1, String tel) {


        String sql = "select * from requirements  where  user = '" + user1 + "' and telephone ='"+tel+"'";
        System.out.println(sql);
        //查询该账户信息
        ConnDb connDb = new ConnDb();
        try {
//            执行SQL语句
            PreparedStatement ps = connDb.conn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<requirements_info> info=new ArrayList<requirements_info>();
            if (rs.next()) {
                while(rs.next()) {
                    requirements_info rsmeg= new requirements_info();
                    String user = rs.getString("user");
                    String telephone = rs.getString("telephone");
                    String province = rs.getString("province");
                    String city = rs.getString("city");
                    String xian = rs.getString("xian");
                    String detailedad = rs.getString("detailedad");
                    String bookclass = rs.getString("bookclass");
                    String booknum   = rs.getString("booknum");
                    String suitage   = rs.getString("suitage");
                    String bookname   = rs.getString("bookname");
                    String detailbook = rs.getString("detailbook");

                    rsmeg.setUser(user);
                    rsmeg.setTelephone(telephone);
                    rsmeg.setUser(province);
                    rsmeg.setUser(city);
                    rsmeg.setUser(xian);
                    rsmeg.setUser(detailedad);
                    rsmeg.setUser(bookclass );
                    rsmeg.setUser(booknum   );
                    rsmeg.setUser(suitage   );
                    rsmeg.setUser(bookname  );
                    rsmeg.setUser(detailbook);

                    info.add(rsmeg);

//                    tojson<String, String> info_json = new tojson<>();
//                    info_json.put("user", user);
//                    info_json.put("telephone", telephone);
//                    info_json.put("province", province);
//                    info_json.put("city", city);
//                    info_json.put("xian", xian);
//                    info_json.put("detailedad", detailedad);
//                    info_json.put("bookclass", bookclass);
//                    info_json.put("booknum", booknum);
//                    info_json.put("suitage", suitage);
//                    info_json.put("bookname", bookname);
//                    info_json.put("detailbook", detailbook);

                }
            }
            else
            {
                requirements_info rsmeg= new requirements_info();
                rsmeg.setUser("-1");
                rsmeg.setTelephone("-1");
                rsmeg.setUser("-1");
                rsmeg.setUser("-1");
                rsmeg.setUser("-1");
                rsmeg.setUser("-1");
                rsmeg.setUser("-1");
                rsmeg.setUser("-1");
                rsmeg.setUser("-1");
                rsmeg.setUser("-1");
                rsmeg.setUser("-1");
                info.add(rsmeg);
            }
            ps.close();
           return info;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("执行SQL语句出错！");
        }
        return null;
    }
}
