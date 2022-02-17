package programming;

import java.util.stream.IntStream;

public class FP05Threads {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println(Thread.currentThread().getId() + ":" + i);

				}

			}

		};

		Runnable runnable2 = () -> {
			for (int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getId() + ":" + i);

			}
		};
		Thread thread = new Thread(runnable2);
		thread.start();

		Thread thread1 = new Thread(runnable2);
		thread1.start();

		Thread thread2 = new Thread(runnable2);
		thread2.start();

		Runnable runnable3 = () -> IntStream.range(0, 10000).forEach(
				i -> System.out.println(Thread.currentThread().getId() + ":" + i)
		);

		Thread thread3 = new Thread(runnable3);
		thread3.start();

		Thread thread4 = new Thread(runnable3);
		thread4.start();

		Thread thread5 = new Thread(runnable3);
		thread5.start();

	}

}
