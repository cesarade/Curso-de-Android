
public class Operadores {
	
	public static void main(String[] arg) {
		
		int i = 10;
		int j = 5;
		
		int result = i + j;
		result = result - 2;
		result = result + 1;
		result++;
		result += 2;
		//result = result - 2;
		result -= 2;
		
		boolean esPar=true;
		
		esPar = result%2 == 0;
		
		//if(result%2 == 0)
		if(esPar) {
			System.out.println("El número " + result + " es par");
		}else {
			System.out.println("El número " + result + " es impar");
		}
		
		System.out.println(result);
		System.out.println(esPar);
		
	}
	
	

}
