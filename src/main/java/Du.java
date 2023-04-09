import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;

public class Du {

    public Long directorySize(File dir) {
        long size = 0;
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            size += file.length();
        }
        return size;
    }

    public long objectSize(String input) {
        File file = new File(input);
        if (!file.exists()) {
            throw new IllegalArgumentException();
        } else {
            if (file.isFile()) {
                return file.length();
            } else if (file.isDirectory()) {
                return directorySize(file);
            }
        }
        return 0;
    }

    public List<String> bases = Arrays.asList("B", "KB", "MB", "GB");
    long size = 0;
    int index = 0;
    int num = 1024;

    public void sum (boolean c, boolean h, boolean si, List<String> file) {
        for (String str : file) {
            long fileSize = objectSize(str);
            if (c)
                size += fileSize;
            else
                System.out.println(str + " = " + read(fileSize, si, h));
        }
        if (c)
            System.out.println("Sum of files = " + read(size, si, h));
    }

    public String read(long size, boolean si, boolean h) {
        StringBuilder res = new StringBuilder();
        if (si) num = 1000;
        if (h) {
            while (size >= num && index <= 3) {
                size /= num;
                index++;
            }
            res.append(size);
            res.append(bases.get(index));
        } else
            res.append(Math.max(1, size / num));
        return res.toString();
    }
}