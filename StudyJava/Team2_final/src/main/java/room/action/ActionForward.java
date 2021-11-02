package room.action;

public class ActionForward {			//전송방식을 결정하는 클래스 forward or redirect
	
	private boolean isRedirect=false;	//토글변수.얘가 true면 forward로!
	private String path=null;			//forward든 redirect든 페이지는 이동하므로, 이동할 페이지 주소를 담는 변수.
	
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