package servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Login;
import services.main_interface;
import services.mine;
import services.requirements_info;
import tools.tojson;
import tools.tomd5;

/*
 * 登录 servlet
 *
 * */
public class main_interfaceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        System.out.println("连接成功反馈  LoginServlet");// 测试是否成功连接
        response.setContentType("text/html;charset=utf-8");
        /*设置字符集为'UTF-8'*/
        request.setCharacterEncoding("utf-8");
        System.out.println("连接成功反馈  LoginServlet");// 测试是否成功连接

        List<requirements_info> infos= main_interface.selectallinfo();

        if(!(null == infos || infos.size() ==0 )) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            //	          封装成JSON格式发送回客户端
            JSONArray jsonArray=JSONArray.fromObject(infos);
            String data1=jsonArray.toString();
            System.out.println("这里的data1    "+data1);

            net.sf.json.JSONArray json=net.sf.json.JSONArray.fromObject(data1);
            if(json.size()>0){
                for(int i=0;i<json.size();i++){
                    // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                    net.sf.json.JSONObject jsonObj = json.getJSONObject(i);

                }}
            out.write(data1);
            out.flush();
            out.close();
        }
        else
        {
            List<requirements_info> infos1=main_interface.selectallinfo_1();
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            //	          封装成JSON格式发送回客户端

            JSONArray jsonArray=JSONArray.fromObject(infos1);
            String data1=jsonArray.toString();
            System.out.println("这里的data1    "+data1);

            net.sf.json.JSONArray json=net.sf.json.JSONArray.fromObject(data1);
            if(json.size()>0){
                for(int i=0;i<json.size();i++){
                    // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                    net.sf.json.JSONObject jsonObj = json.getJSONObject(i);

                }}
            out.write(data1);
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