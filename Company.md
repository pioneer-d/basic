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


Day3

게시판 중 검색기능에 필요한 함수
오라클의 like % 함수 - 검색어와 비슷하거나 해당 검색어로 select한다.
ex) SELECT  ID, USERNAME, HOBBY, STATUS FROM  TESTMAIN  WHERE USERNAME like '%aa%';


Day4

오라클 명령어를 공부하는 이유 -  DB데이터 가공을 java가 아닌 oracle에서 하고 오면 부하도 덜하고 빠르다.

오늘도 Oracle명령어 공부.

--SELECT INTO 예시1     SELECT A INTO B = A를 추출해 B에 입력
DECLARE
       TESTDATE VARCHAR2(50) DEFAULT '20170101';
BEGIN
     DBMS_OUTPUT.PUT_LINE(TESTDATE);
     SELECT EX_DATE INTO TESTDATE FROM TB_EXCESS_CAPS_DATA WHERE EX_DATE ='20170310' AND EX_USERNM = '정재욱';
     DBMS_OUTPUT.PUT_LINE(TESTDATE);
END;


--SELECT INTO 예시2                 ||'|'||가 마치 JAVA의 +인듯?
DECLARE
       TESTDATE VARCHAR2(50) DEFAULT '20170101';
       TESTUSER VARCHAR2(50) DEFAULT '홍길동';
       TESTSTARTTIME VARCHAR2(50) DEFAULT '09:00';
BEGIN
     DBMS_OUTPUT.PUT_LINE(TESTDATE||'|'||TESTUSER||'|'||TESTSTARTTIME);
     SELECT EX_DATE, EX_USERNM, EX_START_TIME2 INTO TESTDATE, TESTUSER, TESTSTARTTIME FROM TB_EXCESS_CAPS_DATA
     WHERE EX_DATE='20170310' AND EX_USERNM='정재욱';
     DBMS_OUTPUT.PUT_LINE(TESTDATE||'|'||TESTUSER||'|'||TESTSTARTTIME);
END;



--프로시저

--프로시저 선언  
--CREATE OR REPLACE PROCEDURE[프로시저명](정의부)
--IS(선언부)
--BEGIN(실행부)
--EXCEPTION(예외처리부)
--END[프로시저명];


--샘플 프로시저 생성
CREATE OR REPLACE PROCEDURE SAMPLE_JW1
IS
  TEST1 NUMBER := 10;
BEGIN
     DBMS_OUTPUT.PUT_LINE(TEST1);
     TEST1 := TEST1+100;
     DBMS_OUTPUT.PUT_LUNE(TEST1);
END SAMPLE_JW1;


--샘플 프로시저 실행
BEGIN [SAMPLE_JW1]; END;



Day5

IP와 port에 관하여

IP - 기기가 인터넷에 접속한 곳의 네트워크상의 위치
0~255까지의 숫자가 올 수 있으며 000.000.000.000 이랑 형태이다.
이 형태는 IPv4형식이라고 한다.

이 IPv4는 256^4의 IP개수를 가질 수 있는데 이는 부족한 현상이 나타난다.
이를 위해 공인IP와 사설IP로 구분하여, 한 공인IP에서 사설IP를 각각에 부여하여 사용한다.

보통 사설IP는 	10.0.0.0 ~ 10.255.255.255
		172.16.0.0 ~ 172.31.255.255
		192.168.0.0 ~ 192.168.255.255

사설IP의 컴퓨터에서 공인IP를 사용하는 서버 등의 다른 컴퓨터로 접근이 가능하지만
다른 컴퓨터에서 사설Ip를 사용하는 컴퓨터로는 접근이 불가하다.

그러므로 웹사이트를 돌리기위한 서버는 공인IP를 사용해야한다.(사설이면 찾을 수 없다.)(고유해야하므로.)

하지만 절대 접근이 불가한 것은 아닌데, 포트를 타고 들어오는 포트포워딩, DMZ를 활용하면 사설IP로의 접근이 가능하다.

또한 유동IP와 고정IP가 있는데,
IP는 한정되어 있기 때문에 일반 가정집에는 유동IP를 나누어 주고 안쓰는 것은 회수하고 가끔 순환을 한다.
고정IP는 고정되어 있는 대신 유동IP보다 비싸다.
그래서 일반 가정집에서 이를 방지하기위해(유동IP처럼 IP가 바뀌는 현상을 말함) DDNS를 한다.
(이때 DNS는 IP를 도메인이랑 연결해주는 것이다.)
DDNS는 동적DNS인데 수시로 변하는 IP를 감지하여 고정된 도메인에 연결해주는 것이다.

IPv6는 훨씬 많은 자릿수가 있기때문에 IPv6가 같이 쓰이고 있다.


Day5

StringTokenizer에 대하여.
(문자열 중에서 원하는 기준(문자)으로 문자열을 분리 할 수 있다.

	public static void main(String[] args) {
		String source = "100,200,300,400";
		StringTokenizer st = new StringTokenizer(source, ",");	//여기서 String값과 기준 문자를 입력한다.
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
=console
100
200
300
400



11/12
1. 오늘 배운내용 쫘악 정리해보기 o
2. 내가 작업할 일 정리해보기 o 
3. 궁금한거 생각해보기 o 
4. IP / port공부 o


11/13
1. USR_GLOBAL table / DEPT_GLOBAL table 뜯어보기
2. oracle 프로시저 / 함수 공부하기
3. 궁금한거 생각해보기

11/14
1. 실제 작업하는 상상하면서 구조 생각해보기
2. enterprise뜯어보기(마인드맵 하면서?)(데이터 흐름만 먼저 살펴보자)
3. 파일질라 공부하기



