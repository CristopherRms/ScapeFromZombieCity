import greenfoot.*;  // Importa las clases necesarias de Greenfoot

/**
 * Clase que representa el menú principal del juego.
 * 
 * Esta clase muestra un botón para iniciar el juego.
 * 
 * @author CristopherRms
 * @version 1.0
 */
public class MenuPrincipal extends World
{
    private Start b;  // Botón de inicio
    private GreenfootImage backgroundImage = new GreenfootImage("sfzzc.jpg");
    
    /**
     * Constructor de la clase MenuPrincipal.
     */
    public MenuPrincipal()
    {    
        super(800, 600, 1);  // Crea un mundo de 800x600 celdas con un tamaño de celda de 1x1 píxeles.
        setBackground(backgroundImage);
        b = new Start();  // Crea una instancia del botón de inicio

        addObject(b, 400, 500);  // Agrega el botón al mundo en la posición (400, 500)
    }
   
}

