package ru.vsu.cs.g81.vvp21.kolesnik_a_v.task_7;

import java.util.Arrays;

public class ColorGraph {
    private final MyGraph graph;
    private final int[] colors;


    public ColorGraph(MyGraph graph) {
        this.graph = graph;
        this.colors = new int[graph.vertexCount()];
        Arrays.fill(colors, 0);
    }

    public boolean isSafe(int v, int cr) {
        for (int i = 0; i < graph.vertexCount(); i++) {
            if (graph.isEdj(v, i) && colors[i] == cr) {
                return false;
            }
        }
        return true;
    }

    public boolean graphColorUtil(int m, int v) {
        if (v == graph.vertexCount()) {
            return true;
        }
        for (int cr = 0; cr <= m; cr++) {
            if (isSafe(v, cr)) {
                colors[v] = cr;
                if (graphColorUtil(m, v + 1)) {
                    return true;
                }
                colors[v] = 0;
            }
        }
        return false;
    }

    public void backTrackingColoring() {
        int m = 1;
        while (!graphColorUtil(m,0)){
            Arrays.fill(colors,0);
            m++;
        }
        printColors();
    }

    public void printColors() {
        for (int i = 0; i < colors.length; i++) {
            System.out.println("Vertex " + i + " have color " + colors[i]);
        }
    }

    public int[] getColors(){
        return colors;
    }
}
//обход ширину