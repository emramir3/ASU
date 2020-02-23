/**
* @author  Elizabeth Ramirez
* Class ID: 146
* Assignment #: 1
* <p>
* 
* <h1>SimpleList</h1>
* The SimpleList program implements six different methods to give 
* practice with Javadoc, creating Junit tests, and using Junit.
*
*/

package cse360assign2;

/**
* Represents a simple array list.
* Parameters in the array list can be added, removed, searched, counted
* and displayed as a string.
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
	* If the list is full, the last element "falls off" the array list.
	*
	* @param arrayNum  The parameter number that will be added at index 0
	*/
	public void add(int arrayNum)
	{
		//empty array
		if (count == 0)
		{
			//adds parameter at beginning of list (position 0)
			list[0] = arrayNum;
			count++;
		}
		
		//non-empty array with less than 10 elements
		else if (count < 10)
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
		
		//full array (10 elements)
		else
		{
			//loops through array to push elements 1-9 to the right
			for (int parameterNum = count - 2; parameterNum >= 0; parameterNum--)
			{
				//shifts array list right
			    list[parameterNum + 1] = list[parameterNum];
			}
		
			list[0] = arrayNum;
		}
	}
 

	/**
	* Searches for first instance of parameter array list and removes it.
	* <p>
	* Also, other values in the array list are moved down the list.
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
}