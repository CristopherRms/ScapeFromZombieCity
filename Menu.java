import greenfoot.*; 
public class Menu extends World
{
    private GreenfootImage backgroundImage = new GreenfootImage("Menu.jpg");
    private Easy e=new Easy();
    private Medium m=new Medium();
    private Hard h=new Hard();
    private HTP p= new HTP();
    /**
     * Constructor
     */
    public Menu()
    {   
        super(800, 600, 1); 
        setBackground(backgroundImage);
        addObject(e,150,400);
        addObject(m,400,400);
        addObject(h,650,400);
        addObject(p,400,500);
    }
}
