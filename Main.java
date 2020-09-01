package list05_11;

//class Outer {
//	int outerField;
//	static int outerStaticField = 1;
//	static class Inner { /*static付きのメンバクラス(インナークラス)なので外クラスの非staticメンバにしかアクセス不可(outerField)*/
//		static void innerMethod() {
//			outerStaticField *= 10;
//			System.out.println("Inner");
//		}
//		//		void innerMethod2() { /*このメソッドはstaticメンバにしかアクセス不可*/
//		//			outerField = 20;
//		//		}
//	}
//	void outerMethod() { /*Outerクラスのメソッドの中でメンバクラスをインスタンス生成し、そのメソッドを呼ぶのは可能*/
//		outerStaticField -= 1;
//		Inner ic = new Inner();
//		ic.innerMethod();
//		System.out.println("Outer");
//	}
//}
//
//class Main {
//	public static void main(String[] args) {
//		Outer.Inner ic = new Outer.Inner();
//		Outer o = new Outer();
//		ic.innerMethod();
//		System.out.println(o.outerStaticField);
//		o.outerMethod();
//		System.out.println(o.outerStaticField);
//	}
//}

class Outer {
	int outerField=10; int outerStaticField=1;

	class Inner { /*static付きのメンバクラス(インナークラス)なので外クラスの非staticメンバにしかアクセス不可(outerField)*/
		void innerMethod() {
			outerStaticField *= 10;
			outerField+=outerStaticField;
			System.out.println("Inner");
		}

//		void innerMethod2() { /*このメソッドはstaticメンバにしかアクセス不可*/
//			outerField = 20;
//		}
	}

	void outerMethod() { /*Outerクラスのメソッドの中でメンバクラスをインスタンス生成し、そのメソッドを呼ぶのは可能*/
		outerStaticField +=1;
		Inner ic = new Inner();
		ic.innerMethod();
		System.out.println("Outer");
	}
}

class Main{
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner ic = o.new Inner();
		ic.innerMethod();
		System.out.println(o.outerStaticField);
		System.out.println(o.outerField);
		o.outerMethod();
		System.out.println(o.outerStaticField);
		System.out.println(o.outerField);

//		System.out.println(ic.outerField);これはアクセスできなかった。


	}
}
