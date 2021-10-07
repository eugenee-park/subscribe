package ex01;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

//구독자 = 일반인(Consumer)
public class MySubscriber implements Subscriber<Integer>{
	
	private Subscription subscription;
	private Integer size = 4;
	private Integer maxsize = 4;

	@Override
	public void onSubscribe(Subscription subscription) {		
		System.out.println("2. 구독 응답 완료 (구독정보-데이터&구독자)");
		this.subscription = subscription;
		subscription.request(size); //요청 -> 리퀘스트 함수 호출
	}

	@Override
	public void onNext(Integer item) {
		System.out.println("4. 신문 " +item +"개 받음");
		size--;
		if(size == 0) {
			size = 4;
			subscription.request(size);
		}
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("신문 전달하다가..사고...났어");
	}

	@Override
	public void onComplete() {
		System.out.println("더 이상 줄 신문..없어");
	}

}
