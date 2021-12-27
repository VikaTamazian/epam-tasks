package by.epam.lab;

public enum RoundMethod {
    FLOOR {
        @Override
        double roundFunction(double value) {
            return Math.floor(value);
        }
    },
    ROUND {
        @Override
        double roundFunction(double value) {
            return Math.round(value);
        }
    },
    CEIL {
        @Override
        double roundFunction(double value) {
            return Math.ceil(value);
        }
    };

    abstract double roundFunction(double value);

    public int round(double value, int d) {
        int tenPow = pow(d);

        return (int) roundFunction(value / (double) tenPow) * tenPow;
    }

    public int pow(int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * 10;
        }
        return result;
    }
}
