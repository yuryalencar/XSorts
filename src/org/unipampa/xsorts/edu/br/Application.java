/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.xsorts.edu.br;

import java.util.Arrays;

/**
 *
 * @author YURY
 */
public class Application {

    /**
     * Method for verify if third argument is time
     * @param args vector with arguments
     * @return true if the third argument is time, false if the not 
     * @throws Exception if the third argument is not time
     */
    private static boolean verifyArgTime(String[] args) throws Exception {
        if (args.length == 3) {
            if (args[2].trim().equals("-t")) {
                return true;
            } else {
                throw new Exception("Argument Invalid");
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long a = 0;
        FileAnalyzer analyzer;
        try {
            if (args.length > 3 || args.length < 1) {
                throw new Exception("Invalid number of parameters");
            }

            analyzer = new FileAnalyzer(args[0]);

            if (verifyArgTime(args)) {
                a = System.nanoTime();
            }
            switch (args[1]) {
                case "-a":
                    System.out.println(Arrays.toString(new HeapSort().ordinate(analyzer.readArchive())));
                    System.out.println(Arrays.toString(new QuickSort().ordinate(analyzer.readArchive())));
                    break;
                case "-h":
                    System.out.println(Arrays.toString(new HeapSort().ordinate(analyzer.readArchive())));
                    break;
                case "-q":
                    System.out.println(Arrays.toString(new QuickSort().ordinate(analyzer.readArchive())));
                    break;
                default:
                    throw new Exception("Argument invalid");
            }
            if (verifyArgTime(args)) {
                System.out.println("Time in Seconds: " + ((System.nanoTime() - a) / 1000000000));
            }
        } catch (Exception e) {
            System.out.println("Oops! An error has occurred:\n* " + e.getMessage());
        }
    }
}
