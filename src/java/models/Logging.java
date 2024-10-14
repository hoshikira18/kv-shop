/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIET
 */
public class Logging {

    String logger;
    Date create_At;

    public Logging() {
    }

    public Logging(String logger, Date create_At) {
        this.logger = logger;
        this.create_At = create_At;
    }

    public void write() {
        LocalDateTime date = LocalDateTime.now();
//        String time = date.toString();
        String[] list = date.toString().split("[.]");
        String time = "";
        for (String string : list) {
            time += string;
        }
        String path = "D:\\02.LearningDocument\\SE IV\\PRJ\\Assignment\\kv-shop\\Logging\\" + time + ".txt";
        File file = new File(path);
        try {
            if (file.createNewFile()) {
            } else {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Loi");
        }

        System.out.println(date);
        System.out.println("--------------");
        System.out.println(time);
        System.out.println("--------------");
        System.out.println(path);
    }

    public static void main(String[] args){
        LocalDateTime date = LocalDateTime.now();
        String[] list = date.toString().split("[.:]");
        String fileName = list[0];
        for (int i = 1; i < list.length; i++) {
            fileName += "-" + list[i];
        }
        String path = "Logging\\" + fileName + ".txt";
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                System.out.println("create");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                bw.write("test write");
                bw.close();
            }
        } catch (IOException ex) {
            System.out.println("loi");
//            Logger.getLogger(Logging.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(fileName);
    }
}
