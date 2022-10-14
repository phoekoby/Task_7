package ru.vsu.cs.g81.vvp21.kolesnik_a_v.task_7;

import java.awt.*;
import java.util.*;

public class MyGraph implements Graph {
    private int[][] data;

    private final ColorGraph colorGraph;

    private int eCount = 0;

    private int vCount = 0;

    public MyGraph(int vertexCount) {
        data = new int[vertexCount][vertexCount];
        colorGraph = new ColorGraph(this);
        vCount = vertexCount;
    }

    public MyGraph() {
        this(0);
    }

    @Override
    public void addEdge(int v1, int v2) {
        int maxV = Math.max(v1, v2);
        if (maxV >= vertexCount()) {
            data = Arrays.copyOf(data, maxV + 1);
            for (int i = 0; i <= maxV; i++) {
                data[i] = i < vCount ? Arrays.copyOf(data[i], maxV + 1) : new int[maxV + 1];
            }
            vCount = maxV + 1;
        }
        if (data[v1][v2] == 0) {
            data[v1][v2] = 1;
            eCount++;
        }
    }

    @Override
    public void removeEdge(int v1, int v2) {

        if (data[v1][v2] != 0) {
            data[v1][v2] = 0;
            eCount--;
        }
    }


    @Override
    public int vertexCount() {
        return getData().length;
    }

    @Override
    public int edgeCount() {
        return eCount;
    }

    private int[][] getData() {
        return Arrays.copyOf(data, data.length);
    }

    protected void print() {
        for (var k : data) {
            for (var s : k) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Integer> adjacenciesWith(int v) {
        return new Iterable<Integer>() {
            Integer nextAdj = null;

            @Override
            public Iterator<Integer> iterator() {
                for (int i = 0; i < vCount; i++) {
                    if (data[v][i] != 0) {
                        nextAdj = i;
                        break;
                    }
                }

                return new Iterator<Integer>() {
                    @Override
                    public boolean hasNext() {
                        return nextAdj != null;
                    }

                    @Override
                    public Integer next() {
                        Integer result = nextAdj;
                        nextAdj = null;
                        for (int i = result + 1; i < vCount; i++) {
                            if (data[v][i] != 0) {
                                nextAdj = i;
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

    public void color() {
        colorGraph.backTrackingColoring();
    }
}
