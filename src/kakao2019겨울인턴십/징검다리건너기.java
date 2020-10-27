package kakao2019겨울인턴십;

/**
 * programmers 
 * 카카오 2019 개발자 겨울 인턴십
 * @author Park Sangwoo
 * @since 2020-10-27
 */
public class 징검다리건너기 {

	static int stones[] = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
	static int k = 3;
	static int answer;
	public static void main(String[] args) {
		solution();
		System.out.println(answer-1);
	}

	public static int solution() {
		answer = 0;
		int countZero = 0;
		a: while (true) {
			for (int i = 0; i < stones.length; i++) {
				if (stones[i] == 0) {
					countZero++;
					if (countZero == k) {
						break a;
					}
					continue;
				}else {
					countZero =0;
				}
				stones[i]--;
			}
			answer++;
			countZero =0;
		}
		return answer;
	}
}
