package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import admin.db.AdminDAO;
import admin.db.ThemaBean;

public class ThemaAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao=new AdminDAO();
		ThemaBean themadata=new ThemaBean();
	   	ActionForward forward=new ActionForward();
	   	
		String realFolder="";
   		String saveFolder="themaUpload";
   		
   		int fileSize=5*1024*1024;
   		
   		realFolder=request.getRealPath(saveFolder);
	   	
   		boolean result=false;
   		
		MultipartRequest multi=null;
			multi=new MultipartRequest(request,realFolder,fileSize,"UTF-8",
   					new DefaultFileRenamePolicy());

   		
   		themadata.setROOMNUM(Integer.parseInt(multi.getParameter("ROOMNUM")));	//Bean�� ���� ����
   		themadata.setROOMNAME(multi.getParameter("ROOMNAME"));
   		themadata.setROOMLEVEL(Integer.parseInt(multi.getParameter("ROOMLEVEL")));
   		themadata.setROOMTIME(Integer.parseInt(multi.getParameter("ROOMTIME")));
   		themadata.setROOMPHOTO(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
   		themadata.setROOMINTRO(multi.getParameter("ROOMINTRO"));
   		themadata.setROOMRESERVETIME(multi.getParameter("ROOMRESERVETIME"));
   		
   		result=admindao.ThemaInsert(themadata);	//DB�� �Է�
	   	
   		if(result==false){
   			System.out.println("��� ����");
   			return null;
   		}
   		System.out.println("��� �Ϸ�");
	   	
   		forward.setRedirect(true);
   		forward.setPath("./Admin.ad");
   		return forward;
	}

}
