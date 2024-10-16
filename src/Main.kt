fun main() {

    // интерфейсы удобно использовать в коллекциях
    val figures: Array<Movable>
    val movable: Movable = Rect(0,0,1,1)
    movable.move(1,1)
    // переменной базового класса
    val f: Figure = Rect(0,0,3,1)
    val f2: Figure = Circle(0, 0, 2)
    val f3: Figure = Square(0, 0, 2)
    val f4 = Rect(0,0,3,1);
    println(f.area())
    println(f2.area())
    println(f3.area())
    f4.move(4,3)
    println("${f4.x} ${f4.y}")
    f4.resize(2)
    f4.rotate(RotateDirection.CounterClockwise, 3, -3)
    println("${f4.x} ${f4.y}")

}