package ru.vsu.cs.g81.vvp21.kolesnik_a_v.task_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Цвета начинаются с 1
        MyGraph graph = new MyGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
//        graph.addEdge(0,6);
//        graph.addEdge(0,5);
//        graph.addEdge(0,4);
//        graph.addEdge(0,3);
//        graph.addEdge(0,2);
//        graph.addEdge(0,1);
//        graph.addEdge(3,4);
//        graph.addEdge(5,3);
//        graph.addEdge(4,5);
//        graph.addEdge(4,6);
//        graph.addEdge(3,6);
//        graph.addEdge(1,2);
        graph.print();
        graph.color();
    }
}
