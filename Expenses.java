import java.util.Scanner;

public class Expenses{
    static String[][] expenses = new String[20][4]; //Multidimensional array to store up to 20 expenses with 4 attributes
    static int expenseCount = 0; //Keep track of what is the index of the expense added/being added
       
                  
             
              
           static void addExpense(Scanner sc) { //Method to addExpense
           
            if (expenseCount >= 20) { //Check if the list is full (Up to 20 expenses)
                System.out.println("Expense list is full");
                return;
            }
                //If its not full, ask for the expense information and store it as a variable
            System.out.print("Enter the name of the expense: ");
            String name = sc.nextLine();
            System.out.print("Enter Date (dd/mm/yy): ");
            String date = sc.nextLine();
            System.out.print("Enter Category (food, transportation, utilities): ");
            String category = sc.nextLine();
            System.out.print("Enter Amount: ");
            String amount = sc.nextLine();

            //Store each variable entered into the array
            expenses[expenseCount][0] = name;
            expenses[expenseCount][1] = date;
            expenses[expenseCount][2] = category;
            expenses[expenseCount][3] = amount;
            expenseCount++; //Once added, increase the expenseCount by 1, so that the next 
            //expense is stored in the next row of the array
    
            System.out.println("Expense added to the list"); //To confirm it was stored
           }
        



static void viewExpenses() { //Method to viewExpenses

    System.out.println("Name\t\t\tDate (dd/mm/yy)\t\tCategory\tAmount");
    System.out.println("---------------------------------------------------------------");
    
    //Use for loop to go through every expense in the expenseCount array
    for (int i = 0; i < expenseCount; i++) {
        //Format the output so that it aligns as an organized table 
        System.out.printf("%-20s %-20s %-15s %-10s\n", expenses[i][0], expenses[i][1], expenses[i][2], expenses[i][3]);
    }
}
      
      

static void calculateTotal(){ //Method to calculateTotal

    double totalExpenses = 0; //Variable to store total amount starting at 0
    for (int i = 0; i < expenseCount; i++) {  //Loop through all expenses and sum up the amounts
        totalExpenses += Double.parseDouble(expenses[i][3]); //Convert amount from String to double and add to 0
     }
        System.out.println("Total Expenses: " + totalExpenses); //Print the toal amount
    }



    static void filterByCategory(String category){ //Method to filterByCategory 
        boolean found = false; //to check if any expense matches the category that the user will have already input
        System.out.println("Category\t\tName\t\t\tDate (dd/mm/yy)\t\tAmount"); //Table structure with "Category" in first place
        System.out.println("---------------------------------------------------------------");
        
        //Loop through all expenses and check if category matches the one that was input
        for (int i = 0; i < expenseCount; i++) {
            if (expenses[i][2].equalsIgnoreCase(category)) {
                //Print the filtered expenses in a formatted way with the "Category"  attribute first
                System.out.printf("%-15s %-20s %-20s %-10s\n", expenses[i][2], expenses[i][0], expenses[i][1], expenses[i][3]);
                found = true; //Set  to true if a match is found
            }
        }
        if (!found) { //If no matching expenses were found, print it
            System.out.println("No expenses found for category: " + category);
        }
    }

}

    class Main { //Main class to run the program
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in); //Create a scanner for user input
    while (true){ //Infinite loop to keep the program running until the user exits
        //Print all the options of the menu
            System.out.println("Welcome to the Expense Tacker!");
            System.out.println("Select an option");
            System.out.println("1. Add an Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Filter Expenses by Category" );
            System.out.println("5. Exit");
        
             String options = sc.nextLine(); //Read the input of the user
    
                switch (options) { //Switch call a fucntion depending on what the user selected
                    case "1":
                    Expenses.addExpense(sc); //Call addExpense method
                        break;
                    case "2":
                    Expenses.viewExpenses(); //Call viewExpenses method               
                      break;
                 case "3":
                   Expenses.calculateTotal(); //Call calculateTotal method
                     break;
                 case "4":
                 System.out.print("Enter the category to filter by (food, transportation, utilities): ");
                 String category = sc.nextLine(); //Store the category that the user chose as a variable to uae it in the function
                 Expenses.filterByCategory(category); //Call filterByCategory method
                     break;
                 case "5":
                 System.out.println("Exiting system...");
                 System.out.println(" SYSTEM EXITED");
                 System.exit(0); //Exit the program
                     break;
                 default: 
                 System.out.println("Invalid Number/ Empty String \tEnter any number 1--5"); //Handle invalid input to loop menu again
                 }
             }       
          }             
      }
  
