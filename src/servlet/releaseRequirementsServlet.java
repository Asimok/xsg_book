package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import services.releaseRequirements;
import tools.tojson;

public class releaseRequirementsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        /*设置字符集为'UTF-8'*/
        request.setCharacterEncoding("UTF-8");
        System.out.println("连接成功反馈");// 测试是否成功连接
        StringBuffer json2 = new StringBuffer();// 字符流
        String line = null;
        BufferedReader reader = request.getReader();// 读取流
        while ((line = reader.readLine()) != null) {
            json2.append(line);// 接受的是JSON格式
        }

        System.out.println(json2);//得到的是JSON格式
        // 把得到的字符串封装为JSON，再获取里面的传过来的键值对

        JSONObject jsonObject = JSONObject.fromObject(json2.toString());
        /*通过键值对获取参数*/
        String user = jsonObject.getString("user");
        String telephone = jsonObject.getString("telephone");
        String province = jsonObject.getString("province");
        String city = jsonObject.getString("city");
        String xian = jsonObject.getString("xian");
        String detailedad = jsonObject.getString("detailedad");
        String bookclass = jsonObject.getString("bookclass");
        String booknum = jsonObject.getString("booknum");
        String suitage = jsonObject.getString("suitage");
        String bookname = jsonObject.getString("bookname");
        String detailbook = jsonObject.getString("detailbook");
       String sucess= releaseRequirements.addRequirement( user,  telephone,  province,
                 city,  xian,  detailedad,  bookclass,
                 booknum,  suitage,  bookname,detailbook);
       if(sucess.equals("0"))
       {
           response.setContentType("text/html;charset=utf-8");
           PrintWriter out = response.getWriter();
           //	          封装成JSON格式发送回客户端
           tojson<String, String> info_json = new tojson<>();
           info_json.put("Status", "0");
           out.write(info_json.toString());
           out.flush();
           out.close();
       }
       else
       {
           response.setContentType("text/html;charset=utf-8");
           PrintWriter out = response.getWriter();
           //	          封装成JSON格式发送回客户端
           tojson<String, String> info_json = new tojson<>();
           info_json.put("Status", "-1");
           out.write(info_json.toString());
           out.flush();
           out.close();
       }

    }


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        doPost(request, response);
    }
}