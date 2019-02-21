public class Main {
    public static void main(String[] args) {
        int i = 0;
        boolean flag = true;
        SudokuField sudoku = new SudokuField(args);

        sudoku.PrintSudoku(); System.out.print("\n");
        while(i < 81)
        {
            if (sudoku.fixField[i / 9][i % 9] == true)
            {
                sudoku.field[i / 9][i % 9]++;
                if (sudoku.field[i / 9][i % 9] > 9) {
                    sudoku.field[i / 9][i % 9] = 0;
                    flag = false;
                    i--;
                    continue;
                }
            }
            else
            {
                if (flag)
                    i++;
                else
                    i--;
                continue;
            }
            if (sudoku.IsValid(i / 9, i % 9)) {
                flag = true;
                i++;
            }
        }
        sudoku.PrintSudoku();
    }
}
