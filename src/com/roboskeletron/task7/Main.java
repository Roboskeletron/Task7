package com.roboskeletron.task7;

import java.util.*;
import java.util.stream.IntStream;
import ru.vsu.cs.util.ArrayUtils;

public class Main {

    public static void main(String[] args) {
        int[] no_answer = IntStream.range(1, 31).toArray();
        printResult(no_answer);
        int[] second_from_left = new int[] { 0, 0, 0, 1, 2, 3, 0, 0, 0, 35, 49, 31, 56, 0, 0, 0};
        printResult(second_from_left);
        int[] one_answer = new int[] { 0, 0, 0, 1, 2, 3, 0, 0, 0, 35, 49, 31, 56, 0, 0, 0, 0};
        printResult(one_answer);

        for (int i = 0; i < 7; i++){
            printResult(ArrayUtils.createRandomIntArray(40, -10, 10));
        }

        while (true){
            System.out.print("Enter your array: ");
            printResult(ArrayUtils.readIntArrayFromConsole());
        }
    }

    public static void printResult(int[] array){
        var result = solution(array);
        System.out.printf("Array: [ %s ]\nSequence length: %d, index of the first element: %d\n",
                ArrayUtils.toString(array), result.length(), result.index());
    }

    public static Answer solution(int[] array){
        List<Answer> answers = new ArrayList<>();

        for (int i = 0; i < array.length- 1; i++){
            for (int j = array.length; j > i; j--){
                var stream = Arrays.copyOfRange(array, i, j);
                if (Arrays.stream(stream).sum() == 0){
                    answers.add(new Answer(i, stream.length));
                }
            }
        }

        answers.sort(Answer::compareTo);

        if ((long) answers.size() > 0) {
            var first = answers.get(0);
            int count = 0;

            for (var i : answers) {
                if (first.compareTo(i) == 0)
                    count++;
                else break;
            }

            if (count > 1)
                return answers.get(1);
            return answers.get(0);
        }

        return new Answer(-1, 0);
    }
}
