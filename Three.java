import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Nivel Tres
 */
public class Three extends Level1
{
    private String t;
    /**
     * Constructor 
     */
    public Three(int ata,int ataB , int ataC, int puntos)
    {    
        ataque=ata;
        ataqueB=ataB;
        sound= new GreenfootSound("N3.mp3");
        ataqueC=ataC;
        puntosAnt=puntos;
        backgroundImage=new GreenfootImage("Nivel Tres.jpg");
        shiftWorld(0);
        prepare();
        tim.mark();
        cont.setValue(120);
        pon.setValue(puntos);
    }
    /**
     * verifica lo que pasa en el nivel
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
        t="Kill the final boss";
        sound.play();
        showText(t,400,200);
        Line line= new Line();
        addObject(line,7000,300);
        addObject(cont,300,30);
        addObject(cont,300,30);
        addObject(pon,200,30);
        
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
        PersonajeB pb1= new PersonajeB(ataqueB);
        Zombie z1 =new Zombie(ataque);
        Zombie z2 =new Zombie(ataque);
        PersonajeB pb2= new PersonajeB(ataqueB);
        Zombie z3 =new Zombie(ataque);
        Zombie z4 =new Zombie(ataque);
        Zombie z5 =new Zombie(ataque);
        PersonajeB pb5= new PersonajeB(ataqueB);
        Zombie z6 =new Zombie(ataque);
        Zombie z7 =new Zombie(ataque);
        Zombie z8 =new Zombie(ataque);
        Zombie z9 =new Zombie(ataque);
        PersonajeB pb3= new PersonajeB(ataqueB);
        Zombie z10 =new Zombie(ataque);
        Zombie z11 =new Zombie(ataque);
        Zombie z12 =new Zombie(ataque);
        PersonajeB pb4= new PersonajeB(ataqueB);
        Zombie z13 =new Zombie(ataque);
        Zombie z14 =new Zombie(ataque);
        Zombie z15 =new Zombie(ataque);
        PersonajeB pb6= new PersonajeB(ataqueB);
        Zombie z16 =new Zombie(ataque);
        Zombie z17 =new Zombie(ataque);
        
        PersonajeB pb7= new PersonajeB(ataqueB);
        PersonajeB pb8= new PersonajeB(ataqueB);
        PersonajeB pb9= new PersonajeB(ataqueB);
        vidaJugador=new LifeBar();
        addObject(vidaJugador,600,30);
        addObject(pla1,120,400);
        addObject(pla2,570,450);
        addObject(pla3,1020,450);
        addObject(pb1,600,430);
        addObject(z1,700,430);
        addObject(z2,900,400);
        addObject(z3,1100,400);
        addObject(pb2,1400,430);
        addObject(pla4,1470,400);
        addObject(pla5,1920,480);
        addObject(pla6,2370,430);
        addObject(z4,2100,430);
        addObject(z5,2300,400);
        addObject(z6,2500,400);
        addObject(pb3,2600,430);
        addObject(pla7,2820,400);
        addObject(pla8,3270,350);
        addObject(pla9,3800,400);
        addObject(z7,3400,430);
        addObject(z8,3600,400);
        addObject(z9,3800,400);
        addObject(pb4,3600,430); 
        
        addObject(pla11,4250,420);
        addObject(pla12,4700,400);
        addObject(pla13,5150,480);
        addObject(pb5,5000,430);
        addObject(z10,5100,430);
        addObject(z11,5300,400);
        addObject(z12,5500,400);
        addObject(pb6,5500,430);
        addObject(pla14,5600,430);
        addObject(pla15,6050,400);
        addObject(pla16,6500,350);
        addObject(pla17,6950,390);
        addObject(pla18,7400,420);
        addObject(pla19,7850,400);
        addObject(z13,6700,430);
        addObject(z14,6900,400);
        addObject(z15,7100,400);
        addObject(z16,7300,430);
        addObject(z17,7500,400);
        addObject(pb7,7500,400);
        addObject(pb8,7700,430);
        addObject(pb9,7800,400);
        
        Inmunity i =new Inmunity();
        Life l=new Life();
        addObject(l,3000,150);
        addObject(i,350,350);
        addObject(pause,30,30);
        PowerProjectile pw= new PowerProjectile();
        addObject(pw,5000,300);
        p= new Personaje(true);
        addObject(p,100,320);
    }
    /**
     * termina la instancia del nivel
     */
    public void terminaNivel(){
            Greenfoot.playSound("puntos.mp3");
            pon.setValue(pon.getValue()+cont.getValue()*10);
            siguienteNivel();
            sound.stop();
    }
    /**
     * da paso a la instacia b del nivel
     */
    public void siguienteNivel(){
        Greenfoot.delay(100);
        ThreeB mundo = new ThreeB(ataque,ataqueB ,ataqueC,pon.getValue()); // Crear una nueva instancia del mundo
        Greenfoot.setWorld(mundo);
    }
}
