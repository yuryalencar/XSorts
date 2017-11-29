package org.unipampa.xsorts.edu.br;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

/**
 *
 * @author YURY
 */
public class FileAnalyzer {

    private String pathArchive;

    public FileAnalyzer() {
        this.pathArchive = "<File path not informed>";
    }

    public FileAnalyzer(String pathArchive) {
        this.pathArchive = pathArchive;
    }

    /**
     * Method for extract data in file txt.
     * @return vector containing strings with numbers
     * @throws Exception 
     */
    public Integer[] readArchive() throws Exception {
        File inputFile = new File(this.pathArchive);
        if (this.pathArchive.trim().equals("<File path not informed>") || !inputFile.exists()) {
            throw new Exception("File path not informed or not exits");
        }
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        Integer[] values = new Integer[Integer.parseInt(reader.readLine())];
        int count = 0;
        while (reader.ready()) {
            try {
                values[count] = Integer.parseInt(reader.readLine());
                count++;
            } catch (Exception e) {
                throw new Exception("File Error - Error on line: " + (count + 2));
            }
        }
        return values;
    }

    /**
     * @param pathArchive the pathArchive to set
     */
    public void setPathArchive(String pathArchive) {
        this.pathArchive = pathArchive;
    }
}
