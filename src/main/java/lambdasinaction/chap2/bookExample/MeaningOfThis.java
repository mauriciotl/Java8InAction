package lambdasinaction.chap2.bookExample;

public class MeaningOfThis
{
	public final int value = 4;


	public void doIt()
	{
		System.out.println(this.value);

		int value = 6;
		System.out.println(value);

		//The following variable is using an anonymous class implementation
		//of the Runnable interface. Runnable is a functional interface whose
		// functional method is run().

		Runnable r = new Runnable(){

			public final int value = 5;

			@Override
			public void run(){

				int value = 10;
				System.out.println(value);

				System.out.println(this.value);
			}

		};

		r.run(); 
	}

	public static void main(String...args)
	{       
		MeaningOfThis m = new MeaningOfThis();
		m.doIt(); // ???   
	}

}
