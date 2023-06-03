import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ventana para ver qué controles se usan en el juego.
 * Esta clase representa una ventana de ayuda que muestra los controles utilizados en el juego.
 * Extiende la clase World de Greenfoot.
 * 
 * @author CristopherRms
 * @version 1.0
 */
public class Controls extends World
{
    private GreenfootImage backgroundImage = new GreenfootImage("Como jugar.jpg");
    private String t;
    
    /**
     * Constructor de los objetos de la clase Controls.
     * Crea una nueva instancia de la clase Controls.
     * Configura el tamaño del mundo a 800x600 celdas con un tamaño de celda de 1x1 píxeles.
     * Establece la imagen de fondo utilizando la imagen proporcionada.
     * Agrega un objeto de tipo MenuGO al mundo en las coordenadas (400, 550).
     */
    public Controls()
    {    
        super(800, 600, 1); 
        setBackground(backgroundImage);
        MenuGO m = new MenuGO();
        addObject(m, 400, 550);
    }
}

