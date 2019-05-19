package servlet;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Login;
import tools.tojson;
import tools.tomd5;

/*
 * 登录 servlet
 *
 * */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        /*设置字符集为'UTF-8'*/
        request.setCharacterEncoding("utf-8");
        System.out.println("连接成功反馈  LoginServlet");// 测试是否成功连接
        StringBuffer json1 = new StringBuffer();// 字符流
        String line = null;
        BufferedReader reader = request.getReader();// 读取流
        while ((line = reader.readLine()) != null) {
            json1.append(line);// 接受的是JSON格式
        }

        System.out.println("传入的" + json1);//得到的是JSON格式

        JSONObject jsonObject = JSONObject.fromObject(json1.toString());
        String zhanghu = jsonObject.getString("zhanghu");//获取Json键值对
        String mima = tomd5.tomd5(jsonObject.getString("mima"));//对密码就行MD5加密

        System.out.println("传入的账户 " + zhanghu);//输出账户、密码、Token，方便查看
        System.out.println("传入的密码 " + mima);


        /*对账户进行命令注入异常检测*/


        boolean in = Login.selectNumberin(zhanghu);
        if (in) {
            String Password = Login.selectNumber(zhanghu);//调用login类方法查询用户密码

            if (Password.equals(mima)) {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
//	          封装成JSON格式发送回客户端
                tojson<String, String> info_json = new tojson<>();
                info_json.put("Status", "0");

                System.out.println("登陆成功  " + info_json.toString());
                out.write(info_json.toString());

                out.flush();
                out.close();
            } else {
                //如果密码错误
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
//	          封装成JSON格式发送回客户端       
                tojson<String, String> info_json = new tojson<>();
                info_json.put("Status", "-1");

                System.out.println("1  " + info_json.toString());
                out.write(info_json.toString());

                out.flush();
                out.close();

            }

        } else {
            //账户不存在
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            //	          封装成JSON格式发送回客户端
            tojson<String, String> info_json = new tojson<>();
            info_json.put("Status", "-2");
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