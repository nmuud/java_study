package zero;
// 임남명
import java.util.Scanner;

public class JavaStudy08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요: ");
        double income = sc.nextDouble();

        calculateTax(income);
    }


    public static void calculateTax(double income) {
        double tax = 0;
        double cumulativeTax = 0;

        if (income > 1000000000) {
            double taxable = income - 1000000000;
            tax += taxable * 0.45;
            System.out.printf("%.0f * 45%% = %.0f\n", taxable, taxable * 0.45);
            income = 1000000000;
        }
        if (income > 500000000) {
            double taxable = income - 500000000;
            tax += taxable * 0.42;
            System.out.printf("%.0f * 42%% = %.0f\n", taxable, taxable * 0.42);
            income = 500000000;
        }
        if (income > 300000000) {
            double taxable = income - 300000000;
            tax += taxable * 0.40;
            System.out.printf("%.0f * 40%% = %.0f\n", taxable, taxable * 0.40);
            income = 300000000;
        }
        if (income > 150000000) {
            double taxable = income - 150000000;
            tax += taxable * 0.38;
            System.out.printf("%.0f * 38%% = %.0f\n", taxable, taxable * 0.38);
            income = 150000000;
        }
        if (income > 88000000) {
            double taxable = income - 88000000;
            tax += taxable * 0.35;
            System.out.printf("%.0f * 35%% = %.0f\n", taxable, taxable * 0.35);
            income = 88000000;
        }
        if (income > 46000000) {
            double taxable = income - 46000000;
            tax += taxable * 0.24;
            System.out.printf("%.0f * 24%% = %.0f\n", taxable, taxable * 0.24);
            income = 46000000;
        }
        if (income > 12000000) {
            double taxable = income - 12000000;
            tax += taxable * 0.15;
            System.out.printf("%.0f * 15%% = %.0f\n", taxable, taxable * 0.15);
            income = 12000000;
        }
        if (income > 0) {
            tax += income * 0.06;
            System.out.printf("%.0f * 6%% = %.0f\n", income, income * 0.06);
        }

        // 누진 공제 계산
        if (income > 1000000000) {
            cumulativeTax = tax - 65400000;
        } else if (income > 500000000) {
            cumulativeTax = tax - 35400000;
        } else if (income > 300000000) {
            cumulativeTax = tax - 25400000;
        } else if (income > 150000000) {
            cumulativeTax = tax - 19400000;
        } else if (income > 88000000) {
            cumulativeTax = tax - 14900000;
        } else if (income > 46000000) {
            cumulativeTax = tax - 5220000;
        } else if (income > 12000000) {
            cumulativeTax = tax - 1080000;
        } else {
            cumulativeTax = tax;
        }

        System.out.printf("\n[세율에 의한 세금]: %.0f\n", tax);
        System.out.printf("[누진공제 계산에 의한 세금]: %.0f\n", cumulativeTax);
    }
}
