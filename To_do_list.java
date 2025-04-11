import java.util.Scanner;
import java.util.ArrayList;

public class To_do_list {
    
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String teks = input.nextLine();
        boolean status = true;

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
                        input.nextLine();

                        allTeks.add(catatan);

                        System.out.println("input Catatan lagi? (y/n)");
                        char next = input.next().charAt(0); //! untuk input 1 huruf di awal
                        input.nextLine();

                        if (next == 'y' || next == 'Y') {
                             allTeks.add(catatan);
                        } else if (next == 'n' || next == 'N') {
                            looping = false;
                        } else {
                            System.out.println("Sistem Input tidak Valid");
                            looping = false;
                        }
                    }
                    break;
            default :
                System.out.println("Sistem tidak tersedia");         
                status = false;       
            }
        }     
        System.out.println("Apakah anda ingin keluar dari aplikasi ? (y/n) : ");
        char keluar = input.next().charAt(0);
        input.nextLine();
        
        if (keluar == 'y' || keluar == 'Y') {
            status = false;
        } 
        System.out.println("Terimakasih sudah menggunakan aplikasi");
        input.close();
    }
}