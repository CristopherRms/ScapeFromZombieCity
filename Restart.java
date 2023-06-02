import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Reinicia desde el nivel 1
 */
public class Restart extends Button
{
   
    private int A;
    private int B;
    private int C;
    private int P;
    public Restart( int a,int b,int c){
        A=a;
        B=b;
        C=c;
    }
    public void act()
    {
        check_mouse();
        if (Greenfoot.mouseClicked(this))
         Greenfoot.setWorld(new One(A,B,C,0));
    }
}
