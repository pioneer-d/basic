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

	git 터미널은 gitvash를 사용한다.

2. 과정
	- Github에 저장소 작성(git iniy) 또는 복제(git clone)
	- 파일의 작성, 편집
	- 파일의 생성 / 변경 / 삭제를 git 인덱스에 추가(git add)
	- 변경 결과를 로컬 저장소에 커밋(git commit)
	- 로컬 저장소를 푸쉬헤 원격 저장소에 반영(git push)

3. 기초 명령어
	mkdir hellogit 	(mkdir : 새로운 디렉토리 생성)
	cd hellogit 	(cd : 디렉토리 이동)
	git init 		(Git 저장소를 새로 만드는 명령어. 현재 디렉토리를 Git저장소로 변환)

	git add hello.html 	(커밋 할 준비를 하기위해 인덱스에 저장)

	git commit -m "new file"	(인덱스에 추가 된 파일을 커밋. 커밋이란 파일이나 디렉토리 추가 또는 변경을 저장소에 기록하는 작업.)

	git status		(파일이 추가 되었는지 확인.)

	git remote add origin https://github.com/pioneer-d/pioneer-d	(원격 저장소의 정보 추가)

	git push origin master	(로컬 저장소의 변경 사항을 GitHub에 있는 원격 저장소에 반영)

	토큰 : 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

	토큰(노트북) : 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

	
4. 브랜치 관련 명령어
	
	git branch	(브랜치 목록 보기)
	
	git branch subdir01	(브랜치 생성)

	git checkout subdir01	(브랜치 지점 이동)
	(git checkout -b subdir01 : 생성 + 이동)

	(hellogit이라는 폴더에 hello2.html 생성 후 커밋.)
	
	git add hello2.html
	git commit -m "add file hello2"
	-> 여기까지 로컬 저장소에 파일 추가가 기록된 것.

	git push origin subdir01
	-> 원격 저장소의 정보는 등록제이기 때문에 브랜치 이름을 지정하는 것만으로 푸쉬가 가능함.
	
	확인해보니 기존의 master 브랜치에는 hello.html이 존재하고,
	추가로 만든 subdir01 브랜치에는 hello.html, hello2.html 두개가 존재한다.
	
	git pull	(git pull 명령어.)	(먼저 해당 저장소에 checkout을 해야함.)
	
	git merge subdir01	(브랜치 병합.) (최종적으로 병합되는 지점에 checkout 해야한다.)

	git brach -d subdir01	(브랜치 삭제)
	













	
	












