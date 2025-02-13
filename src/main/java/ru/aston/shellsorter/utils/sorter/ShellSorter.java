package ru.aston.shellsorter.utils.sorter;

import java.util.Comparator;

public class ShellSorter  {

    public  <T> void sort (T []array, Comparator<T> comparator){
        int n=array.length;
        for (int gap= n/2; gap>0; gap= gap/2){
            for (int i=gap;i<n; i++){
                T  temp=array[i];
                int j;
                for (j=i;j>=gap && comparator.compare(array[j-gap], temp)>0; j=j-gap){
                    array[j]= array[j-gap];
                }
                array[j]=temp;
            }

        }



    }
    }

