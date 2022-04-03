class Cau1{

	public static int maxEvenPos(int a[]) {
		int max = -1000;
        
        for (int i = 0; i < a.length; i++) {
            if (i%2 == 0 && a[i] > max) {
                max = a[i];
                
            }
        }
        return max;
	}
	
	public static String lowercaseFirstLetter(String str){
		String result = "";
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.toLowerCase(arr[i].charAt(0)) + arr[i].substring(1);
            result += arr[i] + " ";
        }

        return result.trim();
	} 
	
	public static void main(String[] args){		
		int a[] = {1,-2,3,1,-2,6};
		System.out.println(maxEvenPos(a));
		String s = "Khoa Cong Nghe thong Tin";
		// System.out.println(lowercaseFirstLetter(s));
	}
}