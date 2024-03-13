package oy.tol.tra;

public class Grades {
   
   private Integer [] grades = null;

   /**
    * A constructor for building IntArrays.
    * @param grades the plain Java integer array with numbers to add.
    */
   public Grades(Integer [] grades) {
      this.grades = new Integer [grades.length];
      for (int counter = 0; counter < grades.length; counter++) {
         this.grades[counter] = grades[counter];
      }
   }

   public void reverse() {
      /* TODO:
       1. Edit the test data files to see if the reverse() really works or not.
       2. Execute the IntArrayTests to see that some of them fail.
       3. Study the code below and try to find what is the issue.
       4. Use the debugger to see the execution and variable values if necessary.
       5. Fix the issue.
       6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java, as instructed in the readme file.
      */
      int i = 1;
      while (i <= grades.length/2) {
         int temp = grades[i-1];
         grades[i-1] = grades[grades.length-i];
         grades[grades.length-i] = temp;
         i++;
     }
   }

   public void sort() {
      /* TODO:
       1. Edit the test data files to see if the sort() really works or not.
       2. Execute the IntArrayTests to see that some of them fail.
       3. Study the code below and try to find what is the issue.
       4. Use the debugger to see the execution and variable values if necessary.
       5. Fix the issue.
       6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java as instructed in the readme file.
      */
      for (int i=0; i < grades.length-1; i++) {
         for (int j=0; j < grades.length-1; j++) {
            if(grades[j]>grades[j+1]){
            int tmp = grades[j];
            grades[j] = grades[j+1];
            grades[j+1] = tmp;
            }
         }
      }
   }

   public Integer [] getArray() {
      return grades;
   }
}
