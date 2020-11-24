package pkgEnum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum eGameDifficulty {

	EASY(.10), MEDIUM(.25), HARD(.50);

	private final double iDifficulty;

	private static final Map<Double, eGameDifficulty> lookup = new HashMap<Double, eGameDifficulty>();

	static {
		for (eGameDifficulty d : eGameDifficulty.values()) {
			lookup.put(d.getiDifficulty(), d);
		}
	}

	private eGameDifficulty(double iDifficulty) {
		this.iDifficulty = iDifficulty;
	}

	public double getiDifficulty() {
		return iDifficulty;
	}

	@Override
	public String toString() {
		return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
	}

	/**
	 * get - return the right enum by name
	 * 
	 * @param strName
	 * @return
	 */
	public static eGameDifficulty get(String strName) {
		for (eGameDifficulty eGD : eGameDifficulty.values()) {
			System.out.println(eGD.name().toUpperCase());
			if (eGD.name().toUpperCase().equals(strName.toUpperCase())) {
				return eGD;
			}
		}
		return null;
	}

	/**
	 * get - return the right enum by iDifficulty score.
	 * 
	 * @param strName
	 * @return
	 */

	public static eGameDifficulty get(double iDifficulty) {

		Iterator it = lookup.entrySet().iterator();
		eGameDifficulty eGD = null;

		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			eGameDifficulty enumDifficulty = (eGameDifficulty) pair.getValue();
			double iDifficultyValue = (int) pair.getKey();
			if (iDifficulty > iDifficultyValue) {
				eGD = enumDifficulty;
			}
		}
		return eGD;
	}
}
