/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul10.TugasModul10;

/**
 *
 * @author Fikri Lazuardi
 */

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Buat Model
            MahasiswaModel model = new MahasiswaModel();
            // 2. Buat View
            MahasiswaView view = new MahasiswaView();
            // 3. Buat Controller (Hubungkan keduanya)
            new MahasiswaController(model, view);
            
            // 4. Tampilkan View
            view.setVisible(true);
        });
    }
}
