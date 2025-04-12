import java.util.Scanner;
import java.util.ArrayList;

public class To_do_list {

    // revisi dul
    // - pas ngedit, munculin nilai sebelumnya (jangan dibuat kosong)
    // - error handling di pmeilihan menu betulin (biar bisa ngeluarin pesan klo input gk valid)

    public static void delay () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String teks = input.nextLine();
        boolean status = true;

        ArrayList<String> allTeks = new ArrayList<>();

        while(status){
            System.out.println("== APLIKASI MANAJEMEN TUGAS ==");

            String[] arrayMenu = {"Tambah teks", "Lihat catatan", "Edit catatan", "Keluar Aplikasi"};
            for(int i = 0; i < arrayMenu.length; i ++){
                System.out.println((i + 1) + ". " + arrayMenu[i]);
            }
            System.out.println("Pilih menu : ");
            byte pilihan = -1;

            try {
                pilihan = input.nextByte();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("\nInput tidak valid, masukkan angka antara (1-4)\n");
                input.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1 :
                    boolean looping = true;
                    while (looping) {
                        System.out.println("Tambahkan Catatan : ");
                        String catatan = input.nextLine();

                        allTeks.add(catatan);

                        System.out.println("input Catatan lagi? (y/n)");
                        char next = input.next().charAt(0); //! untuk input 1 huruf di awal
                        input.nextLine();

                        if (next == 'y' || next == 'Y') {
                             looping = true;
                        } else if (next == 'n' || next == 'N') {
                            looping = false;
                        } else {
                            System.out.println("Sistem Input tidak Valid");
                            looping = false;
                        }
                    }
                    break;
                case 2 :
                    System.out.println("Sedang memuat catatan");
                    for (int i = 0; i < 3; i++){
                        System.out.print(".");
                        delay();
                    }
                        System.out.println("\n");

                    if (allTeks.isEmpty()){
                        System.out.println("Belum ada catatan");
                    } else {
                        for (int i = 0; i < allTeks.size(); i++){
                            System.out.println((i + 1) + "." + allTeks.get(i));
                        }
                    }
                    break;
                case 3 :
                    if (allTeks.isEmpty()){
                        System.out.println("belum ada catatan yang diperbaharui");
                    } else {
                        System.out.println("Catatan kamu : ");
                        for (int i = 0; i < allTeks.size(); i++){
                            System.out.println((i + 1) + (". ") + allTeks.get(i) + " ");
                        }

                        System.out.println("Pilih yang ingin di edit : ");
                        byte choice = input.nextByte();
                        input.nextLine();

                        if(choice >= 1 && choice <= allTeks.size()){
                            System.out.println("Masukkan teks : ");
                            for(int i = 0; i < allTeks.size(); i++){
                                System.out.println((i + 1) + ". " + allTeks.get(i) + " ");
                            }
                            String teksMasukan = input.nextLine();
                            allTeks.set(choice -1, teksMasukan); //! untuk mengganti teks yang sudah ada
                            System.out.println("Catatan berhasil diperbarui");
                        } else {
                            System.out.println("Nomor yang dimasukkan tidak valid");
                        }
                    break;
                    }
                case 4 :
                    status = false;
                    for (int i = 0; i < 3; i++){
                        System.out.print(".");
                        delay();
                    }
                    break;
                default :
                    status = false;
                    System.out.println("Pilihan tidak tersedia.  silahkan pilih (1-4).");   
                    break;
                }
                
            System.out.println("\nApakah anda ingin keluar dari aplikasi ? (y/n) : ");
            char keluar = input.next().charAt(0);
            input.nextLine();
            
            if (keluar == 'y' || keluar == 'Y') {
                status = false;
                System.out.println("Terimakasih sudah menggunakan aplikasi");
            } else if (keluar == 'N' || keluar == 'n'){
                status = true;
            }
        }     
    }

}