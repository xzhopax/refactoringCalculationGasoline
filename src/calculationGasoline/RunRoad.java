package calculationGasoline;

import javax.swing.*;

public class RunRoad {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuGUI gui = new MenuGUI();// creat panel MenuGUI
            gui.setVisible(true); // show panel
        });
    }

}
