import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Clase padre de los niveles
 */
public class Level1 extends World
{   protected int xOffset = 0;
    protected GreenfootImage backgroundImage;
   protected Personaje p;
    private final static int SWIDTH = 800;
    private final static int SHeight = 600;
    private final static int wWIDTH = 8000;
    protected LifeBar vidaJugador;
    SimpleTimer tim= new SimpleTimer();
    Counter1 cont= new Counter1();
    public Counter1 power_ups = new Counter1();
    private boolean fin=false;
    public int ataque;
    public int ataqueB;
    public int ataqueC;
    public int puntosAnt;
    private int tiempoespera=50000;
    Points pon= new Points();
    Pause pause= new Pause();
    int start=0;
    GreenfootSound sound;
    /**
     * Para el sonido
     */
    public void paraSonido(){
        sound.stop();
    }
    /**
     * Regresa los puntos del puntaje
     * @return puntaje
     */
    public Points getPoints(){
        return pon;
    }
    /**
     * act
     */
    public void act(){
        checkLife();
        checkLevel();
        if (tim.millisElapsed()>1000 && fin==false){
            cont.add(-1);
            power_ups.add(-1);
            tim.mark();
        }
        if(power_ups.getValue()==0)
            removeObject(power_ups);
        if (cont.getValue()==0 && fin==false)
         p.life=0;
    }
    /**
     * Metodo para verificar lo que pasa durante el nivel
     */
    public void checkLevel(){
        
    }
    /**
     * Constructor
     */
    public Level1()
    {   
        super(800, 600, 1,false); 
        
    }
    /**
     * Metodo para el scroll
     */
    public void shiftWorld(int dx){
        if( (xOffset + dx) <= 0 && (xOffset + dx) >= SWIDTH - wWIDTH) {
         xOffset = xOffset + dx;
         shiftWorldBackground(dx);
         shiftWorldActors(dx);
     }
    }
    /**
     * Mueve a los actores en un valor absoluto
     */
    private void shiftWorldActors(int dx) {
         List<ScrollingActor> saList = getObjects(ScrollingActor.class);
         for( ScrollingActor a : saList ) {
         a.setAbsoluteLocation(dx);
         }
         List<PersonajeB> pbList = getObjects(PersonajeB.class);
         for( PersonajeB p : pbList ) {
         p.setAbsoluteLocation(dx);
         }
         List<PersonajeC> pCList = getObjects(PersonajeC.class);
         for( PersonajeC p : pCList ) {
         p.setAbsoluteLocation(dx);
         }
         List<Zombie> zList=getObjects(Zombie.class);
         for( Zombie z : zList ) {
         z.setAbsoluteLocation(dx);
     }
     }
     /**
      * Añade un reloj para el power up
      */
     public void powerUp(int t){
         addObject(power_ups,400,30);
         power_ups.setValue(t);
     }
     /**
      * recorre la imagen de fondo
      */
    private void shiftWorldBackground(int dx) {
         GreenfootImage bkgd = new GreenfootImage(SWIDTH, SHeight);
         bkgd.drawImage(backgroundImage, xOffset, 0);
         setBackground(bkgd);
     }
     /**
      * verifica la vida del personaje
      */
    private void checkLife(){
        String texto = " " + p.life;
        showText(texto,600,30);
           if(p.life==100)
               vidaJugador.setImage("vida100.png");
            if(p.life>=80 && p.life<=99)
               vidaJugador.setImage("vida80.png");
            if(p.life>=50 && p.life<=79)
               vidaJugador.setImage("vida50.png");
            if(p.life>=30 && p.life<=49)
               vidaJugador.setImage("vida30.png");
            if(p.life>=1 && p.life<=29)
               vidaJugador.setImage("vida10.png");
            if(p.life<=0)
               vidaJugador.setImage("vida00.png");
    }
    
   
    
}
