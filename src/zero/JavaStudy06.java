package zero;
// 임남명
import java.util.Random;
import java.util.Scanner;

public class JavaStudy06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // 총 투표수를 입력 받음
        System.out.print("총 진행할 투표수를 입력해 주세요: ");
        int totalVotes = sc.nextInt();

        // 후보자 수를 입력 받음
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요: ");
        int candidateCount = sc.nextInt();

        // 후보자 이름을 입력 받음
        String[] candidates = new String[candidateCount];
        for (int i = 0; i < candidateCount; i++) {
            System.out.print((i + 1) + "번째 후보자 이름을 입력해 주세요: ");
            candidates[i] = sc.next();
        }

        // 각 후보자의 득표수를 저장할 배열
        int[] votes = new int[candidateCount];

        // 무작위로 투표 진행
        for (int i = 0; i < totalVotes; i++) {
            int vote = random.nextInt(candidateCount);  // 랜덤 투표
            votes[vote]++;

            // 투표 진행률 계산
            double progress = (double) (i + 1) / totalVotes * 100;

            // 현재 투표된 후보자 이름
            String votedCandidate = candidates[vote];

            // 결과 출력
            System.out.printf("\n[투표진행률]: %.2f%%, %d명 투표 => %s\n", progress, (i + 1), votedCandidate);

            // 각 후보자의 득표율 및 득표수 출력
            for (int j = 0; j < candidateCount; j++) {
                double percentage = (double) votes[j] / (i + 1) * 100;
                System.out.printf("[기호:%d] %s:   %.2f%%   (투표수: %d)\n", j + 1, candidates[j], percentage, votes[j]);
            }
        }

        // 당선자 결정
        int winnerIndex = 0;
        for (int i = 1; i < candidateCount; i++) {
            if (votes[i] > votes[winnerIndex]) {
                winnerIndex = i;
            }
        }

        // 당선자 출력
        System.out.println("\n[투표결과] 당선인 : " + candidates[winnerIndex]);
    }
}
