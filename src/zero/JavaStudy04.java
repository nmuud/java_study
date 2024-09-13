package zero;
// 임남명
import java.util.Random;
import java.util.Scanner;

public class JavaStudy04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.println("[주민등록번호 계산]");

        // 생년월일 입력 받기
        System.out.print("생년월일을 입력해 주세요.(YYMMDD): ");
        String birthDate = scanner.next();

        // 성별 입력 받기
        System.out.print("성별을 입력해 주세요.(m/f): ");
        char gender = scanner.next().charAt(0);

        // 주민등록번호의 앞자리
        String frontPart = birthDate;

        // 성별에 따른 뒷자리 첫 숫자 설정
        int genderNumber = 0;
        if (gender == 'm') {
            genderNumber = 3;  // 남자일 경우
        } else if (gender == 'f') {
            genderNumber = 4;  // 여자일 경우
        }

        // 랜덤 6자리 숫자 생성 (1 ~ 999999)
        int randomNumber = random.nextInt(999999) + 1;

        // 주민등록번호의 뒷자리 (성별번호 + 랜덤숫자)
        String backPart = String.format("%d%06d", genderNumber, randomNumber);

        // 최종 주민등록번호 출력
        System.out.println(frontPart + "-" + backPart);

        scanner.close();
    }
}
