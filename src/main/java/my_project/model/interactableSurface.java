package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class interactableSurface{
    protected BufferedImage image;
    protected double x;
    protected double y;
    protected String[] Text;

    public interactableSurface(double x, double y){
        this.x = x;
        this.y = y;
    }

    protected BufferedImage getImage(String path){
        try{
            return ImageIO.read(new File(path));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    protected void drawText(DrawTool drawTool){
        if (Text == null){
            return;
        }
        drawTool.formatText("Serif", Font.ITALIC,50);
        for (int i = 0; i <Text.length && Text[i] != null; i++) {
            drawTool.drawText(x+ (double)image.getWidth()/2-16*(double)Text[i].length()/2-30,y + (double)image.getHeight()/2 + 50*(i-2),Text[i]);

        }

    }

    public void setText(String[] text) {
        Text = text;
    }

    //TODO: abstrakt machen so super() funktioniert ( habs vergessen)
    public abstract void draw(DrawTool drawTool);

}
