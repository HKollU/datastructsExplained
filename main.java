import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class main 
{
	public static int shellsort(int arr[]) 
	{ 
		int n = arr.length; 

	  
		// Start with a big gap, then reduce the gap 
		for (int gap = n/2; gap > 0; gap /= 2) 
		{ 
			int numswap=0;
			if(gap==6)
				gap=7;
			if(gap==2)
				gap=3;
				// Do a gapped insertion sort for this gap size. 
				// The first gap elements a[0..gap-1] are already 
				// in gapped order keep adding one more element 
				// until the entire array is gap sorted 
				for (int i = gap; i < n; i += 1) 
				{
					// add a[i] to the elements that have been gap 
					// sorted save a[i] in temp and make a hole at 
					// position i 
					int temp = arr[i]; 
					// shift earlier gap-sorted elements up until 
					// the correct location for a[i] is found 
					int j; 
					for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
						{arr[j] = arr[j - gap]; 
						numswap++;
						}
	  
					// put temp (the original a[i]) in its correct 
					// location 
					arr[j] = temp; 
				}
				System.out.printf("After %d sort:  ",gap);
				for(int i = 0; i < arr.length;i++)
					System.out.printf("%d, ",arr[i]);
					System.out.printf("    with %d swaps\n", numswap);
				
		} 
		return 0; 
	}
	public static void insertionSort(int arr[], int n) 
	{ 
	
		   int i, key, j; 
		   for (i = 1; i < n; i++) 
		   { System.out.printf("Pass %d : ",i);
			   int swaps = 0;
		       key = arr[i]; 
		       j = i-1; 
		   
		       /* Move elements of arr[0..i-1], that are 
		          greater than key, to one position ahead 
		          of their current position */
		       while (j >= 0 && arr[j] > key) 
		       { 
		           arr[j+1] = arr[j]; 
		           j = j-1; 
		           swaps++;
		       } 
		      
		       arr[j+1] = key; 
		       for(int x = 0; x < arr.length; x++)
		    	   System.out.printf("%d, ", arr[x]);
		       System.out.printf("  With %d swaps\n", swaps);
		   } 
	}
	
	public static void mergeSort(int [] a)
	{
		int [] tmpArray = new int[a.length];
		
		mergeSort(a,tmpArray,0,a.length - 1);
		
		
	}
	private static void mergeSort(int[] a, int[] tmpArray, int left, int right) 
	{
		// TODO Auto-generated method stub
		if(left < right)
		{
			int center = (left + right) / 2;
			for(int i = left; i <= center;i++ )
			System.out.printf("%d, ", a[i]);
			System.out.print("          " );
			for(int i = center+1; i <= right; i++)
				System.out.printf("%d,", a[i]);
			System.out.println();
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center+ 1, right);
			merge(a, tmpArray, left, center+1, right);
		}
		
	}

	private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) 
	{
		int leftEnd = rightPos -1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		while(leftPos <= leftEnd && rightPos <= rightEnd)
			if(a[leftPos] <= a[rightPos])
				tmpArray[tmpPos++] = a[leftPos++];
			else
				tmpArray[tmpPos++] = a[rightPos++];
		while (leftPos <=leftEnd)
			tmpArray[tmpPos++] = a[leftPos++];
		while(rightPos <= rightEnd)
			tmpArray[tmpPos++] = a[rightPos++];
		for(int i = 0; i < numElements; i++, rightEnd --)
			a[rightEnd] = tmpArray[rightEnd];
		for(int i = 0; i < a.length;i++)
			System.out.printf("%d, ", a[i]);
		System.out.println();
				
	}

	public static void quicksort( Comparable [ ] a ) {
		quicksort( a, 0, a.length - 1 );
	}
	
	
	private static final int CUTOFF = 4;
	
	private static void quicksort( Comparable [ ] a, int low, int high ) {
		if( low + CUTOFF > high )
		{
			System.out.printf("%d is low pos, and %d is high pos in range:\n", low,high);
			for(int i = 0; i < a.length;i++)
			{
				if(i>=low && i<=high)
					System.out.printf("%d*\t",a[i]);
				else
				System.out.printf("\t");
			}
			System.out.println("\nPost Insertion sorting:");
			insertionSort( a, low, high );
		for(int i = 0; i < a.length;i++)
			System.out.printf("%d\t ", a[i]);
		System.out.println();
		}
		else {
			// Sort low, middle, high
			int middle = ( low + high ) / 2;
			System.out.println("\nMEDIAN 3");
			for(int i = 0; i < a.length;i++)
				System.out.printf("%d\t", a[i]);
				System.out.println();
				for(int i = 0; i < a.length; i++)
				{
					if(i==low || i==high || i==middle)
						System.out.printf("%d*\t", a[i]);
					else System.out.printf("\t");
				}
				System.out.println();
				if( a[ middle ].compareTo( a[ low ] ) < 0 )
					
					swapReferences( a, low, middle );
				if( a[ high ].compareTo( a[ low ] ) < 0 )
					swapReferences( a, low, high );
				if( a[ high ].compareTo( a[ middle ] ) < 0 )
					swapReferences( a, middle, high );

				// Place pivot at position high - 1
				swapReferences( a, middle, high - 1 );
				Comparable pivot = a[ high - 1 ];
				System.out.println("PIVOT IS :" + pivot);
				for(int i = 0; i<a.length;i++)
				{
					if(i==high-1)
						System.out.printf("%d*\t", a[i]);
					else
						System.out.printf("%d\t",a[i]);
				}
				System.out.println();

				// Begin partitioning
				int i, j;
				for( i = low, j = high - 1; ; ) {
					while( a[ ++i ].compareTo( pivot ) < 0 );

					while( pivot.compareTo( a[ --j ] ) < 0 );
					if( i >= j )
						break;
					for(int x = 0; x < a.length;x++)
					{
						if(x==i )
							System.out.printf("%di\t", a[i]);
						else if(x==j)
							System.out.printf("%dj\t", a[j]);
						else System.out.printf("%d\t", a[x]);
					}
					System.out.println("\t BEING SWAPPED");
					swapReferences( a, i, j );
					System.out.println("Post Swapped");
					for(int q = 0; q < a.length;q++)
						System.out.printf("%d\t",a[q]);
					System.out.println();
				}

					// Restore pivot
				swapReferences( a, i, high - 1 );

				for(int z = 0; z < a.length; z++)
				{
					if(z>=low && z<=i-1)
						System.out.printf("%d\t",a[z]);
					else
						System.out.printf("\t");
				}
				System.out.println(" IS S1");
				for(int z = 0; z < a.length; z++)
				{
					if(z>=i+1 && z<=high)
						System.out.printf("%d\t",a[z]);
					else
						System.out.printf("\t");
				}
				System.out.println(" IS S2");

				quicksort( a, low, i - 1 );    // Sort small elements
				quicksort( a, i + 1, high );   // Sort large elements
		}
	}

	/**
	 * Method to swap to elements in an array.
	 * @param a an array of objects.
	 * @param index1 the index of the first object.
	 * @param index2 the index of the second object.
	 */
	public static final void swapReferences( Object [ ] a, int index1, int index2 ) {
		Object tmp = a[ index1 ];
		a[ index1 ] = a[ index2 ];
		a[ index2 ] = tmp;
	}


	/**
	 * Internal insertion sort routine for subarrays
	 * that is used by quicksort.
	 * @param a an array of Comparable items.
	 * @param low the left-most index of the subarray.
	 * @param n the number of items to sort.
	 */

	public static int getInvCount(int [] arr) 
	{ 
		int inv_count = 0; 
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = i + 1; j < arr.length; j++) 
				if (arr[i] > arr[j]) 
				{
					System.out.printf("(%d,%d)\t",arr[i],arr[j]);
					inv_count++; 
				}
			System.out.println();
		}

		return inv_count; 
	}
	private static void insertionSort( Comparable [ ] a, int low, int high ) {
		for( int p = low + 1; p <= high; p++ ) {
			Comparable tmp = a[ p ];
			int j;
             
			for( j = p; j > low && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
				a[ j ] = a[ j - 1 ];
			a[ j ] = tmp;
		}
		}
	static int Prec(char ch) 
	{ 
		switch (ch) 
		{ 
		case '+': 
		case '-': 
			return 1; 

		case '*': 
		case '/': 
			return 2; 

		case '^': 
			return 3; 
		} 
		return -1; 
	} 
		// The main method that converts given infix expression 
		// to postfix expression.  
	static String infixToPostfix(String exp) 
	{ 
	// initializing empty String for result 
		String result = new String(""); 
			          
		// initializing empty stack 
		Stack<Character> stack = new Stack<>(); 
			          
		for (int i = 0; i<exp.length(); ++i) 
		{ 
			char c = exp.charAt(i); 
			
			// If the scanned character is an operand, add it to output. 
			if (Character.isLetterOrDigit(c)) 
				result += c; 
			               
			// If the scanned character is an '(', push it to the stack. 
			else if (c == '(') 
				stack.push(c); 
			              
			//  If the scanned character is an ')', pop and output from the stack  
			// until an '(' is encountered. 
			else if (c == ')') 
			{ 
				while (!stack.isEmpty() && stack.peek() != '(') 
					result += stack.pop(); 
			                  
				if (!stack.isEmpty() && stack.peek() != '(') 
					return "Invalid Expression"; // invalid expression                 
				else
					stack.pop(); 
			} 
			else // an operator is encountered 
			{ 
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){ 
					if(stack.peek() == '(') 
						return "Invalid Expression"; 
					result += stack.pop(); 
				} 
				stack.push(c); 
			} 
			       
		} 
			       
		// pop all the operators from the stack 
		while (!stack.isEmpty()){ 
			if(stack.peek() == '(') 
				return "Invalid Expression"; 
			result += stack.pop(); 
		} 
		return result; 
		} 
	    
	public static String postfixToInfix(String expression)
	{
		Stack<String> stack = new Stack<>();
		for (int i = 0; i <expression.length() ; i++)
		{
			char c = expression.charAt(i);

			if(c=='*'||c=='/'||c=='^'||c=='+'||c=='-' ){
				String s1 = stack.pop();
				String s2 = stack.pop();
				String temp = "("+s2+c+s1+")";
				stack.push(temp);
			}
			else
				stack.push(c+"");
			
		}

		String result=stack.pop();
		return result;
	}
			    
	static int AVLtree(int H) 
	{ 
	       // Base Conditions 
			if (H == 0) 
			return 1; 
		if (H == 1) 
			return 2; 
        
       
		int r =  AVLtree(H-1) +AVLtree(H-2) + 1;
		System.out.print("N("+H+") = N("+(H-1)+") + N("+(H-2)+ ") + 1 =" );
		System.out.println(r);
		return r;
		     
	} 
	public static void heapify(int arr[], int n, int i) 
	{ 
		int largest = i; // Initialize largest as root 
		int l = 2*i + 1; // left = 2*i + 1 
		int r = 2*i + 2; // right = 2*i + 2 
	  
		// If left child is larger than root 
		if (l < n && arr[l] > arr[largest]) 
			largest = l; 
	  
		// If right child is larger than largest so far 
		if (r < n && arr[r] > arr[largest]) 
			largest = r; 
	  
	        // If largest is not root 
		
		if (largest != i) 
		{ 
			
			int swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 
			
			
			// Recursively heapify the affected sub-tree 
			heapify(arr, n, largest);
			
		}
    	
	} 
	public static void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
        	
        
            heapify(arr, n, i); 
        }
        int num1=0;
        printarr(arr);
        // One by one extract an element from heap 
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            
			
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
            num1++;
			System.out.print(num1 +".");
			printarr(arr);
        } 
    }
	
	public static void printarr(int arr[])
	{
		for(int i = 0; i < arr.length;i++)
		{
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}
	static void hsh(int arr[],int val)
{
	
	int i = 0;
	int res= ((val%11 + i*i) % 11);
	while(arr[res]!=0)
	{
		i++;
		res= ((val%11 + i*i) % 11);
		if(res>arr.length)
			res%=11;
		if(i==10)
			break;
	}
	if(arr[res] == 0)
	arr[res]=val;
	else
		System.out.println(val + " Not inserted");
}
	public static void main(String[] args) 
	{	
		
		int arr9[]= {5,8,15,3,9,10,12,1,7,4,11,13,2};
		heapify(arr9,arr9.length,arr9.length);

		sort(arr9);
		
		 int[] ar2 = {0,0,0,0,0,0,0,0,0,0,0};
			hsh(ar2,43);
			hsh(ar2,13);
			hsh(ar2,61);
			hsh(ar2,41);
			hsh(ar2,44);
			hsh(ar2,96);
			hsh(ar2,30);

			for(int i = 0; i<ar2.length;i++)
				System.out.println(i+"| "+ ar2[i]);
		/*for(int i = 0; i < arr9.length;i++)
			System.out.print(arr9[i]+", ");
		int arr[]={7,12,1,2,17,3,4,18,13,9,5,6};
		System.out.println(getInvCount(arr));
		 int arr2[]={7,12,9,2,17,3,4,18,13,1,5,6};
		 
		 
		System.out.println(getInvCount(arr2));
		insertionSort(arr,arr.length);
		*/
		/*System.out.println("\nShell:");
		int z[]={2,17,13,1,12,4,3,9,18,7,5};
		shellsort(z);*/
		/*System.out.println("\nQuick:");
		Integer []x= {5,6,14,10,2,13,11,4,7,15,8};
		quicksort(x);
		for(int i = 0; i < x.length;i++)
			System.out.printf("%d, ", x[i]);*//*
		System.out.println();
		System.out.println(infixToPostfix("(a+b-c)*(d-e)/(f-g+h)"));
		System.out.println(postfixToInfix(infixToPostfix("(a+b-c)*(d-e)/(f-g+h)")));
int sum=0;
		for ( int i = 1; i < 2; i++)
			    for ( int j = i; j < 4; j ++)
			           for (int k = 0; k < 2; k++) 
			               sum++;
		System.out.println(sum);
		

		Queue<Integer> q = new LinkedList<Integer>();
		  Stack<Integer> s = new Stack<Integer>();
	  s.push(new Integer(5));
	 s.push(new Integer(6));
		  s.push(new Integer(7));
		 q.add((s.pop()));
		  q.add(new Integer(8));
	 q.add(new Integer(9));

		//(1)
		  System.out.println(q.remove());

		  s.push(q.remove());

		// (2)
		  System.out.println(s.pop());

		// (3)
		  System.out.println(s.pop()+"\n\n\n\n");
		  
		 // System.out.println(AVLtree(8));
		  
		  int[] ar2 = {0,0,0,0,0,0,0,0,0,0};
		hsh(ar2,33);
		hsh(ar2,23);
		hsh(ar2,51);
		hsh(ar2,21);
		hsh(ar2,24);
		hsh(ar2,45);

		for(int i = 0; i<ar2.length;i++)
			System.out.println(i+"| "+ ar2[i]);*/
	}
	
}
