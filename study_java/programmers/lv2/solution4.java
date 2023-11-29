import java.util.*;

class Solution {
    public String[] solution(String[][] tasks) {
        String[] result = new String[tasks.length];

        Stack<String[]> pausedTasks = new Stack<>();

        Arrays.sort(tasks,(a,b)->ToSec(a[1])-(ToSec(b[1])));


        int totalTasks = tasks.length;

        int resultIndex=0;
        int taskIndex=0;
        int currentTime=0;
        String taskType ="";
        int taskStart =0;
        int taskDuration =0;
        int nextTaskStart=0;
        while(totalTasks != taskIndex){

            taskType = tasks[taskIndex][0];
            taskStart = ToSec(tasks[taskIndex][1]);
            taskDuration = Integer.parseInt(tasks[taskIndex][2]);

            currentTime = taskStart + taskDuration;

            // Check if the new task overlaps with the current one
            if(totalTasks-1 != taskIndex){
                nextTaskStart = ToSec(tasks[taskIndex+1][1]);
                if(currentTime > nextTaskStart){

                    pausedTasks.push(new String[]{taskType, currentTime - nextTaskStart + ""});
                    currentTime = nextTaskStart;
                    taskIndex++;

                    continue;

                }
            }

            // Complete the current task
            result[resultIndex++]= taskType;

            // Check if we can complete the paused tasks during the remaining time
            while(!pausedTasks.isEmpty()){

                int remainingTime = nextTaskStart - currentTime;

                String[] pausedTask = pausedTasks.pop();

                int pausedTaskDuration = Integer.parseInt(pausedTask[1]);

                // Complete the paused task
                if(remainingTime >= pausedTaskDuration){

                    result[resultIndex++]= pausedTask[0];
                    currentTime += pausedTaskDuration;
                } else {
                    // Pause the task again
                    pausedTasks.push(new String[]{pausedTask[0], pausedTaskDuration - remainingTime + ""});
                    break;
                }
            }
            taskIndex++;
        }

        // Finish the remaining paused tasks
        while(!pausedTasks.isEmpty()){
            result[resultIndex++]= pausedTasks.pop()[0];
        }

        return result;
    }

    public int ToSec (String time){

        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]) * 60;
        int minutes = Integer.parseInt(timeParts[1]);

        return hours + minutes;
    }
}
