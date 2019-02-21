public class SudokuField {

    public int field[][] = new int[9][9];
    public boolean fixField[][] = new boolean[9][9];

    SudokuField(String args[])
    {
        int arr[] = new int[9];
        String tmp[] = new String[9];
        int j = 0;

        for (String str : args)
        {
            tmp = str.split(" ");
            int i = 0;
            for (String s : tmp)
            {
                arr[i] = Integer.parseInt(s);
                if (arr[i] == 0)
                    fixField[j][i] = true;
                i++;
            }
            field[j] = arr.clone();
            j++;
        }
    }

    public void PrintSudoku()
    {
        for(int str[] : field)
        {
            for(int c : str)
            {
                if (c == 0)
                    System.out.print(". ");
                else
                    System.out.print(c + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public boolean IsValid(int x, int y)
    {
        for (int i = 0; i < 9; i++)
        {
            if (field[x][i] == field[x][y] && y != i)
                return (false);
        }
        for (int i = 0; i < 9; i++)
        {
            if (field[i][y] == field[x][y] && x != i)
                return (false);
        }
        for(int i = x / 3 * 3; i < x / 3 * 3 + 3; i++)
        {
            for(int j = y / 3 * 3; j < y / 3 * 3 + 3; j++)
            {
                if (field[i][j] == field[x][y] && x != i && y != j)
                    return (false);
            }
        }
        return (true);
    }
}
