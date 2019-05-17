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

        response.setContentType("text/html;charset=utf-8");
        /*�����ַ���Ϊ'UTF-8'*/
        request.setCharacterEncoding("utf-8");
        System.out.println("���ӳɹ�����");// �����Ƿ�ɹ�����
        StringBuffer json2 = new StringBuffer();// �ַ���
        String line = null;
        BufferedReader reader = request.getReader();// ��ȡ��
        while ((line = reader.readLine()) != null) {
            json2.append(line);// ���ܵ���JSON��ʽ
        }

        System.out.println(json2);//�õ�����JSON��ʽ
        // �ѵõ����ַ�����װΪJSON���ٻ�ȡ����Ĵ������ļ�ֵ��

        JSONObject jsonObject = JSONObject.fromObject(json2.toString());
        /*ͨ����ֵ�Ի�ȡ����*/
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

       String sucess= releaseRequirements.addRequirement( user,  telephone,  province,
                 city,  xian,  detailedad,  bookclass,
                 booknum,  suitage,  bookname);
       if(sucess.equals("0"))
       {
           response.setContentType("text/html;charset=utf-8");
           PrintWriter out = response.getWriter();
           //	          ��װ��JSON��ʽ���ͻؿͻ���
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
           //	          ��װ��JSON��ʽ���ͻؿͻ���
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