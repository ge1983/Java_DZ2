// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
import java.io.FileWriter;
import java.io.IOException;

public class Z2 {
    public static void main(String[] args) throws IOException {
        int [] array = {2, 5, 1, -7, 3, 64, 0};

        System.out.println("Исходный массив:");
        for (int i = 0; i < 7; i++) {
            System.out.printf(array[i] + " ");
        }

        System.out.println();

        int[] newArray = sortArray(array);
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < 7; i++) {
            System.out.printf(newArray[i] + " ");
        }
    }
    public static int[] sortArray(int [] arr){
        for(int k = 0; k < arr.length-1; k++) {

            for (int i = 0; i < arr.length - k-1; i++){
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    writeToFile(convertArrayToString(arr));
                }
            }
        }
        return arr;
    }

    static String convertArrayToString(int []arr) {
        StringBuilder stb = new StringBuilder();
        for (int element : arr) {
            stb.append(element).append(" ");
        }
        return stb.toString();
    }

    static void writeToFile( String line) {
        try (FileWriter fw = new FileWriter("fileForArray.txt", true)) {
            fw.write(line);
            fw.write("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}