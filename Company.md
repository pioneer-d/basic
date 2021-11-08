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
1. ps -ef | grep inctool 프로세스 확인
2. 해당 프로세스 죽이기 kill -9 프로세스번호

** 리눅스에서 로그 확인  (Sysout확인 가능)
1. tomcat/logs들어가기
2. tail -f catalina.out

