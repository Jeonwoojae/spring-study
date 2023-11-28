import java.time.LocalTime;
import java.util.*;

class Solution {
    public class Plan {
        public String name;
        public LocalTime startTime;
        public int remainTime;

        public Plan(String name, String startTime, String remainTime) {
            this.name = name;
            this.startTime = LocalTime.parse(startTime);
            this.remainTime = Integer.parseInt(remainTime);
        }

        public void doPlan(int minute) {
            System.out.println("현재 작업 수행"+this.name+":" +minute);
            this.remainTime -= minute;
            if(this.remainTime > 0) {
                stack.push(this);
            } else {
                answer.add(this.name);
            }
        }
    }

    public static Deque<Plan> stack = new ArrayDeque<>();
    public static List<String> answer = new ArrayList<>();

    // 시간의 차이를 분 단위로 계산하는 메서드
    public int calculateMinutes(LocalTime start, LocalTime end) {
        int hours = end.getHour() - start.getHour();
        int minutes = end.getMinute() - start.getMinute();
        return hours * 60 + minutes;
    }

    public String[] solution(String[][] plans) {
        List<Plan> planList = new ArrayList<>();
        for (String[] plan : plans) {
            planList.add(new Plan(plan[0], plan[1], plan[2]));
        }

        planList.sort(Comparator.comparing(plan -> plan.startTime));

        for(int i=0;i<planList.size();i++) {
            Plan currentPlan = planList.get(i);
            if((i+1) < planList.size()) {
                Plan nextPlan = planList.get(i+1);
                int freeTime = calculateMinutes(currentPlan.startTime, nextPlan.startTime);
                currentPlan.doPlan(freeTime);

                while(!stack.isEmpty() && stack.peek().startTime.plusMinutes(stack.peek().remainTime).isBefore(nextPlan.startTime)) {
                    Plan stackedPlan = stack.pop();
                    freeTime = calculateMinutes(stackedPlan.startTime, nextPlan.startTime);
                    stackedPlan.doPlan(freeTime);
                }
            } else {
                currentPlan.doPlan(currentPlan.remainTime);
            }
        }

        while(!stack.isEmpty()) {
            Plan currentPlan = stack.pop();
            currentPlan.doPlan(currentPlan.remainTime);
        }

        return answer.toArray(new String[0]);
    }
}

