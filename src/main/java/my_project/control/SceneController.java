package my_project.control;

import KAGO_framework.model.abitur.datenstrukturen.BinaryTree;
import my_project.model.Scene;

public class SceneController {

    private BinaryTree<Scene> sceneBinaryTree;

    public SceneController(){


        BinaryTree<Scene> bankerTree = new BinaryTree<>(new Scene("Scene2",false), //Banker
                new BinaryTree<>(new Scene("Scene3",false), //verhandelst
                        new BinaryTree<>(new Scene("Scene4",true)), // du verlangst ein teil züruck
                        new BinaryTree<>(new Scene("Scene5",false) // du verlangst alles zurück
                                ,new BinaryTree<>(new Scene("Scene6", true)) //Kopf
                                ,new BinaryTree<>(new Scene("Scene7", true)) // Zahl
                        )),
                new BinaryTree<>(new Scene("Scene8",false) // Glückspiel
                        , new BinaryTree<>(new Scene("Scene6",true)) // Kopf
                        ,new BinaryTree<>(new Scene("Scene7",true)) // Zahl
                )
        );

        BinaryTree<Scene> piratenTree = new BinaryTree<>(new Scene("Scene16",false)
                ,new BinaryTree<>(new Scene("Scene17",false)
                        ,new BinaryTree<>(new Scene("Scene18",true))
                        ,new BinaryTree<>(new Scene("Scene19",true))
                )
                ,new BinaryTree<>(new Scene("Scene20",false)
                        ,new BinaryTree<>(new Scene("Scene21",true))
                        ,new BinaryTree<>(new Scene("Scene22",true))
                )
        );
        BinaryTree<Scene> barTree = new BinaryTree<>(new Scene("Scene10" ,false)
                ,new BinaryTree<>(new Scene("Scene11",true))
                ,new BinaryTree<>(new Scene("Scene12",false)
                    ,new BinaryTree<>(new Scene("Scene13",true))
                    ,piratenTree
                )
        );
        BinaryTree<Scene> hafenTree = new BinaryTree<>(new Scene("Scene14",false)
                ,new BinaryTree<>(new Scene("Scene15",true))
                ,piratenTree
        );

        sceneBinaryTree = new BinaryTree<>(new Scene("Scene1",false),
                bankerTree,
                new BinaryTree<>(new Scene("Scene9",false)
                        ,barTree
                        ,hafenTree
                ));
    }

    public void updateScene(double mouseX, double mouseY){
        Scene scene = sceneBinaryTree.getContent();

        if(sceneBinaryTree.getContent().isEndScene())
            return;

        if(!scene.isButtonsExist()){
            scene.goToNextEvent();
            return;
        }
        if(scene.isLeftButtonPressed(mouseX,mouseY)) {
            sceneBinaryTree = sceneBinaryTree.getLeftTree();
        }else if(scene.isRightButtonPressed(mouseX,mouseY))
            sceneBinaryTree = sceneBinaryTree.getRightTree();
    }

    public Scene getSceneBinaryTreeContent() {
        return sceneBinaryTree.getContent(); 
    }
}
