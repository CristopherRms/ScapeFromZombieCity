import greenfoot.*;  // Importa las clases necesarias de Greenfoot

/**
 * Clase que representa la pantalla de reinicio del nivel o regreso al menú.
 * 
 * Esta clase muestra opciones para reiniciar el nivel o regresar al menú principal.
 * @author CristopherRms
 * @version 1.0
 */
public class Reinicia extends World
{
    private GreenfootImage backgroundImage = new GreenfootImage("GameOver.jpg");
    
    /**
     * Constructor de la clase Reinicia.
     * 
     * @param a Ataque
     * @param b Ataque 
     * @param c Ataque 
     */
    public Reinicia(int a, int b, int c)
    {    
        super(800, 600, 1);  // Crea un mundo de 800x600 celdas con un tamaño de celda de 1x1 píxeles.
        setBackground(backgroundImage);
        Restart e = new Restart(a, b, c);  // Crea una instancia del botón de reinicio con los parámetros dados
        MenuGO m = new MenuGO();  // Crea una instancia del botón de regreso al menú principal

        addObject(e, 200, 400);  // Agrega el botón de reinicio al mundo en la posición (200, 400)
        addObject(m, 600, 400);  // Agrega el botón de regreso al menú al mundo en la posición (600, 400)
    }
}
