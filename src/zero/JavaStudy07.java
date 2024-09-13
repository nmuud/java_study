package zero;
// 임남명
import java.util.*;

public class JavaStudy07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]");
        System.out.print("로또 개수를 입력해 주세요. (숫자 1 ~ 10): ");
        int numOfLottos = scanner.nextInt();

        // 입력받은 로또 개수만큼 구매
        int[][] myLottos = new int[numOfLottos][6];
        for (int i = 0; i < numOfLottos; i++) {
            myLottos[i] = generateLottoNumbers();
        }

        // 당첨 번호 생성
        int[] winningLotto = generateLottoNumbers();

        // 구매한 로또 출력
        System.out.println("\n[내 로또 번호]");
        for (int i = 0; i < numOfLottos; i++) {
            System.out.print((char) ('A' + i) + "\t"); // A, B, C ... 표시
            printLotto("", myLottos[i]);
            System.out.println();
        }

        // 당첨 번호 출력
        System.out.println("\n[로또 발표]");
        printLotto("\t", winningLotto);
        System.out.println();


        System.out.println("\n[내 로또 결과]");
        for (int i = 0; i < numOfLottos; i++) {
            System.out.print((char) ('A' + i) + "\t");
            printLotto("", myLottos[i]);
            int matchCount = compareNumbers(myLottos[i], winningLotto);
            System.out.println(" => " + matchCount + "개 일치");
        }

        scanner.close();
    }


    // 로또 번호 생성 함수 (1 ~ 45 사이에서 중복 없이 6개의 숫자)
    public static int[] generateLottoNumbers() {
        Random random = new Random();
        Set<Integer> lottoSet = new HashSet<>();

        // 중복되지 않도록 6개의 로또 번호 생성
        while (lottoSet.size() < 6) {
            int number = random.nextInt(45) + 1; // 1 ~ 45 범위
            lottoSet.add(number);
        }

        // 배열로 변환 후 정렬
        int[] lottoNumbers = lottoSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(lottoNumbers);

        return lottoNumbers;
    }

    // 로또 번호와 당첨 번호 비교하여 일치하는 숫자 수 반환
    public static int compareNumbers(int[] myLotto, int[] winningLotto) {
        int matchCount = 0;

        // 구매한 로또와 당첨 로또 비교
        for (int myNumber : myLotto) {
            for (int winningNumber : winningLotto) {
                if (myNumber == winningNumber) {
                    matchCount++;
                }
            }
        }

        return matchCount;
    }

    // 로또 번호 배열 출력
    public static void printLotto(String prefix, int[] lotto) {
        System.out.print(prefix);
        for (int i = 0; i < lotto.length; i++) {
            System.out.printf("%02d", lotto[i]);
            if (i < lotto.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
