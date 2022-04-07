//람다함수1 (타입추론)
var LamdaTest : (Int) -> (Int) = {number -> number*number}

//람다함수2
val LamdaTest2 = {a : String, b : Int -> "My name is ${a}, I'm ${b}"}

//람다+확장함수
val extendClass : String.() -> String = {this + " complete"}

//확장 함수 매개변수가 1개일때(it) + 함수의 리턴에 람다가 사용될때
fun extendString(name : String, age : Int) : String{
    var introduceMySelf : String.(Int) -> String = {"My name is ${this}, I'm ${it}"}
	return name.introduceMySelf(age)
}

----------------------------->Main
fun main() {
    println(LamdaTest(12))
	println(LamdaTest2("승연",28))
    
    var a = "test"
    println(a.extendClass())
    
    println(extendString("준영",25))
}