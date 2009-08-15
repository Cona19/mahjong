package jp.sourceforge.andjong;

/**
 * 手牌を管理する。
 *
 * @author Yuji Urushibara
 *
 */
public class Tehai {
	/** 純手牌の最大値 */
	public final static int JYUNTEHAI_MAX = 14;

	/** 純手牌 */
	private Hai[] jyunTehai = new Hai[JYUNTEHAI_MAX];

	/** 純手牌の長さ */
	private int jyunTehaiLength;

	/** 副露の最大値 */
	public final static int FUURO_MAX = 4;

	/** 面子の長さ(3) */
	public final static int MENTSU_LENGTH_3 = 3;

	/** 面子の長さ(4) */
	public final static int MENTSU_LENGTH_4 = 4;

	/** 明順の配列 */
	private Hai[][] minShuns = new Hai[FUURO_MAX][MENTSU_LENGTH_3];

	/** 明順の配列の長さ */
	private int minShunsLength;

	/** 明刻の配列 */
	private Hai[][] minKous = new Hai[FUURO_MAX][MENTSU_LENGTH_3];

	/** 明刻の配列の長さ */
	private int minKousLength;

	/** 明槓の配列 */
	private Hai[][] minKans = new Hai[FUURO_MAX][MENTSU_LENGTH_4];

	/** 明槓の配列の長さ */
	private int minKansLength;

	/** 暗槓の配列 */
	private Hai[][] anKans = new Hai[FUURO_MAX][MENTSU_LENGTH_4];

	/** 暗槓の配列の長さ */
	private int anKansLength;

	/**
	 * 手牌を作成する。
	 */
	public Tehai() {
		initialize();

		for (int i = 0; i < JYUNTEHAI_MAX; i++) {
			jyunTehai[i] = new Hai();
		}

		for (int i = 0; i < FUURO_MAX; i++) {
			for (int j = 0; j < MENTSU_LENGTH_3; j++) {
				minShuns[i][j] = new Hai();
				minKous[i][j] = new Hai();
			}

			for (int j = 0; j < MENTSU_LENGTH_4; j++) {
				minKans[i][j] = new Hai();
				anKans[i][j] = new Hai();
			}
		}
	}

	/**
	 * 手牌を初期化する。
	 */
	public void initialize() {
		jyunTehaiLength = 0;
		minShunsLength = 0;
		minKousLength = 0;
		minKansLength = 0;
		anKansLength = 0;
	}

	/**
	 * 手牌をコピーする。
	 *
	 * @param destTehai
	 *            コピー先の手牌
	 * @param srcTehai
	 *            コピー元の手牌
	 * @param jyunTehaiCopy
	 *            純手牌のコピー許可
	 */
	public static void copy(Tehai destTehai, Tehai srcTehai,
			boolean jyunTehaiCopy) {
		if (jyunTehaiCopy == true) {
			destTehai.jyunTehaiLength = srcTehai.jyunTehaiLength;
			Tehai.copyJyunTehai(destTehai.jyunTehai, srcTehai.jyunTehai,
					destTehai.jyunTehaiLength);
		}

		destTehai.minShunsLength = srcTehai.minShunsLength;
		Tehai.copyMinShuns(destTehai.minShuns, srcTehai.minShuns,
				destTehai.minShunsLength);

		destTehai.minKousLength = srcTehai.minKousLength;
		Tehai.copyMinKous(destTehai.minKous, srcTehai.minKous,
				destTehai.minKousLength);

		destTehai.minKansLength = srcTehai.minKansLength;
		Tehai.copyMinKans(destTehai.minKans, srcTehai.minKans,
				destTehai.minKansLength);

		destTehai.anKansLength = srcTehai.anKansLength;
		Tehai.copyMinKans(destTehai.anKans, srcTehai.anKans,
				destTehai.anKansLength);
	}

	/**
	 * 純手牌を取得する。
	 *
	 * @return 純手牌
	 */
	public Hai[] getJyunTehai() {
		return jyunTehai;
	}

	/**
	 * 純手牌の長さを取得する。
	 *
	 * @return 純手牌の長さ
	 */
	public int getJyunTehaiLength() {
		return jyunTehaiLength;
	}

	/**
	 * 純手牌に牌を追加する。
	 *
	 * @param hai
	 *            追加する牌
	 * @return 結果
	 */
	public boolean addJyunTehai(Hai hai) {
		if (jyunTehaiLength >= JYUNTEHAI_MAX) {
			return false;
		}

		int i;
		for (i = jyunTehaiLength; i > 0; i--) {
			if (jyunTehai[i - 1].getId() <= hai.getId()) {
				break;
			}

			Hai.copy(jyunTehai[i], jyunTehai[i - 1]);
		}

		Hai.copy(jyunTehai[i], hai);
		jyunTehaiLength++;

		return true;
	}

	/**
	 * 純手牌から指定位置の牌を削除する。
	 *
	 * @param idx
	 *            指定位置
	 * @return 結果
	 */
	public boolean rmJyunTehai(int idx) {
		if (idx >= JYUNTEHAI_MAX) {
			return false;
		}

		for (int i = idx; i < jyunTehaiLength - 1; i++) {
			Hai.copy(jyunTehai[i], jyunTehai[i + 1]);
		}

		jyunTehaiLength--;

		return true;
	}

	/**
	 * 純手牌から指定の牌を削除する。
	 *
	 * @param hai
	 *            指定の牌
	 * @return 結果
	 */
	public boolean rmJyunTehai(Hai hai) {
		int id = hai.getId();

		for (int i = 0; i < jyunTehaiLength; i++) {
			if (id == jyunTehai[i].getId()) {
				rmJyunTehai(i);
				return true;
			}
		}

		return false;
	}

	/**
	 * 純手牌をコピーする。
	 *
	 * @param destJyunTehai
	 *            コピー先の純手牌
	 * @param srcJyunTehai
	 *            コピー元の純手牌
	 * @param length
	 *            コピーする長さ
	 * @return 結果
	 */
	public static boolean copyJyunTehai(Hai[] destJyunTehai,
			Hai[] srcJyunTehai, int length) {
		if (length >= JYUNTEHAI_MAX) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			Hai.copy(destJyunTehai[i], srcJyunTehai[i]);
		}

		return true;
	}

	/**
	 * 純手牌の指定位置の牌をコピーする。
	 *
	 * @param hai
	 *            牌
	 * @param idx
	 *            指定位置
	 */
	public boolean copyJyunTehaiIdx(Hai hai, int idx) {
		if (idx >= jyunTehaiLength) {
			return false;
		}

		Hai.copy(hai, jyunTehai[idx]);

		return true;
	}

	/**
	 * 明順を追加する。
	 *
	 * @param minShun
	 *            明順
	 * @return 結果
	 */
	public boolean addMinShun(Hai[] minShun) {
		if (minShunsLength >= FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < MENTSU_LENGTH_3; i++) {
			Hai.copy(minShuns[minShunsLength][i], minShun[i]);
		}
		minShunsLength++;

		return true;
	}

	/**
	 * 明順の配列を取得する。
	 *
	 * @return 明順の配列
	 */
	public Hai[][] getMinShuns() {
		return minShuns;
	}

	/**
	 * 明順の配列の長さを取得する。
	 *
	 * @return 明順の配列の長さ
	 */
	public int getMinShunsLength() {
		return minShunsLength;
	}

	/**
	 * 明順の配列をコピーする。
	 *
	 * @param destMinShuns
	 *            コピー先の明順の配列
	 * @param srcMinShuns
	 *            コピー元の明順の配列
	 * @param length
	 *            コピーする長さ
	 * @return 結果
	 */
	public static boolean copyMinShuns(Hai[][] destMinShuns,
			Hai[][] srcMinShuns, int length) {
		if (length >= FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < MENTSU_LENGTH_3; j++) {
				Hai.copy(destMinShuns[i][j], srcMinShuns[i][j]);
			}
		}

		return true;
	}

	/**
	 * 明刻を追加する。
	 *
	 * @param minKou
	 *            明刻
	 * @return 結果
	 */
	public boolean addMinKou(Hai[] minKou) {
		if (minKousLength >= FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < MENTSU_LENGTH_3; i++) {
			Hai.copy(minKous[minKousLength][i], minKou[i]);
		}
		minKousLength++;

		return true;
	}

	/**
	 * 明刻の配列を取得する。
	 *
	 * @return 明刻の配列
	 */
	public Hai[][] getMinKous() {
		return minKous;
	}

	/**
	 * 明刻の配列の長さを取得する。
	 *
	 * @return 明刻の配列の長さ
	 */
	public int getMinKousLength() {
		return minKousLength;
	}

	/**
	 * 明刻の配列をコピーする。
	 *
	 * @param destMinKous
	 *            コピー先の明刻の配列
	 * @param srcMinKous
	 *            コピー元の明刻の配列
	 * @param length
	 *            コピーする長さ
	 * @return 結果
	 */
	public static boolean copyMinKous(Hai[][] destMinKous, Hai[][] srcMinKous,
			int length) {
		if (length >= FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < MENTSU_LENGTH_3; j++) {
				Hai.copy(destMinKous[i][j], srcMinKous[i][j]);
			}
		}

		return true;
	}

	/**
	 * ポンの可否をチェックする。
	 *
	 * @param suteHai
	 *            捨牌
	 * @return ポンの可否
	 */
	public boolean validPon(Hai suteHai) {
		int suteHaiId = suteHai.getId();
		for (int i = 0, count = 1; i < jyunTehaiLength; i++) {
			if (suteHaiId == jyunTehai[i].getId()) {
				count++;
				if (count >= MENTSU_LENGTH_3) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * ポンを設定する。
	 *
	 * @param suteHai
	 *            捨牌
	 * @return 結果
	 */
	public boolean setPon(Hai suteHai) {
		if (minKousLength >= FUURO_MAX) {
			return false;
		}

		if (!validPon(suteHai)) {
			return false;
		}

		int minKouIdx = 0;

		Hai.copy(minKous[minKousLength][minKouIdx], suteHai);
		minKouIdx++;

		int suteHaiId = suteHai.getId();

		for (int i = 0; i < jyunTehaiLength; i++) {
			if (suteHaiId == jyunTehai[i].getId()) {
				Hai.copy(minKous[minKousLength][minKouIdx], jyunTehai[i]);
				minKouIdx++;

				rmJyunTehai(i--);

				if (minKouIdx >= MENTSU_LENGTH_3) {
					minKousLength++;
					break;
				}
			}
		}

		return true;
	}

	/**
	 * 明槓を追加する。
	 *
	 * @param minKan
	 *            明槓
	 * @return 結果
	 */
	public boolean addMinKan(Hai[] minKan) {
		if (minKansLength >= FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < MENTSU_LENGTH_4; i++) {
			Hai.copy(minKans[minKansLength][i], minKan[i]);
		}
		minKansLength++;

		return true;
	}

	/**
	 * 明槓の配列を取得する。
	 *
	 * @return 明槓の配列
	 */
	public Hai[][] getMinKans() {
		return minKans;
	}

	/**
	 * 明槓の配列の長さを取得する。
	 *
	 * @return 明槓の配列の長さ
	 */
	public int getMinKansLength() {
		return minKansLength;
	}

	/**
	 * 明槓の配列をコピーする。
	 *
	 * @param destMinKans
	 *            コピー先の明槓の配列
	 * @param srcMinKans
	 *            コピー元の明槓の配列
	 * @param length
	 *            コピーする長さ
	 * @return 結果
	 */
	public static boolean copyMinKans(Hai[][] destMinKans, Hai[][] srcMinKans,
			int length) {
		if (length >= FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < MENTSU_LENGTH_4; j++) {
				Hai.copy(destMinKans[i][j], srcMinKans[i][j]);
			}
		}

		return true;
	}

	/**
	 * 暗槓を追加する。
	 *
	 * @param anKan
	 *            暗槓
	 * @return 結果
	 */
	public boolean addAnKan(Hai[] anKan) {
		if (anKansLength >= FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < MENTSU_LENGTH_4; i++) {
			Hai.copy(anKans[anKansLength][i], anKan[i]);
		}
		anKansLength++;

		return true;
	}

	/**
	 * 暗槓の配列を取得する。
	 *
	 * @return 暗槓の配列
	 */
	public Hai[][] getAnKans() {
		return anKans;
	}

	/**
	 * 暗槓の配列の長さを取得する。
	 *
	 * @return 暗槓の配列の長さ
	 */
	public int getAnKansLength() {
		return anKansLength;
	}

	/**
	 * 暗槓の配列をコピーする。
	 *
	 * @param destAnKans
	 *            コピー先の暗槓の配列
	 * @param srcAnKans
	 *            コピー元の暗槓の配列
	 * @param length
	 *            コピーする長さ
	 * @return 結果
	 */
	public static boolean copyAnKans(Hai[][] destAnKans, Hai[][] srcAnKans,
			int length) {
		if (length >= FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < MENTSU_LENGTH_4; j++) {
				Hai.copy(destAnKans[i][j], srcAnKans[i][j]);
			}
		}

		return true;
	}
}
