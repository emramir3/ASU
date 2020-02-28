/**
 * @author  Elizabeth Ramirez
 * Class ID: 146
 * Assignment #: 2
 * <p>
 * 
 * <h1>SimpleList</h1>
 * The SimpleList program implements nine different methods to give 
 * practice with using a version control system (github).
 *
 */

package cse360assign2;

/**
 * Represents a simple array list.
 * Parameters in the array list can be added, removed, searched, counted, 
 * and displayed as a string. It will also provide you the size of the array,
 * parameter at index 0, parameter at last index, and can append an element 
 * to the end of the list.
 */
public class SimpleList
{
	/**
	 * Declare Variables
	 *  Creates the array.
	 *  Creates the counter.
	 */
	private int[] list;
	private int count;

 
	/**
	* Class Constructor
	*  Creates an array list that holds 10 integers.
	*  The count is set to 0.
	*/
	public SimpleList()
	{
		list = new int [10];
		this.count = 0;
	}


	/**
	 * Adds a parameter to the beginning of the array list at index 0.
	 * <p>
	 * Also moves all the other integers in the list over so there is room.
	 * If the list is full, then the array size is increased by 50%.
	 *
	 * @param arrayNum  The parameter number that will be added at index 0
	 */
	public void add(int arrayNum)
	{
		//if array list is full, increase the size by 50%
		if (count == list.length)
		{
			//calculate array increase by 50%
			int arrayIncrease = count + (count/2); 
      
			//create a new array
			int resizedArray[] = new int[arrayIncrease];

			//copy list array elements into resized array
			for (int newArray = 0; newArray < arrayIncrease && newArray < count; newArray++) 
			{
				resizedArray[newArray] = list[newArray];
			}

			//replace original array with new resized array
			list = resizedArray;

			//adjust count
			if (arrayIncrease < count) 
			{
				count = arrayIncrease;
			}
		}
		
		//empty array
		if (count == 0)
		{
			//adds parameter at beginning of list (position 0)
			list[0] = arrayNum;
			count++;
		}
		
		//non-empty array with less than 10 elements
		else
		{
			for(int parameterNum = count; parameterNum >= 0; parameterNum--)
			{
			    if(list[parameterNum] != 0)
			    {
			        //shift array list right
			        list[parameterNum + 1] = list[parameterNum];
			    }
			}
			
		    list[0] = arrayNum;
		    count++;
		}
	}
 

	/**
	 * Searches for first instance of parameter array list and removes it.
	 * <p>
	 * Also, other values in the array list are moved down the list.
     * If list has more than 25% empty places, the array is decreased
     * to the size of amount of elements in the array.
	 *
	 * @param arrayNum  The parameter number to be removed.
	 */
	public void remove(int arrayNum)
	{
		//locate index location of first instance of parameter
		int index = search(arrayNum);
		
		if (index != -1)
		{
			//remove indexed parameter in the array
		    for (int parameterNum = index; parameterNum < list.length - 1; parameterNum++)
		    {
		    	//shift array left when parameter found
		    	list[parameterNum] = list[parameterNum + 1];
		    }
		    
		    //decrement count after removing first instance of parameter
		    count--;
		 }
		
		//calculate 75% of capacity
        int capacity = 3 * list.length / 4;

        //check if list has more than 25% empty places
        if (count < capacity)
        {
        	//create a new array
        	int downsizedArray[] = new int[count];

        	//copy list array elements into down sized array
        	for (int newArray = 0; newArray < count; newArray++) 
        	{
        		downsizedArray[newArray] = list[newArray];
        	}

        	//replace original array with new down sized array
        	list = downsizedArray;

        	//adjust the count
        	if (capacity < count) 
        	{
        		count = capacity;
        	}
        }
	}
	
 
	/**
	 * Returns the number of elements stored in the array list.
	 *
	 * @return count Number of elements in the array list.
	 */
	public int count()
	{
		return count;
	}


	/**
	 * Returns the array list as a String.
	 * <p>
	 * Elements must be separated by a space, with no space after last integer.
	 *
	 * @return arrayString  Returns the array list parameters as a string.
	 */
	public String toString()
	{
		//declare an empty string	
		String arrayString = "";
		
		//loop through all elements in the array that are filled
		for (int parameterNum = 0; parameterNum < count; parameterNum++)
		{
			//concatenate string and array list
			arrayString += list[parameterNum];
			
			//if not the last element of the array
			if (parameterNum != count - 1)
			{
				arrayString += " ";
			}
		}
	 
		//returns the string of elements in the array
		return arrayString;
	}
	

	/**
	 * Searches for the location of the parameter in the array list.
	 * <p>
	 * If the parameter is not in the list, return -1
	 *
	 * @param arrayNum     The parameter number to be searched.
	 * @return arrayIndex  Returns the index of the parameter searched for.
	 */
	public int search(int arrayNum)
	{
		//set arrayIndex to -1 as default
		int arrayIndex = -1;
		
		//loop through elements starting at the last element in the array
		for(int parameterNum = count; parameterNum >= 0; parameterNum--)
		{
			//if element is found in the array
			if (list[parameterNum] == arrayNum)
			{
				//provide location of parameter in arrayIndex
				arrayIndex = parameterNum;
			}
		}
	
		//return the parameter if found	
		return arrayIndex;
	}


	/**
	 * Appends the parameter to the end of the list.
	 *
	 * @param appendElement     The parameter to be appended to end of list
	 */
	public void append(int appendElement)
	{
		//if array list is full, increase the size by 50%
		if (count == list.length)
		{
			//calculate array increase by 50%
			int arrayIncrease = count + (count/2); 
      
			//create a new array
			int appendedArray[] = new int[arrayIncrease];

			//copy list array elements into appended array
			for (int i = 0; i < arrayIncrease && i < count; i++) 
			{
				appendedArray[i] = list[i];
			}

			//replace original array with new appended array
			list = appendedArray;

			//adjust count
			if (arrayIncrease < count) 
			{
				count = arrayIncrease;
			}
		}

		//add at count index
		list[count] = appendElement;
		count++;
	}

	
	/**
	 * Returns the first element in the list.
	 * <p>
	 * If the parameter is not in the list, return -1
	 *
	 * @return  Returns the parameter at index 0.
	 */
	public int first()
	{
		if (count == 0)
		{
			//empty array
			return -1;
		}
		else
		{
			//return first element
			return list[0];
		}
	}
	
	
	/**
	 * Returns the last element in the list.
	 * <p>
	 * If the parameter is not in the list, return -1
	 *
	 * @return  Returns the last element in the list.
	 */
	public int last()
	{
		if (count == 0)
		{
			//empty array
			return -1;
		}
		else
		{
			//return last element
			return list[count - 1];
		}
	}


	/**
	 * Returns the current number of possible locations in the list.
	 *
	 * @return  Returns the length of the array list.
	 */
	public int size()
	{
		//return capacity of array
		return list.length;
	}
}