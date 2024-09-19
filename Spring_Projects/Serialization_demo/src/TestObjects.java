import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjects {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		PurchaseOrder po=new PurchaseOrder("1234", "Dell", 100, 9000);
		FileOutputStream fos=new FileOutputStream("pofile.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(po);
		System.out.println(oos.toString());
		
		FileInputStream fis=new FileInputStream("pofile.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Object obj= ois.readObject();
		PurchaseOrder ref=(PurchaseOrder) obj;
		System.out.println(ois.toString());
		System.out.println(ref);
	}

}
