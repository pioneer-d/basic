package admin.action;

import javax.servlet.http.*;

public interface Action {
	
	public ActionForward execute(HttpServletRequest request,
			   HttpServletResponse response) throws Exception;	  
		/*
	    * �߻�޼ҵ�
	    * ������ �ϰ��ǰ� ����ϱ� ���� (get, post)
	    * throws �� ����ó��
	    * Action�� Ŭ������ ������
	    * � ���(action)�̴� ���� ���۹�İ� URI�� �Ѿ���ϹǷ� ActionForward�� ����Ÿ���̴�.
	    */
}
