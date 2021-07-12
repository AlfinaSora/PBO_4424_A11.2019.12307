/*
Nama: Muhammad Naufal Firdana Trisya
Nim: A11.2019.11671
Kelas: A11.4423
 */
package Controller;

import Inputan.InputanSewaBuku; /*Memanggil file InputanSewaBuku.java dalam Package Inputan*/
import Model.TabelSewaBuku; /*Memanggil file TabelSewaBuku.java dalam Package Model*/
import Model.mTable; /* Memanggil file mTable.java dalam Package Model*/
import gui.maingui; /*Memanggil maingui.java dalam Package */
import java.util.List; /*Untuk memanggil package list pada java*/
import Interfaces.InterfacesSewaBuku; /*Memanggil file InterfacesSewaBuku.java dalam Package Interfaces*/

/**
 *
 * @author Firdana
 */
public class cSewaBuku {
    
    public cSewaBuku(maingui _tampil){
        this._tampilan = _tampil;
        InterfacesSewaBuku = new InputanSewaBuku();
    }
    
        public void IsiTable(){
      list_sewaBuku = InterfacesSewaBuku.GetAll();
      TabelSewaBuku tabelSewaBuku = new TabelSewaBuku(list_sewaBuku);
      _tampilan.GetTabelData().setModel(tabelSewaBuku);
        
    }
       
       maingui _tampilan;
       InterfacesSewaBuku InterfacesSewaBuku;
       List<mTable> list_sewaBuku;
}
