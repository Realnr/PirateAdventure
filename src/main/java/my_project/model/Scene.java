package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.DrawTool;
import my_project.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import my_project.Config;

public class Scene extends GraphicalObject {
    private String name;
    private BufferedImage backgroundImage;
    private textField textField;
    private Queue<String[]> textQueue;
    private Button[] buttons;

    private boolean buttonsExist;

    private boolean isEndScene;


    public Scene(String name, boolean isEndScene){
        this.name = name;
        backgroundImage = Util.getImageFromFolder(name);
        createInteractableSurfaces();
        this.isEndScene = isEndScene;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawFilledRectangle(0,0,600,629);
        drawTool.drawImage(backgroundImage,0,0);
        drawInteractableSurfaces(drawTool);
    }

    private void createInteractableSurfaces(){
        buttons = new Button[]{
                new Button(0,(double)Config.WINDOW_HEIGHT/2, Util.getTextFromFolder(name,1)),
                        new Button((double)Config.WINDOW_WIDTH/2,(double)Config.WINDOW_HEIGHT/2, Util.getTextFromFolder(name,2))
        };
        textField = new textField(0,(double)(Config.WINDOW_HEIGHT-29)/2-9);
        textQueue = Util.createTextQueue(name);
        textField.setText(textQueue.front());

    }
    private void drawInteractableSurfaces(DrawTool drawTool){
        if(buttonsExist) {
            buttons[0].draw(drawTool);
            buttons[1].draw(drawTool);
        }else{
            textField.draw(drawTool);
        }
    }


    public void goToNextEvent(){
        textQueue.dequeue();
        if(textQueue.isEmpty()) {
            buttonsExist = true;
            return;
        }
        textField.setText(textQueue.front());
    }


    public boolean isLeftButtonPressed(double mouseX, double mouseY){
            return buttons[0].isPressed(mouseX,mouseY);
    }
    public boolean isRightButtonPressed(double mouseX, double mouseY){
            return buttons[1].isPressed(mouseX,mouseY);
    }

    public boolean isButtonsExist() {
        return buttonsExist;
    }

    public boolean isEndScene() {
        return isEndScene;
    }
}
