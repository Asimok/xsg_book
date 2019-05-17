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
 * ��¼ servlet
 *
 * */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        /*�����ַ���Ϊ'UTF-8'*/
        request.setCharacterEncoding("utf-8");
        System.out.println("���ӳɹ�����  LoginServlet");// �����Ƿ�ɹ�����
        StringBuffer json1 = new StringBuffer();// �ַ���
        String line = null;
        BufferedReader reader = request.getReader();// ��ȡ��
        while ((line = reader.readLine()) != null) {
            json1.append(line);// ���ܵ���JSON��ʽ
        }

        System.out.println("�����" + json1);//�õ�����JSON��ʽ

        JSONObject jsonObject = JSONObject.fromObject(json1.toString());
        String zhanghu = jsonObject.getString("zhanghu");//��ȡJson��ֵ��
        String mima = tomd5.tomd5(jsonObject.getString("mima"));//���������MD5����

        System.out.println("������˻� " + zhanghu);//����˻������롢Token������鿴
        System.out.println("��������� " + mima);


        /*���˻���������ע���쳣���*/


        boolean in = Login.selectNumberin(zhanghu);
        if (in) {
            String Password = Login.selectNumber(zhanghu);//����login�෽����ѯ�û�����

            if (Password.equals(mima)) {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
//	          ��װ��JSON��ʽ���ͻؿͻ���
                tojson<String, String> info_json = new tojson<>();
                info_json.put("Status", "0");

                System.out.println("��½�ɹ�  " + info_json.toString());
                out.write(info_json.toString());

                out.flush();
                out.close();
            } else {
                //����������
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
//	          ��װ��JSON��ʽ���ͻؿͻ���       
                tojson<String, String> info_json = new tojson<>();
                info_json.put("Status", "-1");

                System.out.println("1  " + info_json.toString());
                out.write(info_json.toString());

                out.flush();
                out.close();

            }

        } else {
            //�˻�������
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            //	          ��װ��JSON��ʽ���ͻؿͻ���
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