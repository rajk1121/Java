/*
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 */
public class valid_sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] sudoku = {
	{'.','.','9','7','4','8','.','.','.'},
	{'7','.','.','.','.','.','.','.','.'},
	{'.','2','.','1','.','9','.','.','.'},
	{'.','.','7','.','.','.','2','4','.'},
	{'.','6','4','.','1','.','5','9','.'},
	{'.','9','8','.','.','.','3','.','.'},
	{'.','.','.','8','.','3','.','2','.'},
	{'.','.','.','.','.','.','.','.','6'},
	{'.','.','.','2','1','5','9','.','.'}
			};
//		char c = (char);
//		System.out.println(c);
//		for(int i=0 ; i<9 ; i++) {
//			if(sudoku[0][i]=='.') {
//
////				System.out.println(i);
//				generateAnswer(sudoku,0,i);
//				break;
//			}
//		}
		System.out.println(generateAnswer(sudoku,0,0));
		
	}
	public static boolean generateAnswer(char[][] sudoku,int row, int col) {
		
		if(row==9 || col==9) {
//			System.out.println('s');
			return true;
		}
		if(sudoku[row][col]=='.') {
			if(col==8) {

//				System.out.println('a');
				return generateAnswer(sudoku, row+1, 0);
				
			}else {

//				System.out.println('a');
				return generateAnswer(sudoku, row, col+1);
				
			}
		}
//		
		
		int colcell = col/3;
		int rowcell = row/3;
		int srowcell = 3*rowcell;
		int erowcell = srowcell+3;
		int scolcell = 3*colcell;
		int ecolcell = scolcell+3;
		char i = sudoku[row][col];
			//check for cell
			for(int j=srowcell; j<erowcell;j++) {
				for(int k=scolcell ; k<ecolcell ; k++) {
					if(sudoku[j][k]==i && j!=row && k!=col) {
						return false;
					}
						
				}
			}

			//check for row
			for(int j=0 ; j<9 ; j++) {
				if(sudoku[row][j]==i && j!=col) {
					return false;
				}
					
			}

			//check for col
			for(int j=0 ; j<9 ; j++) {
				if(sudoku[j][col]==i && i!=row)
				{
					return false;
				}
			}

			
			if(col==8) {

//				System.out.println('a');
				boolean value = generateAnswer(sudoku, row+1, 0);
				if(value)
					return true;
			}else {

//				System.out.println('a');
				boolean value = generateAnswer(sudoku, row, col+1);
				if(value)
					return true;
			

			
		}
//		System.out.println('a');
		
		return false;
	}

}
