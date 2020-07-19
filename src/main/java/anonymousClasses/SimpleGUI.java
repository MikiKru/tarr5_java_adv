package anonymousClasses;

import javax.swing.*;

public class SimpleGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();                    // obiekt okna aplikacji
        JLabel label = new JLabel("tekst");         // etykieta
        JButton button = new JButton("click me");   // przycisk
        // konfiguracja kontrolek
        label.setBounds(20,20, 100, 20);
        frame.add(label);
        button.setBounds(20,50, 100, 20);
        frame.add(button);

        // konfiguracja okna
        frame.setSize(200,150);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
