package me.luizclaudiosantos.fileWrite.integration;

import java.io.*;

public class FilePrinter {

    public void print(File file){
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));

            String line = "";

            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
