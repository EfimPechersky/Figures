import kotlin.math.cos
import kotlin.math.sin

// TODO: дополнить определение класса размерами и позицией
class Circle(var x: Int, var y: Int, var radius:Int) :Transforming,Movable, Figure(0) {
    // TODO: реализовать интерфейс Transforming
    override fun move(dx: Int, dy: Int){
        x+=dx;
        y+=dy;
    }
    override fun resize(zoom: Int) {
        radius *= zoom;
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
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
    override fun area(): Float {
        return  (radius*radius*Math.PI).toFloat()
    }
}