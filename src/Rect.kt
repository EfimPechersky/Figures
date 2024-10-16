import kotlin.math.cos
import kotlin.math.sin

// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Transforming, Figure(0) {
    var color: Int = -1 // при объявлении каждое поле нужно инициализировать

    lateinit var name: String // значение на момент определения неизвестно (только для объектных типов)
    // дополнительный конструктор вызывает основной
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        width*=zoom;
        height*=zoom;
    }
    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val wr=width;
        width=height;
        height=wr;
        var a = 0;
        var b = 0;
        when(direction) {
            RotateDirection.Clockwise->a=1;
            RotateDirection.CounterClockwise->b=-1;
        }
        val altx=x
        x = (centerX + ((x-centerX) * b) - ((y - centerY) * a)).toInt()
        y = (centerY + ((altx-centerX) * a) + ((y - centerY) * b)).toInt()
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width*height).toFloat() // требуется явное приведение к вещественному числу
    }
}