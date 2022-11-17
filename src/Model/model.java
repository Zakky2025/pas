package Model;

import Controler.controller;
import Konek.koneksi;
import View.view;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class model implements controller{

    @Override
    public void simpan(view v) throws SQLException {
        try {
            Connection con = koneksi.getCon();
            String sql ="Insert Into siswa Values(?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, v.txtnis.getText());
            prepare.setString(2, v.txtnm.getText());
            prepare.setString(3, (String) v.cmbjurusan.getSelectedItem());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null,"Ud masuk kok mmmhhhhh");
            prepare.close();
            Baru(v);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            tampil(v);
        }
    }

    @Override
    public void ubah(view v) throws SQLException {
        try {
            Connection con = koneksi.getCon();
            String sql ="UPDATE siswa SET nama=?"+"jurusan=? WHERE NIS=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, v.txtnis.getText());
            prepare.setString(2, v.txtnm.getText());
            prepare.setString(3, (String) v.cmbjurusan.getSelectedItem());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null,"sudah hilang kok sayang");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            tampil(v);
            Baru(v);
        } 
    }

    @Override
    public void hapus(view v) throws SQLException {
        try {
            Connection con = koneksi.getCon();
            String sql ="DELETE FROM siswa WHERE NIS=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, v.txtnis.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null,"sudah hilang kok sayang");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            tampil(v);
            Baru(v);
        } 
    }
    
    @Override
    public void Baru(view v) throws SQLException {
        v.txtnis.setText("");
        v.txtnm.setText("");
        v.cmbjurusan.setSelectedIndex(0);
    }
    @Override
    public void tampil(view v) throws SQLException {
        v.tblmodel.getDataVector().removeAllElements();
        v.tblmodel.fireTableDataChanged();
         try {
            Connection con = koneksi.getCon();
            Statement stt = con.createStatement();
            String sql = "SELECT * FROM siswa ORDER BY NIS ASC";
            ResultSet res = stt.executeQuery(sql);
            while (res.next()){
                Object[] ob = new Object[6];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void klik(view v) throws SQLException {
        try {
            int pilih = v.tbl.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            v.txtnis.setText(v.tbl.getValueAt(pilih, 0).toString());
            v.txtnm.setText(v.tbl.getValueAt(pilih, 1).toString());
            v.cmbjurusan.setSelectedItem(v.tbl.getValueAt(pilih, 2).toString());
        } catch (Exception e) {
        }
    }

    
   
}
