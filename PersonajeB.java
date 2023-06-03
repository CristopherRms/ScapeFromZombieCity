import greenfoot.*;

/**
 * Clase PersonajeB (CharacterB)
 * 
 * Esta clase representa a un aliado del jefe en el juego.
 * @autor CristopherRms
 * @version 1.0
 */
public class PersonajeB extends Enemigo {
    private int shootCooldown = 0;
    public int ataque;
    
    /**
     * Constructor de la clase PersonajeB.
     *
     * @param a el valor de ataque del personaje
     */
    public PersonajeB(int a) {
        ataque = a;
        walkingDFrames = new GreenfootImage[3];
        walkingDFrames[0] = new GreenfootImage("PB01.png");
        walkingDFrames[1] = new GreenfootImage("PB02.png");
        walkingDFrames[2] = new GreenfootImage("PB03.png");
        walkingIFrames = new GreenfootImage[3];
        walkingIFrames[0] = new GreenfootImage("PB04.png");
        walkingIFrames[1] = new GreenfootImage("PB05.png");
        walkingIFrames[2] = new GreenfootImage("PB06.png");
        attackDFrames = new GreenfootImage[3];
        attackDFrames[0] = new GreenfootImage("PB07.png");
        attackDFrames[1] = new GreenfootImage("PB08.png");
        attackDFrames[2] = new GreenfootImage("PB09.png");
        attackIFrames = new GreenfootImage[3];
        attackIFrames[0] = new GreenfootImage("PB10.png");
        attackIFrames[1] = new GreenfootImage("PB11.png");
        attackIFrames[2] = new GreenfootImage("PB12.png");
        currentFrame = 0;
        animationSpeed = 5;
        animationCounter = 0;
        direction = 1;
        modeAttack = false;
        life = 150;
    }
    
    /**
     * Configura la posición absoluta del personaje aliado.
     *
     * @param dx la distancia en el eje X a mover el personaje
     */
    public void setAbsoluteLocation(int dx) {
        setLocation(getX() + dx, getY());
    }
    
    /**
     * Método act() del personaje aliado.
     * Realiza las acciones del personaje en cada frame.
     */
    public void act() {
        // Obtener la posición x del personaje principal
        int personajeX = getWorld().getObjects(Personaje.class).get(0).getX();
    
        // Obtener la posición x del personaje aliado
        int personajeBX = getX();
        
        // Calcular la distancia en el eje X entre el personaje aliado y el personaje principal
        int distanceX = personajeX - getX();
        
        // Obtener la posición y del personaje principal
        int personajeY = getWorld().getObjects(Personaje.class).get(0).getY();
    
        // Obtener la posición y del personaje aliado
        int personajeBY = getY();
        
        // Calcular la distancia en el eje Y entre el personaje aliado y el personaje principal
        int distanceY = Math.abs(personajeY - getY());
        
        // Mover al personaje aliado hacia el personaje principal en el eje X
        if (personajeBX < personajeX && distanceX > 200) {
            setLocation(getX() + 2, getY()); // Si el personaje principal está a la derecha, mover al aliado hacia la derecha
            direction = 1;
            modeAttack = false;
        } else if (personajeBX > personajeX && distanceX < -200) {
            setLocation(getX() - 2, getY()); // Si el personaje principal está a la izquierda, mover al aliado hacia la izquierda
            direction = -1;
            modeAttack = false;
        }
        
        // Verificar si el personaje aliado está en posición de atacar
        if (personajeBX >= personajeX && personajeBX <= personajeX + 200 && distanceY <= 200) {
            modeAttack = true;
        }
        
        if (personajeBX + 200 >= personajeX && personajeBX <= personajeX && distanceY <= 200) {
            modeAttack = true;
        }
        
        gravedad();
        
        // Comprobar si el personaje aliado toca el suelo
        Actor plataformaTocada = getOneIntersectingObject(Plataform.class);
        if (plataformaTocada != null) {
            setLocation(getX(), plataformaTocada.getY() - plataformaTocada.getImage().getHeight() / 5 - getImage().getHeight() / 2);
            vy = 0;
        }
        
        animate();
        vida();
        
        if (shootCooldown > 0) {
            shootCooldown--;
        }
    }
    
    /**
     * Aplica la gravedad al personaje aliado.
     */
    public void gravedad() {
        vy += 1; // Aumenta la velocidad vertical
        setLocation(getX(), getY() + vy); // Aplica la velocidad vertical
    }
    
    /**
     * Verifica si el personaje aliado está muerto.
     * Si está muerto, se elimina del mundo y se aumentan los puntos del jugador.
     */
    public void vida() {
        if (this.life <= 0) {
            Greenfoot.playSound("puntos.mp3");
            World world = getWorld();
            world.removeObject(this);
            Level1 l1 = (Level1) world;
            Points points = l1.getPoints();
            points.setValue(points.getValue() + 15);
        }
    }
    
    /**
     * Realiza la animación del personaje aliado.
     */
    private void animate() {
        animationCounter++;
        if (animationCounter >= animationSpeed) {
            currentFrame = (currentFrame + 1) % 3;
            setImage(getCurrentFrame());
            animationCounter = 0;
        }
    }
    
    /**
     * Obtiene el frame actual del personaje aliado.
     *
     * @return la imagen actual del personaje aliado
     */
    private GreenfootImage getCurrentFrame() {
        if (direction == 1 && modeAttack == false) {
            return walkingDFrames[currentFrame];
        } else if (direction == -1 && modeAttack == false) {
            return walkingIFrames[currentFrame];
        } else if (direction == 1 && modeAttack == true) {
            if (currentFrame == 2) {
                atacar();
            }
            return attackDFrames[currentFrame];
        } else {
            if (currentFrame == 2) {
                atacar();
            }
            return attackIFrames[currentFrame];
        }
    }
    
    /**
     * Realiza el ataque del personaje aliado.
     * Verifica si el personaje principal está en rango de ataque y realiza el disparo.
     */
    private void atacar() {
        // Obtener la posición x del personaje principal
        int pX = getWorld().getObjects(Personaje.class).get(0).getX();
    
        // Obtener la posición x del personaje aliado
        int zX = getX();
        
        // Obtener la posición y del personaje principal
        int pY = getWorld().getObjects(Personaje.class).get(0).getY();
    
        // Obtener la posición y del personaje aliado
        int zY = getY();
        
        // Calcular la distancia en el eje X entre el personaje aliado y el personaje principal
        int dX = Math.abs(pX - zX);
        
        // Calcular la distancia en el eje Y entre el personaje aliado y el personaje principal
        int dY = Math.abs(pY - zY);
        
        if (dX <= 200 && dY <= 200 && modeAttack == true && shootCooldown == 0) {
            disparar();
        }
    }
    
    /**
     * Crea un proyectil para disparar.
     * El proyectil se crea en la posición del personaje aliado y se mueve en la dirección en la que está mirando.
     */
    private void disparar() {
        Greenfoot.playSound("Disparo.mp3");
        ProjectileNormal2 p;
        getWorld().addObject(p = new ProjectileNormal2(ataque), getX() + 10, getY());
        shootCooldown = 60;
        if (direction == -1) {
            p.moverIzquierda();
        } else {
            p.moverDerecha();
        }
    }
}
