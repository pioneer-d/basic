Day1

Tool설치

1. EditPlus : 에디터 (전용 개발툴)

2. XDBA : DB 쿼리 실행.

3. putty : 리눅스 운영체제에서 각종 명령어 실행 (서버관련)

4. Eclipse : java 파일 컴파일용.


** tomcat 의 구조. (WAS Web Applicatoin Server) 

1. bin : 서버 실행파일 (start,stop)
2. conf : 서버 설정관련 (포트,DB 연결)
    - server.xml : 포트,DB 세팅
    - context.xml : DB 세팅
3. logs : 각종 로그 확인 
4. webapps : 프로그램 폴더. (autoby)

    webapps
     - autoby
     - autovy2


**  리눅스 명령어

ls : 목록보기
cd 폴더명 : 해당 폴더 들어가기.

** 리눅스에서 tomcat 시작 및 재시작
1. ps -ef | grep 로그인아이디 프로세스 확인
2. 해당 프로세스 죽이기 kill -9 프로세스번호

** 리눅스에서 로그 확인  (Sysout확인 가능)
1. tomcat/logs들어가기
2. tail -f catalina.out



Day2
oracle에서 사용하는 명령어?

 --1. 변수 대입 출력
 DECLARE
        TEST1 NUMBER;
 BEGIN
        DBMS_OUTPUT.PUT_LINE(TEST1);
        TEST1 := 10;
        DBMS_OUTPUT.PUT_LINE(TEST1);
        TEST1 := TEST1+10;
        DBMS_OUTPUT.PUT_LINE(TEST1);
 END;


 --2. 변수 기본값 설정 및 대입
 DECLARE
        TEST1 NUMBER DEFAULT 5;
 BEGIN
      DBMS_OUTPUT.PUT_LINE(TEST1);
      TEST1 := 10;
      DBMS_OUTPUT.PUT_LINE(TEST1);
      TEST1 := TEST1+10;
      DBMS_OUTPUT.PUT_LINE(TEST1);
 END;


 --3. TEST1값에 따른 구분 출력(IF/END IF)
 DECLARE
        TEST1 NUMBER DEFAULT 5;
 BEGIN
      DBMS_OUTPUT.PUT_LINE(TEST1);
      IF TEST1 = 5 THEN
         DBMS_OUTPUT.PUT_LINE('TEST1은 5 입니다');
      END IF;
 END;
 
 
 --4 TEST1값에 따른 구분 출력2(IF/ELSE/END IF)
 DECLARE
        TEST1 NUMBER DEFAULT 10;
 BEGIN
      DBMS_OUTPUT.PUT_LINE(TEST1);
      IF TEST1 = 5 THEN
         DBMS_OUTPUT.PUT_LINE('TEST1은 5입니다');
      ELSE
          DBMS_OUTPUT.PUT_LINE('TEST1은 5가 아닙니다');
      END IF;
 END;
 
 
 --5 TEST1값 복수 조건에 따른 구분 출력(IF/ELSIF/ELSE)
DECLARE
       TEST1 NUMBER DEFAULT 15;
BEGIN
     IF TEST1 < 10 THEN
        DBMS_OUTPUT.PUT_LINE('TEST1은 10보다 작다');
     ELSIF TEST1 < 20 THEN
        DBMS_OUTPUT.PUT_LINE('TEST1은 20보다 작다');
     ELSIF TEST1 < 30 THEN
        DBMS_OUTPUT.PUT_LINE('TEST1은 30보다 작다');
     END IF;
END;










