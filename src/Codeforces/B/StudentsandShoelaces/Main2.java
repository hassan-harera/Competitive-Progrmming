/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codeforces.B.StudentsandShoelaces;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author harera
 */
public class Main2 {

    static List<Integer> [] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        
        graph = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList();
        }
        
        for (int i = 0; i < m; i++) {
             stk = new StringTokenizer(in.readLine());
                     int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        graph[a].add(b);
        graph[b].add(a);
        }
        
        int ans = 0;
        while (true) {            
            Boolean thereIsOneEdge = false;
            Queue<Point> q = new LinkedList();
            for (int i = 0; i < graph.length; i++) {
                if(graph[i].size() == 1){
                    q.add(new Point(i, graph[i].get(0)));
                    graph[i].remove(0);
                    thereIsOneEdge = true;
                }
            }
            
            if(thereIsOneEdge){
                ans++;
            }else {
                break;
            }
            
            for (Point point : q) {
                graph[point.y].remove(new Integer(point.x));
            }
        }
        System.out.println(ans);
        
    }
}
