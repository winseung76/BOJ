import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class n12791_Starman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<Integer, String> map = new TreeMap();
		map.put(1967, "DavidBowie");
		map.put(1969, "SpaceOddity");
		map.put(1970, "TheManWhoSoldTheWorld");
		map.put(1971, "HunkyDory");
		map.put(1972, "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars");
		map.put(1973, "AladdinSane PinUps");
		map.put(1974, "DiamondDogs");
		map.put(1975, "YoungAmericans");
		map.put(1976, "StationToStation");
		map.put(1977, "Low Heroes");
		map.put(1979, "Lodger");
		map.put(1980, "ScaryMonstersAndSuperCreeps");
		map.put(1983, "LetsDance");
		map.put(1984, "Tonight");
		map.put(1987, "NeverLetMeDown");
		map.put(1993, "BlackTieWhiteNoise");
		map.put(1995, "1.Outside");
		map.put(1997, "Earthling");
		map.put(1999, "Hours");
		map.put(2002, "Heathen");
		map.put(2003, "Reality");
		map.put(2013, "TheNextDay");
		map.put(2016, "BlackStar");

		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int count = 0;
			Iterator it = map.keySet().iterator();
			StringBuffer buf = new StringBuffer();
			while (it.hasNext()) {
				int key = (int) it.next();
				if (key >= a && key <= b) {

					if (key == 1973 || key == 1977) {
						buf.append("\n" + key + " " + map.get(key).split(" ")[0]);
						buf.append("\n" + key + " " + map.get(key).split(" ")[1]);
						count += 2;
					} else {
						buf.append("\n" + key + " " + map.get(key));
						count++;
					}
				}
			}
			System.out.print(count);
			System.out.println(buf.toString());

		}
	}
}
