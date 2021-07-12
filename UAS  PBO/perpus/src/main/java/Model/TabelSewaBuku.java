/*
Nama: Muhammad Naufal Firdana Trisya
Nim: A11.2019.11671
Kelas: A11.4423
 */
package Model;

import java.util.List;/*Untuk memanggil package List pada java */
import javax.swing.table.AbstractTableModel;/*Untuk memanggil swing table AbstractTableModel pada java*/
/**
 *
 * @author Firdana
 */
public class TabelSewaBuku  extends AbstractTableModel{
    List<mTable> list_sewaBuku;

     public TabelSewaBuku(List<mTable> list_sewaBuku){
        this.list_sewaBuku = list_sewaBuku;
    }
     
    @Override
    public int getRowCount() {
         return this.list_sewaBuku.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
                case 0:
                    return list_sewaBuku.get(rowIndex).id;
                    case 1:
                    return list_sewaBuku.get(rowIndex).judul;
                    case 2:
                    return list_sewaBuku.get(rowIndex).tanggal_pinjam;
                    case 3:
                    return list_sewaBuku.get(rowIndex).tanggal_harus_kembali;
                    case 4:
                    return list_sewaBuku.get(rowIndex).tanggal_kembali;
                    case 5:
                    return list_sewaBuku.get(rowIndex).denda;
                    case 6:
                    return list_sewaBuku.get(rowIndex).biaya_sewa;
                default :
                    return null;
            }
    }
    
     @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Judul";
            case 2:
                return "Tanggal Pinjam";
            case 3:
                return "Tanggal Harus Kembali";
            case 4:
                return "Tanggal Kembali";
            case 5:
                return "Denda";
            case 6:
                return "Biaya Sewa";
            default :
                return null;
        }
    }
}
