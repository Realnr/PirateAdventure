package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class textField extends interactableSurface {

    public textField(double x, double y){
        super(x,y);
        image = getImage("src/main/resources/graphic/textField.png");
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(image,x,y);
        drawText(drawTool);
    }
}
