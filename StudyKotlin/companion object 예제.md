//private으로 일반적인 접근 제한.
class BookInfo private constructor(var num : Int, var name : String){
    
    companion object companionName : bookNumProvider{ //-> Java의 static 역할을 함.
        
        //companion의 property
        var myBook = "new Book"
        
        //인터페이스 상속에 의한 override
        override fun getId() : Int{
            return 123
        }
        
        //companion의 메소드
        fun create() = BookInfo(getId(), myBook)
    }
}

interface bookNumProvider{
    fun getId() : Int
}

fun main() {

    //companion object가 없으면 private때문에 객체 생성을 못함.
    //var book = BookInfo(0,"test")
    
    //마치 자바의 싱글톤 패턴과 유사한 것 같다!
    var book1 = BookInfo.companionName.create()	//이때 CompanionName 생략 가능.
    println("${book1.num}, ${book1.name}")
    
    //companion object의 property 출력
    var bookNum = BookInfo.companionName.getId()
    println("${bookNum}")
    
}