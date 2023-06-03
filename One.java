import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Nivel 1 del juego.
 * Extiende la clase Level1.
 * 
 * @autor CristopherRms
 * @version 1.0
 */
public class One extends Level1
{
    Zombie z1 = new Zombie(ataque);
    private String t;
    private String s;
    // the filename is the same as the one you would use in the playSound method;

    /**
     * Constructor de la clase One.
     * Crea una nueva instancia de la clase One.
     * 
     * @param ata el valor del ataque
     * @param ataB el valor del ataque B
     * @param ataC el valor del ataque C
     * @param puntos los puntos obtenidos
     */
    public One(int ata, int ataB, int ataC, int puntos)
    {    
        sound = new GreenfootSound("N1.mp3");
        ataque = ata;
        ataqueB = ataB;
        ataqueC = ataC;
        puntosAnt = puntos;
        backgroundImage = new GreenfootImage("City1.jpg");
        shiftWorld(0);
        prepare();
        tim.mark();
        cont.setValue(120);
        pon.setValue(puntos);
    }

    /**
     * Verifica qué ocurre en el nivel.
     */
    public void checkLevel()
    {
        if (p.getX() == 400) {
            t = "";
            showText(t, 400, 200);
        }
        if (ataque == 10) {
            s = "E";
            showText(s, 780, 580);
        }
        if (ataque == 15) {
            s = "M";
            showText(s, 780, 580);
        }
        if (ataque == 20) {
            s = "H";
            showText(s, 780, 580);
        }
    }

    /**
     * Prepara el nivel.
     */
    private void prepare()
    {   
        t = "Find the key to enter the hospital";
        sound.play();
        showText(t, 400, 200);
        addObject(cont, 300, 30);
        addObject(pon, 200, 30);
        Key key = new Key();
        key.setImage("llave.png");
        Plataform pla1 = new Plataform();
        Plataform pla2 = new Plataform();
        Plataform pla3 = new Plataform();
        Plataform pla4 = new Plataform();
        Plataform pla5 = new Plataform();
        Plataform pla6 = new Plataform();
        Plataform pla7 = new Plataform();
        Plataform pla8 = new Plataform();
        Plataform pla9 = new Plataform();
        Plataform pla10 = new Plataform();
        Plataform pla11 = new Plataform();
        Plataform pla12 = new Plataform();
        Plataform pla13 = new Plataform();
        Plataform pla14 = new Plataform();
        Plataform pla15 = new Plataform();
        Plataform pla16 = new Plataform();
        Plataform pla17 = new Plataform();
        Plataform pla18 = new Plataform();
        Plataform pla19 = new Plataform();
        Plataform pla20 = new Plataform();
        
        Zombie z2 = new Zombie(ataque);
        Zombie z3 = new Zombie(ataque);
        Zombie z4 = new Zombie(ataque);
        Zombie z5 = new Zombie(ataque);
        Zombie z6 = new Zombie(ataque);
        Zombie z7 = new Zombie(ataque);
        Zombie z8 = new Zombie(ataque);
        Zombie z9 = new Zombie(ataque);
        Zombie z10 = new Zombie(ataque);
        Zombie z11 = new Zombie(ataque);
        Zombie z12 = new Zombie(ataque);
        Zombie z13 = new Zombie(ataque);
        Zombie z14 = new Zombie(ataque);
        Zombie z15 = new Zombie(ataque);
        Zombie z16 = new Zombie(ataque);
        Zombie z17 = new Zombie(ataque);
        Zombie z18 = new Zombie(ataque);
        Zombie z19 = new Zombie(ataque);
        vidaJugador = new LifeBar();
        addObject(vidaJugador, 600, 30);
        addObject(pla1, 120, 570);
        addObject(pla2, 570, 500);
        addObject(pla3, 1020, 450);
        addObject(z1, 700, 430);
        addObject(z2, 900, 400);
        addObject(z3, 1100, 400);
        addObject(pla4, 1470, 570);
        addObject(pla5, 1920, 500);
        addObject(pla6, 2370, 450);
        addObject(z4, 2100, 430);
        addObject(z5, 2300, 400);
        addObject(z6, 2500, 400);
        addObject(pla7, 2820, 570);
        addObject(pla8, 3270, 550);
        addObject(pla9, 3800, 400);
        addObject(z7, 3400, 430);
        addObject(z8, 3600, 400);
        addObject(z9, 3800, 400);
        addObject(pla10, 3270, 200);
        addObject(pla19, 3270, 570);
        addObject(key, 3270, 150);
        addObject(pla11, 4250, 570);
        addObject(pla12, 4700, 500);
        addObject(pla13, 5150, 450);
        addObject(z10, 5100, 430);
        addObject(z11, 5300, 400);
        addObject(z12, 5500, 400);
        addObject(pla14, 5600, 570);
        addObject(pla15, 6050, 500);
        addObject(pla16, 6500, 450);
        addObject(pla17, 6950, 570);
        addObject(pla18, 7400, 550);
        addObject(pla19, 7850, 400);
        addObject(z13, 6700, 430);
        addObject(z14, 6900, 400);
        addObject(z15, 7100, 400);
        addObject(z16, 7300, 430);
        addObject(z17, 7500, 400);
        addObject(z18, 7700, 400);
        Hospital h = new Hospital();
        addObject(h, 7500, 400);
        Inmunity i = new Inmunity();
        Life l = new Life();
        addObject(l, 3000, 150);
        addObject(i, 350, 350);
        addObject(pause, 30, 30);
        PowerProjectile pw = new PowerProjectile();
        addObject(pw, 5000, 300);
        p = new Personaje(true);
        addObject(p, 100, 500);
    }

    /**
     * Finaliza el nivel actual y suma los puntos que el tiempo da.
     */
    public void terminaNivel()
    {
        Greenfoot.playSound("puntos.mp3");
        pon.setValue(pon.getValue() + (cont.getValue() * 10));
        siguienteNivel();
        sound.stop();
    }

    /**
     * Avanza al siguiente nivel.
     */
    public void siguienteNivel()
    {
        Greenfoot.delay(100);
        Two mundo = new Two(ataque, ataqueB, ataqueC, pon.getValue()); // Crear una nueva instancia del mundo
        Greenfoot.setWorld(mundo);
    }
}
