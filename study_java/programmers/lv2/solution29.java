import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> parkingTime = new HashMap<>();  // 차량 번호 별 주차 시간
        HashMap<String, String> inTime = new HashMap<>();  // 입차 기록
        ArrayList<String> carNumbers = new ArrayList<>();

        for (String record : records) {
            String[] splitRecord = record.split(" ");
            String time = splitRecord[0];
            String carNumber = splitRecord[1];
            String status = splitRecord[2];

            if (!carNumbers.contains(carNumber)) {
                carNumbers.add(carNumber);
            }

            if (status.equals("IN")) {
                inTime.put(carNumber, time);
            } else if (status.equals("OUT")) {
                // 총 주차 시간 합해주기
                int parkedTime = parkingTime.getOrDefault(carNumber, 0);
                parkedTime += calculateMinutes(inTime.get(carNumber), time);
                // 주차 시간 없데이트
                parkingTime.put(carNumber, parkedTime);
                // 현 입차 기록에서 삭제
                inTime.remove(carNumber);
            }
        }

        for (String carNumber : inTime.keySet()) {
            int parkedTime = parkingTime.getOrDefault(carNumber, 0);
            parkedTime += calculateMinutes(inTime.get(carNumber), "23:59");
            parkingTime.put(carNumber, parkedTime);
        }

        // 차량 번호 순으로 정렬
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];

        // 요금 계산
        for (int i = 0; i < carNumbers.size(); i++) {
            int time = parkingTime.get(carNumbers.get(i));
            answer[i] = fees[1];

            if (time > fees[0]) {
                answer[i] += (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }
        }

        return answer;
    }

    // 주차한 분을 계산하는 함수
    private int calculateMinutes(String inTime, String outTime) {
        String[] in = inTime.split(":");
        String[] out = outTime.split(":");
        int inMinutes = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
        int outMinutes = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);
        return outMinutes - inMinutes;
    }
}
