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

//람다의 return
var calculateScore : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

//람다를 매개변수로 받는 함수. (Double이 Input이고 Boolean이 output인 람다를 받음.)
//즉 저런 형태의 람다가 들어오면 해당 람다식에 5.4313을 넣은 값을 리턴 하겠다는 의미.
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean{
    return lamda(5.4313)
}


fun main() {
    println(LamdaTest(12))
	println(LamdaTest2("승연",28))
    
    var a = "test"
    println(a.extendClass())
    
    println(extendString("준영",25))
    
    println(calculateScore(41))
    
    var lamda : (Double) -> Boolean = {number : Double -> number == 4.123} 
    println(invokeLamda(lamda))
    
    //람다 리터럴? 람다 실체를 넣지않고 가상의 람다를 활용하는 것.
    println(invokeLamda({it > 3.12}))
    //이 식과 같음! invokeLamda{it > 3.12}
}










