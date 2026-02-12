import java.util.*;

public class GradeCalculator {
    public static void main(String[] args){
        
        Scanner myScanner = new Scanner(System.in);

        int arraysize = 0;

        System.out.println("input the amount of grades you have");
        arraysize = myScanner.nextInt();
        myScanner.nextLine();

        // Create an array
        double[] grades = new double[arraysize];
        int i = 0;
        double grade = 0;

        while(i < arraysize){
            System.out.println("Input the grade");
            grade = myScanner.nextDouble();
            myScanner.nextLine();
            grades[i] = grade;
            i++;
        }

        System.out.print("Grades ");
        for(int k = 0; k < grades.length; k++){
            System.out.print(grades[k] + ", ");
        }

        System.out.println();

        System.out.print("Sorted Grades ");
        for(int j = 0; j < grades.length; j++){
            System.out.print(sortGrades(grades)[j] + ", ");
        }
        System.out.println();

        System.out.println("Average " +average(grades));
        System.out.println("Highest Grade: " + highestGrade(grades));
        System.out.println("Lowest Grade: " + lowestGrade(grades));

        System.out.print("Grades in letters: ");
        for(int l = 0; l < grades.length; l++){
            System.out.print(getLetterGrades(sortGrades(grades))[l] + ", ");
        }

        myScanner.close();;
    }

    public static double average(double[] grades){
        double total = 0;
        for(int i = 0; i < grades.length; i++){
            total += grades[i];
        }
        return total / grades.length;
    }

    public static double highestGrade(double[] grades){
        double highest = 0;
        for(int i = 0; i < grades.length; i++){
            if(grades[i] > highest){
                highest = grades[i];
            }
        }
        return highest;
    }

    public static double lowestGrade(double[] grades){
        double lowest = grades[0];
        for(int i = 0; i < grades.length; i++){
            if(grades[i] < lowest){
                lowest = grades[i];
            }
        }
        return lowest;
    }

    public static String getLetterGrade(double grade){
        int value = (int)Math.round(100  / 6 * grade);
        if(value >= 90){
            return "A";
        }else if(value >= 80){
            return "B";
        }else if(value >= 70){
            return "C";
        }else if(value >= 60){
            return "D";
        }else{
            return "F";
        }
    }

    public static String[] getLetterGrades(double[] grades){
        String[] letterGrades = new String[grades.length];
        for(int i = 0; i < grades.length; i++){
            letterGrades[i] = getLetterGrade(grades[i]);
        }
        return letterGrades;
    }

    public static double[] sortGrades(double[] grades){
        double storage = 0;
        for(int i = 0; i < grades.length; i++){
            for(int j = 0; j < grades.length - 1; j++){
                if(grades[j] > grades[j + 1]){
                    storage = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = storage;
                }
            }
        }
        return grades;
    }
}
