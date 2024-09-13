package zero;
// 임남명
import java.util.Scanner;

public class JavaStudy03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 기본 입장료
        final int BASIC_PRICE = 10000;
        final int SPECIAL_DISCOUNT_PRICE = 4000;
        final int GENERAL_DISCOUNT_PRICE = 8000;

        // 입력 받기
        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요. (숫자): ");
        int age = scanner.nextInt();

        System.out.print("입장시간을 입력해 주세요. (숫자입력): ");
        int entryTime = scanner.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요. (y/n): ");
        char nationalMerit = scanner.next().charAt(0);

        System.out.print("복지카드 여부를 입력해 주세요. (y/n): ");
        char welfareCard = scanner.next().charAt(0);


        // 기본 입장료로 초기화
        int ticketPrice = BASIC_PRICE;
        int specialDiscount = BASIC_PRICE;
        int generalDiscount = BASIC_PRICE;

        // 3세 미만이면 무료 입장
        if (age < 3) {
            ticketPrice = 0;
        } else {
            // 특별 할인가 조건: 13세 미만이거나 입장 시간이 17시 이후
            if (age < 13 || entryTime >= 17) {
                specialDiscount = SPECIAL_DISCOUNT_PRICE;
            }

            // 일반 할인가 조건: 국가유공자이거나 복지카드 소지자
            if (nationalMerit == 'y' || welfareCard == 'y') {
                generalDiscount = GENERAL_DISCOUNT_PRICE;
            }

            // 가장 할인을 많이 받은 금액(최소값)으로 입장료 결정
            ticketPrice = Math.min(ticketPrice, Math.min(specialDiscount, generalDiscount));
        }


        System.out.println("입장료: " + ticketPrice);

        scanner.close();
    }
}
