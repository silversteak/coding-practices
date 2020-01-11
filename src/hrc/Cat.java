package hrc;

public class Cat extends Animal {
	
	public void bark() {
		System.out.println("Hello fro Cat");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat cat = new Cat();
		cat.bark();
		Animal catAni = new Cat();
		catAni.bark();		
		
	}

}
