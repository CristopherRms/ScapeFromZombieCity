import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Botones
 */

public class Button extends Actor
{
    private boolean mouseOver=false;
    public static int MAX=225;
    /**
     * Verfica si el mouse esta encima de el
     */
    public void check_mouse()
    {
      if (Greenfoot.mouseMoved(null)){
            mouseOver =Greenfoot.mouseMoved(this);
        }
        if (mouseOver)
        ajustTransparency(MAX/3);
        else
        ajustTransparency(MAX);
  
    }
    /**
     * ajusta la transparencia de este
     */
    public void ajustTransparency(int ajust){
        GreenfootImage temp= getImage();
        temp.setTransparency(ajust);
        setImage(temp);
    }
   
}
