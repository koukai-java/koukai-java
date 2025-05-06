package test;

import java.util.List;

import dao.ExamDAO;
import model.Exam;

public class ExamDAOTest {
    public static void main(String[] args) {
        ExamDAO dao = new ExamDAO();

        // ここでは DB 接続はせず、ExamDAO に任せる
        int time = 1;
        List<Exam> examList = dao.getExamByTime(time);

        if (examList.isEmpty()) {
            System.out.println("❌ データが取得できませんでした。");
        } else {
            System.out.println("✅ データ取得成功: " + examList.size() + " 件");
            for (Exam exam : examList) {
                System.out.println("番号: " + exam.getNumber());
                System.out.println("問題: " + exam.getQuestion());
                System.out.println("答え: " + exam.getAnswer());
                System.out.println("----");
            }
        }
    }
}
