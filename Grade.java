package studentgradetracker;
import java.util.ArrayList;
import java.util.List;

// Class representing a grade for a subject or assignment
class Grade {
    private String subject;  // Subject or assignment name
    private double score;    // Score received

    // Constructor to initialize subject and score
    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    // Getter method for subject
    public String getSubject() {
        return subject;
    }

    // Getter method for score
    public double getScore() {
        return score;
    }

    // Override toString method to display grade information
    @Override
    public String toString() {
        return "Subject: " + subject + ", Score: " + score;
    }
}


