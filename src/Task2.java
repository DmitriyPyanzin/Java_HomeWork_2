import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;


public class Task2 {

    /*
     * 2. Напишите метод, который определит тип (расширение) файлов из текущей папки
     * и выведет в консоль результат вида
     *          1 Расширение файла: txt
     *          2 Расширение файла: pdf
     *          3 Расширение файла:
     *          4 Расширение файла: jpg
     */

    public static void main(String[] args) {
        Task2 t2 = new Task2();
        Path dir = Path.of("dir");
        List<Path> listFiles = t2.createList(dir);
        t2.filesExtention(listFiles);
    }

    public List<Path> createList(Path directory) {
        List<Path> files;
        try {
            files = Files.list(directory).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return files;
    }

    public void filesExtention(List<Path> filesList) {
        StringBuilder str = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < filesList.size(); i++) {
            for (int j = 0; j < filesList.get(i).toString().length(); j++) {
                if (flag) {
                    str.append(filesList.get(i).toString().charAt(j));
                }
                if (filesList.get(i).toString().charAt(j) == '.') {
                    flag = true;
                }
            }
            System.out.println((i + 1) + " Расширение файла: " + str);
            flag = false;
            str.delete(0, str.length());
        }
    }
}
