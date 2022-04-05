fun main() {
    var a = Test("동준영")
    var b = Test("김계환")
    var c = Test("홍준모",1999)
}

class Test (var name : String, var age : Int){
    init{
        println("${name}님의 출생년도 : ${age}")
    }
    
    constructor (name : String) : this(name, 1998){
        println("부 생성자 호출")
    }
    
}


