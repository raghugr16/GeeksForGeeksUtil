package com.java.geeks.solution.queue;

import java.util.Scanner;

import com.java.geeks.solution.utils.Stack;

public class QueueUsingStack {

	private Stack stack1 = new Stack();
	private Stack stack2 = new Stack();

	public void enQueue(int data) {
		stack1.push(data);
	}

	public int dqQueue() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return -1;
		}
		int data = -1;
		if (!stack2.isEmpty()) {
			data = stack2.pop();
			return data;
		}
		if (!stack1.isEmpty() && stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			data = stack2.pop();
		}
		return data;
	}

	public boolean isEmpty() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return true;
		}
		return false;
	}

	public void display() {

		if (stack1.isEmpty() && stack2.isEmpty()) {
			return;
		}
		System.out.println();
		if (stack1.isEmpty() && !stack2.isEmpty()) {
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			while (!stack1.isEmpty()) {
				int data = stack1.pop();
				System.out.print(data + " ");
				stack2.push(data);
			}
			return;
		}
		if (!stack1.isEmpty() && stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				int data = stack1.pop();
				System.out.print(data + " ");
				stack2.push(data);
			}
		}
	}

	public int peek() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return 0;
		}
		if (!stack2.isEmpty()) {
			return stack2.poll();
		} else {
			return stack1.getHead();
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * QueueUsingStack queue = new QueueUsingStack(); queue.enQueue(10);
		 * queue.enQueue(20); queue.enQueue(30); queue.enQueue(40);
		 * queue.enQueue(50); queue.enQueue(60); queue.enQueue(70);
		 * queue.display(); queue.dqQueue(); queue.display(); queue.dqQueue();
		 * queue.display(); queue.dqQueue(); queue.display(); queue.dqQueue();
		 * queue.display();
		 */

		QueueUsingStack solution = new QueueUsingStack();
		int n = Integer.parseInt(scanner.nextLine().trim());

		for (int i = 0; i < n; i++) {
			String str = scanner.nextLine();
			str = str.trim();
			if (str.contains(" ")) {
				String token[] = str.split(" ");
				solution.enQueue(Integer.parseInt(token[1]));
			} else {
				int action = Integer.parseInt(str);
				if (action == 2) {
					solution.dqQueue();
				} else if (action == 3) {
					System.out.println(solution.peek() + " ");
				}
			}
		}

		scanner.close();

	}
}
