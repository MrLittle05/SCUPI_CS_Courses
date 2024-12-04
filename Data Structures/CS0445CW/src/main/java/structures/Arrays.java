package structures;

public class Arrays {
	
	    // 使用泛型的数组复制方法
	    public static <T> T[] copyOf(T[] original, int newLength) {
	        if (newLength < 0) {
	            throw new NegativeArraySizeException("新数组长度不能为负数");
	        }

	        @SuppressWarnings("unchecked")
	        T[] copy = (T[]) java.lang.reflect.Array.newInstance(original.getClass().getComponentType(), newLength);
	          
	        // 如果新数组长度小于原数组长度，只复制新数组长度个元素
	        // 否则，复制整个原数组
	        int elementsToCopy = Math.min(original.length, newLength);
	        for (int i = 0; i < elementsToCopy; i++) {
	            copy[i] = original[i];
	        }
	        
	        return copy;
	    }

	    // int数组复制方法
	    public static int[] copyOf(int[] original, int newLength) {
	        if (newLength < 0) {
	            throw new NegativeArraySizeException("新数组长度不能为负数");
	        }

	        int[] copy = new int[newLength];
	        int elementsToCopy = Math.min(original.length, newLength);
	        for (int i = 0; i < elementsToCopy; i++) {
	            copy[i] = original[i];
	        }  
	        return copy;
	    }
	    
	    //float数组复制方法
	    public static float[] copyOf(float[] original, int newLength) {
	        if (newLength < 0) {
	            throw new NegativeArraySizeException("新数组长度不能为负数");
	        }

	        float[] copy = new float[newLength];
	        int elementsToCopy = Math.min(original.length, newLength);
	        for (int i = 0; i < elementsToCopy; i++) {
	            copy[i] = original[i];
	        }   
	        return copy;
	    }
	    
	    //按照arr对name进行排名（从高到低）
	    public static <T> T[] rank(T[] name ,int[] arr) {
	    	int j=arr.length;
	    	//冒泡排序，从大到小
	    	for(int k=arr.length-1;k>0;k--) {
	    		for(int i=0;i<j-1;i++) {
	    			if(arr[i]<arr[i+1]) {
	    				int tmp1=arr[i+1];
	    				arr[i+1]=arr[i];
	    				arr[i]=tmp1;
	    				T tmp2=name[i+1];
	    				name[i+1]=name[i];
	    				name[i]=tmp2;
	    			}
	    		}
	    		j--;
	    	}
	    	return name;
	    }
	    
	    public static int[] rank(int[] name ,int[] arr) {
	    	int j=arr.length;
	    	//冒泡排序，从大到小
	    	for(int k=arr.length-1;k>0;k--) {
	    		for(int i=0;i<j-1;i++) {
	    			if(arr[i]<arr[i+1]) {
	    				int tmp1=arr[i+1];
	    				arr[i+1]=arr[i];
	    				arr[i]=tmp1;
	    				int tmp2=name[i+1];
	    				name[i+1]=name[i];
	    				name[i]=tmp2;
	    			}
	    		}
	    		j--;
	    	}
	    	return name;
	    }
	    
	    public static int[] rank(int[] name ,float[] arr) {
	    	int j=arr.length;
	    	//冒泡排序，从大到小
	    	for(int k=arr.length-1;k>0;k--) {
	    		for(int i=0;i<j-1;i++) {
	    			if(arr[i]<arr[i+1]) {
	    				float tmp1=arr[i+1];
	    				arr[i+1]=arr[i];
	    				arr[i]=tmp1;
	    				int tmp2=name[i+1];
	    				name[i+1]=name[i];
	    				name[i]=tmp2;
	    			}
	    		}
	    		j--;
	    	}
	    	return name;
	    }
}
