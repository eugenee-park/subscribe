package ex01;

import java.util.Arrays;
import java.util.Iterator;

public class MyApp {
	public static void main(String[] args) {
		MyPublisher pub = new MyPublisher();
		MySubscriber sub = new MySubscriber();
		
		pub.subscribe(sub); //구독시작 (request)
	}
}
   