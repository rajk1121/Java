import java.io.*;
import java.util.*;
class PersonalisedPair{
	String name;
	int values;
	
	public PersonalisedPair(String a, int b) {
		name = a;
		values = b;
	}
}
class SecondPersonlisedPair{
	String name;
	int max_qty;
	int min_qty;
	int avg_qty;
	int total_qty;
	int total_revenue;
	int occ;
	SecondPersonlisedPair(String a, int b, int c, int d, int e, int f, int g){
		name = a;
		max_qty = b;
		min_qty = c;
		avg_qty = d;
		total_qty = e;
		total_revenue = f;
		occ = g;
	}
	public String toString() {
		String str = "";
		str = this.name + " " + this.avg_qty +" "+this.max_qty+" "+this.min_qty+" "+this.occ+" "+this.total_qty+" "+this.total_revenue;
		return str;
	}
}

public class mobiui{
public static void main(String[] args)throws Exception{

File file = new File("C:\\Users\\rajat\\eclipse-workspace\\Java\\src\\data_set.txt");

BufferedReader br = new BufferedReader(new FileReader(file));
HashMap<Integer, Integer> monthlySales = new HashMap<>();
HashMap<Integer, PersonalisedPair> popularItemMonthWise = new HashMap<>();
HashMap<Integer, PersonalisedPair> mostRevenueItemMonthWise = new HashMap<>();
HashMap<String, ArrayList<SecondPersonlisedPair>> itemMonthWiseAllData = new HashMap<>();
String st;
int i= 0;
int total_sales = 0;
while ((st = br.readLine()) != null ) {
	if(i==0) {
		i++;
		continue;
	}
			String[] arr = st.split(",");
			String[] dateArr = arr[0].split("-");
//			System.out.println(Arrays.toString(dateArr));
			int month = Integer.parseInt(dateArr[1]);
			String itemName = arr[1];
			int qty = Integer.parseInt(arr[3]);
			int sale = Integer.parseInt(arr[4]);
			total_sales += sale;
			monthlySales.put(month, monthlySales.getOrDefault(month, 0) + sale);
			SecondPersonlisedPair currentItemDetails;
			if(itemMonthWiseAllData.containsKey(itemName)) {
				ArrayList<SecondPersonlisedPair> list = itemMonthWiseAllData.get(itemName);
//				System.out.println(month+" "+list.size()+" "+itemName);
				if(list.size()>=month) {
					SecondPersonlisedPair dataForThatMonth = list.get(month - 1);
					dataForThatMonth.min_qty = Math.min(dataForThatMonth.min_qty, qty);
					dataForThatMonth.max_qty = Math.max(dataForThatMonth.max_qty, qty);
					dataForThatMonth.avg_qty = (dataForThatMonth.total_qty + qty)/(dataForThatMonth.occ + 1);
					dataForThatMonth.occ = dataForThatMonth.occ + 1;
					dataForThatMonth.total_qty = dataForThatMonth.total_qty + qty;
					dataForThatMonth.total_revenue = dataForThatMonth.total_revenue + sale;
//					int popularItemQtyForThatMonth = popularItemMonthWise.getOrDefault(month, new SecondPersonlisedPair("",0,0,0,0,0,0)).
					currentItemDetails = dataForThatMonth;
				}else {
					SecondPersonlisedPair temp = new SecondPersonlisedPair(itemName, qty, qty, qty, qty, sale, 1);
					list.add(month-1, temp);
					currentItemDetails = temp;
				}
			}else {
				SecondPersonlisedPair temp = new SecondPersonlisedPair(itemName, qty, qty, qty, qty, sale, 1);
				ArrayList<SecondPersonlisedPair> list = new ArrayList(31);
				list.add(month - 1, temp);
				itemMonthWiseAllData.put(itemName, list);
				currentItemDetails = temp;
			}
			if(popularItemMonthWise.get(month)!=null) {
				PersonalisedPair previous = popularItemMonthWise.get(month);
				PersonalisedPair current = new PersonalisedPair(currentItemDetails.name, currentItemDetails.total_qty);
				PersonalisedPair toBePosted = previous.values < current.values ? current : previous;
				popularItemMonthWise.put(month, toBePosted);
			}else{
				popularItemMonthWise.put(month, new PersonalisedPair(currentItemDetails.name, currentItemDetails.total_qty));
			}
			if(mostRevenueItemMonthWise.get(month)!=null) {
				PersonalisedPair previous = mostRevenueItemMonthWise.get(month);
				PersonalisedPair current = new PersonalisedPair(currentItemDetails.name, currentItemDetails.total_revenue);
				PersonalisedPair toBePosted = previous.values < current.values ? current : previous;
				mostRevenueItemMonthWise.put(month, toBePosted);
			}else{
				mostRevenueItemMonthWise.put(month, new PersonalisedPair(currentItemDetails.name, currentItemDetails.total_revenue));
			}
//			System.out.println(Arrays.toString(arr));
			i++;
		}
		System.out.println(total_sales);
		System.out.println(monthlySales);
		System.out.println(popularItemMonthWise.get(1).name+" "+popularItemMonthWise.get(1).values);
		System.out.println(mostRevenueItemMonthWise.get(1).name+" "+mostRevenueItemMonthWise.get(1).values+" "+"rev");
		System.out.println(itemMonthWiseAllData.get(popularItemMonthWise.get(1).name).get(0).toString());
//		System.out.println(total_sales);
	}
}