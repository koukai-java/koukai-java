package test;

import java.util.List;

import dao.PointsDAO;
import model.Points;

public class PointsDAOTest {
    public static void main(String[] args) {
        PointsDAO dao = new PointsDAO();

        // テストケース1: LU（正しいmeridian）
        String testQuizType1 = "肺";
        System.out.println("=== Test: quizType = " + testQuizType1 + " ===");
        List<Points> result1 = dao.getPointByQuizType(testQuizType1);
        for (Points p : result1) {
            System.out.println(p);
        }
        System.out.println("件数: " + result1.size());
        System.out.println();

        // テストケース2: LI（別の正しいmeridian）
        String testQuizType2 = "督";
        System.out.println("=== Test: quizType = " + testQuizType2 + " ===");
        List<Points> result2 = dao.getPointByQuizType(testQuizType2);
        for (Points p : result2) {
            System.out.println(p);
        }
        System.out.println("件数: " + result2.size());
        System.out.println();

        // テストケース3: 存在しないquizType
        String testQuizType3 = "膀胱";
        System.out.println("=== Test: quizType = " + testQuizType3 + " ===");
        List<Points> result3 = dao.getPointByQuizType(testQuizType3);
        if (result3.isEmpty()) {
            System.out.println("該当するデータはありません。");
        } else {
            for (Points p : result3) {
                System.out.println(p);
            }
        }
        System.out.println("件数: " + result3.size());
    }
}
