/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.xsorts.edu.br;

/**
 *
 * @author YURY
 */
public class HeapSort implements Sort {

    @Override
    public Integer[] ordinate(Integer[] data) {
        int vectorSize = data.length;
        mountTreeHeap(data);
        for (int i = data.length - 1; i > 0; i--) {
            swap(data, 0, i);
            sortTree(data, 0, --vectorSize);
        }
    
        return data;
    }

    private void mountTreeHeap(Integer[] data) {
        for (int i = (data.length - 1) / 2; i > -1; i--) {
            sortTree(data, i, data.length);
        }
    }

    private void sortTree(Integer[] data, int fatherPosition, int vectorSize) {
        int firstSonPosition = fatherPosition * 2 + 1;
        int secondSonPosition = firstSonPosition + 1;

        if (firstSonPosition < vectorSize) {
            if (secondSonPosition < vectorSize) {
                if (data[firstSonPosition] < data[secondSonPosition]) {
                    firstSonPosition = secondSonPosition;
                }
            }

            if (data[fatherPosition] < data[firstSonPosition]) {
                swap(data, fatherPosition, firstSonPosition);
                sortTree(data, firstSonPosition, vectorSize);
            }
        }

    }

    private void swap(Integer[] data, int firstPosition, int secondPosition) {
        Integer aux = data[firstPosition];
        data[firstPosition] = data[secondPosition];
        data[secondPosition] = aux;
    }

}
