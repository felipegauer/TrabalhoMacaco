import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class App {
    public static ArrayList<String> reader(String filePath) {
        List<String> recordList = new ArrayList<String>();
        String delimiter = " ";
        String currentLine;

        ArrayList<String> arrayToReturn = new ArrayList<>();
        String[] line;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                recordList.add(currentLine);
            }

            for (int i = 0; i < recordList.size(); i++) {
                line = recordList.get(i).split(delimiter);

                for (int j = 0; j < line.length; j++) {
                    arrayToReturn.add(line[j]);
                }
            }
            br.close();

            return arrayToReturn;

        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();
        ArrayList<Macaco> macacos = new ArrayList<>();
        int rodadas = 0;
        ArrayList<String> data = reader("caso1000.txt");


        for (int x = 0; x < data.size();) {
            if (data.get(x).equals("Macaco")) {
                x += 4;
                int par = Integer.parseInt(data.get(x));
                x += 3;
                int impar = Integer.parseInt(data.get(x));
                Macaco aux = new Macaco(macacos.size(),par, impar);
                macacos.add(aux);
                x += 2;
                int qntcoco = Integer.parseInt(data.get(x));
                x += 2;
                for (int i = 0; i < qntcoco; i++) {
                    int coco = Integer.parseInt(data.get(x));

                    if (coco % 2 == 0)
                        aux.addCocosPar(1);
                    else
                        aux.addCocosImpar(1);
                    x++;
                }
            } else {
                rodadas = Integer.parseInt(data.get(x + 1));
                x += 3;
            }
        }

        for (int i = 0; i < rodadas; i++) {
            for (int j = 0; j < macacos.size(); j++) {
                Macaco m = macacos.get(j);
                Macaco aux = macacos.get(m.getPar());
                aux.addCocosPar(m.zeraCocosPar());

                aux = macacos.get(m.getImpar());
                aux.addCocosImpar(m.zeraCocosImpar());

            }
        }


        int ganhador = -1;
        int somaganhador = 0;
        for (Macaco m : macacos) {
            int soma = m.getCocosPar() + m.getCocosImpar();
            if(soma>somaganhador) {
                somaganhador = soma;
                ganhador = m.getId();
            }
        }
        System.out.println("O macaco ganhador foi o macaco "+ganhador);

        long duration = (System.nanoTime() - start) / 1000000;
        if (duration > 1000) {
            double s = duration / 1000.00;
            System.out.printf("RunTime: %.2fs\n", s);
        } else
            System.out.println("RunTime: " + duration + "ms");
    }
}
