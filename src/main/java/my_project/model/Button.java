package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Button extends interactableSurface {


    public Button(double x, double y, String[] Text){
        super(x,y);
        image = getImage("src/main/resources/graphic/Button.png");
        this.Text = Text;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(image,x,y);
        drawText(drawTool);
    }

    public boolean isPressed(double mouseX, double mouseY){
        if(x < mouseX && y < mouseY && x + image.getWidth() > mouseX && y + image.getHeight() > mouseY)
            return true;
        return false;
    }
}
