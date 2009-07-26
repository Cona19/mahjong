package jp.sourceforge.andjong;

/**
 * 捨牌を管理するクラス
 * 
 * @author Yuji Urushibara
 * 
 */
public class SuteHai extends Hai {
	/** 鳴きフラグ */
	private boolean naki;

	/** リーチフラグ */
	private boolean reach;

	/** 手出しフラグ */
	private boolean tedashi;

	/**
	 * 捨牌を作成する。
	 */
	public SuteHai() {
		super();
	}

	/**
	 * 番号から捨牌を作成する。
	 * 
	 * @param id
	 *            番号
	 */
	public SuteHai(int id) {
		super(id);
	}

	/**
	 * 牌から捨牌を作成する。
	 * 
	 * @param hai
	 *            牌
	 */
	public SuteHai(Hai hai) {
		super(hai);
	}

	/**
	 * 鳴きフラグを設定する。
	 * 
	 * @param naki
	 *            鳴きフラグ
	 */
	public void setNaki(boolean naki) {
		this.naki = naki;
	}

	/**
	 * 鳴きフラグを取得する。
	 * 
	 * @return 鳴きフラグ
	 */
	public boolean isNaki() {
		return naki;
	}

	/**
	 * リーチフラグを設定する。
	 * 
	 * @param reach
	 *            リーチフラグ
	 */
	public void setReach(boolean reach) {
		this.reach = reach;
	}

	/**
	 * リーチフラグを取得する。
	 * 
	 * @return リーチフラグ
	 */
	public boolean isReach() {
		return reach;
	}

	/**
	 * 手出しフラグを設定する。
	 * 
	 * @param tedashi
	 *            手出しフラグ
	 */
	public void setTedashi(boolean tedashi) {
		this.tedashi = tedashi;
	}

	/**
	 * 手出しフラグを取得する。
	 * 
	 * @return 手出しフラグ
	 */
	public boolean isTedashi() {
		return tedashi;
	}
}
