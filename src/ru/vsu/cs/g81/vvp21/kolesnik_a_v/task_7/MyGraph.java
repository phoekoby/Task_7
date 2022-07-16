package ru.vsu.cs.g81.vvp21.kolesnik_a_v.task_7;

import java.awt.*;
import java.util.*;

public class MyGraph{
    private final int[][] data;

    private final ColorGraph colorGraph;

    public MyGraph(int vertexCount) {
        data = new int[vertexCount][vertexCount];
        colorGraph = new ColorGraph(this);
    }

    public void addEdge(int v1, int v2) {
        if (v1 == v2) {
            return;
        }
        int maxV = Math.max(v1, v2);
        if (maxV >= getData().length) {
            throw new RuntimeException("You can not create edge with non-exiting vertex");
        }
        getData()[v1][v2] = 1;
        getData()[v2][v1] = 1;
    }

    public void removeEdge(int v1, int v2) {
        getData()[v1][v2] = 0;
    }


    public int vertexCount() {
        return getData().length;

    }

    private int[][] getData() {
        return Arrays.copyOf(data,data.length);
    }

    protected void print() {
        for (var k : data) {
            for (var s : k) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    Iterable<Edge> adjacenciesWith(int v) {
        return new Iterable<>() {
            Edge nextAdj = null;

            @Override
            public Iterator<Edge> iterator() {
                for (int i = 0; i < vertexCount(); i++) {
                    if (data[v][i] != 0) {
                        nextAdj = new Edge(i, v);
                        break;
                    }
                }

                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return nextAdj != null;
                    }

                    @Override
                    public Edge next() {
                        Edge result = nextAdj;
                        nextAdj = null;
                        for (int i = result.getTo() + 1; i < vertexCount(); i++) {
                            if (data[v][i] != 0) {
                                nextAdj = new Edge(i, v);
                                break;
                            }
                        }
                        return result;
                    }
                };
            }
        };
    }

    public boolean isEdj(int v1, int v2) {
        return data[v1][v2] != 0;
    }

    public void color(){
        colorGraph.backTrackingColoring();
    }
}
