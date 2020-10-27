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
		System.out.println(answer);
	}

	public static int solution() {
		int l = 0;
        int r = Integer.MAX_VALUE;
        int mid = 0;
        int count = 0;                        //0이 연속적으로 나오는지 확인
        boolean flag = false;                //r을 줄일지 l을 줄일지 파악(ex.0이 연속으로 나오면 r을 줄여야함)
        answer = 0;
        while(l <= r) {
            int[] stoneA = stones.clone();  //매번 필요하므로 주소값이 stones을 가르키지 않게 
            mid = (l+r)/2;
            count= 0;
            flag = false;        
            
            for(int i = 0 ; i < stoneA.length;i++) { //0으로 바꿔줬음
                if(stoneA[i] <= mid) {
                    stoneA[i] = 0;
                    count++;
                    if(count == k) {                //0의 개수가 K와 같으면 건너지 못함.
                        flag = true;                //건너지 못하므로 사람 순서를 더 적게해서 도전한다.
                        break;
                    }
                }else {                                //연속되지 않으면 count를 0으로 초기화
                    count =0;
                }
            }
            if(flag) {                                //mid번 째 사람이 넘는지 안넘는지에 따라 r,l조정
                r = mid -1;
                answer = mid;                        //true 즉 건널 수 있을 때 건너간 mid번째 사람을 저장.
            }else {
                l = mid +1;
            }
        }
        return answer;
	}
}
