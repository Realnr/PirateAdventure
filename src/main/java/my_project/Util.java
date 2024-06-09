package my_project;

import KAGO_framework.model.abitur.datenstrukturen.Queue;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Util {
    public static BufferedImage getImageFromFolder(String path){
        try{
            return ImageIO.read(new File("src/main/resources/graphic/" + path + "/" + path + "Image" + ".png"));
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static <ContentType> int countQueue(Queue<ContentType> queue) {
        int count = 0;
        Queue<ContentType> helpQueue = new Queue<>();
        while (!queue.isEmpty()) {
            helpQueue.enqueue(queue.front());
            queue.dequeue();
            count++;
        }
        while (!helpQueue.isEmpty()) {
            queue.enqueue(helpQueue.front());
            helpQueue.dequeue();
        }
        return count;
    }

    public static Queue<String[]> createTextQueue(String path){
        File directory = new File("src/main/resources/graphic/" + path + "/" + "textQueue");
        int count = directory.list().length;
        Queue<String[]> queue = new Queue<>();
        for (int i = 0; i < count; i++) {
            try {
               queue.enqueue(readFile("src/main/resources/graphic/" + path + "/" + "textQueue" + "/" + "Text" + (i+1),20));
            } catch (IOException e){
                throw  new RuntimeException(e);
            }
        }
        return queue;
    }
    public static String[] getTextFromFolder(String path, int num){
        try{
            return readFile("src/main/resources/graphic/" + path + "/" + "choice" + num,11);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    private static String[] readFile(String file, int maxLineLength) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String[] output = new String[5];
        int index = 0;

        String line = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            while((line = reader.readLine()) != null) {

                if(stringBuilder.toString().length() + line.length() > maxLineLength ){
                    output[index] = stringBuilder.toString();
                    index++;
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(line + " ");

            }
            output[index] = stringBuilder.toString();

            return output;
        } finally {
            reader.close();
        }
    }

    //TODO: abstrahier und organisier die Util Klasse
}
