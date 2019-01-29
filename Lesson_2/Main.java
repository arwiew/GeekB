package Lesson_2;

public class Main {

    private static final int size = 4;

    public static void main(String[] args) {

        String[][] arrText = new String[][]{
                {"1", "h", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "j", "1"},
                {"1", "1", "1", "1"},
        };

        try {
            int result = sum(arrText);
            System.out.println(result);
        } catch (MyArraySizeException ex) {
            System.out.println("Размер массива некорректен!");
        } catch (MyArrayDataException ex) {
            ex.printStackTrace();
            System.out.println("Массив содержит недопустимые значение в ячейке" + " " + ex.getI() + "x" + ex.getJ());
        }
    }


    private static int sum(String[][] arrText) throws MyArraySizeException, MyArrayDataException {
        if (arrText.length != size) {
            throw new MyArraySizeException();
        }
        int arrValue = 0;
        for (int i = 0; i < arrText.length; i++) {
            for (int j = 0; j < arrText.length; j++) {
                try {
                    arrValue += Integer.parseInt(arrText[i][j]);
                } catch (Exception ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return arrValue;
    }
}













