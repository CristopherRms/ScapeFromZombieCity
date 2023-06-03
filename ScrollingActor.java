import greenfoot.*;

/**
 * La clase ScrollingActor es una subclase de Actor y representa un actor que se desplaza horizontalmente en el mundo.
 * Esta clase proporciona el método setAbsoluteLocation para establecer la ubicación absoluta del actor en el eje x.
 * Esta clase es utilizada para implementar el desplazamiento de actores en un juego de desplazamiento lateral.
 * 
 * @author CristopherRms
 * @version 1.0
 */
public class ScrollingActor extends Actor {
    
    /**
     * Establece la ubicación absoluta del actor en el eje x sumando un desplazamiento dado.
     * @param dx El desplazamiento en el eje x.
     */
    public void setAbsoluteLocation(int dx) {
        setLocation(getX() + dx, getY());
    }
}
