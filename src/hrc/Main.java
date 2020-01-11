package hrc;

import java.util.ArrayList;

public class Main {
	
	public static void main(String args[]) {
		A a = new A();
		B b = new B();
		C c = new C();
		A a2 = new C();
		
		
		b.m1();
		c.m2();
		a.m3();
		
		
		c.m1();
		c.m2();
		c.m3();
		
		a.m1();
		b.m2();
		c.m3();
		
		a2.m1();
		a2.m2();
		a2.m3();
		
		Object o = new C();
		System.out.println(o.getClass().getName());
		
		ArrayList<Object> list = new ArrayList<>();
		list.add(a);
		
		A aa = (A) list.get(0);
		aa.m1();
		
		
	}
	
	

}
