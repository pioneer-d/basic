function Compare() {
	var RegExp = /^[a-zA-Z0-9]{4,12}$/; //id와 pwassword 유효성 검사 정규식
	var e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;  //이메일 유효성 검사 정규식
	var n_RegExp = /^[가-힣]{2,15}$/; //이름 유효성검사 정규식

	var jnumArr = new Array(); // 입력 한 주민번호 앞자리를 저장해줄 배열 선언
	var jnumArr2 = new Array(); //입력 한 주민번호 뒷자리를 저장해줄 배열 선언
	var jnumCal = [2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 1]; // 주민번호 계산할때 쓰이는 배열
	var jnumSum = 0; //주민번호 계산에 사용 될 값


	var objId = document.getElementById("id"); //아이디
	var objPwd = document.getElementById("pwd"); //비밀번호
	var objPwd2 = document.getElementById("pwd2"); //비밀번호확인
	var objEmail = document.getElementById("mail");//메일
	var objName = document.getElementById("name"); //이름
	var objNum = document.getElementById("num"); //주민번호앞 6
	var objNum2 = document.getElementById("num2"); //주민번호 뒷자리 7
	var objIntro = document.getElementById("introduce"); //자기소개

	// ---------------- ID 유효성검사 ---------------- //

	if (objId.value == '') {    //공백이면 objId.value값을 리턴하지 않는다
		alert("ID를 입력해주세요.");
		objId.focus();
		return false;
	}
	if (!RegExp.test(objId.value)) { //아이디 유효성검사  test는 대응되는 문자열이 있는지 검사하는 메소드
		alert("ID는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");
		return false;
	}

	// ---------------- PASSWORD 유효성검사 ----------------//
	if (objPwd.value == '') { // 비밀번호 입력여부 검사
		alert("Password를 입력해주세요.");
		objPwd.focus();
		return false;
	}
	if (!RegExp.test(objPwd.value)) { //패스워드 유효성검사
		alert("Password는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");
		objPwd.focus();
		return false;
	}
	if (objPwd.value == objId.value) { //패스워드와 ID가 동일한지 검사
		alert("Password는 ID와 동일하면 안됩니다.");
		objPwd.focus();
		return false;
	}

	if (objPwd2.value != objPwd.value) { //비밀번호와 비밀번호확인이 동일한지 검사
		alert("비밀번호가 틀립니다. 다시 확인하여 입력해주세요.");
		objPwd2.focus();
		return false;
	}

	// ---------------- email 유효성검사 ---------------- //
	if (e_RegExp.value == '') { // 이메일 입력여부 검사
		alert("이메일을 입력해주세요.");
		objEmail.focus();
		return false;
	}

	if (!e_RegExp.test(objEmail.value)) { //이메일 유효성 검사
		alert("올바른 이메일 형식이 아닙니다.");
		objEmail.focus();
		return false;
	}

	// ---------------- 이름 유효성검사 ---------------- //        
	if (objName.value == '') {
		alert("이름을 입력해주세요.");
		objName.focus();
		return false;
	}
	if (!n_RegExp.test(objName.value)) {
		alert("특수문자,영어,숫자는 사용할수 없습니다. 한글만 입력하여주세요.");
		objName.focus();
		return false;
	}


	// ---------------- 주민등록번호 유효성검사 ---------------- //
	if (objNum.value == "" || objNum2.value == "") { // 주민번호입력 형식이 알맞은지 검사 
		alert("주민번호 형식이 올바르지 않습니다.");
		objNum.focus();
		return false;
	}

	for (var i = 0; i < objNum.value.length; i++) { // 입력받은 주민번호 앞자리 jnumArr배열에 넣기  
		jnumArr[i] = objNum.value.charAt(i);
	}

	for (var i = 0; i < objNum2.value.length; i++) {		//입력받은 주민번호 뒷자리 jnumArr2배열에 넣기
		jnumArr2[i] = objNum2.value.charAt(i);
	}

	jnumArrAll = jnumArr.concat(jnumArr2);  //주민번호 총 자리		


	for (var i = 0; i < 12; i++) {
		jnumSum += jnumArrAll[i] * jnumCal[i];    //jnumplus배열과 입력한 주민번호 순서대로 하나씩 곱하여 jnumSum에 저장
	}

	jnumSum = (11 - (jnumSum % 11)); //jnumSum저장 값을 11로 나눈 나머지를 11로 뺀 값

	if (jnumSum != jnumArrAll[12]) { // 계산되서 나온 결과값(jnumSum)과 입력한 주민번호의 마지막이 맞지 않으면 
		alert("주민번호가 올바르지 않습니다."); //alert 창 띄우기

		return false;
	}

	var y = String(jnumArrAll[0]);	//생일자동완성 위한 변수선언
	var y1 = String(jnumArrAll[1]);
	var m = String(jnumArrAll[2]);
	var m1 = String(jnumArrAll[3]);
	var d = String(jnumArrAll[4]);
	var d1 = String(jnumArrAll[5]);
	var tmp = String(jnumArrAll[6]);


	if (tmp == '1' || tmp == '2') {  //생일 자동완성
		f.year.value = "19" + y + y1;
		f.mon.value = m + m1;
		f.day.value = d + d1;
	}
	else if (tmp == '3' || tmp == '4') {
		f.year.value = "20" + y + y1;
		f.month.value = m + m1;
		f.day.value = d + d1;
	}


	// ---------------- 자기소개란 공백시 알림 ---------------- //
	if (objIntro.value == "") {
		alert("자기소개 해주세요~")
		objIntro.focus();
		return false;
	} else { //형식이 올바르면 회원가입 완료 창 뜨기
		alert("수정이 완료 되었습니다")
		history.back();

	}
}