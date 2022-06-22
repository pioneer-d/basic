object carFactory{	//-> 앱 실행동안 딱 한번만 생성되는 객체.
    var cars = mutableListOf<Car>()
    
    fun makeCar(horsePower : Int) : Car{
        var car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(var power : Int)


fun main() {
	var car1 = carFactory.makeCar(10)
    var car2 = carFactory.makeCar(1000)
    
    println("car1 : ${car1}, car2 : ${car2}")
    println(carFactory.cars.size)
}