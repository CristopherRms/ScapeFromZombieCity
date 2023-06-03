import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ventana para el final del juego.
 * Esta clase representa la ventana final del juego que muestra la puntuación obtenida.
 * Extiende la clase World de Greenfoot.
 * 
 * @autor CristopherRms
 * @version 1.0
 */
public class Fin extends World
{
    private GreenfootImage backgroundImage = new GreenfootImage("Fin.jpg");
    private String t;
    
    /**
     * Constructor de los objetos de la clase Fin.
     * Crea una nueva instancia de la clase Fin.
     * Configura el tamaño del mundo a 800x600 celdas con un tamaño de celda de 1x1 píxeles.
     * Establece la imagen de fondo utilizando la imagen proporcionada.
     * Muestra la puntuación obtenida en la posición (600, 190).
     * Agrega un objeto de tipo MenuGO al mundo en las coordenadas (400, 500).
     * 
     * @param p la puntuación obtenida al final del juego.
     */
    public Fin(int p)
    {    
        super(800, 600, 1); 
        setBackground(backgroundImage);
        t = "" + p;
        showText(t, 600, 190);
        MenuGO m = new MenuGO();
        addObject(m, 400, 500);
    }
}

