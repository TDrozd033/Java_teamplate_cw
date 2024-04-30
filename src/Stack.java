enum ErrCode {
    STACK_ALLOCATION(2), STACK_IS_EMPTY(1), OTHER_ERROR(0);
int mCode;
ErrCode( int code)
{ mCode = code; }
}
// obiekty wewnatrz klasy

// zamiast wskaznikow uzywamy referencji
class StackException extends RuntimeException
{
    private ErrCode  mErrCode = ErrCode.OTHER_ERROR;

    public StackException( ErrCode errCode)
    {
        mErrCode = errCode;
    }
    public String getReason()
    {
        switch(mErrCode)
        {
            case STACK_ALLOCATION: return " Memory Allocation error \n";
            case STACK_IS_EMPTY: return " Stack is Empty \n";
            default: return "Other error\n";
        }
    }
}
public class Stack<T>
{
    private class StackItem<T>
    {
        private T mKey;
        private StackItem mNext;

        public StackItem( T obj, StackItem next)
        {
            mKey = obj;
            mNext = next;
        }

        public T getKey() {
            return mKey;
        }

        public StackItem getNext() {
            return mNext;
        }
    }

    private StackItem mHead = null;

    public void push( T obj ) throws StackException
    {
        try{
            mHead = new StackItem<T>( obj, mHead);
        }
        catch(OutOfMemoryError e)
        {
            throw new StackException(ErrCode.STACK_ALLOCATION);
        }

    }


    public T  pop() throws StackException
    {
        if( isEmpty())
        {
            throw new StackException( ErrCode.STACK_IS_EMPTY);
        }
        T obj = top();
        del();
        return obj;
    }
    public T top() throws StackException
    {
        if( !isEmpty())
        {
            return (T)mHead.getKey();
        }
        throw new StackException(ErrCode.STACK_IS_EMPTY);
    }
    public void del() throws StackException
    {
        if( isEmpty())
        {
            throw new StackException(ErrCode.STACK_IS_EMPTY);
        }
        mHead = mHead.getNext();
    }

    public boolean isEmpty()
    {
        return mHead == null;
    }
}

// nastepnym razem klasy abstrakcyjne i synchronizowanie wątków

