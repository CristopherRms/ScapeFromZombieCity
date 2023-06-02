import greenfoot.*; 

public class Personaje extends Humanoide {
    private GreenfootImage[] idleDFrames;
    private GreenfootImage[] idleIFrames;
    private GreenfootImage[] jumpDFrames;
    private GreenfootImage[] jumpIFrames;
    private GreenfootImage[] deathDFrames;
    private GreenfootImage[] deathIFrames;
    public boolean salto;
    public boolean b=false;
    private int shootCooldown;
    private int shootBomb;
    private int tiempoInmune;
    private int tiempoProjectile;
    private boolean stand;
    private boolean live;
    private boolean inmune=false;
    private int speedX;
    public int tipoProjectil=1;
    public boolean key;
    private static final int SPEED = 2;
    private static final int BOUNDARY = 400;
    private int bomba=1;
    public boolean linea=false;
    public boolean bounded;
    /**
     * Constructor
     */
    public Personaje(boolean boun) {
        walkingDFrames = new GreenfootImage[3];
        walkingDFrames[0] = new GreenfootImage("0001.png");
        walkingDFrames[1] = new GreenfootImage("0003.png");
        walkingDFrames[2] = new GreenfootImage("0010.png");
        walkingIFrames = new GreenfootImage[3];
        walkingIFrames[0] = new GreenfootImage("0001L.png");
        walkingIFrames[1] = new GreenfootImage("0003L.png");
        walkingIFrames[2] = new GreenfootImage("0010L.png");
        attackDFrames = new GreenfootImage[3];
        attackDFrames[0] = new GreenfootImage("0030.png");
        attackDFrames[1] = new GreenfootImage("0032.png");
        attackDFrames[2] = new GreenfootImage("0038.png");
        attackIFrames = new GreenfootImage[3];
        attackIFrames[0] = new GreenfootImage("0030L.png");
        attackIFrames[1] = new GreenfootImage("0032L.png");
        attackIFrames[2] = new GreenfootImage("0038L.png");
        idleDFrames = new GreenfootImage[3];
        idleDFrames[0] = new GreenfootImage("0060.png");
        idleDFrames[1] = new GreenfootImage("0065.png");
        idleDFrames[2] = new GreenfootImage("0068.png");
        idleIFrames = new GreenfootImage[3];
        idleIFrames[0] = new GreenfootImage("0060L.png");
        idleIFrames[1] = new GreenfootImage("0065L.png");
        idleIFrames[2] = new GreenfootImage("0068L.png");
        jumpDFrames = new GreenfootImage[3];
        jumpDFrames[0] = new GreenfootImage("0460.png");
        jumpDFrames[1] = new GreenfootImage("0464.png");
        jumpDFrames[2] = new GreenfootImage("0469.png");
        jumpIFrames = new GreenfootImage[3];
        jumpIFrames[0] = new GreenfootImage("0460L.png");
        jumpIFrames[1] = new GreenfootImage("0464L.png");
        jumpIFrames[2] = new GreenfootImage("0469L.png");
        deathDFrames = new GreenfootImage[5];
        deathDFrames[0] = new GreenfootImage("D01.png");
        deathDFrames[1] = new GreenfootImage("D02.png");
        deathDFrames[2] = new GreenfootImage("D03.png");
        deathDFrames[3] = new GreenfootImage("D04.png");
        deathDFrames[4] = new GreenfootImage("D05.png");
        deathIFrames = new GreenfootImage[5];
        deathIFrames[0] = new GreenfootImage("I01.png");
        deathIFrames[1] = new GreenfootImage("I02.png");
        deathIFrames[2] = new GreenfootImage("I03.png");
        deathIFrames[3] = new GreenfootImage("I04.png");
        deathIFrames[4] = new GreenfootImage("I05.png");
        currentFrame = 0;
        animationSpeed = 5;
        animationCounter = 0;
        life = 100;
        shootCooldown = 0;
        shootBomb=0;
        direction = 1;
        modeAttack = false;
        bounded=boun;
        stand = true;
        salto = false;
        live = true;
        speedX=1;
        key=false;
    }
    
    public void act() {
        keyboard();
        if(bounded==true)
        boundedMove();
        else 
        movv();
        if (shootCooldown > 0) {
            shootCooldown--;
        }
        if (shootBomb > 0) {
            shootBomb--;
        }
        gravedad();
        animate();
        // Comprobar si se toca el suelo
        Actor plataformaTocada = getOneIntersectingObject(Plataform.class);
        if (plataformaTocada != null) {
            setLocation(getX(), plataformaTocada.getY() - plataformaTocada.getImage().getHeight() / 5 - getImage().getHeight() / 2 );
        // El jugador está tocando la plataforma
            salto = false;
            vy = 0;
        }
        verificaInmune();
        verificaProjectile();
        if (this.life <= 0) {
            // Cambiar la imagen de la animación
            live = false;
            animationSpeed = 10;
        }
    }
    /**
     * Verifica el tiempo que tienen las balas de fuego
    */
    public void verificaProjectile(){
        if (tipoProjectil!=1){
            tiempoProjectile--;
            if (tiempoProjectile<=0){
                tipoProjectil=1;
            }
        }
    }
    /**
     * verifiica el tiempo que es inmune 
     */
    public void verificaInmune(){
        if (inmune){
            life=100;
            tiempoInmune--;
            if (tiempoInmune<=0){
                inmune=false;  
            }
        }
    }
    /**
     * pone un contador al power up
     */
    public void setTimeProjectile(int time){
        tiempoProjectile=time;
        ((Level1)getWorld()).powerUp(time/60);
    }
    /**
     * Da orden de que es inmune
     */
    public void setInmune(int tiempo){
        ((Level1)getWorld()).power_ups.setImage("escudo2.png");
        inmune=true;
        tiempoInmune=tiempo;
        
        ((Level1)getWorld()).powerUp((tiempo/60)+2);
    }
    /**
     * Scroll
     */
    private void boundedMove() {
    if(isAtEdge()&& Greenfoot.isKeyDown("left"))
        setLocation(getX(), getY());
    else
     if( speedX+getX() <= BOUNDARY ) {
     setLocation(speedX+getX(), getY());
        ((Level1)getWorld()).shiftWorld(-speedX);
     } else if( speedX+getX() >= getWorld().getWidth()-BOUNDARY ) {
     setLocation(getWorld().getWidth()-BOUNDARY, getY());
     ((Level1)getWorld()).shiftWorld(-speedX);
     } else {
     setLocation(getX()+speedX, getY());
     }
     speedX = 0;
     }
    /**
     * mover sin scroll
     */
    private void movv(){
    if(Greenfoot.isKeyDown("right")) {
           setLocation(getX()+speedX, getY());
       // ((Level1)getWorld()).shiftWorld(-speedX);
     } else if( Greenfoot.isKeyDown("left") ) {
         setLocation(getX()+speedX, getY());
     //((Level1)getWorld()).shiftWorld(-speedX);
     } 
    /**
     * animacion
     */
    }
    private void animate() {
        animationCounter++;
        if (animationCounter % animationSpeed == 0) {
            currentFrame++;
            if (live == true) {
                if (currentFrame >= 3) {
                    currentFrame = 0;
                }
            }
            else {
                if (currentFrame >= 5) {
                    currentFrame = 0;
                }
            }
            setImage(getCurrentFrame());
        }
    }
    /**
     * regresa que Frame se usara
     */
    private GreenfootImage getCurrentFrame() {
        if (direction == 1 && modeAttack == false && stand == false && live == true) {
            return walkingDFrames[currentFrame];
        } else if (direction == -1 && modeAttack == false && stand == false && live == true) {
            return walkingIFrames[currentFrame];
        } else if (direction == 1 && modeAttack == true && stand == false && live == true ) {
            return attackDFrames[currentFrame];
        } else if (direction == -1 && modeAttack == true && live == true && stand == false) {
            return attackIFrames[currentFrame];
        } else if (stand == true && direction == 1 && live == true) {
            return idleDFrames[currentFrame];
        } else if (stand == true && direction == -1 && live == true) {
            return idleIFrames[currentFrame];
        } else if (live == false && direction == -1) {
            if (currentFrame == 4) {
                setImage(deathIFrames[currentFrame]);
                reinicia();
            }
            return deathIFrames[currentFrame];
        } else if (live == false && direction == 1) {
            if (currentFrame == 4) {
                setImage(deathDFrames[currentFrame]);
                reinicia();
            }
            return deathDFrames[currentFrame];
        } else {
            return idleDFrames[currentFrame];
        }
    }
    /**
     * Reinicia la partida
     */
    private void reinicia() {
        Greenfoot.delay(100);
        if(bounded==true){
            ((Level1)getWorld()).paraSonido();
            Reinicia mundo = new Reinicia(((Level1)getWorld()).ataque,((Level1)getWorld()).ataqueB,((Level1)getWorld()).ataqueC); // Crear una nueva instancia del mundo
            Greenfoot.setWorld(mundo);
        }
        else{
            ((ThreeB)getWorld()).paraSonido();
            Reinicia mundo = new Reinicia(((ThreeB)getWorld()).ataque,((ThreeB)getWorld()).ataqueB,((ThreeB)getWorld()).ataqueC); // Crear una nueva instancia del mundo
            Greenfoot.setWorld(mundo);
        }
         // Reiniciar el juego
    }
    /**
     * Gravedad
     */
    public void gravedad() {
        vy += 1; // aumenta la velocidad vertical
        setLocation(getX(), getY() + vy); // aplica la velocidad vertical
    }
    /**
     * Bombas
     */
    private void avientaBomba(){
            if (shootBomb == 0){
            Greenfoot.playSound("Disparo.mp3");
            Bomba p;
            getWorld().addObject(p = new Bomba(), getX()+10, getY());
            shootBomb=100;
            bomba--;
            if (direction == -1) {
                p.moverIzquierda();
            } else {
               p.moverDerecha();
            }
        }
    }
    /**
     * Crea los proyectiles
     */
    private void atacar() {
        if (shootCooldown == 0){
            
            switch(tipoProjectil){
                case 1:
                    Greenfoot.playSound("Disparo.mp3");
                    ProjectileNormal p;
                    getWorld().addObject(p = new ProjectileNormal(), getX()+10, getY());
                    shootCooldown = 8;
                    p.moverDerecha();
                    if (direction == -1) {
                        p.moverIzquierda();
                    } else {
                        p.moverDerecha();
                    }
                break;
                case 2:
                    Greenfoot.playSound("bola fuego.mp3");
                    Projectil2 p2;
                    getWorld().addObject(p2 = new Projectil2(), getX()+5, getY());
                    shootCooldown = 20;
                    p2.moverDerecha();
                    if (direction == -1) {
                        p2.moverIzquierda();
                    } else {
                        p2.moverDerecha();
                    }
                break;
                    
            }

            
        }// establece un tiempo de espera antes del siguiente disparo
    }
    /**
     * verfica el teclado
     */
    public void keyboard(){
        // Mover al personaje si se presiona una tecla
        stand = true;
        if (Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("a")) {//CAMINA HACIA LA izquierda
            direction = -1;
            modeAttack = false;
            stand = false;
            speedX=-3;
        }
        
        if (Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("a")) {//CAMINA HACIA LA DERCHA
            direction = 1;
            modeAttack = false;
            stand = false;
            speedX=3;
        }
        
        if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("left")) {//camina hacia la izquierda y dispara 
            direction = -1;
            modeAttack = true;
            stand = false;
            speedX=-3;
            atacar();
        }
        
        if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("right")) {//camina hacia la dercha y dispara 
            direction = 1;
            modeAttack = true;
            stand = false;
            atacar();
            speedX=3;
            
        }
        
        if (Greenfoot.isKeyDown("a") && direction == -1) {//parado disparando izquierda
            modeAttack = true;
            if (Greenfoot.isKeyDown("left")) {
                stand = false;
            } else {
                stand = true;
            }
            atacar();
        }
        
        if (Greenfoot.isKeyDown("a") && direction == 1) {//parado disparando derecha
            modeAttack = true;
            if (Greenfoot.isKeyDown("right")) {
                stand = false;
            } else {
                stand = true;
            }
            atacar();
        }
        if (Greenfoot.isKeyDown("s")&& bomba > 0 ){
           
            avientaBomba();
            
            
        }
        if (!salto && (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space"))) {
            // Realiza el salto
            salto = true;
            vy = -20; // velocidad inicial del salto
        }
    }
}