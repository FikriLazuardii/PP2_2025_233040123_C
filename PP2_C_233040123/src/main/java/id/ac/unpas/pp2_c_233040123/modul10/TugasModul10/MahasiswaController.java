/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul10.TugasModul10;

/**
 *
 * @author Fikri Lazuardi
 */

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MahasiswaController {
    private MahasiswaModel model;
    private MahasiswaView view;

    public MahasiswaController(MahasiswaModel model, MahasiswaView view) {
        this.model = model;
        this.view = view;

        // Init Data Awal
        loadData();

        // Registrasi Listener ke View
        view.addSimpanListener(e -> simpanData());
        view.addEditListener(e -> editData());
        view.addHapusListener(e -> hapusData());
        view.addClearListener(e -> clearForm());
        view.addCariListener(e -> cariData());
        
        view.addTableMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.getSelectedRow();
                view.setNama(view.getValueAt(row, 1));
                view.setNim(view.getValueAt(row, 2));
                view.setJurusan(view.getValueAt(row, 3));
            }
        });
    }

    private void loadData() {
        List<Mahasiswa> data = model.getAll();
        view.updateTable(data);
    }

    private void simpanData() {
        // Validasi Kosong (Latihan 2)
        if (view.getNama().trim().isEmpty() || view.getNim().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
            return;
        }

        // Validasi Duplikasi NIM (Latihan 4)
        if (model.isNimExists(view.getNim())) {
            JOptionPane.showMessageDialog(view, "NIM sudah terdaftar!");
            return;
        }

        try {
            Mahasiswa m = new Mahasiswa(0, view.getNama(), view.getNim(), view.getJurusan());
            model.insert(m);
            JOptionPane.showMessageDialog(view, "Data Berhasil Disimpan");
            loadData();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }

    private void editData() {
         if (view.getNama().trim().isEmpty() || view.getNim().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
            return;
        }
         
        try {
            Mahasiswa m = new Mahasiswa(0, view.getNama(), view.getNim(), view.getJurusan());
            model.update(m);
            JOptionPane.showMessageDialog(view, "Data Berhasil Diubah");
            loadData();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }

    private void hapusData() {
        try {
            model.delete(view.getNim());
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
            loadData();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }

    private void cariData() { // Latihan 3
        String keyword = view.getKeywordCari();
        List<Mahasiswa> data = model.search(keyword);
        view.updateTable(data);
    }

    private void clearForm() {
        view.setNama("");
        view.setNim("");
        view.setJurusan("");
    }
}
