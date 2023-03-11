package com.jeugenedev;

import java.util.*;

/*
4 5
10 9 2 1
*
4 3
2 4 1 5
*/
public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int curFloor;
        List<Integer> countPickedCurFloorPair = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toList();
        curFloor = countPickedCurFloorPair.get(1);
        List<Integer> floors = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());

        go(floors, curFloor);
    }

    private static void go(List<Integer> floors, int curFloor) {
        while(floors.size() > 0) {
            boolean direction = floors.get(0) > curFloor;
            int finalFloor = floors.get(0), lastFloor = -1;
            List<Integer> route = new ArrayList<>();
            for (int currentFloor : floors) {
                if((currentFloor > curFloor && currentFloor <= finalFloor && direction) || (currentFloor < curFloor && currentFloor >= finalFloor && !direction)) {
                    route.add(currentFloor);
                    lastFloor = currentFloor;
                }
            }
            floors.removeAll(route);
            route.sort(direction ? Comparator.naturalOrder() : Comparator.reverseOrder());
            System.out.print(String.join(" ", route.stream().map(String::valueOf).toList()) + " ");
            curFloor = lastFloor == -1 ? curFloor : lastFloor;
        }
    }
}
