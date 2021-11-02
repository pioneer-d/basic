<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function Compare(){
    var ROOMNUM = document.getElementById("ROOMNUM"); 
    var ROOMNAME = document.getElementById("ROOMNAME"); 
    var ROOMLEVEL = document.getElementById("ROOMLEVEL"); 
    var ROOMTIME = document.getElementById("ROOMTIME");
    var ROOMPHOTO = document.getElementById("ROOMPHOTO");
    var ROOMINTRO = document.getElementById("ROOMINTRO");    
    var ROOMRESERVETIME = document.getElementById("ROOMRESERVETIME");    
    
    if(ROOMNUM.value==''){    //공백검사
        alert("방코드를 입력해주세요.");
        ROOMNUM.focus();
        return false;
    }
    if(ROOMNAME.value==''){    //공백검사
        alert("이름을 입력해주세요.");
        ROOMNAME.focus();
        return false;
    }
    if(ROOMLEVEL.value==''){    //공백검사
        alert("난이도를 입력해주세요.");
        ROOMLEVEL.focus();
        return false;
    }
    if(ROOMTIME.value==''){    //공백검사
        alert("시간을 입력해주세요.");
        ROOMTIME.focus();
        return false;
    }
    if(ROOMPHOTO.value==''){    //공백검사
        alert("사진을 입력해주세요.");
        ROOMPHOTO.focus();
        return false;
    }
    if(ROOMINTRO.value==''){    //공백검사
        alert("사진을 입력해주세요.");
        ROOMINTRO.focus();
        return false;
    }
    if(ROOMRESERVETIME.value==''){    //공백검사
        alert("사진을 입력해주세요.");
        ROOMRESERVETIME.focus();
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
	<form onsubmit="return Compare();" action="./ThemaAddAction.ad"
			enctype="multipart/form-data"  method="post">
		<table width="50%" height="80" border="1" align="center"
			cellpadding="5" cellspacing="0" bordercolor="lightgrey">
			<tr align="center">
				<td colspan="2" align="center" bgcolor="#339999">
					<div style="font-weight: bold; font-size: 18px">Thema 추가</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
					<div style="font-weight: bold;">방코드:</div>
				</td>
				<td><input type="text" name="ROOMNUM" id = "ROOMNUM"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
					<div style="font-weight: bold;">테마이름:</div>
				</td>
				<td><input type="text" name="ROOMNAME" id = "ROOMNAME"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">난이도:</div></td>
				<td><input type="text" name="ROOMLEVEL" id = "ROOMLEVEL"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">진행시간:</div></td>
				<td><input type="text" name="ROOMTIME" id = "ROOMTIME"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">테마사진:</div></td>
				<td><input type="file" name="ROOMPHOTO" id = "ROOMPHOTO"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">테마설명:</div></td>
				<td><textarea rows="5" cols="50" name="ROOMINTRO" id = "ROOMINTRO"></textarea>
				<!-- input type="text" --></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">예약가능시간:</div></td>
				<td><input type="text" name="ROOMRESERVETIME" id = "ROOMRESERVETIME" size="50"></td>
			</tr>			
		</table>
		<p align=center>
			<input type="submit" value="등록하기">
		</p>
	</form>
	<p align=center>
		<a href="javascript:window.history.back();">뒤로가기</a>
	</p>