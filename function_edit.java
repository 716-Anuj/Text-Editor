public class function_edit {
    GUI gui;

    public function_edit(GUI gui) {this.gui = gui;}

    public void undo()
    {
        gui.un.undo();
    }

    public void redo()
    {
        gui.un.redo();
    }
}
