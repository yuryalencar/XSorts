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
public class MergeSort implements Sort {

    @Override
    public Integer[] ordinate(Integer[] data) {
        mergeSort(data, 0, data.length - 1);
        return data;
    }

    private void mergeSort(Integer[] data, int start, int end) {
        if (start < end) {
            int center = (start + end) / 2;
            mergeSort(data, start, center);
            mergeSort(data, center + 1, end);
            merge(data, start, center, end);
        }
    }

    private void merge(Integer[] data, int start, int beginning, int end) {
        Integer[] aux = data.clone();
        int i = start;
        int j = beginning + 1;
        for (int k = start; k <= end; k++) {
            if (i > beginning) {
                data[k] = aux[j++];
            } else if (j > end) {
                data[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                data[k] = aux[i++];
            } else {
                data[k] = aux[j++];
            }
        }
    }
}
