package servlet;
/*ע��Servlet*/
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
    String isError;//isError �жϳ�����Ϣ
    @Override
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

        String Password = tomd5.tomd5(jsonObject.getString("mima"));//����MD5����   MD5����
        String Name =  jsonObject.getString("Name");  //Unicode���������ַ�
        String Sex = jsonObject.getString("Sex");//��ȡ�Ա�
        String PhoneNumber = jsonObject.getString("PhoneNumber");//��ȡ�绰��
        String Email = jsonObject.getString("Email");//��ȡ����

        /*��Ա���Ž�������ע���쳣���*/
        FilterManage check1 = new FilterManage();
        check1.addChecker(new EmployeeNumberChecker());

            //���Ա���źϷ�



                //����ע��  "status":"0" ���ظ��ͻ��˽���
                //	isError �жϳ�����Ϣ
                isError = Regist.Regist(Password,Name,Sex,PhoneNumber,Email);
                //����Regist�෽��  ע��
                if(isError.trim().toString().equals("ע��ɹ�"))
                {
                    //���ע��ɹ�
                    System.out.println("д��ɹ�");
                    PrintWriter out = response.getWriter();
                    String  info_json  = "{\"status\":\"0\"}";//�ɹ�����0
                    System.out.println(info_json);
                    out.write(info_json);
                    out.flush();
                    out.close();
                }


                else

                {
                    //Ա������ע��
                    response.setContentType("text/html;charset=utf-8");
                    PrintWriter out = response.getWriter();
//               ��װ��JSON��ʽ���ͻؿͻ���
                    String  info_json  = "{\"status\":\"-1\"}";//ע��ʧ�ܣ�
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