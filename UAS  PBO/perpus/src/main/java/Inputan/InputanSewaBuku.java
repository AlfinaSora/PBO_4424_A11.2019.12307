/*
Nama: Muhammad Naufal Firdana Trisya
Nim: A11.2019.11671
Kelas: A11.4423
 */
package Inputan;
import Koneksi.Koneksi; /*Untuk memanggil Koneksi.java dalam Package Koneksi*/
import Model.mTable; /*Untk memanggil mTable.java dalam Package Model*/
import java.sql.Connection; /*Untuk memanggil package sql connection pada java*/
import java.sql.PreparedStatement; /*Untuk memanggil package sql PreparedSteatement pada java*/
import java.sql.ResultSet; /*Untuk memanggil package sql ResultSet pada java*/
import java.sql.SQLException; /*Untuk memanggil package sql SQLException pada java */
import java.sql.Statement; /*Untuk memanggil package sql Statement pada java */
import java.text.ParseException; /*Untuk memanggil package text ParseException pada java */
import java.text.SimpleDateFormat; /*Untuk memanggil package text SimpleDateFormat pada java */
import java.time.Duration; /*Untuk memanggil package time Duration pada java */
import java.time.LocalDate; /*Untuk memanggil package time LocalDate pada java */
import java.time.format.DateTimeFormatter; /*Untuk memanggil package time format DateTimeFormatter pada java */
import java.util.ArrayList; /*Untuk memanggil package ArrayList pada java */
import java.util.Calendar; /*Untuk memanggil package Calender pada java */
import java.util.Date; /*Untuk memanggil package Date pada java */
import java.util.List; /*Untuk memanggil package List pada java */
import java.util.logging.Level; /*Untuk memanggil package logging level pada java */
import java.util.logging.Logger; /*Untuk memanggil package logging loggerr pada java */
import Interfaces.InterfacesSewaBuku; /*Untuk memanggil InterfaceSewaBuku.java dalam package Interfaces*/

/**
 *
 * @author Firdana
 */
public class InputanSewaBuku implements InterfacesSewaBuku{
     Connection con = Koneksi.GetConnection();
     
    @Override
    public List<mTable> GetAll() {
       SimpleDateFormat format_waktu = new SimpleDateFormat("dd MMMM yyyy");
         List<mTable> list_sewaBuku = null ;
     try{
         list_sewaBuku = new ArrayList<mTable>();
         Statement st = con.createStatement();
         String query = "SELECT * FROM sewabuku";
         ResultSet rs = st.executeQuery(query);
         while(rs.next()){
             mTable newObj = new mTable();
             newObj.id = rs.getInt("id");
             newObj.judul = rs.getString("judul");
             
             newObj.tanggal_pinjam = rs.getString("tanggal_pinjam");
             String _tgl_pinjam = newObj.tanggal_pinjam;
             Date date_pinjam = new SimpleDateFormat("yyyy-MM-dddd").parse(_tgl_pinjam);
             newObj.tanggal_pinjam = format_waktu.format(date_pinjam);
             
             newObj.tanggal_harus_kembali = rs.getString("tanggal_harus_kembali");
             String _tgl_harusKembali = newObj.tanggal_harus_kembali;
             Date date_harus_kembali = new SimpleDateFormat("yyyy-MM-dddd").parse(_tgl_harusKembali);
             newObj.tanggal_harus_kembali = format_waktu.format(date_harus_kembali);
             
             newObj.tanggal_kembali = rs.getString("tanggal_kembali");
             if(newObj.tanggal_kembali != null){
             String _tgl_kembali = newObj.tanggal_kembali;
             Date date_kembali = new SimpleDateFormat("yyyy-MM-dddd").parse(_tgl_kembali);
             newObj.tanggal_kembali = format_waktu.format(date_kembali);
             }else{
                 newObj.tanggal_kembali = "";
             }
            
             
             newObj.denda = rs.getInt("denda");
             newObj.biaya_sewa = rs.getInt("biaya_sewa");
             list_sewaBuku.add(newObj);
         }
     }
     catch(SQLException e){
         System.out.println("Error");
     }   catch (ParseException ex) {
             Logger.getLogger(InputanSewaBuku.class.getName()).log(Level.SEVERE, null, ex);
         }
    return list_sewaBuku;
    }
    
     //sql querry
    String query_InsertData = "INSERT INTO sewabuku (judul,tanggal_pinjam,tanggal_harus_kembali, biaya_sewa) VALUES (?,?,?,?)";
    public void InserNewData(String _judul,String _tanggal_pinjam, String _tanggal_harus_kembali){
         PreparedStatement statement = null;
         int biaya_sewa = 5000;
         try{
              statement = con.prepareStatement(query_InsertData);
              statement.setString(1, _judul);
              statement.setString(2, _tanggal_pinjam);
              statement.setString(3, _tanggal_harus_kembali);
              statement.setInt(4, biaya_sewa);
              statement.execute();
         }
         catch(SQLException e){
              System.out.println("Gagal");
         }
         finally
        {
            try 
            {
                statement.close();
            } catch (SQLException ex) 
            {
               System.out.println("Gagal");          
            }
        }
    }
    
String query_updateData = "UPDATE sewabuku SET judul = ? WHERE id = ?";
    public void UpdateData(int _id,String _judul){
         PreparedStatement statement = null;
         
         try{
              statement = con.prepareStatement(query_updateData);
              statement.setString(1,_judul);
              statement.setInt(2, _id);
              statement.execute();
         }
         catch(SQLException e){
              System.out.println("Gagal"); 
         }
         finally
        {
            try 
            {
                statement.close();
            } catch (SQLException ex) 
            {
               System.out.println("Gagal");          
            }
        }
    }
    
    String query_deleteData = "DELETE FROM sewabuku where id = ?";
     public void DeleteData(int id){
         PreparedStatement statement = null;
         
         try{
              statement = con.prepareStatement(query_deleteData);
              statement.setInt(1, id);
              statement.execute();
         }
         catch(SQLException e){
              System.out.println("Gagal");
         }
         finally
        {
            try 
            {
                statement.close();
            } catch (SQLException ex) 
            {
               System.out.println("Gagal");          
            }
        }
    }
     
     
     public String GetTanggalHarusKembali(int id){
          String tanggal_harusKembali = "";
          try{
         Statement st = con.createStatement();
         String querry = "SELECT tanggal_harus_kembali FROM sewabuku WHERE id = "+id;
         System.out.println(querry);
         ResultSet rs = st.executeQuery(querry);
       while (rs.next()) {
     tanggal_harusKembali = rs.getString("tanggal_harus_kembali");
        }
     }
     catch(SQLException e){
         System.out.println("Error");
     }
        return tanggal_harusKembali;
     }
     
     //kembalikan buku
     public void KembalikanBuku(int id) throws ParseException{
         long denda = 2000;
         String _harusKembali = GetTanggalHarusKembali(id);
             Date harusKembali =new SimpleDateFormat("yyyy-MM-dddd").parse(_harusKembali);
    Date kembali = new Date();
     
    
      if(kembali.after(harusKembali)){
       
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
  String str1 = formatter.format(harusKembali);
  String str2 = formatter.format(kembali);
     
     LocalDate d1 = LocalDate.parse(str1, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse(str2, DateTimeFormatter.ISO_LOCAL_DATE);
        
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());

        long diffDays = diff.toDays(); 
         denda=  denda * diffDays;
     }else{
          denda =  0;
      }
     
         UpdateTanggalKembaliBuku(denda,id);

}

     String query_updateKembaliBuku = "UPDATE sewabuku SET tanggal_kembali = ?,denda = ?  WHERE id = ?";
     public void UpdateTanggalKembaliBuku(long _denda,int id){
           PreparedStatement statement = null;
         
         try{
              statement = con.prepareStatement(query_updateKembaliBuku);
              
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
              Date dateNow = new Date();
              
              statement.setString(1,formatter.format(dateNow));
              statement.setLong(2, _denda);
              statement.setInt(3, id);
              statement.execute();
         }
         catch(SQLException e){
              System.out.println("Gagal"); 
         }
         finally
        {
            try 
            {
                statement.close();
            } catch (SQLException ex) 
            {
               System.out.println("Gagal");          
            }
        }
     }
}

