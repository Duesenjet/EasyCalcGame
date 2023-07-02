package easycalcgame;

import java.util.Random;

public class Calc {

    final Random rand = new Random();
    private int a;
    private int b;
    private char operator;

    public Calc(int difficulty) {

        this.operator = createOperator();


        switch (difficulty) {
            case 1:                     //easy
                if (operator == '+' || operator == '-') {
                    if (operator == '+') {
                        this.a = rand.nextInt(10);
                        this.b = rand.nextInt(10);
                        break;
                    } else {
                        do {
                            this.a = rand.nextInt(10);
                            this.b = rand.nextInt(10);
                        } while (a < b);
                    }
                    break;
                } else {
                    if (operator == '*') {
                        this.a = rand.nextInt(10);
                        this.b = rand.nextInt(3);
                        break;
                    } else {
                        do {
                            this.a = rand.nextInt(11);
                            this.b = rand.nextInt(1, 4);
                        } while (a % b != 0);
                        break;
                    }
                }

            case 2:                     //middle
                if (operator == '+' || operator == '-') {
                    if (operator == '+') {
                        this.a = rand.nextInt(15);
                        this.b = rand.nextInt(15);
                        break;
                    } else {
                        do {
                            this.a = rand.nextInt(15);
                            this.b = rand.nextInt(1, 15);
                        } while (a < b);
                        break;
                    }
                } else {
                    if (operator == '*') {
                        this.a = rand.nextInt(10);
                        this.b = rand.nextInt(8);
                        break;
                    } else {
                        do {
                            this.a = rand.nextInt(10);
                            this.b = rand.nextInt(1, 8);

                        } while (a % b != 0);
                        break;
                    }
                }


            case 3:                     //hard
                if (operator == '+' || operator == '-') {
                    if (operator == '+') {
                        this.a = rand.nextInt(25);
                        this.b = rand.nextInt(25);
                        break;
                    } else {
                        do {
                            this.a = rand.nextInt(25);
                            this.b = rand.nextInt(1, 25);
                        } while (a < b);
                        break;
                    }
                } else {
                    if (operator == '*') {
                        this.a = rand.nextInt(10);
                        this.b = rand.nextInt(8);
                        break;
                    } else {
                        do {
                            this.a = rand.nextInt(10);
                            this.b = rand.nextInt(1, 10);
                        } while (a % b != 0);
                        break;
                    }
                }


        }

    }

    public char createOperator() {
        int randi = rand.nextInt(6);
        char operator = ' ';

        if (randi == 0)
            operator = '+';

        if (randi == 1)
            operator = '-';

        if (randi == 2)
            operator = '*';

        if (randi == 3)
            operator = '/';

        if (randi == 4)
            operator = '+';

        if (randi == 5)
            operator = '-';

        return operator;
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public double getResult(int a, int b, char operator) { //calculates the correct result of the operation
        double result = 0;

        if (operator == '+')
            result = (double) a + b;
        if (operator == '-')
            result = (double) a - b;
        if (operator == '*')
            result = (double) a * b;
        if (operator == '/')
            result = (double) (a * 1.0) / (b * 1.0);

        return result;
    }

    public char getOperator() {
        return operator;
    }
}
