# Double Dispatch

## 介绍

在软件工程中，Double Dispatch是一种特殊形式的Multiple Dispatch，也是根据于两个对象的运行时类型来调用的其相应具体类（不是基类）方法的一种机制。在大多数面向对象的系统中，在代码（程序）中的一个函数调用具体类的方法都取决于单个对象的动态类型（运行时的类型），（它们一般）被称为Single Dispath calls，或只是虚拟函数调用。

 不难看出一次虚函数的调用叫做Single Dispath ，那么Double Dispatch应该就是两次虚函数的调用。

更进一步说就是一次通过动态类型（运行时类型）调用相应子类真实类型的方法函数，就称为一次Dispath。那么以此类推，需要两次通过运行时类型调用相应类型的方法函数，则称为Double Dispatch。

## 实现

### 方法1-static dispatch

```java
public interface Spi {
}
public class PrivateBundle implements Spi {
}
public class PlatformBundle implements Spi {
}
public class Handler {

    public void handle(Spi spi) {
        System.out.println("It is spi");
    }

    public void handle(PrivateBundle event) {
        System.out.println("It is PrivateBundle");
    }

    public void handle(PlatformBundle event) {
        System.out.println("It is PlatformBundle");
    }
}

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();
        handler.handle(new Spi() {
        });
        handler.handle(new PlatformBundle());
        handler.handle(new PrivateBundle());

        Spi spi = new PrivateBundle();
        handler.handle(spi);
    }
}
```

### 方法2-dynimic dispatch

```java
public interface Spi {
    void doSomething(Handler handler);
}

public class PrivateBundle implements Spi {
    public void doSomething(Handler handler) {
        handler.handle(this);
    }
}
public class PlatformBundle implements Spi {
    public void doSomething(Handler handler) {
        handler.handle(this);
    }
}

public class Handler {

    public void handle(Spi spi) {
        System.out.println("It is spi");
    }

    public void handle(PrivateBundle event) {
        System.out.println("It is PrivateBundle");
    }

    public void handle(PlatformBundle event) {
        System.out.println("It is PlatformBundle");
    }
}

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();
        new PlatformBundle().doSomething(handler);
        Spi platformBundle = new PlatformBundle();
        platformBundle.doSomething(handler);

        new PrivateBundle().doSomething(handler);
        Spi privateBundle = new PrivateBundle();
        privateBundle.doSomething(handler);
    }
}
```

更有意思的代码

```java
public enum Outcome { WIN, LOSE, DRAW } ///:~
 
 
interface Item {
	Outcome compete(Item it);
 
	Outcome eval(Paper p);
 
	Outcome eval(Scissors s);
 
	Outcome eval(Rock r);
}
 
class Paper implements Item {
	public Outcome compete(Item it) {
		return it.eval(this);
	}
 
	public Outcome eval(Paper p) {
		return DRAW;
	}
 
	public Outcome eval(Scissors s) {
		return WIN;
	}
 
	public Outcome eval(Rock r) {
		return LOSE;
	}
 
	public String toString() {
		return "Paper";
	}
}
 
class Scissors implements Item {
	public Outcome compete(Item it) {
		return it.eval(this);
	}
 
	public Outcome eval(Paper p) {
		return LOSE;
	}
 
	public Outcome eval(Scissors s) {
		return DRAW;
	}
 
	public Outcome eval(Rock r) {
		return WIN;
	}
 
	public String toString() {
		return "Scissors";
	}
}
 
class Rock implements Item {
	public Outcome compete(Item it) {
		return it.eval(this);
	}
	
	public Outcome eval(Paper p) {
		return WIN;
	}
 
	public Outcome eval(Scissors s) {
		return LOSE;
	}
 
	public Outcome eval(Rock r) {
		return DRAW;
	}
 
	public String toString() {
		return "Rock";
	}
}
 
public class RoShamBo1 {
	static final int SIZE = 20;
	private static Random rand = new Random(47);
 
	public static Item newItem() {
		switch (rand.nextInt(3)) {
		default:
		case 0:
			return new Scissors();
		case 1:
			return new Paper();
		case 2:
			return new Rock();
		}
	}
 
	public static void match(Item a, Item b) {
		System.out.println(a + " vs. " + b + ": " + a.compete(b));
	}
 
	public static void main(String[] args) {
		for (int i = 0; i < SIZE; i++)
			match(newItem(), newItem());
	}
}

RoshamBol.match()有2个item参数，通过Item.compete()方法开始2路分发，要判定a的类型，分发机制会在a的实际类型的compete()内部起到分发作用。compete()方法通关过eval()来为另一个类型实现第二次分发， 将自身(this)作为参数调用eval()，能够调用重载过的eval()方法，这能够保留第一次分发的类型信息，第二次分发完成时，就能知道两个Item对象的具体类型了。

```

## 架构

在架构设计中可以定义一个Spi(接口),实现多个Bundle(实现),配置一定规则校验上下文,来实现多Double Bundle 或 MultiBundle

符合开闭原则,上述的Handler可以抽象为配置项和配置值, 当新的业务来了,添加配置项, 将新业务路由到新的bundle

## 语言

一个方法所属的对象叫做方法的接收者，方法的接收者与方法的参量统称做方法的宗量

根据分派可以基于多少种宗量，可以将面向对象的语言划分为单分派语言和多分派语言。单元分派语言根据一个宗量的类型（真实类型）进行对方法的选择,多分派语言根据多于一个的宗量的类型对方法进行选择。

C++和Java以及Smaltalk都是单分派语言；多分派语言的例子包括CLOS和Cecil。按照这样的区分，C++和Java就是动态的单分派语言，因为这两种语言的动态分派仅仅会考虑到方法的接收者的类型，同时又是静态的多分派语言，因为这两种语言对重载方法的分派会考虑到方法的接收者的类型和方法所有参量的类型。

在一个支持动态单分派的语言里面，有两个条件决定了一个请求会调用哪一个操作：一是请求的名字，二是接收者的真实类型。单分派限制了方法的选择过程，使得只有一个宗量可以被考虑到，这个宗量通常就是方法的接收者。在JAVA语言里面，如果一个操作是作用于某个类型不明的对象上面的。那么这个对象的真实类型测试仅会发生一次。这个就是动态的单分派的特征。

一言以蔽之，JAVA语言支持静态的多分派和动态的单分派。