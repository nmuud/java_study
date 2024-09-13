package zero;
// 임남명
import java.time.LocalDate;
import java.util.Scanner;

public class JavaStudy05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요. (yyyy): ");
        int year = scanner.nextInt();
        System.out.print("달력의 월을 입력해 주세요. (mm): ");
        int month = scanner.nextInt();

        printThreeMonths(year, month);
        scanner.close();
    }


    public static void printThreeMonths(int currYear, int currMonth) {
        // 이전, 현재, 다음달 구하기
        int prevMonth = (currMonth == 1) ? 12 : currMonth - 1;
        int prevYear = (currMonth == 1) ? currYear -1 : currYear;

        int nextMonth = (currMonth == 12) ? 1 : currMonth + 1;
        int nextYear = (currMonth == 12) ? currYear + 1 : currYear;

        // 달력의 헤더 출력
        printHeader(prevYear, prevMonth);
        System.out.print("\t" + "\t" + "\t" + "\t" + "\t" + "\t");
        printHeader(currYear, currMonth);
        System.out.print("\t" + "\t" + "\t" + "\t" + "\t" + "\t");
        printHeader(nextYear, nextMonth);
        System.out.println();

        // 요일 헤더 출력
        printWeekdayHeaders();
        System.out.print("\t" + "\t" + "\t");
        printWeekdayHeaders();
        System.out.print("\t" + "\t" + "\t");
        printWeekdayHeaders();
        System.out.println();

        // 각 달력의 데이터를 생성하여 6주치의 데이터를 출력
        int[][] prevMonthCalendar = buildCalendar(prevYear, prevMonth);
        int[][] currMonthCalendar = buildCalendar(currYear, currMonth);
        int[][] nextMonthCalendar = buildCalendar(nextYear, nextMonth);

        for (int i = 0; i < 6; i++) {
            printWeek(prevMonthCalendar, i);
            System.out.print("        ");  // 달 사이 간격
            printWeek(currMonthCalendar, i);
            System.out.print("        ");  // 달 사이 간격
            printWeek(nextMonthCalendar, i);
            System.out.println();
        }

    }

    public static void printHeader(int year, int month) {
        System.out.printf("[%4d년 %02d월]", year, month);
    }


    public static void printWeekdayHeaders() {
        System.out.print("일\t월\t화\t수\t목\t금\t토");
    }

    public static void printWeek(int[][] calendar, int week) {
        for (int day = 0; day < 7; day++) {
            if (calendar[week][day] == 0) {
                System.out.print("    "); // 빈칸
            } else {
                System.out.printf("%02d  ", calendar[week][day]);
            }
        }
    }


    public static int[][] buildCalendar(int year, int month) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

        int daysInMonth = firstDayOfMonth.lengthOfMonth();
        int firstDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue() % 7; // 일요일은 0

        int[][] calendar = new int[6][7]; // 최대 6주
        int day = 1;

        for (int i = 0; i < 6; i++) {
            for (int j = (i == 0 ? firstDayOfWeek : 0); j < 7; j++) {
                if (day <= daysInMonth) {
                    calendar[i][j] = day++;
                }
            }
        }
        return calendar;
    }
}
