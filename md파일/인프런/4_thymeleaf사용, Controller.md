1. Controller를 만들 것임.
	hello/helloSpring/controller 하위
	HelloContoller.class만들었음

2. Controller는 클래스 위에 컨트롤러임을 명시하는 annotation을 붙여줘야함.
	@Controller

3. Contoller 내부에 hello라는 String타입 메소드 만들고
	@GetMapping annotation 선언하고 매핑하는 주소를 입력해줌. ("hello")
	
	또한 이 메소드는 Model객체를 파라미터로 받는데,
	MVC중 Model에 해당하는 객체이다.


4. 이후 templates폴더(static폴더와 같은 위치에 있음)에 hello라는 html생성
이곳에 thymeleaf를 사용하는 스키마 선언 <html xmlns:th="http://www.thymeleaf.org">
이후 th 태그? 사용하면서 (문법) Controller의 model로 입력해준 데이터를 받아오는 작업.

기존에는 localhost:8089로 들어가 static의 index를 접했다면,
localhost:8089/hello를 붙여 매핑을 하면 Controller에 의해 templates의 hello.html에 도달하게 된다.




