import java.util.*;

import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();

        for (int w : truck_weights) {
            trucks.offer(w);
        }

        int time = 0;
        int totalWeightOnBridge = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            time++;
            totalWeightOnBridge -= bridge.poll();

            if (!trucks.isEmpty()) {
                if (totalWeightOnBridge + trucks.peek() <= weight) {
                    totalWeightOnBridge += trucks.peek();
                    bridge.offer(trucks.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }

        return time;
    }
}
