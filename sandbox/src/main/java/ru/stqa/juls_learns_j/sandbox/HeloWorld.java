package ru.stqa.juls_learns_j.sandbox;

import ru.stqa.juls_learns_j.sandbox.Square;

public class HeloWorld {
	public static void main(String[] args) {
		Helo("World");
		Helo("user");

		Square s = new Square(5);

		System.out.println("the area with size " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 6);

		System.out.println("the area with sides " + r.a + " and " + r.b + " = " + r.area());
	}

	public static void Helo(String somebody) {
		//= ;
		System.out.println("Hello, juuuuuuls " + somebody + "!");

	}


}