package src;

import src.gui.GUIWindow;

public class Main {
    public static void main(String args[]) {
        GUIWindow gui = new GUIWindow();

        gui.setUpGUI();
        gui.setUpButtonListener();
    }
}
