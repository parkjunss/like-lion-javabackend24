// n x m 크기 격자 모양의 퍼즐판이 주어집니다.
// 퍼즐판에는 빨간색 수레와 파란색 수레가 하나씩 존재합니다. 각 수레들은 자신의 시작 칸에서부터 자신의 도착 칸까지 이동해야 합니다.
// 모든 수레들을 각자의 도착 칸으로 이동시키면 퍼즐을 풀 수 있습니다.
// 당신은 각 턴마다 반드시 모든 수레를 상하좌우로 인접한 칸 중 한 칸으로 움직여야 합니다. 단, 수레를 움직일 때는 아래와 같은 규칙이 있습니다.
// 수레는 벽이나 격자 판 밖으로 움직일 수 없습니다.
// 수레는 자신이 방문했던 칸으로 움직일 수 없습니다.
// 자신의 도착 칸에 위치한 수레는 움직이지 않습니다. 계속 해당 칸에 고정해 놓아야 합니다.
// 동시에 두 수레를 같은 칸으로 움직일 수 없습니다.
// 수레끼리 자리를 바꾸며 움직일 수 없습니다.
// 예를 들어, 아래 그림처럼 n = 3, m = 2인 퍼즐판이 있습니다.


// 속이 빨간색인 원은 빨간색 수레를 나타냅니다.
// 속이 파란색인 원은 파란색 수레를 나타냅니다.
// 테두리가 빨간색인 원은 빨간색 수레의 도착 칸을 나타냅니다.
// 테두리가 파란색인 원은 파란색 수레의 도착 칸을 나타냅니다.
// 위 퍼즐판은 아래와 같은 순서로 3턴만에 풀 수 있습니다.

// 빨간색 사선이 처진 칸은 빨간색 수레가 방문했던 칸을 나타냅니다. 규칙에 따라 빨간색 수레는 빨간색 사선이 처진 칸(방문했던 칸)으로는 이동할 수 없습니다.
// 파란색 사선이 처진 칸은 파란색 수레가 방문했던 칸을 나타냅니다. 규칙에 따라 파란색 수레는 파란색 사선이 처진 칸(방문했던 칸)으로는 이동할 수 없습니다.

// 위처럼 동시에 수레를 같은 칸으로 움직일 수는 없습니다.
// 퍼즐판의 정보를 나타내는 2차원 정수 배열 maze가 매개변수로 주어집니다. 퍼즐을 푸는데 필요한 턴의 최솟값을 return 하도록 solution 함수를 완성해 주세요. 퍼즐을 풀 수 없는 경우 0을 return 해주세요.

// 제한사항
// 1 ≤ maze의 길이 (= 세로 길이) ≤ 4
// 1 ≤ maze[i]의 길이 (= 가로 길이) ≤ 4
// maze[i][j]는 0,1,2,3,4,5 중 하나의 값을 갖습니다.
// maze[i][j]	의미
// 0	빈칸
// 1	빨간 수레의 시작 칸
// 2	파란 수레의 시작 칸
// 3	빨간 수레의 도착 칸
// 4	파란 수레의 도착 칸
// 5	벽
// 빨간 수레의 시작 칸, 빨간 수레의 도착 칸, 파란 수레의 시작 칸, 파란 수레의 도착 칸은 퍼즐판에 1개씩 존재합니다.
// 입출력 예
// maze	result
// [[1, 4], [0, 0], [2, 3]]	3
// [[1, 0, 2], [0, 0, 0], [5, 0 ,5], [4, 0, 3]]	7
// [[1, 5], [2, 5], [4, 5], [3, 5]]	0
// [[4, 1, 2, 3]]	0


// 솔루션 방법
// 1. 퍼즐판의 상태를 나타내는 클래스를 정의합니다. 이 클래스는 빨간색 수레와 파란색 수레의 위치, 방문했던 칸의 정보를 포함해야 합니다.
// 2. BFS(너비 우선 탐색) 알고리즘을 사용하여 퍼즐판의 상태 공간을 탐색합니다. BFS는 최단 경로를 찾는 데 적합한 알고리즘입니다.
// 3. BFS를 구현하기 위해 큐를 사용하여 탐색할 상태를 저장합니다. 초기 상태는 빨간색 수레와 파란색 수레의 시작 위치입니다.
// 4. 각 상태에서 가능한 모든 이동을 시도하여 새로운 상태를 생성합니다. 이동할 때는 규칙을 확인하여 유효한 이동인지 판단해야 합니다.
// 5. 새로운 상태가 퍼즐을 푸는 상태(빨간색 수레와 파란색 수레가 각각 도착 칸에 위치한 상태)인지 확인합니다. 만약 그렇다면, 현재까지의 턴 수를 반환합니다.
// 6. BFS 탐색이 끝날 때까지 퍼즐을 푸는 상태를 찾지 못하면 0을 반환합니다.
package day2;

public class Solution {
    int n, m;
    int[][] maze;
    boolean[][] redVisited, blueVisited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int INF = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;
        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) { rx = i; ry = j; }
                if (maze[i][j] == 2) { bx = i; by = j; }
            }
        }

        redVisited[rx][ry] = true;
        blueVisited[bx][by] = true;
        int result = dfs(rx, ry, bx, by, 0);
        
        return result == INF ? 0 : result;
    }

    private int dfs(int rx, int ry, int bx, int by, int count) {
        boolean rDone = (maze[rx][ry] == 3);
        boolean bDone = (maze[bx][by] == 4);

        if (rDone && bDone) return count;

        int minSteps = INF;

        // 빨강 4방향, 파랑 4방향 모든 조합 시도
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int nrx = rDone ? rx : rx + dx[i];
                int nry = rDone ? ry : ry + dy[i];
                int nbx = bDone ? bx : bx + dx[j];
                int nby = bDone ? by : by + dy[j];

                if (isValid(rx, ry, bx, by, nrx, nry, nbx, nby)) {
                    redVisited[nrx][nry] = true;
                    blueVisited[nbx][nby] = true;
                    minSteps = Math.min(minSteps, dfs(nrx, nry, nbx, nby, count + 1));
                    redVisited[nrx][nry] = false;
                    blueVisited[nbx][nby] = false;
                }
            }
        }
        return minSteps;
    }

    private boolean isValid(int rx, int ry, int bx, int by, int nrx, int nry, int nbx, int nby) {
        // 1. 범위를 벗어나거나 벽(5)인 경우
        if (nrx < 0 || nrx >= n || nry < 0 || nry >= m || maze[nrx][nry] == 5) return false;
        if (nbx < 0 || nbx >= n || nby < 0 || nby >= m || maze[nbx][nby] == 5) return false;

        // 2. 방문했던 칸 (이미 도착한 경우는 제외)
        if (maze[rx][ry] != 3 && redVisited[nrx][nry]) return false;
        if (maze[bx][by] != 4 && blueVisited[nbx][nby]) return false;

        // 3. 두 수레가 같은 칸에 있는 경우
        if (nrx == nbx && nry == nby) return false;

        // 4. 두 수레가 서로 자리를 바꾸는 경우 (교차 불가)
        if (nrx == bx && nry == by && nbx == rx && nby == ry) return false;

        return true;
    }
}