/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul07;

/**
 *
 * @author Fikri Lazuardi
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TugasModul07 extends JFrame {
    
      private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatpel;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;
    
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //komponen nama
        panel.add(new JLabel("nama siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);
        
        //komponen mata pelajaran (combobox)
        panel.add(new JLabel("mata pelajaran:"));
        String[] matpel = {"Matematika dasar", "Bahasa Indonesia", "Algotirma dan pemograman 1", "Praktikum pemograman 2"};
        cmbMatpel = new JComboBox<>(matpel);
        panel.add(cmbMatpel);
        
        //komponen nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);
        
        // tombol simpan
        JButton btnSimpan = new JButton("Simpan Data");

        // tombol reset
        JButton btnReset = new JButton("Reset");

        panel.add(btnReset);
        panel.add(btnSimpan);

        // event tombol simpan
        btnSimpan.addActionListener(e -> prosesSimpan());

        // event reset
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatpel.setSelectedIndex(0);
        });

        return panel;
    }
    //method untuk membuat desain tab tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        //setup model tabel 
        String[] kolom = {"Nama", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);
        
        //membungkus tabel  dengan  scrollpane
        JScrollPane scroll = new JScrollPane(tableData);
        panel.add(scroll, BorderLayout.CENTER);

        // tombol hapus
        JButton btnHapus = new JButton("Hapus Data");
        JPanel panelBawah = new JPanel();
        panelBawah.add(btnHapus);
        panel.add(panelBawah, BorderLayout.SOUTH);

        btnHapus.addActionListener(e -> {
            int row = tableData.getSelectedRow();
            if (row > -1) {
                tableModel.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Pilih baris yang ingin dihapus!",
                    "Tidak ada data dipilih",
                    JOptionPane.WARNING_MESSAGE);
            }
        });

        return panel;
    }
    //Logika validasi dan penyimpanan data
    private void prosesSimpan() {
        //1.Ambil data dari input
        String nama = txtNama.getText();
        String matpel = (String) cmbMatpel.getSelectedItem();
        String strNilai = txtNilai.getText();

        //2. Validasi Input
        // Validasi nama kosong
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
            "Error validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Validasi minimal 3 karakter
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Nama minimal 3 karakter!",
                    "Error Validasi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi nilai numerik
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 -100!",
                        "Error validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", 
                    "error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Penentuan grade
        String grade;

        switch (nilai / 10) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default:
                grade = "E";
                break;
        }
        // Simpan ke tabel
        Object[] dataBaris = {nama, matpel, nilai, grade};
        tableModel.addRow(dataBaris);
        
        //reset form
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatpel.setSelectedIndex(0);
        
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        tabbedPane.setSelectedIndex(1);
    }
    public TugasModul07() {
        //1.Konfigurasi framme utama
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(550, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //2.Inisialisasi Tabbed pane
        tabbedPane = new JTabbedPane();
        
        //3.membuat panel untuk tab 1
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input data", panelInput);
        
        //4.membuat panel untuk tab 2
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);
        
        //5.menambahkan tabbedpane
        add(tabbedPane);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TugasModul07().setVisible(true);
        });
    }
    
}
