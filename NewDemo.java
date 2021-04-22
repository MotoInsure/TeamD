
public class NewDemo<K> {
	private K data;

	public NewDemo(K data) {
		super();
		this.data = data;
	}

	public K getData() {
		return data;
	}

	public void setData(K data) {
		this.data = data;
	};

	// comment added - hemaja
	public static void main(String[] args) {
		NewDemo<String> d1= new NewDemo<String>("Hii");
		//d1.setData(1001);
		System.out.println(d1.getData());
		
		NewDemo<Integer> d2= new NewDemo<Integer>(1032);
		System.out.println(d2.getData());
		
	}

}
