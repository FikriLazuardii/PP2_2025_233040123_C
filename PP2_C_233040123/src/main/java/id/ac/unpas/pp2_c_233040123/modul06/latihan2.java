/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Fikri Lazuardi
 */
public class latihan2 {
      public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Konverter Suhu (Event)");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 200); 
                frame.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
                frame.setLocationRelativeTo(null);
                frame.getContentPane().setBackground(new Color(40, 40, 40)); 

                JLabel label = new JLabel("Celcius:");
                label.setFont(new Font("Arial", Font.BOLD, 16));
                label.setForeground(Color.WHITE);

                JTextField input = new JTextField(10);
                input.setFont(new Font("Consolas", Font.PLAIN, 16));
                input.setBackground(new Color(230, 230, 230));
                input.setForeground(Color.BLACK);

                JLabel label1 = new JLabel("Fahrenheit:");
                label1.setFont(new Font("Arial", Font.BOLD, 16));
                label1.setForeground(Color.WHITE);

                JLabel hasil = new JLabel("...");
                hasil.setFont(new Font("Consolas", Font.BOLD, 18));
                hasil.setForeground(new Color(0, 255, 100));

                JButton button = new JButton("Konversi");
                button.setFont(new Font("Arial", Font.BOLD, 14));
                button.setBackground(new Color(0, 120, 215));
                button.setForeground(Color.WHITE);
                button.setFocusPainted(false);
                button.setPreferredSize(new Dimension(100, 35));

                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String teksInput = input.getText().trim();
                            double celcius = Double.parseDouble(teksInput);
                            double fahrenheit = (celcius * 9.0 / 5.0) + 32;
                            hasil.setText(String.format("%.2f °F", fahrenheit));
                            hasil.setForeground(new Color(0, 255, 100)); // hijau jika sukses
                        } catch (NumberFormatException ex) {
                            hasil.setText("Input Angka!");
                            hasil.setForeground(Color.RED); // merah jika salah input
                        }
                    }
                };
                button.addActionListener(listener);

                frame.add(label);
                frame.add(input);
                frame.add(label1);
                frame.add(hasil);
                frame.add(button);
                frame.setVisible(true);
            }
        });
    }
}
