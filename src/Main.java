public class Main {
    public static void main(String[] args)
    {

        Stack<Character> s = new Stack(); // nie mozna konkretyzowac szablonu typem podstawowym
        Stack<Integer> s1 = new Stack<>(); // moze byc bez <>

        try{
            s.push( 'A');
            s.push('B');
            s.push('C');

            s1.push( 1 );
            s1.push(2 );
            s1.push(3 );


            System.out.println( s.pop() + " " + s.pop() );
            System.out.println( s.pop());
            //System.out.println( s.pop()); // wygenreuje wyjątek

            System.out.println( s1.pop() + " " + s1.pop() );
            System.out.println( s1.pop());
            System.out.println( s1.pop()); // wygenreuje wyjątek
        }
        catch(StackException e)
        {
            System.out.println("Exception: " + e.getReason());

        }


    }
}