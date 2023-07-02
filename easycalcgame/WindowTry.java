package easycalcgame;

import Ü6.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowTry {


    private JPanel panel1;
    private JTextField textField1;

    public static void main(String[] args) {
    WindowTry windowTry = new WindowTry();

    }


    public WindowTry() {
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            WindowTry window = new WindowTry();
                            window.panel1.setVisible(true);

                            JButton button = new JButton("User Management");
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JOptionPane.showConfirmDialog(null, "ok lets go");
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
