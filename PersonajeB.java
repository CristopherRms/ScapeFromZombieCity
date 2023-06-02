import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Aliado del Jefe
 */
public class PersonajeB extends Enemigo
{
    private int shootCooldown=0;
    public int ataque;
    /**
     * Constructor
     */
    public PersonajeB(int a) {
        ataque=a;
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
     * Pone su posicion absoluta
     */
       public void setAbsoluteLocation(int dx) {
         setLocation(getX()+dx, getY());
     }
    public void act() {
        
        // Obtener la posición x del personaje
        int personajeX = getWorld().getObjects(Personaje.class).get(0).getX();
    
        // Obtener la posición x del zombie
        int personajebX = getX();
        
        // Calcular la distancia entre el zombie y el personaje en el eje X
        int distanceX = personajeX - getX();
        
        // Obtener la posición y del personaje
        int personajeY = getWorld().getObjects(Personaje.class).get(0).getY();
    
        // Obtener la posición y del zombie
        int zombieY = getY();
        
        // Calcular la distancia entre el zombie y el personaje en el eje Y
        int distanceY = Math.abs(personajeY - getY());
        
        // Mover el zombie hacia el personaje en el eje x
        if (personajebX < personajeX && distanceX > 200) {
            setLocation(getX() + 2, getY()); // Si el personaje está a la derecha, mueve el zombie hacia la derecha
            direction = 1;
            modeAttack = false;
        } else if (personajebX > personajeX && distanceX < -200) {
            setLocation(getX() - 2, getY()); // Si el personaje está a la izquierda, mueve el zombie hacia la izquierda
            direction = -1;
            modeAttack = false;
        }
        
        
        if (personajebX >= personajeX && personajebX <= personajeX + 200 && distanceY <= 200) {
            // Cambiar la imagen de la animación a los attackDFrames
            modeAttack = true;
            
        }
        if (personajebX + 200 >= personajeX && personajebX  <= personajeX && distanceY <= 200) {
            // Cambiar la imagen de la animación a los attackDFrames
            modeAttack = true;
        }
        gravedad();
        // Comprobar si se toca el suelo
        Actor plataformaTocada = getOneIntersectingObject(Plataform.class);
        if (plataformaTocada != null) {
            setLocation(getX(), plataformaTocada.getY() - plataformaTocada.getImage().getHeight() / 5 - getImage().getHeight() / 2 );
        // El jugador está tocando la plataforma
            vy = 0;
        }
        animate();
        vida();
        if (shootCooldown > 0) {
            shootCooldown--;
        }
    }
    /**
     * Gravedad
     */
    public void gravedad(){
        vy += 1; // aumenta la velocidad vertical
        setLocation(getX(), getY() + vy); // aplica la velocidad vertical
    }
    /**
     * verifica si esta muerto
     */
    public void vida(){
        if(this.life<=0){
            Greenfoot.playSound("puntos.mp3");
            World world;
            world=getWorld();
            world.removeObject(this);
            Level1 l1= (Level1)world;
            Points pon= l1.getPoints();
            pon.setValue(pon.getValue()+15);
        }
    }
    /**
     * animacion
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
     * regresa el Frame que se va a utilizar
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
     * Verifica si esta en posicion de atacar
     */
    private void atacar() {
        // Obtener la posición x del personaje
        int pX = getWorld().getObjects(Personaje.class).get(0).getX();
    
        // Obtener la posición x del zombie
        int zX = getX();
        
        // Obtener la posición y del personaje
        int pY = getWorld().getObjects(Personaje.class).get(0).getY();
    
        // Obtener la posición y del zombie
        int zY = getY();
        
        // Calcular la distancia entre el zombie y el personaje en el eje X
        int dX = Math.abs(pX - zX);
        
        // Calcular la distancia entre el zombie y el personaje en el eje Y
        int dY = Math.abs(pY - zY);
        
        if (dX <= 200 && dY <= 200 && modeAttack == true&& shootCooldown==0){
                disparar();
        }
    }
    /**
     * crea proyectiles para disparar
     */
    private void disparar(){
            Greenfoot.playSound("Disparo.mp3");
                    ProjectileNormal2 p;
                    getWorld().addObject(p = new ProjectileNormal2(ataque), getX()+10, getY());
                    shootCooldown = 60;
                    p.moverDerecha();
                    if (direction == -1) {
                        p.moverIzquierda();
                    } else {
                        p.moverDerecha();
                    }
    }
}
