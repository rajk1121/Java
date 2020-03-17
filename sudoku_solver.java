
public class sudoku_solver {

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
	{'.','.','.','2','7','5','9','.','.'}
			};
//		char c = (char);
//		System.out.println(c);
		for(int i=0 ; i<9 ; i++) {
			if(sudoku[0][i]=='.') {

//				System.out.println(i);
				generateAnswer(sudoku,0,i);
				break;
			}
		}
		for(int i=0; i<9 ; i++) {
			for(int j=0 ; j<9 ; j++) {
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean generateAnswer(char[][] sudoku,int row, int col) {
		
		if(row==9 || col==9) {
//			System.out.println('s');
			return true;
		}
		if(sudoku[row][col]!='.') {
			if(col==8) {

//				System.out.println('a');
				return generateAnswer(sudoku, row+1, 0);
				
			}else {

//				System.out.println('a');
				return generateAnswer(sudoku, row, col+1);
				
			}
		}
		
		int colcell = col/3;
		int rowcell = row/3;
		int srowcell = 3*rowcell;
		int erowcell = srowcell+3;
		int scolcell = 3*colcell;
		int ecolcell = scolcell+3;
		for(int i=1 ; i<=9 ; i++) {
			boolean duplicate= false;
			//check for cell
			for(int j=srowcell; j<erowcell;j++) {
				for(int k=scolcell ; k<ecolcell ; k++) {
					if(sudoku[j][k]==(char)(i+'0')) {
						duplicate = true;
						break;
					}
						
				}
			}

			if(duplicate)
				continue;
			//check for row
			for(int j=0 ; j<9 ; j++) {
				if(sudoku[row][j]==(char)(i+'0')) {
					duplicate = true;
					break;
				}
					
			}

			if(duplicate)
				continue;
			//check for col
			for(int j=0 ; j<9 ; j++) {
				if(sudoku[j][col]==(char)(i+'0'))
				{
					duplicate = true;
					break;
				}
			}

			if(duplicate)
				continue;
			sudoku[row][col] =(char)(i+'0') ;
			
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

			sudoku[row][col] = '.';
			
		}
//		System.out.println('a');
		sudoku[row][col] = '.';
		
		return false;
	}

}
