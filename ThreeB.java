import greenfoot.*;  // Importa las clases necesarias de Greenfoot
import java.util.List;

/**
 * Clase que representa el tercer nivel del juego.
 * 
 * Este nivel contiene elementos como plataformas, personajes y contadores de vida y puntos.
 * Permite desplazar el mundo horizontalmente y controla el flujo del nivel.
 * 
 * @author CristopherRms
 * @version 1.0
 */
public class ThreeB extends World
{   
    protected int xOffset = 0;
    protected GreenfootImage backgroundImage;
    protected Personaje p;
    protected PersonajeC pC;
    private final static int SWIDTH = 800;
    private final static int SHeight = 600;
    private final static int wWIDTH = 800;
    protected LifeBar vidaJugador;
    SimpleTimer tim = new SimpleTimer();
    Counter1 cont = new Counter1();
    public Counter1 power_ups = new Counter1();
    private boolean fin = false;
    public int ataque;
    public int ataqueB;
    public int ataqueC;
    public int puntosAnt;
    private int tiempoespera = 50000;
    Points pon = new Points();
    Pause pause = new Pause();
    int start = 0;
    GreenfootSound sound;
    
    /**
     * Constructor de la clase ThreeB.
     * 
     * @param ata Ataque Zombie
     * @param ataB Ataque del personaje B
     * @param ataC Ataque del personaje C
     * @param puntos Puntos acumulados anteriormente
     */
    public ThreeB(int ata, int ataB, int ataC, int puntos)
    {   
        super(800, 600, 1);  // Crea un mundo de 800x600 celdas con un tamaño de celda de 1x1 píxeles.
        sound = new GreenfootSound("N3.mp3");
        ataque = ata;
        ataqueB = ataB;
        ataqueC = ataC;
        puntosAnt = puntos;
        backgroundImage = new GreenfootImage("NivelTresB.jpg");
        shiftWorld(0);
        prepare();
        tim.mark();
        cont.setValue(120);
        pon.setValue(puntos);
    }
    /**
     * Para el sonido que se esta reproduciendo
     */
    public void paraSonido(){
        sound.stop();
    }
    /**
     * Regresa los puntos
     * @return pon
     */
    public Points getPoints(){
        return pon;
    }
    /**
     * Prepara el mundo agregando los objetos necesarios.
     */
    private void prepare()
    {
        sound.play();
        addObject(cont, 300, 30);
        addObject(pon, 200, 30);
        Plataform pla1 = new Plataform();
        Plataform pla2 = new Plataform();
        Plataform pla3 = new Plataform();
        addObject(pause, 30, 30);
        addObject(pla1, 120, 570);
        addObject(pla2, 450, 570);
        addObject(pla3, 1020, 570);
        vidaJugador = new LifeBar();
        addObject(vidaJugador, 600, 30);
        p = new Personaje(false);
        addObject(p, 120, 500);
        pC = new PersonajeC(ataqueC);
        addObject(pC, 700, 500);
    }
    
    /**
     * Desplaza el mundo horizontalmente.
     * 
     * @param dx Cantidad de desplazamiento
     */
    public void shiftWorld(int dx)
    {
        if ((xOffset + dx) <= 0 && (xOffset + dx) >= SWIDTH - wWIDTH) {
            xOffset = xOffset + dx;
            shiftWorldBackground(dx);
            shiftWorldActors(dx);
        }
    }
        /**
     * Desplaza el fondo del mundo.
     * @param dx la cantidad de píxeles a desplazar.
     */
    private void shiftWorldBackground(int dx) {
        GreenfootImage bkgd = new GreenfootImage(SWIDTH, SHeight);
        bkgd.drawImage(backgroundImage, xOffset, 0);
        setBackground(bkgd);
    }
    /**
     * Desplaza los actores del mundo horizontalmente.
     * 
     * @param dx Cantidad de desplazamiento
     */
    private void shiftWorldActors(int dx)
    {
        List<ScrollingActor> saList = getObjects(ScrollingActor.class);
        for (ScrollingActor a : saList) {
            a.setAbsoluteLocation(dx);
        }
        
        List<PersonajeB> pbList = getObjects(PersonajeB.class);
        for (PersonajeB p : pbList) {
            p.setAbsoluteLocation(dx);
        }
        
        List<PersonajeC> pCList = getObjects(PersonajeC.class);
        for (PersonajeC p : pCList) {
            p.setAbsoluteLocation(dx);
        }
        
        List<Zombie> zList = getObjects(Zombie.class);
        for (Zombie z : zList) {
            z.setAbsoluteLocation(dx);
        }
    }
    
    /**
     * Muestra un contador de power-ups en el mundo.
     * 
     * @param t Cantidad de power-ups restantes
     */
    public void powerUp(int t)
    {
        addObject(power_ups, 400, 30);
        power_ups.setValue(t);
    }
    
    /**
     * Actualiza los contadores y realiza acciones periódicas.
     */
    public void act()
    {
        checkLife();
        checkLevel();
        
        if (tim.millisElapsed() > 1000 && fin == false) {
            cont.add(-1);
            power_ups.add(-1);
            tim.mark();
        }
        
        if (power_ups.getValue() == 0)
            removeObject(power_ups);
        
        if (cont.getValue() == 0 && fin == false)
            p.life = 0;
    }
    
    /**
     * Verifica el nivel actual y realiza acciones correspondientes.
     */
    public void checkLevel()
    {
        
    }
    
    /**
     * Actualiza la barra de vida del jugador.
     */
    private void checkLife()
    {
        String texto = " " + p.life;
        showText(texto, 600, 30);
        
        if (p.life == 100)
            vidaJugador.setImage("vida100.png");
        if (p.life >= 80 && p.life <= 99)
            vidaJugador.setImage("vida80.png");
        if (p.life >= 50 && p.life <= 79)
            vidaJugador.setImage("vida50.png");
        if (p.life >= 30 && p.life <= 49)
            vidaJugador.setImage("vida30.png");
        if (p.life >= 1 && p.life <= 29)
            vidaJugador.setImage("vida10.png");
        if (p.life <= 0)
            vidaJugador.setImage("vida00.png");
    }
    
    /**
     * Finaliza el nivel y muestra la puntuación obtenida.
     */
    public void terminaNivel()
    {
        Greenfoot.playSound("puntos.mp3");
        pon.setValue(pon.getValue() + (cont.getValue() * 10) + 500);
        siguienteNivel();
        sound.stop();
    }
    
    /**
     * Carga el siguiente nivel.
     */
    public void siguienteNivel()
    {
        Greenfoot.delay(100);
        Fin mundo = new Fin(pon.getValue());  // Crea una nueva instancia del mundo Fin
        Greenfoot.setWorld(mundo);  // Establece el mundo Fin como el mundo actual
    }
}


