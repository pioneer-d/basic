Spring Boot 설정하기

1. Geadle / Java / 2.6.3
	/Dependencies (어떤 라이브러리 쓸건지)
		- Spring Web / Thymeleaf(html을 만들어주는 템플릿 엔진)
설정을 마치면 하단의 generate 누르면 파일을 다운한다. 이를 intelliJ에서 open하면 됨.


2. 설치 후 open하면 몇몇 폴더가 있음

	src - main , test (실제 폴더와 test폴더가 구분 되어져 있음.)
	
	main/resources - 실제 자바코드 제외한 xml, property등이 존재.
	resources/application.properties - 포트도 설정 가능.

	build.gradle - 버전설정, 라이브러리 설정 등 하는 곳.

3. Class도 하나 만들어져 있을텐데, 들어가서 main부분 실행한뒤, 설정한 port대로
	localhost:8089 브라우저에 입력하면 에러페이지 나올거임. 그럼 성공

4. Spring boot가 웹서버 tomcat을 내장하고 있음.