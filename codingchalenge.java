public class Code {

	public static void main (String arr[])
	{
	 String str = "A major sentence is a regular sentence; it has a subject and a predicate,e.g. \"I have a ball.\" In this sentence, one can change the persons.";

   
    String new_str = str.replaceAll("sentence", "########");
   
    
    System.out.println("Original string: " + str);
    System.out.println("New String: " + new_str);
	}
}
