/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Fikri Lazuardi
 */
public class latihan1 {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("Kalkulator Latihan 1");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setLayout(new BorderLayout(8, 8));

                // Layar teks
                JTextField layar = new JTextField("0");
                layar.setEditable(false);
                layar.setHorizontalAlignment(JTextField.RIGHT);
                layar.setFont(new Font("Consolas", Font.BOLD, 26));
                layar.setBackground(new Color(30, 30, 30));
                layar.setForeground(Color.GREEN);
                layar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                frame.add(layar, BorderLayout.NORTH);

                // Panel tombol
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(4, 4, 8, 8));
                panel.setBackground(new Color(45, 45, 45));
                frame.add(panel, BorderLayout.CENTER);

                // Deretan tombol
                panel.add(new JButton("7"));
                panel.add(new JButton("8"));
                panel.add(new JButton("9"));
                panel.add(new JButton("/"));
                panel.add(new JButton("4"));
                panel.add(new JButton("5"));
                panel.add(new JButton("6"));
                panel.add(new JButton("*"));
                panel.add(new JButton("1"));
                panel.add(new JButton("2"));
                panel.add(new JButton("3"));
                panel.add(new JButton("-"));
                panel.add(new JButton("0"));
                panel.add(new JButton("C"));
                panel.add(new JButton("="));

                // Tombol tambah
                JButton tombolTambah = new JButton("+");
                tombolTambah.setBackground(new Color(220, 20, 60)); // merah tua
                tombolTambah.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
                tombolTambah.setForeground(Color.WHITE);
                tombolTambah.setToolTipText("Tombol untuk menambah (+)");
                panel.add(tombolTambah);

                frame.setVisible(true);
            } 
        });
    }
}
