package com.roboskeletron.task7;

public record Answer(int index, int length) implements Comparable<Answer> {

    @Override
    public int compareTo(Answer o) {
        return -Integer.compare(length, o.length);
    }
}
