package zero;
// 임남명
import java.util.Scanner;

public class JavaStudy02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요. (금액): ");


        int amount = scanner.nextInt();

        // 결제 금액의 10%를 캐시백으로 계산
        int cashback = (int) (amount * 0.1);

        // 캐시백을 백원 단위로 반올림
        cashback = (cashback / 100) * 100;

        // 캐시백이 300원을 넘지 않도록 제한
        if (cashback > 300) {
            cashback = 300;
        }

        System.out.println("결제 금액은 " + amount + "원이고, 캐시백은 " + cashback + "원 입니다.");

        scanner.close();
    }
}
