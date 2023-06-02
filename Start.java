import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Start extends Button
{
    
     private boolean mouseOver=false;
     public void act(){
         if (Greenfoot.mouseMoved(null)){
            mouseOver =Greenfoot.mouseMoved(this);
        }
        if (mouseOver)
        setImage("green_image.png");
        else
        setImage("PRESS START.png");
         if (Greenfoot.mouseClicked(this))
         Greenfoot.setWorld(new Menu());
         
     }
}
