import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Two here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Two extends Level1
{
    private String t;
    
    /**
     * Constructor for objects of class Two.
     * 
     */
    public Two(int ata,int ataB , int ataC, int puntos)
    {    
        backgroundImage=new GreenfootImage("NivelDos.png");
        
        sound= new GreenfootSound("N2.mp3");
        ataque=ata;
        ataqueB=ataB;
        ataqueC=ataC;
        shiftWorld(0);
        prepare();
        puntosAnt=puntos;
        tim.mark();
        cont.setValue(120);
        pon.setValue(puntos);
    }
    /**
     * Verifica que pasa en el nivel 
     */
    public void checkLevel(){
        if(p.getX()==400){
            t="";
            showText(t,400,200);
        }
    }
    /**
     * prepara el nivel
     */
    private void prepare()
    {   
        addObject(cont,300,30);
        addObject(pon,200,30);
        t="Find the cure and get out of the hospital";
        sound.play();
        showText(t,400,200);
        Key key =new Key();
        
        key.setImage("cura.png");
        Plataform pla1=new Plataform();
        Plataform pla2=new Plataform();
        Plataform pla3=new Plataform();
        Plataform pla4=new Plataform();
        Plataform pla5=new Plataform();
        Plataform pla6=new Plataform();
        Plataform pla7=new Plataform();
        Plataform pla8=new Plataform();
        Plataform pla9=new Plataform();
        Plataform pla10=new Plataform();
        Plataform pla11=new Plataform();
        Plataform pla12=new Plataform();
        Plataform pla13=new Plataform();
        Plataform pla14=new Plataform();
        Plataform pla15=new Plataform();
        Plataform pla16=new Plataform();
        Plataform pla17=new Plataform();
        Plataform pla18=new Plataform();
        Plataform pla19=new Plataform();
        Plataform pla20=new Plataform();
        Zombie z1 =new Zombie(ataque);
        Zombie z2 =new Zombie(ataque);
        Zombie z3 =new Zombie(ataque);
        Zombie z4 =new Zombie(ataque);
        Zombie z5 =new Zombie(ataque);
        Zombie z6 =new Zombie(ataque);
        Zombie z7 =new Zombie(ataque);
        Zombie z8 =new Zombie(ataque);
        Zombie z9 =new Zombie(ataque);
        Zombie z10 =new Zombie(ataque);
        Zombie z11 =new Zombie(ataque);
        Zombie z12 =new Zombie(ataque);
        Zombie z13 =new Zombie(ataque);
        Zombie z14 =new Zombie(ataque);
        Zombie z15 =new Zombie(ataque);
        Zombie z16 =new Zombie(ataque);
        Zombie z17 =new Zombie(ataque);
        Zombie z18 =new Zombie(ataque);
        Zombie z19 =new Zombie(ataque);
        PersonajeB pb1= new PersonajeB(ataqueB);
        PersonajeB pb2= new PersonajeB(ataqueB);
        PersonajeB pb3= new PersonajeB(ataqueB);
        vidaJugador=new LifeBar();
        addObject(vidaJugador,600,30);
        addObject(pla1,120,570);
        addObject(pla2,570,550);
        addObject(pla3,1020,570);
        addObject(z1,700,50);
        addObject(z2,900,400);
        addObject(z3,1100,400);
        addObject(pb1,1100,400);
        addObject(pla4,1470,570);
        addObject(pla5,1920,500);
        addObject(pla6,2370,560);
        addObject(z4,2100,430);
        addObject(z5,2300,400);
        addObject(z6,2500,400);
        addObject(pla7,2820,570);
        addObject(pla8,3270,550);
        addObject(pla9,3800,500);
        addObject(z7,3400,430);
        addObject(z8,3600,400);
        addObject(z9,3800,400);
        addObject(pb2,3800,400);
        addObject(pla10,3270,200);
        addObject(key,3270,150);
        addObject(pla11,4250,570);
        addObject(pla12,4700,500);
        addObject(pla13,5150,500);
        
        addObject(z10,5100,430);
        addObject(z11,5300,400);
        addObject(z12,5500,400);
        addObject(pla14,5600,500);
        addObject(pla15,6050,520);
        addObject(pla16,6500,550);
        addObject(pla17,6950,560);
        addObject(pb3,6950,560);
        addObject(pla18,7400,550);
        addObject(pla19,7850,500);
        addObject(z13,6700,430);
        addObject(z14,6900,400);
        addObject(z15,7100,400);
        addObject(z16,7300,430);
        addObject(z17,7500,400);
        addObject(z18,7700,400);
        PowerProjectile pw= new PowerProjectile();
        Inmunity i =new Inmunity();
        Life l=new Life();
        addObject(i,3000,150);
        addObject(pw,350,350);
        addObject(pause,30,30);
        Door d= new Door();
        addObject(d,6000,400);
        addObject(l,4000,300);
        p= new Personaje(true);
        p.key=false;
        addObject(p,100,500);
    }
    /**
     * da fin a este nivel
     */
    public void terminaNivel(){
            Greenfoot.playSound("puntos.mp3");
            pon.setValue(pon.getValue()+cont.getValue()*10);
            siguienteNivel();
            sound.stop();
    }
    /**
     * da paso a el nivel 3
     */
    public void siguienteNivel(){
        Greenfoot.delay(100);
        Three mundo = new Three(ataque,ataqueB,ataqueC,pon.getValue()); // Crear una nueva instancia del mundo
        Greenfoot.setWorld(mundo);
    }
    
    
    
}
