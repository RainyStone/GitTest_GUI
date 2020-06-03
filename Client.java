package practice7;

import util.XMLUtil_Practice7;

public class Client {
	public static void main(String[] args) {
		Resume resume_previous=new Resume();
		Resume resume_new=null;
		Image image=new Image();
		resume_previous.setImage(image);
		String isWithImageString=XMLUtil_Practice7.IsWithImage();
		try {
			resume_new=resume_previous.copyWithImage(isWithImageString);
		} catch (Exception e) {
			System.out.println("克隆失败");
		}
		//比较简历
		System.out.println("简历是否相同?"+(resume_previous==resume_new));
		//比较照片
		System.out.println("照片是否相同?"+(resume_previous.getImage()==resume_new.getImage()));
	}
}
