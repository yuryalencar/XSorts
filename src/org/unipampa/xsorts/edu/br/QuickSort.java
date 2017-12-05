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
public class QuickSort implements Sort {

    @Override
    public Integer[] ordinate(Integer[] data) {
        quickSort(data, 0, data.length - 1);
        return data;
    }

    private void quickSort(Integer[] data, int left, int right) {
        int pivot;
        if (left < right) {
            pivot = partition(data, left, right);
            quickSort(data, left, pivot - 1);
            quickSort(data, pivot + 1, right);
        }
    }

    private int partition(Integer[] data, int left, int right) {
        int l = left, r = right;
        while (l < r) {
            while (l < right && data[l] <= data[left]) {
                l++;
            }
            while (r > left && data[r] >= data[left]) {
                r--;
            }
            if (l < r) {
                swap(data, l, r );
                l++;
                r--;
            }
        }
        swap(data, left, r);
        
        return r;
    }

    private void swap(Integer[] data, int l, int r) {
        Integer aux = data[l];
        data[l] = data[r];
        data[r] = aux;
    }
}
