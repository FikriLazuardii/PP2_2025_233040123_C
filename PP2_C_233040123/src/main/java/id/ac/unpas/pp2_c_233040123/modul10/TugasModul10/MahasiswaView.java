/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul10.TugasModul10;

/**
 *
 * @author Fikri Lazuardi
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

public class MahasiswaView extends JFrame {
     // Komponen UI dibuat private, akses lewat getter
    private JTextField txtNama, txtNIM, txtJurusan, txtCari;
    private JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    private JTable tableMahasiswa;
    private DefaultTableModel model;

    public MahasiswaView() {
        setTitle("MVC Mahasiswa App");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- Panel Form ---
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        txtNama = new JTextField();
        txtNIM = new JTextField();
        txtJurusan = new JTextField();
        
        panelForm.add(new JLabel("Nama:")); panelForm.add(txtNama);
        panelForm.add(new JLabel("NIM:")); panelForm.add(txtNIM);
        panelForm.add(new JLabel("Jurusan:")); panelForm.add(txtJurusan);

        // --- Panel Tombol ---
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");
        
        panelTombol.add(btnSimpan); panelTombol.add(btnEdit);
        panelTombol.add(btnHapus); panelTombol.add(btnClear);

        // --- Panel Cari ---
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");
        panelCari.add(new JLabel("Cari Nama:")); panelCari.add(txtCari); panelCari.add(btnCari);

        // --- Layouting Atas ---
        JPanel panelAtas = new JPanel();
        panelAtas.setLayout(new BoxLayout(panelAtas, BoxLayout.Y_AXIS));
        panelAtas.add(panelForm);
        panelAtas.add(panelTombol);
        panelAtas.add(panelCari);
        add(panelAtas, BorderLayout.NORTH);

        // --- Tabel ---
        model = new DefaultTableModel(new String[]{"No", "Nama", "NIM", "Jurusan"}, 0);
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);
    }

    // --- Getter untuk Data Form ---
    public String getNama() { return txtNama.getText(); }
    public String getNim() { return txtNIM.getText(); }
    public String getJurusan() { return txtJurusan.getText(); }
    public String getKeywordCari() { return txtCari.getText(); }

    // --- Setter untuk Form ---
    public void setNama(String v) { txtNama.setText(v); }
    public void setNim(String v) { txtNIM.setText(v); }
    public void setJurusan(String v) { txtJurusan.setText(v); }

    // --- Helper untuk Tabel ---
    public int getSelectedRow() { return tableMahasiswa.getSelectedRow(); }
    public String getValueAt(int row, int col) { return model.getValueAt(row, col).toString(); }

    public void updateTable(List<Mahasiswa> data) {
        model.setRowCount(0); // Reset
        int no = 1;
        for (Mahasiswa m : data) {
            model.addRow(new Object[]{no++, m.getNama(), m.getNim(), m.getJurusan()});
        }
    }

    // --- Listener Injection (Agar Controller bisa menghandle klik) ---
    public void addSimpanListener(ActionListener l) { btnSimpan.addActionListener(l); }
    public void addEditListener(ActionListener l) { btnEdit.addActionListener(l); }
    public void addHapusListener(ActionListener l) { btnHapus.addActionListener(l); }
    public void addClearListener(ActionListener l) { btnClear.addActionListener(l); }
    public void addCariListener(ActionListener l) { btnCari.addActionListener(l); }
    public void addTableMouseListener(MouseAdapter l) { tableMahasiswa.addMouseListener(l); }
}
