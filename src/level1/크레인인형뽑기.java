package level1;
/**
 * programmers 
 * 카카오 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크레인인형뽑기 {
	static int [][] board; 
	static int [] moves;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		board = new int [30][30];
		moves = new int [1000];
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < moves.length; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}
		solution(board,moves);
	}
	public static int solution(int[][] board, int[] moves) {

		int answer = 0;
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				// board가 배열로 시작값이 0부터 시작이므로 -1
				if (board[j][moves[i]-1] != 0) {
					// 스택이 비어있을 경우 최초 입력
					if (st.isEmpty()) {
						st.push(board[j][moves[i]-1]);
					}
					// 그렇지 않을 경우
					else {
						// 스택의 맨 위의 값이 비교 값이랑 같을 경우
						if (st.peek() == board[j][moves[i]-1]) {
							st.pop();
							// 하나 없애고 하나 추가 안하지만 없애는걸로 cnt하여 +2
							answer +=2;
						}
						// 비교 값이 같이 않을 경우
						else {
							st.push(board[j][moves[i]-1]);
						}
					}
					//뺀 배열의 값을 0으로 초기화
					board[j][moves[i]-1] = 0;
					break;
				}
			}
		}
		return answer;
	
	}
}
