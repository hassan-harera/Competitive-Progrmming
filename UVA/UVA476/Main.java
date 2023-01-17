package UVA.UVA476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        List<Figure> figs = new ArrayList<>();

        String str;
        for (int i = 0; !(str = in.readLine()).equals("*"); i++) {
            str = str.substring(1, str.length());
            stk = new StringTokenizer(str);

            Figure f;
            float a1 = Float.parseFloat(stk.nextToken());
            float a2 = Float.parseFloat(stk.nextToken());
            float a3 = Float.parseFloat(stk.nextToken());
            float a4 = Float.parseFloat(stk.nextToken());

            f = new Figure(a1, a2, a3, a4);
            figs.add(f);
        }
        for (int i = 1; !(str = in.readLine()).equals("9999.9 9999.9"); i++) {
            stk = new StringTokenizer(str);
            float a1 = Float.parseFloat(stk.nextToken());
            float a2 = Float.parseFloat(stk.nextToken());

            Boolean noFigure = false;

            for (int j = 0; j < figs.size(); j++) {
                Figure fig = figs.get(j);
                if (a1 >= fig.x1 && a1 <= fig.y1 && a2 >= fig.y2 && a2 <= fig.x2) {
                    sb.append("Point " + i + " is contained in figure " + (j+1)  + "\n");
                    noFigure = true;
                }
            }

            if (!noFigure) {
                sb.append("Point " + i + " is not contained in any figure\n");
            }

        }
        System.out.print(sb);
    }

}

class Figure {

    float x1, x2, y1, y2;

    public Figure(float x1, float x2, float y1, float y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

}
