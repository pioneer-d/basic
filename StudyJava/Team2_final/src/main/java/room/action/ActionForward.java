package room.action;

public class ActionForward {			//���۹���� �����ϴ� Ŭ���� forward or redirect
	
	private boolean isRedirect=false;	//��ۺ���.�갡 true�� forward��!
	private String path=null;			//forward�� redirect�� �������� �̵��ϹǷ�, �̵��� ������ �ּҸ� ��� ����.
	
	public boolean isRedirect(){
		return isRedirect;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setRedirect(boolean b){
		isRedirect=b;
	}
	
	public void setPath(String string){
		path=string;
	}
}