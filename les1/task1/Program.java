import java.io.*;

public class Program {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String formatException = "Неправильный формат, проверьте правильность строки в input.txt";
        String str;
        Double a = null;
        Double b = null;
        while ((str = br.readLine()) != null) {
            String[] datas = str.split(" ");
            if(datas[0].equals("a")){
                try {
                    a = Double.valueOf(datas[1]);
                } catch (Exception e) {
                    System.out.println(formatException);
                }
            }
            else if(datas[0].equals("b")){
                try {
                    b = Double.valueOf(datas[1]);
                } catch (Exception e) {
                    System.out.println(formatException);
                }
            }
            else{
                System.out.println(formatException);
            }
        }
        if(a != null && b != null){
            try(FileWriter fw = new FileWriter("output.txt", false)){
                fw.write(Double.toString(Math.pow(a, b)));
                fw.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            System.out.println(formatException);
        }
        br.close();
    }
}
