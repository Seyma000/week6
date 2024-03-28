package FileAndDirectoryOperations;

import java.io.*;

public class FileReadingAndWriting {
    public static void main(String[] args) {
        String Path = "src/FileAndDirectoryOperations/Number.txt";
        try {
            //createFile(Path);
            writeFile(Path);
            readFile(Path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //Dosya Oluşturma
    public static void createFile(String path) throws IOException{
        File file = new File(path);
        // Dosyanın olup olmadığını kontrol et
        if (file.createNewFile()){
            System.out.println(file.getName() + " dosyası oluşturuldu");
        }else {
            System.out.println(file.getName() + " dosyası mevcut !");
        }
    }

    // Dosyaya Yazma
    public static void writeFile(String path) throws IOException{
        File file = new File(path);

        FileWriter fileWriter = new FileWriter(file,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("5\n10\n20\n12\n33");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
    // Dosyayı Okuma
    public static void readFile(String path)throws IOException{
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int sum = 0;

        while ((line = bufferedReader.readLine()) != null){
            int number = Integer.parseInt(line);
            sum += number;
        }
        System.out.println("Sayıların toplamı : " + sum);
        bufferedReader.close();
    }

}
