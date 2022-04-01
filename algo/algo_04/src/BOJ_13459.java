import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13459 {
    static class Ball {
        int r_x;
        int r_y;
        int b_x;
        int b_y;
        int cnt;

        public Ball() {
        }

        public Ball(int r_x, int r_y, int b_x, int b_y, int cnt) {
            this.r_x = r_x;
            this.r_y = r_y;
            this.b_x = b_x;
            this.b_y = b_y;
            this.cnt =cnt;
        }
    }
    static int N,M;
    static char[][] map;
    static boolean visited[][][][];
    static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        Ball balls = new Ball();
        balls.cnt=0;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j<M; j++) {
                map[i][j]=temp.charAt(j);
                if(map[i][j]=='R'){
                    balls.r_x=i;
                    balls.r_y=j;
                }else if(map[i][j]=='B'){
                    balls.b_x=i;
                    balls.b_y=j;
                }
            }
        }

        System.out.println(solution(balls));
    }

    static int solution(Ball balls){
        Queue<Ball> q = new ArrayDeque<>();
        q.offer(balls);
        while(!q.isEmpty()){
            Ball ball = q.poll();
            visited[ball.r_x][ball.r_y][ball.b_x][ball.b_y] =true;
            if(ball.cnt>=10){
                return 0;
            }
            for (int idx = 0; idx < 4; idx++) {
                int red [] = move(ball.r_x,ball.r_y,idx);
                int blue [] = move(ball.b_x,ball.b_y,idx);

                if(map[blue[0]][blue[1]]=='O')
                    continue;
                if(map[red[0]][red[1]]=='O'){
                    return 1;
                }//북남 서동
                if(red[0]==blue[0]&&red[1]==blue[1]){
                    if(idx==0){
                        if(ball.r_x < ball.b_x ){
                            blue[0]+=1;
                        }else{
                            red[0]+=1;
                        }
                    }else if(idx==1){
                        if(ball.r_x < ball.b_x ){
                            red[0]-=1;
                        }else{
                            blue[0]-=1;
                        }
                    }
                    else if(idx==2){
                        if(ball.r_y < ball.b_y ){
                            blue[1]+=1;
                        }else{
                            red[1]+=1;
                        }
                    }else if(idx==3){
                        if(ball.r_y < ball.b_y ){
                            red[1]-=1;
                        }else{
                            blue[1]-=1;
                        }
                    }
                }
                if(!visited[red[0]][red[1]][blue[0]][blue[1]]){
                    q.offer(new Ball(red[0],red[1],blue[0],blue[1],ball.cnt+1));
                }
            }

        }
        return 0;

    }



    static int[] move(int x , int y, int dir){
        int next[] = new int[2];
        int n_x = x;
        int n_y = y;
        while(map[n_x+dx[dir]][n_y+dy[dir]]!='#'){
            n_x += dx[dir];
            n_y += dy[dir];
            if(map[n_x][n_y]=='O'){
                break;
            }
        }
        next[0] =n_x;
        next[1] =n_y;
        return next;
    }


}


