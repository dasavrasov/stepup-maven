package ru.stepup.payments.mobile;

public enum ArithmeticOper {
    ADD(1){
        @Override
        int op(int x, int y) {
            return x+y;
        }
    },
    SUBTRACT(2){
        @Override
        int op(int x, int y) {
            return x-y;
        }
    },
    MULTIPLY(3){
        @Override
        int op(int x, int y) {
            return x*y;
        }
    },
    DIVIDE(4){
        @Override
        int op(int x, int y) {
            return x/y;
        }
    };
    int op,x,y;

    ArithmeticOper(int op) {
        this.op = op;
    }

    abstract int op(int x, int y);
}
