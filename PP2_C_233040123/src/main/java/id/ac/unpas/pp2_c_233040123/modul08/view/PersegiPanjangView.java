/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul08.view;

/**
 *
 * @author Fikri Lazuardi
 */

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasilLuas = new JLabel("-");
    private JLabel lblHasilKeliling = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        // Inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 250);
        this.setLayout(new GridLayout(5, 2, 10, 10)); // Grid 4 baris
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasilLuas);
        this.add(new JLabel("Hasil Keliling:")); // Spacer kosong
        this.add(lblHasilKeliling);
        this.add(btnHitung);
        this.add(btnReset);
    }
    
        // Mengambil nilai panjang dari Textfield
        public double getPanjang() {
            return Double.parseDouble(txtPanjang.getText());
        }
        
        // Mengambil nilai lebar dari Textfield
        public double getLebar() {
            return Double.parseDouble(txtLebar.getText());
        }
        
        // Menampilkan hasil luas ke Label
        public void setHasilLuas(double luas) {
            lblHasilLuas.setText(String.valueOf(luas));
        }
        
        // Menampilkan hasil keliling ke Label
        public void setHasilKeliling(double keliling) {
            lblHasilKeliling.setText(String.valueOf(keliling));
        }
        
         // Reset input dan hasil
        public void reset() {
            txtPanjang.setText("");
            txtLebar.setText("");
            lblHasilLuas.setText("-");
            lblHasilKeliling.setText("-");
        }
          
        // Menampilkan pesan error (Jika input bukan angka)
        public void tampilkanPesanError(String pesan) {
            JOptionPane.showMessageDialog(this, pesan);
        }
        
        // Mendaftarkan Listener untuk tombol (Controller yang akan memberikan aksinya)
        public void addHitungListener(ActionListener listener) {
            btnHitung.addActionListener(listener);
        }
        
        public void addResetListener(ActionListener x) {
        btnReset.addActionListener(x);
        }
       
}
        
        
