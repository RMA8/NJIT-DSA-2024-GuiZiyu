package oy.tol.tra;

public class Grades {
   
   private Integer [] grades = null;

   public Grades(Integer [] grades) {
      this.grades = new Integer [grades.length];
      for (int counter = 0; counter < grades.length; counter++) {
         this.grades[counter] = grades[counter];
      }
   }

   public void reverse() {
      int i = 1;
      while (i <= grades.length/2) {
         int temp = grades[i-1];
         grades[i-1] = grades[grades.length-i];
         grades[grades.length-i] = temp;
         i++;
     }
   }

   public void sort() {
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
