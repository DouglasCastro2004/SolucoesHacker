import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.text.*; 
import java.util.*;
import java.util.regex.*;


public class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int qq = 1;
        //int qq = Integer.MAX_VALUE;
        //int qq = readInt();
        for(int casenum = 1; casenum <= qq; casenum++) {
            int r = readInt();
            int c = readInt();
            int n = readInt();
            n--;
            int[][] bomb = new int[r][c];
            for(int i = 0; i < r; i++) {
                String s = nextToken();
                for(int j = 0; j < c; j++) {
                    if(s.charAt(j) == 'O') {
                        bomb[i][j] = 2;
                    }
                }
            }
            n %= 100;
            int[] dx = new int[]{-1,1,0,0};
            int[] dy = new int[]{0,0,-1,1};
            for(int i = 1; i <= n; i++) {
                if(i%2 == 1) {
                    for(int a = 0; a < r; a++) {
                        for(int b = 0; b < c; b++) {
                            if(bomb[a][b] == 0) {
                                bomb[a][b] = 3;
                            }
                            else if(bomb[a][b] > 0) {
                                bomb[a][b]--;
                            }
                        }
                    }
                }
                else {
                    boolean[][] dead = new boolean[r][c];
                    for(int a = 0; a < r; a++) {
                        for(int b = 0; b < c; b++) {
                            if(bomb[a][b] == 1) { 
                                dead[a][b] = true;
                                for(int k = 0; k < dx.length; k++) {
                                    int nx = a + dx[k];
                                    int ny = b + dy[k];
                                    if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                                        dead[nx][ny] = true;
                                    }
                                }
                            }
                        }
                    }
                    for(int a = 0; a < r; a++) {
                        for(int b = 0; b < c; b++) {
                            if(dead[a][b])
                                bomb[a][b] = 0;
                            else if(bomb[a][b] > 0) {
                                bomb[a][b]--;
                            }
                        }
                    }
                }
            }
            for(int[] out: bomb) {
                for(int out2: out) {
                    if(out2 > 0) {
                        pw.print('O');
                    }
                    else {
                        pw.print('.');
                    }
                }
                pw.println();
            }
        }
        exitImmediately();
    }
    private static void exitImmediately() {
        pw.close();
        System.exit(0);
    }
    private static long readLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    private static double readDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    private static String nextLine() throws IOException  {
        if(!br.ready()) {
            exitImmediately();
        }
        st = null;
        return br.readLine();
    }
    private static String nextToken() throws IOException  {
        while(st == null || !st.hasMoreTokens())  {
            if(!br.ready()) {
                exitImmediately();
            }
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}