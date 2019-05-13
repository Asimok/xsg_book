package tools;

/*
 * ����ʼ��Ϸ���
 * 
 * */

public class emailChecker implements BaseFilter_Albert_Frank_Check {

	@Override
	public boolean doCheck(String sin) {
		
		if(sin.contains("'")||sin.contains("\"")||sin.contains(" ")||sin.contains("(")||sin.contains(")")||sin.contains("*"))
		{
	
			System.out.println(getClass().getName()+"error");
			System.out.println(sin+"    ����Ƿ����룬�����Ƿ�ע�����");
			return false;
		}
		// TODO Auto-generated method stub
		System.out.println(sin+"     ����Ϸ�");
		return true;
	}
	

}