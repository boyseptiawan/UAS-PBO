package com.saepul;

import com.saepul.model.ProductModel;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        String pilihanUser;
        boolean is_continue = true;
        ProductModel product = new ProductModel();
        String id;
        String qty;
        String price;
        String name;

        while (is_continue) {
            clearScreen();
            System.out.println("=====Program CRUD Produk=====");
            System.out.println("1. Tampilkan Data Produk");
            System.out.println("2. Tambah Data Produk");
            System.out.println("3. Ubah Data Produk");
            System.out.println("4. Hapus Data Produk");
            System.out.println("===========================");

            System.out.print("Pilih (1-5)? ");
            pilihanUser = userInput.next();

            switch (pilihanUser) {
                case "1":
                    System.out.println("List Produk\n");
                    product.showAllProduct();
                    break;
                case "2":
                    System.out.println("Tambah Produk");
                    System.out.print("Masukan nama produk: ");
                    name = userInput.next();
                    System.out.print("Masukan jumlah produk: ");
                    qty = userInput.next();
                    System.out.print("Masukan harga produk: ");
                    price = userInput.next();
                    product.saveProduct(name, qty, price);
                    break;
                case "3":
                    System.out.println("Ubah Produk");
                    product.showAllProduct();
                    System.out.print("Masukan ID produk yang ingin diubah? ");
                    id = userInput.next();
                    System.out.print("Masukan nama produk: ");
                    name = userInput.next();
                    System.out.print("Masukan jumlah produk: ");
                    qty = userInput.next();
                    System.out.print("Masukan harga produk: ");
                    price = userInput.next();
                    product.updateProduct(id, name, qty, price);
                    break;
                case "4":
                    System.out.println("Hapus Produk");
                    product.showAllProduct();
                    System.out.print("Masukan ID produk yang ingin diubah? ");
                    id = userInput.next();
                    product.deleteProduct(id);
                    product.showAllProduct();
                    break;
                default:
                    System.out.println("Pilihan yang anda masukan salah!\nPilih (1-5)?");
                    break;
            }

            System.out.print("Apakah anda ingin melanjutkan? (y/n)? ");
            pilihanUser = userInput.next();
            is_continue = pilihanUser.equalsIgnoreCase("y");
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("Tidak Bisa ClearScreen");
        }
    }

    public static boolean getChoise(String message) {
        Scanner userInput = new Scanner(System.in);
        String pilihanUser;
        boolean isContinue;

        System.out.print(message);
        pilihanUser = userInput.next();

        if (pilihanUser.equalsIgnoreCase("y")) {
            isContinue = true;
        } else {
            isContinue = false;
        }

        return isContinue;
    }
}
