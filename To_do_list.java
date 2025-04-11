import java.util.Scanner;
import java.util.ArrayList;

public class To_do_list {
    
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String teks = input.nextLine();
        boolean status = false;

        ArrayList<String> allTeks = new ArrayList<>();

        while(status){
            System.out.println("== APLIKASI MANAJEMEN TUGAS ==");

            String[] arrayMenu = {"Tambah teks", "Edit teks", "Hapus tugas"};
            for(int i = 0; i < arrayMenu.length; i ++){
                System.out.println((i + 1) + ". " + arrayMenu[i]);
            }
            System.out.println("Pilih menu : ");
            byte pilihan = input.nextByte();

            switch (pilihan) {
                case 1 :
                    boolean looping = true;
                    while (looping) {
                        System.out.println("Tambahkan Catatan : ");
                        String catatan = input.nextLine();

                        System.out.println("input Catatm? (y/n)");
                        char next = input.next().charAt(0); //! untuk input 1 huruf di awal
                        input.nextLine();

                        if (next == 'y' || next == 'Y') {
                             allTeks.add(catatan);
                        } else if (next == 'n' || next == 'N') {
                            looping = false;
                        } else {
                            System.out.println("Sistem Input tidak Valid");
                        }
                    }
                    break;
            default :
                System.out.println("Sistem tidak tersedia");                
            }
        }     
    }
}