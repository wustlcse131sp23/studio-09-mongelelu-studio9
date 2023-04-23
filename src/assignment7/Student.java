package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	
	private String firstName;
	private String lastName;
	private static int studentId;
	private int attemptedCredits;
	private int passedCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	
	/**
	 * 
	 * @param first - the first name of the student
	 * @param last - the last name of the student
	 * @param id - the student's id
	 */
	public Student(String first, String last, int id) {
		firstName = first;
		lastName = last;
		studentId = id;
	}
	
	/**
	 * @return - returns the first and last name of the student with a space
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * 
	 * @return - returns the student Id
	 */
	public int getId() {
		return studentId;
	}
	
	/**
	 * 
	 * @return - returns the student's attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}
	
	/**
	 * 
	 * @return - returns the number of passing credits
	 */
	public int getTotalPassingCredits() {
		return this.passedCredits;
	}
	
	/**
	 * 
	 * @return - the GPA w quality  points
	 */
	public double calculateGradePointAverage() {
		 return totalGradeQualityPoints / attemptedCredits;
	}
	
	/**
	 * 
	 * @param grade - the grade the student gets in the course
	 * @param credits - the amount of credits the class is

	 */
	public void submitGrade(double grade, int credits) {
		if(grade > 1.7) {
			passedCredits += credits;
			totalGradeQualityPoints += (credits * grade);
		}
		else {
			passedCredits += 0;
			totalGradeQualityPoints += (credits * grade);
		}
		attemptedCredits += credits;
	}
	
	/**
	 * 
	 * @return - returns the year of the student based on how many credits they have passed
	 */
	public String getClassStanding() {
		if(passedCredits < 30) {
			return "First Year";
		}
		else if(passedCredits >= 30 && passedCredits < 60) {
			return "Sophomore";
		}
		else if(passedCredits >= 60 && passedCredits < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	
	/**
	 * 
	 * @return - true if student is eligible to join PBK
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if(passedCredits >= 98 && calculateGradePointAverage() >= 3.6) {
			return true;
		}
		else if(passedCredits >= 75 && calculateGradePointAverage() >= 3.8) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return - returns the amount the student has of bear bucks
	 */
	public double getBearBucksBalance() {
		return this.bearBucksBalance;
	}
	
	/**
	 * 
	 * @param amount - amount of bear bucks student has
	 */
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}
	
	/**
	 * 
	 * @param amount - amount of bear bucks student has
	 */
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}
	
	/**
	 * 
	 * @return takes the balance and subtracts $10 fee
	 */
	public double cashOutBearBucks() {
		double balance = this.bearBucksBalance;
		this.bearBucksBalance = 0.0;
		if(balance <= 10) {
			return 0;
		}
		else {
			return balance - 10.0;
		}
	}
	
	/**
	 * 
	 * @param firstName - name of the parent
	 * @param otherParent - name of the other parent
	 * @param isHyphenated - if the name is hyphenated
	 * @param id - student id
	 * @return - the child's name with the bear bucks from the parent
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		if(isHyphenated) {
			this.studentId = id;
			String name = this.lastName + "-" + otherParent.lastName;
			Student legacy = new Student(firstName, name, id);
			double cashout = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
			legacy.depositBearBucks(cashout);
			return legacy;
		}
		else {
			this.studentId = id;
			String name = this.lastName;
			Student legacy = new Student(firstName, name, id);
			double cashout = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
			legacy.depositBearBucks(cashout);
			return legacy;
		}
	}
	
	/**
	 * @return - student's first and last name and their id
	 */
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.studentId;
	}
}
