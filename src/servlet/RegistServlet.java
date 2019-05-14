package servlet;
/*注册Servlet*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import services.Regist;
import tools.EmployeeNumberChecker;
import tools.FilterManage;
import tools.tomd5;

public class RegistServlet extends HttpServlet {
    String isError;//isError 判断出错信息
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        /*设置字符集为'UTF-8'*/
        request.setCharacterEncoding("utf-8");
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

        String Password = tomd5.tomd5(jsonObject.getString("mima"));//生成MD5编码   MD5加密
        String Name =  jsonObject.getString("Name");  //Unicode解码中文字符
        String Sex = jsonObject.getString("Sex");//获取性别
        String PhoneNumber = jsonObject.getString("PhoneNumber");//获取电话号
        String Email = jsonObject.getString("Email");//获取邮箱

        /*对员工号进行命令注入异常检测*/
        FilterManage check1 = new FilterManage();
        check1.addChecker(new EmployeeNumberChecker());

            //如果员工号合法



                //可以注册  "status":"0" 返回给客户端解析
                //	isError 判断出错信息
                isError = Regist.Regist(Password,Name,Sex,PhoneNumber,Email);
                //调用Regist类方法  注册
                if(isError.trim().toString().equals("注册成功"))
                {
                    //如果注册成功
                    System.out.println("写入成功");
                    PrintWriter out = response.getWriter();
                    String  info_json  = "{\"status\":\"0\"}";//成功返回0
                    System.out.println(info_json);
                    out.write(info_json);
                    out.flush();
                    out.close();
                }


                else

                {
                    //员工号已注册
                    response.setContentType("text/html;charset=utf-8");
                    PrintWriter out = response.getWriter();
//               封装成JSON格式发送回客户端
                    String  info_json  = "{\"status\":\"-1\"}";//注册失败！
                    System.out.println(info_json);
                    out.write(info_json);
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