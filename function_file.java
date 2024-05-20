import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class function_file {
    GUI gui;
    String fileName;
    String fileAddress;
    public function_file(GUI gui) {
        this.gui = gui;
    }

    public void newfile() {
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void openfile() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));

            gui.textArea.setText("");

            String line =null;

            while((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();
        }
        catch(Exception e) {
            System.out.println("Error opening file");
        }

    }

    public void savefile() {

        if(fileName == null) {
            saveAsfile();
        }
        else{
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(fileName);
                gui.window.setTitle(fileName);
                fw.close();
            }
            catch(Exception e) {
                System.out.println("Error saving file");
            }
        }
    }

    public void saveAsfile() {

        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        }
        catch(Exception e) {
            System.out.println("Error saving file");
        }
    }

    public void exitFile() {
        System.exit(0);
    }
}
