package easycalcgame;

public class Participations {

    boolean correct;
    long timeA;
    long timeB;

    Participations() {                                       //time a is set, time b is set after the user puts in the right datatype in application
        this.timeA = System.currentTimeMillis();
    }

    void setTimeB() {
        this.timeB = System.currentTimeMillis();
    }

    public double getTimeNeeded() {                         //time needed per calc
        return (double) (timeB - timeA) / 1000.0;
    }

    public Boolean isCorrect(double coorectResult, double userResult) {             //checks if userresult is the same as the correct "computer" result
        this.correct = false;

        if (coorectResult == userResult)
            correct = true;

        return correct;
    }
}

