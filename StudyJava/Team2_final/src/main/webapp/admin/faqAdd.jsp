<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function Compare(){
    var FAQ_NUM = document.getElementById("FAQ_NUM"); 
    var FAQ_TITLE = document.getElementById("FAQ_TITLE"); 
    var FAQ_CONTENT = document.getElementById("FAQ_CONTENT"); 
    
    if(FAQ_NUM.value==''){    //공백검사
        alert("게시물번호를 입력해주세요.");
        FAQ_NUM.focus();
        return false;
    }
    if(FAQ_TITLE.value==''){    //공백검사
        alert("제목을 입력해주세요.");
        FAQ_TITLE.focus();
        return false;
    }
    if(FAQ_CONTENT.value==''){    //공백검사
        alert("내용을 입력해주세요.");
        FAQ_CONTENT.focus();
        return false;
    }

    else{ //형식이 올바르면
        alert("등록이 완료 되었습니다")
        history.back();
    	
    }
}
</script>
</head>
<body>
	<form onsubmit="return Compare();" action = "./FaqAddAction.ad">
	<table width="50%" height="80" border="1" align="center"
		cellpadding="5" cellspacing="0" bordercolor="lightgrey">
		<tr align="center">
			<td colspan="2" align="center" bgcolor="#339999">
				<div style="font-weight: bold; font-size: 18px">FAQ 추가</div>
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">게시물번호:</div>
			</td>
			<td><input type = "text" name = "FAQ_NUM" id = "FAQ_NUM">
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">제목:</div>
			</td>
			<td><textarea rows="5" cols="50" name = "FAQ_TITLE" id = "FAQ_TITLE"></textarea>
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center">
			<div style="font-weight: bold;">내용:</div></td>
			<td><textarea rows="5" cols="50" name = "FAQ_CONTENT" id = "FAQ_CONTENT"></textarea>
			</td>
		</tr>

	</table>
	<p align = center><input type = "submit" value = "등록하기"></p>
	</form>
	<p align = center><a href="javascript:window.history.back();">뒤로가기</a></p>
</body>
</html>