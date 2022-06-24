package com.basic.kotlin_project.step_12_accessControl

    /*
    기본 접근 제어자 : public
    public     : 모든 곳에서 접근 가능
    protected  : 선언된 클래스, 하위 클래스에서만 접근 가능
    internal   : 같은 모듈에서만 접근 가능 (모듈 : 한 번에 컴파일 되는 Kotlin 코드)
    private    : 선언된 클래스 내에서만 접근 가능
    Kotlin에서 Package는 단지 namespace용도. 접근 제어에 관여하지 않는다.
    Kotlin 파일 내에 여러 변수, 메소드, 클래스가 올 수 있다.

    getter, setter에서 custom을 통해 접근 제어를 따로 설정 할 수 있다.

     */

class ko_accessControl private constructor() {
    // 생성자에 접근 지시자를 사용하면 (public 이외) constructor를 꼭 명시해줘야함.
}