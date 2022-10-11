package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex1 {

	public Ex1() {
		showFrame();
	}
	
	public void showFrame() {
		/*
		 * 이벤트 처리 4단계. 익명 내부클래스(Anonymous Inner Class) 형태로 정의
		 * - 리스너 인터페이스 또는 어댑터 클래스를 구현하는 핸들러를 별도로 정의하지 않고
		 *   해당 리스너 또는 어댑터의 이름을 그대로 사용하여
		 *   변수 선언 및 인스턴스 생성과 추상메서드 구현까지 한꺼번에 수행하는 방법
		 * - 개발자가 별도의 핸들러 이름을 부여하지 않으므로
		 *   이름이 없다는 뜻의 익명클래스라는 의미가 붙게됨  
		 * - 3단계 위치가 동일하며 클래스 정의 방법만 달라짐
		 * */
		JFrame f = new JFrame("이벤트 처리 - 4");
		f.setBounds(600, 400, 300, 200);
		
		// 로컬 레벨
		WindowAdapter listener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("로컬 windowClosing");
				System.exit(0);
			}
		};
	
		// 람다식 X
		// => 추상클래스이고 오버라이딩을 1개 선택햇을 뿐
		//    추상메서드가 1개 뿐인 인터페이스가 아니다!
//		WindowAdapter listener2 = e -> {
//			System.out.println("로컬 windowClosing");
//			System.exit(0);
//		};
		
		
		f.addWindowListener(listener);
		f.setVisible(true);
		
		
	}
	
	// 멤버레벨
	WindowAdapter listener = new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("멤버 windowClosing");
			System.exit(0);
		}
	};
	
	public static void main(String[] args) {
		new Ex1();
	}

}
