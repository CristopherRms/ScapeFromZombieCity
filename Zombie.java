import greenfoot.*;

public class Zombie extends Enemigo {
    public int ataque;
       public Zombie(int ata) {
        ataque=ata;
        walkingDFrames = new GreenfootImage[3];
        walkingDFrames[0] = new GreenfootImage("ZWR1.png");
        walkingDFrames[1] = new GreenfootImage("ZWR3.png");
        walkingDFrames[2] = new GreenfootImage("ZWR10.png");
        walkingIFrames = new GreenfootImage[3];
        walkingIFrames[0] = new GreenfootImage("ZWL1.png");
        walkingIFrames[1] = new GreenfootImage("ZWL3.png");
        walkingIFrames[2] = new GreenfootImage("ZWL10.png");
        attackDFrames = new GreenfootImage[3];
        attackDFrames[0] = new GreenfootImage("ZAR1.png");
        attackDFrames[1] = new GreenfootImage("ZAR3.png");
        attackDFrames[2] = new GreenfootImage("ZAR10.png");
        attackIFrames = new GreenfootImage[3];
        attackIFrames[0] = new GreenfootImage("ZAL1.png");
        attackIFrames[1] = new GreenfootImage("ZAL3.png");
        attackIFrames[2] = new GreenfootImage("ZAL10.png");
        currentFrame = 0;
        animationSpeed = 15;
        animationCounter = 0;
        direction = 1;
        modeAttack = false;
        life = 100;
    }
       public void setAbsoluteLocation(int dx) {
         setLocation(getX()+dx, getY());
     }
    public void act() {
        
        // Obtener la posición x del personaje
        int personajeX = getWorld().getObjects(Personaje.class).get(0).getX();
    
        // Obtener la posición x del zombie
        int zombieX = getX();
        
        // Calcular la distancia entre el zombie y el personaje en el eje X
        int distanceX = personajeX - getX();
        
        // Obtener la posición y del personaje
        int personajeY = getWorld().getObjects(Personaje.class).get(0).getY();
    
        // Obtener la posición y del zombie
        int zombieY = getY();
        
        // Calcular la distancia entre el zombie y el personaje en el eje Y
        int distanceY = Math.abs(personajeY - getY());
        
        // Mover el zombie hacia el personaje en el eje x
        if (zombieX < personajeX && distanceX > 60) {
            setLocation(getX() + 1, getY()); // Si el personaje está a la derecha, mueve el zombie hacia la derecha
            direction = 1;
            modeAttack = false;
        } else if (zombieX > personajeX && distanceX < -60) {
            setLocation(getX() - 1, getY()); // Si el personaje está a la izquierda, mueve el zombie hacia la izquierda
            direction = -1;
            modeAttack = false;
        }
        
        // Verificar si el zombie está tocando al personaje
        if (zombieX >= personajeX && zombieX <= personajeX + 60 && distanceY <= 60) {
            // Cambiar la imagen de la animación a los attackDFrames
            modeAttack = true;
            
        }
        if (zombieX + 60 >= personajeX && zombieX  <= personajeX && distanceY <= 60) {
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
    }
    
    public void gravedad(){
        vy += 1; // aumenta la velocidad vertical
        setLocation(getX(), getY() + vy); // aplica la velocidad vertical
    }
    
    public void vida(){
        if(this.life<=0){
            Greenfoot.playSound("puntos.mp3");
            World world;
            world=getWorld();
            world.removeObject(this);
            Level1 l1= (Level1)world;
            Points pon= l1.getPoints();
            pon.setValue(pon.getValue()+10);
        }
    }
    
    private void animate() {
        animationCounter++;
        if (animationCounter >= animationSpeed) {
            currentFrame = (currentFrame + 1) % 3;
            setImage(getCurrentFrame());
            animationCounter = 0;
        }
    }
    
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
        
        if (dX <= 60 && dY <= 60 && modeAttack == true){
            Personaje personaje = getWorld().getObjects(Personaje.class).get(0);
            if (personaje != null)
                personaje.life -= ataque;
        }
    }
}
