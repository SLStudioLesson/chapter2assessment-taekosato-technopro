package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        File dataFile = new File(filePath);
        // ファイルを読み込む
        if (dataFile.length() == 0 && dataFile.exists()) {
            // ファイルが空の時
            System.out.println("No recipes available.");
        } else {
            // ファイルの中身があるとき
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                System.out.println(); // 改行
                System.out.println("Recipes:");
                while ((line = reader.readLine()) != null) {
                    // カンマで分ける
                    String[] pairs = line.split(",");
                    // for (int i = 0; i < pairs.length; i++) {
                        // 最初だけ出力
                        System.out.println("-----------------------------------");
                        System.out.println("Recipe Name: " + pairs[0]);
                        System.out.print("Main Ingredients: ");
                        for(int j = 1; j < pairs.length; j++) {
                            // 残りを順番に
                            System.out.print(pairs[j]);
                        }
                        System.out.println();
                    // }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter recipe name: ");
        String inputName = reader.readLine();

        System.out.print("Enter main ingredients (comma separated): ");
        String inputIngredient = reader.readLine();

        // inputIngredientsを配列にする
        String[] inuputIngredients = inputIngredient.split(",");

        // ファイルの書き込み
        String writeString = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(inputName + writeString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Recipe added successfully.");
    }
    public String writeString() {
        for (String food : inuputIngredients) {
            system.out.print("," + food);
        }
    }
}
