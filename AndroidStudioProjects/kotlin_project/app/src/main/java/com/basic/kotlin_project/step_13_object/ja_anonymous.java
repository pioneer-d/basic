package com.basic.kotlin_project.step_13_object;

public class ja_anonymous {

    /*
    익명 클래스 : 특정 인터페이스나, 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스.
    */

    public static void main(String[] args) {
        moveSomething(new Movable() {
            // 여기서 interface 의 메소드 구현!
            @Override
            public void move() {
                System.out.println("move!");
            }

            @Override
            public void fly() {
                System.out.println("fly!");
            }
        });
    }

    private static void moveSomething(Movable movable){
        movable.move();
        movable.fly();
    }

}
