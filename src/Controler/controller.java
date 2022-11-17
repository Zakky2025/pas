package Controler;

import View.view;
import java.sql.SQLException;

public interface controller {
public void simpan(view v) throws SQLException;
public void ubah(view v) throws SQLException;    
public void hapus(view v) throws SQLException;
public void tampil(view v) throws SQLException;
public void Baru(view v) throws SQLException;
public void klik(view v) throws SQLException;
}
