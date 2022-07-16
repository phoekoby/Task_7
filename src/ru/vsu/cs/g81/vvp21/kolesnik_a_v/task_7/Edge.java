package ru.vsu.cs.g81.vvp21.kolesnik_a_v.task_7;

public class Edge {
    private final int to;
    private final int from;

    public Edge(int to, int from){
        this.to = to;
        this.from = from;
    }

    public int getTo() {
        return to;
    }
    public int getFrom(){return from;}
}
