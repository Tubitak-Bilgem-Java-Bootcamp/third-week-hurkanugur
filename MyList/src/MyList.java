import java.util.Arrays;


public class MyList<T> 
{
    T[] hukoArray;

    @SuppressWarnings("unchecked")
    public MyList() 
    {
        this.hukoArray = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
     public MyList(int newSize) 
    {
        this.hukoArray = (T[]) new Object[newSize];
    }

    public int size() 
    {
        int sizeCounter = 0;
        
        for (T elementAtIndex : hukoArray) 
        {
            if (elementAtIndex != null) 
            {
            	sizeCounter++;
            }
        }
        return sizeCounter;
    }

    public int getCapacity() 
    {
        return hukoArray.length;
    }

    public void add(T dataToBeAppended) 
    {
        for (int i = 0; i < hukoArray.length; i++) 
        {
            if (hukoArray[i] == null) 
            {
                hukoArray[i] = dataToBeAppended;
                break;
            } 
            else if ((hukoArray[i] != null) && (i == hukoArray.length - 1)) 
            {
                hukoArray = Arrays.copyOf(hukoArray, hukoArray.length * 2);
                hukoArray[hukoArray.length / 2] = dataToBeAppended;
                break;
            }
        }
    }

    public T get(int indexToBeReceived) 
    {
        try 
        {
            if (hukoArray[indexToBeReceived] != null) 
            {
                return hukoArray[indexToBeReceived];
            } 
            else 
            {
            	return null;
            }
        } 
        catch (Exception exception) 
        {
            return null;
        }
    }

    public T remove(int indexToBeRemoved) 
    {
        T element;
        
        try 
        {
        	element = get(indexToBeRemoved);
        	
            if (hukoArray[indexToBeRemoved] != null) 
            {
                if ((size() - indexToBeRemoved) >= 0) System.arraycopy(hukoArray, (indexToBeRemoved + 1), hukoArray, indexToBeRemoved, (size() - indexToBeRemoved));
            }
            
        } 
        catch (Exception exception) 
        {
            return null;
        }
        
        return element;
    }

    public void set(int index, T data) {
        try 
        {
            if (hukoArray[index] != null) 
            {
                hukoArray[index] = data;
            }
        } 
        catch (Exception exception) 
        {
            System.out.println("Something went wrong");
        }
    }

    public String toString() 
    {
        if (size() > 0) 
        {
            StringBuilder str = new StringBuilder("[");
            
            for (int i = 0; i < size(); i++) 
            {
            	
                if (i == (size() - 1)) 
                {
                    str.append(hukoArray[i]).append("]");
                } 
                else 
                {
                	str.append(hukoArray[i]).append(",");
                }

            }
            return str.toString();
        }
        return "[]";
    }

    public int indexOf(T data) 
    {
        int index = -1;
        
        for (int i = 0; i < size(); i++) 
        {
            if (hukoArray[i] == data) 
            {
                index = i;
                break;
            }
        }
        
        return index;
    }

    public int lastIndexOf(T data) 
    {
        int occuredIndex = -1;
        
        for (int i = size() - 1; i >= 0; i--) 
        {
            if (hukoArray[i] == data) 
            {
            	occuredIndex = i;
                break;
            }
        }
        return occuredIndex;
    }

    public boolean isEmpty() 
    {
        return size() == 0;
    }

    public T[] toArray() 
    {
        return Arrays.copyOfRange(hukoArray, 0, size());
    }

    @SuppressWarnings("unchecked")
	public void clear() 
    {
        this.hukoArray = (T[]) new Object[10];
    }

    public MyList<T> subList(int start, int finish) 
    {
        MyList<T> newHukoList = new MyList<>((finish - start + 1));
        
        for (int i = start; i <= finish; i++) 
        {
        	newHukoList.add(hukoArray[i]);
        }
        
        return newHukoList;
    }

    public boolean contains(T valueToLookFor) 
    {
        boolean isIterable = false;
        
        for (int i = 0; i < size(); i++) 
        {
            if (hukoArray[i] == valueToLookFor) 
            {
            	isIterable = true;
                break;
            }
        }
        
        return isIterable;
    }
}