package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.ConnDb;

public class releaseRequirements {

    //ע����Ϣ



    public static String addRequirement(String user, String telephone, String province,
                                String city, String xian, String detailedad, String bookclass,
                                String booknum, String suitage, String bookname) {


        String insql4 = "insert into requirements values ('" + user
                + "','" + telephone + "','" + province + "'," + city + ",'" + xian + ",'" + detailedad + ",'" + xian + ",'" + bookclass + ",'"
                + booknum + ",'" + suitage + ",'" + bookname + "')";
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
                System.out.println("1 ����ʧ�ܣ�  catch�׳�");
                return "-1";
            }

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("2 ����ʧ�ܣ�  catch�׳�");
            return "-1";
        }

    }

}
