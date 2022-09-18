package com.csc600.array;



import java.util.Arrays;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class ArrayController {

    int[] array = new int [20]; //create array
    
    @FXML
    private StackPane StackPaneT;
    
    @FXML
    private TextField mainArrayText;

    @FXML
    private Button displayContentsButton;

    @FXML
    private Button addNummberButton;

    @FXML
    private Button deleteNumberButton;

    @FXML
    private Button sortArrayButton;

    @FXML
    private Button searchArrayButton;

    @FXML
    private TextField numbersToAddText;

    @FXML
    private TextField addSpecifyText;

    @FXML
    private TextField deleteNumberText;

    @FXML
    private TextField originalDisplayText;

    @FXML
    private TextField sortedDisplayText;

    @FXML
    private Button arraySizeButton;

    @FXML
    private TextField arraySizeText;

    @FXML
    private TextField searchText;
    
     @FXML
    private Button ClearButton;

    @FXML
    private Button ExitButton;

    @FXML
    void AddNumberButtonPressed(ActionEvent event) {
        if (mainArrayText.getText().equals("")) 
        {//if text is blank then tell user to generate text
        mainArrayText.setText("Please Generate Array Using Display Contents Button!");
        }//if text is blank then tell user to generate text
        if (numbersToAddText.getText().equals("") )
        {//if text is blank then tell user to generate text
        numbersToAddText.setText("Enter Value");
        }//if text is blank then tell user to generate text
        if (addSpecifyText.getText().equals(""))
        {//if text is blank then tell user to generate text
        addSpecifyText.setText("Enter Value");
        }
        else
        { //Get user values and assign them to variables
          int addIndex = Integer.parseInt(addSpecifyText.getText());
          int addValue = Integer.parseInt(numbersToAddText.getText());
          //create new array with 1 longer index
          int[] array1 = new int [array.length + 1 ];
          //This code will copy the array contents onto the new array plus the value
          //specified by the user
          for(int i = 0; i < array.length + 1; i++)
          {
              if (i < addIndex - 1)
              {
                  array1[i] = array[i];
              }
              else if (i == addIndex - 1 )
              {
               array1[i] = addValue;               
              }
              else 
              {
               array1[i] = array[i-1];               
              }
              
          }
          
          //display the new array created
          mainArrayText.setText(Arrays.toString(array1));
        }   
    }

    @FXML
    void ArraySizeButtonPressed(ActionEvent event) {
        if (mainArrayText.getText().equals("")|| (mainArrayText.getText().equals("Please Generate Array Using Display Contents Button!"))) 
        {//if text is blank then tell user to generate text
        mainArrayText.setText("Please Generate Array Using Display Contents Button!");
        
        }
        else{
        int size = array.length;
        //display size of the array using array.length
        arraySizeText.setText(String.valueOf(size));
        }
    }

    @FXML
    void DeleteNumberButtonPressed(ActionEvent event)
    {
        if (mainArrayText.getText().equals("")) 
        {//if text is blank then tell user to generate text
        mainArrayText.setText("Please Generate Array Using Display Contents Button!");
        }//if text is blank then tell user to generate text
        if (deleteNumberText.getText().equals("") )
        {//if text is blank then tell user to generate text
        deleteNumberText.setText("Enter Value");
        }
        else
        {
            
         //assign the user input value to deleteindex  
          int deleteIndex = Integer.parseInt(deleteNumberText.getText());
          //create new array with 1 less element
          int[] array1 = new int [array.length - 1 ];
          
            for (int i = 0, j = 0; i < array.length; i++) 
            {//copy array to new array except for deleteindex value
                if (i != deleteIndex) 
                {
                    array1[j++] = array[i];
                    
                }
            }//set text to new array created
          mainArrayText.setText(Arrays.toString(array1));

        }
    }

    @FXML
    void DisplayContentsButtonPressed(ActionEvent event) {
    for ( int i = 0; i < 20; i++)
    {//this will generate an array of 20 random integers between 1 and 100.
        array[i] = (int)(Math.random()*101);
    }//set text to array created
    mainArrayText.setText(Arrays.toString(array));
    
    
    
    }

    @FXML
    void SearchArrayButtonPressed(ActionEvent event) 
    {
        if (mainArrayText.getText().equals("")) 
        {//if text is blank then tell user to generate text
        mainArrayText.setText("Please Generate Array Using Display Contents Button!");
        }//if text is blank then tell user to generate text
        if (searchText.getText().equals("")) 
        {//if text is blank then tell user to generate text
        searchText.setText("Enter Value");
        }
        else{
        //get user value and assign it to search int   
       int search = Integer.parseInt(searchText.getText());
       
      
       for(int i = 0; i < array.length;i++)
       { //Search through earch element of the array and find the user input
          
           if(array[i]==search)
           {//once found delete text box and create a label with that number and highlight it.
            StackPaneT.getChildren().clear();
            Label label = new Label( Integer.toString(array[i]));
            label.setStyle("-fx-text-fill:GREEN; -fx-font-size: 25; -fx-font-weight: bold");
            StackPaneT.getChildren().add(label);
            //to continue to use program- you will need to use clear button to generate text box again
            
           }
            
        }
             
           }
        
    }
 
    

    @FXML
    void SortArrayButtonPressed(ActionEvent event) {
    if (mainArrayText.getText().equals("")|| (mainArrayText.getText().equals("Please Generate Array Using Display Contents Button!"))) 
    {//if text is blank then tell user to generate text
        
        
    mainArrayText.setText("Please Generate Array Using Display Contents Button!");
    }//if text is blank then tell user to generate text
    else{
    //create new array
     int[] array1 = new int [array.length];
     //copy contents onto new array
     for (int i = 0, j = 0; i < array.length; i++) 
            {
               array1[j++] = array[i];
            }
    //sort array1 
     Arrays.sort(array1);
    originalDisplayText.setText(Arrays.toString(array));//display original array
    sortedDisplayText.setText(Arrays.toString(array1));//display sorted array
    }  
    }
    
    @FXML//clear everything and generate new textbox
    void ClearButtonPressed(ActionEvent event) {
    mainArrayText.clear();
    numbersToAddText.clear();
    addSpecifyText.clear();
    deleteNumberText.clear();
    originalDisplayText.clear();
    sortedDisplayText.clear();
    arraySizeText.clear();
    searchText.clear();
    StackPaneT.getChildren().add(mainArrayText);
    mainArrayText.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");
    
    }
    
    @FXML//exit the program
    void ExitButtonPressed(ActionEvent event) {
        Platform.exit();
    }
    

}