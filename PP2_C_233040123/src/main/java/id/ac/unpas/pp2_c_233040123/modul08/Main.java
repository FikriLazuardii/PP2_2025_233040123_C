/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul08;

import id.ac.unpas.pp2_c_233040123.modul08.controller.PersegiPanjangController;
import id.ac.unpas.pp2_c_233040123.modul08.model.PersegiPanjangModel;
import id.ac.unpas.pp2_c_233040123.modul08.view.PersegiPanjangView;

/**
 *
 * @author Fikri Lazuardi
 */
public class Main {
    public static void main(String[] args) {
        // 1. Instaniasi Model
        PersegiPanjangModel model = new PersegiPanjangModel();
        
        // 2. Instaniasi View
        PersegiPanjangView view = new PersegiPanjangView();
        
        // 3. Instaniasi Controller (Hubungkan Model & View)
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        
        // 4. Tampilkan View 
        view.setVisible(true);
    }
}
