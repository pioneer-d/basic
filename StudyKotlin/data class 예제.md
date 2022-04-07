data class Ticket(val company : String, val name : String, var num : Int)
class Ticket2 (val company : String, val name : String, var num : Int)

fun main() {
    var ticket1 = Ticket("스냅태그","동준영",3)
    var ticket2 = Ticket2("something","하승연",5)
    
    println(ticket1)
    println(ticket2)
}


console
Ticket(company=스냅태그, name=동준영, num=3)
Ticket2@439f5b3d