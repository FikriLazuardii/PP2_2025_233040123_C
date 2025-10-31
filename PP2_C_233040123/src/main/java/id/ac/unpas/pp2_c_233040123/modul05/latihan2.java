/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul05;

import javax.swing.*;

/**
 *
 * @author Fikri Lazuardi
 */
public class latihan2 {
     public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable (){
           public void run() {
               JFrame frame = new JFrame("Jendela Dengan Label");
               frame.setSize(400,300);
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
               // 1. Buat komponen Jlabel
               JLabel label = new JLabel("ini adalah JLabel");
               
               // 2. Tambahkan JLabel ke JFrame
               // Secara Default, JFrame menggunakan BorderLayout.
               // dan .add() akan menambahkannya ke bagian tengah (CENTER)
               frame.add(label);
               
               frame.setVisible(true);
        }
           
        });
    }
}
