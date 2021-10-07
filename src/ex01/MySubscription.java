package ex01;

import java.util.Iterator;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

//구독정보를 가진 클래스 
public class MySubscription implements Subscription {

	Iterator<Integer> it;
	private Subscriber subscriber;

	public MySubscription(Iterable<Integer> its, Subscriber subscriber) {
		System.out.println("-> 구독정보 만들어짐");
		this.it = its.iterator();
		this.subscriber = subscriber;
	}

	@Override
	public void request(long n) { //리퀘스트 함수가 3번실행 아니고 내부가 3번 주는 것 
		System.out.println("3. 신문 " + n + "개씩 받을게!"); // 백프레셔 조정을 해야함.
		while(n-- > 0) {
		if(it.hasNext()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		subscriber.onNext(it.next()); 
		} else {
		subscriber.onComplete();
		}
	}
}

	
	@Override
	public void cancel() {
		System.out.println("구독취소");
	}
}
