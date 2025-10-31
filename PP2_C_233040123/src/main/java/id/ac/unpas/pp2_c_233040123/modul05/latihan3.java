/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul05;

import javax.swing.*;
import java.awt.FlowLayout;  

/**
 *
 * @author Fikri Lazuardi
 */
public class latihan3 {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable (){
           public void run() {
               JFrame frame = new JFrame("Label dan Tombol");
               frame.setSize(400,300);
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
               // 1. Atur Layout Manajer
               // Flowlayout akan menyusun komponen dari kiri ke kanan
               frame.setLayout(new FlowLayout());
               
               // 2. Buat komponen GUI
               JLabel label = new JLabel("Text Awal");
               JButton button = new JButton("Klik Saya!");
               
               /* 3. Tambahkan aksi (ActionListener) ke tombol 
               penambahan ini menggunakan lamba untuk mempersingkat
               penggunaan anonymus inner class*/
               button.addActionListener(e -> {
               // Aksi ini akan mengubah text pada label
                label.setText("Tombol berhasil diklik!");
               });
               
               /* 4. Tambahkan komponen ke frame 
               Karena kita menggunakan FlowLayout,
               keduanya akan tampil berdampingan
               */
               frame.add(label);
               frame.add(button);
  
               frame.setVisible(true);
        }
           
        });
    }
}
