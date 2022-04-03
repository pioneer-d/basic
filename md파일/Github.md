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

	git commit -m "new file"


