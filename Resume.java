package practice7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Resume implements Cloneable,Serializable{
	private Image image;
	
	public Resume() {
		System.out.println("Resume原型已创建");
	}
	
	public Image getImage(){
		return image;
	}
	
	public void setImage(Image image) {
		this.image=image;
	}
	
	public Resume copyWithImage(String cloneImageOrNot) throws ClassNotFoundException, IOException {
		Resume resume=null;
		if(cloneImageOrNot.equals("是")) {
			resume=deepClone();
			return resume;
		}
		else if(cloneImageOrNot.equals("否")){
			resume=shallowClone();
			return resume;
		}
		else 
			return resume;
	}
	
	private Resume shallowClone() {
		Object obj=null;
		try {
			System.out.println("Resume原型已被浅克隆");
			obj=super.clone();
			
			return (Resume)obj;
		} catch (CloneNotSupportedException e) {
			System.out.println("不支持浅克隆");
			
			return null;
		}
	}
	
	private Resume deepClone() throws IOException, ClassNotFoundException{
		//将对象写入流中
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bao);
		oos.writeObject(this);
		//将对象从流中取出
		ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		System.out.println("Resume原型已被深克隆");
		
		return (Resume)ois.readObject();
	}
}
