https://tagilog.tistory.com/377
1. 사전 지식
	커밋(Commit) : 파일을 추가하거나 변경 내용을 저장소에 저장하는 작업
	푸시(Push) : 파일을 추가하거나 변경 내용을 원격 저장소에 업로드하는 작업

	로컬 저장소 : 자신의 컴퓨터에 있는 저장소.
	원격 저장소 : 서버, 네트워크 상에 있는 저장소.
	-> 기본적으로 로컬 저장소에 작업 수행 후 원격 저장소에 저장.

	브랜치(branch) :  소프트웨어의 버전 관리하며 새로운 기능 추가, 버그 수정.
			여러 버전 관리를 위한 기능.
			History의 흐름을 분기하여 기록해 나가는 방식.

2. 과정
	- Github에 저장소 작성(git iniy) 또는 복제(git clone)
	- 파일의 작성, 편집
	- 파일의 생성 / 변경 / 삭제를 git 인덱스에 추가(git add)
	- 변경 결과를 로컬 저장소에 커밋(git commit)
	- 로컬 저장소를 푸쉬헤 원격 저장소에 반영(git push)

3. 명령어
	mkdir hellogit 	(mkdir : 새로운 디렉토리 생성)
	cd hellogit 	(cd : 디렉토리 이동)
	git init 		(Git 저장소를 새로 만드는 명령어. 현재 디렉토리를 Git저장소로 변환)

	git add hello.html 	(커밋 할 준비를 하기위해 인덱스에 저장)

	git commit -m "new file"	(인덱스에 추가 된 파일을 커밋. 커밋이란 파일이나 디렉토리 추가 또는 변경을 저장소에 기록하는 작업.)

	gitstatus		(파일이 추가 되었는지 확인.)

	git remote add origin https://github.com/pioneer-d/pioneer-d	(원격 저장소의 정보 추가)

	git push origin master	(로컬 저장소의 변경 사항을GitHub에 있는 원격 저장소에 반영)


	현재 토큰방식 때문에 push가 안된다. 토큰 생성방식부터 이어서 하자.

https://miracleground.tistory.com/entry/GitHub-%ED%86%A0%ED%81%B0-%EC%9D%B8%EC%A6%9D-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%ED%95%98%EA%B8%B0-%EC%98%A4%EB%A5%98-%ED%95%B4%EA%B2%B0-remote-Support-for-password-authentication-was-removed-on-August-13-2021-Please-use-a-personal-access-token-instead



