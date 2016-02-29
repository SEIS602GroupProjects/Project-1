package PointOfSale;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PoS_System PoS = new PoS_System();
		
		PoS.Run();
		// ANY 
		/*try {
			File file = new File("Data/usernames.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
