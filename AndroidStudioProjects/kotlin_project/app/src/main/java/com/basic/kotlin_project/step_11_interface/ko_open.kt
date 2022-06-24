package com.basic.kotlin_project.step_11_interface

fun main(){
    Derived(100)

    /*
    Base Class 는 상속을 허용하기 위해 open 키워드를 입력.
    Derived Class가 Base Class를 상속받고 있음.
    Base Class 의 프로퍼티 number가 val, open인데,
    Derived Class 에서 Derived Class 의 number를 override하여 생성자에서 초기화 하고 있음.
    이때 Derived에 number를 초기화하면서 인스턴스화 하게되면?
    Base의 init에서의 number가 어떻게 나올까
     */

    /*
    Derived Class를 인스턴스화 한다는 것은
    Derived에 입력한 number를 상위 클래스에 보내고,
    Base Class에서 number를 출력해주는데,
    이때 상위 클래스의 생성자가 하위 클래스의 생성자보다 먼저 실행이 되는 단계이기 때문에
    하위 클래스의 number 값이 초기화가 이루어지지 않는다.
    이러한 상태로 Base Class의 number를 출력하니까 number를 못 읽음.

    결론은 상위 클래스에서 하위 클래스의 필드로 접근하면 안된다.
    정확히는 하위 클래스에서 override하고 있는 프로퍼티에 접근하면 안된다!

     */

}

open class Base(
    open val number : Int = 200
){
    init {
        println("Base Class")
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number){
    init {
        println("Derive Class")
    }
}
