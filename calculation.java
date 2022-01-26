package conversions;

public class calc {
	
	static float cy;
	public static float rup_conv(int x,String c2) {
		if(c2=="USD") {
			cy=(float) (x/74.39);
		}
		
		else if(c2=="Euro") {
			cy=(float) (x/84.06);
		}
		
		else if(c2=="Pounds") {
			cy=(float) (x/100);
		}
		
		else if(c2=="Won") {
			cy=(float) (x/0.062);
		}
		
		else if(c2=="Yen") {
			cy=(float) (x/0.64);
		}
		
		else {
			cy=x;
		}
		
	return cy;	
	}
	
	public static float usd_conv(int x,String c2) {
		if(c2=="Rupee") {
			cy=(float) (x * 74.31);
		}
		
		else if(c2=="Euro") {
			cy=(float) (x * 0.88);
		}
		
		else if(c2=="Pounds") {
			cy=(float) (x * 0.74);
		}
		
		else if(c2=="Won") {
			cy=(float) (x * 1197.56);
		}
		
		else if(c2=="Yen") {
			cy=(float) (x * 115.59);
		}
		
		else {
			cy=x;
		}
		
	return cy;	
	}

	public static float euro_conv(int x,String c2) {

		if(c2=="Rupee") {
			cy=(float) (x * 84.39);
		}
		
		else if(c2=="USD") {
			cy=(float) (x * 1.14);
		}
		
		else if(c2=="Pounds") {
			cy=(float) (x * 0.84);
		}
		
		else if(c2=="Won") {
			cy=(float) (x * 1360.62);
		}
		
		else if(c2=="Yen") {
			cy=(float) (x * 131.31);
		}
		
		else {
			cy=x;
		}
		
	return cy;	
	}

	public static float pnd_conv(int x,String c2) {
		if(c2=="Rupee") {
			cy=(float) (x * 100.93);
		}
		
		else if(c2=="USD") {
			cy=(float) (x * 1.36);
		}
		
		else if(c2=="Euro") {
			cy=(float) (x * 1.20);
		}
		
		else if(c2=="Won") {
			cy=(float) (x * 1627.30);
		}
		
		else if(c2=="Yen") {
			cy=(float) (x * 157.07);
		}
		
		else {
			cy=x;
		}
		
	return cy;	
	}

	public static float won_conv(int x,String c2) {
		if(c2=="Rupee") {
			cy=(float) (x * 0.062);
		}
		
		else if(c2=="USD") {
			cy=(float) (x * 0.00084);
		}
		
		else if(c2=="Euro") {
			cy=(float) (x * 0.00073);
		}
		
		else if(c2=="Pounds") {
			cy=(float) (x * 0.00061);
		}
		
		else if(c2=="Yen") {
			cy=(float) (x * 0.097);
		}
		
		else {
			cy=x;
		}
		
	return cy;	
	}

	public static float yen_conv(int x,String c2) {
		if(c2=="Rupee") {
			cy=(float) (x * 0.64);
		}
		
		else if(c2=="USD") {
			cy=(float) (x * 0.0087);
		}
		
		else if(c2=="Euro") {
			cy=(float) (x * 0.0076);
		}
		
		else if(c2=="Pounds") {
			cy=(float) (x * 0.0064);
		}
		
		else if(c2=="Won") {
			cy=(float) (x * 10.36);
		}
		
		else {
			cy=x;
		}
		
	return cy;	
	}
}


