package com.jersey.automatictypecon.resources;

public class ProductCode {
	private int  pcode;
	private int  pnum;
	
	/*If you want this class to be created and injected.
	 * This class has to follw some rules 
	 * This class should contain one argumented constructor(That argument is String only)
	 * or else you can achieve the same thing using static valueOf method of you dont have this 
	 * single argumented class it will search for static valueOf method from the same class
	 * */
	
/* public ProductCode(String productDetails) {
	 System.out.println("inside the Productcode class constructor");
	 System.out.println("argumented value is "+productDetails);
	 if(productDetails != null && productDetails.length() <=5) {
		String  pc = productDetails.substring(0,2);
		String  pid = productDetails.substring(2 ,productDetails.length());
		System.out.println("values are "+ pc +" and "+pid);
		pcode = Integer.parseInt(pc);
		pnum = Integer.parseInt(pid);
	 }
	 else {
		 System.out.println("inside else block of the constructor");
	 }
}*/
 public static ProductCode valueOf(String productDetails) {
	 ProductCode productCode = null;
	 System.out.println("inside the static valueOf method");
	 System.out.println("inside the Productcode class constructor");
	 System.out.println("argumented value is "+productDetails);
	 if(productDetails != null && productDetails.length() <=5) {
		String  pc = productDetails.substring(0,2);
		String  pid = productDetails.substring(2 ,productDetails.length());
		System.out.println("values are "+ pc +" and "+pid);
		productCode= new ProductCode();
		productCode.pcode = Integer.parseInt(pc);
		productCode.pnum = Integer.parseInt(pid);
	 }
	 else {
		 System.out.println("inside else block of the constructor");
	 }
	 return productCode;
 }

@Override
public String toString() {
	return "ProductCode [pcode=" + pcode + ", pnum=" + pnum + "]";
}

public int getPcode() {
	return pcode;
}

public void setPcode(int pcode) {
	this.pcode = pcode;
}

public int getPnum() {
	return pnum;
}

public void setPnum(int pnum) {
	this.pnum = pnum;
}
}
