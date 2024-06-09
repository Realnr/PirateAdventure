package my_project.view;

import KAGO_framework.model.InteractiveGraphicalObject;
import my_project.control.ProgramController;
import my_project.control.SceneController;

import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManager extends InteractiveGraphicalObject {

    private SceneController sceneController;



    public InputManager(SceneController sceneController){
        this.sceneController = sceneController;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        sceneController.updateScene(e.getX(),e.getY());
    }

}
