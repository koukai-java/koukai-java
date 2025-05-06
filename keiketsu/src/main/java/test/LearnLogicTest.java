package test;

import java.util.List;

import model.LearnLogic;
import model.Points;

public class LearnLogicTest {
    public static void main(String[] args) {

        LearnLogic logic = new LearnLogic();

        // テスト対象のクイズタイプ（例：任脈）
        String quizType = "任";

        List<Points> result = logic.getPointsByQuizScpe(quizScpe);

        if (result != null && !result.isEmpty()) {
            System.out.println("【テスト成功】" + result.size() + " 件のデータが取得されました。");
            for (Points p : result) {
                System.out.println("ID: " + p.getId() + " / 経絡: " + p.getMeridian() + " / 名称: " + p.getName());
            }
        } else {
            System.out.println("【テスト失敗】データが取得できませんでした。");
        }
    }
}
