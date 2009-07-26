package jp.sourceforge.andjong;

/**
 * 牌を管理するクラス
 * 
 * @author Yuji Urushibara
 * 
 */
public class Hai {
	/** ID */
	private int id;

	/** 一萬 */
	public static final int ID_WAN_1 = 0;
	/** 二萬 */
	public static final int ID_WAN_2 = 1;
	/** 三萬 */
	public static final int ID_WAN_3 = 2;
	/** 四萬 */
	public static final int ID_WAN_4 = 3;
	/** 五萬 */
	public static final int ID_WAN_5 = 4;
	/** 六萬 */
	public static final int ID_WAN_6 = 5;
	/** 七萬 */
	public static final int ID_WAN_7 = 6;
	/** 八萬 */
	public static final int ID_WAN_8 = 7;
	/** 九萬 */
	public static final int ID_WAN_9 = 8;

	/** 一筒 */
	public static final int ID_PIN_1 = 9;
	/** 二筒 */
	public static final int ID_PIN_2 = 10;
	/** 三筒 */
	public static final int ID_PIN_3 = 11;
	/** 四筒 */
	public static final int ID_PIN_4 = 12;
	/** 五筒 */
	public static final int ID_PIN_5 = 13;
	/** 六筒 */
	public static final int ID_PIN_6 = 14;
	/** 七筒 */
	public static final int ID_PIN_7 = 15;
	/** 八筒 */
	public static final int ID_PIN_8 = 16;
	/** 九筒 */
	public static final int ID_PIN_9 = 17;

	/** 一索 */
	public static final int ID_SOU_1 = 18;
	/** 二索 */
	public static final int ID_SOU_2 = 19;
	/** 三索 */
	public static final int ID_SOU_3 = 20;
	/** 四索 */
	public static final int ID_SOU_4 = 21;
	/** 五索 */
	public static final int ID_SOU_5 = 22;
	/** 六索 */
	public static final int ID_SOU_6 = 23;
	/** 七索 */
	public static final int ID_SOU_7 = 24;
	/** 八索 */
	public static final int ID_SOU_8 = 25;
	/** 九索 */
	public static final int ID_SOU_9 = 26;

	/** 東 */
	public static final int ID_TON = 27;
	/** 南 */
	public static final int ID_NAN = 28;
	/** 西 */
	public static final int ID_SHA = 29;
	/** 北 */
	public static final int ID_PE = 30;

	/** 白 */
	public static final int ID_HAKU = 31;
	/** 發 */
	public static final int ID_HATSU = 32;
	/** 中 */
	public static final int ID_CYUN = 33;

	/** 番号 */
	private int no;

	/** 一 */
	public static final int NO_1 = 1;
	/** 二 */
	public static final int NO_2 = 2;
	/** 三 */
	public static final int NO_3 = 3;
	/** 四 */
	public static final int NO_4 = 4;
	/** 五 */
	public static final int NO_5 = 5;
	/** 六 */
	public static final int NO_6 = 6;
	/** 七 */
	public static final int NO_7 = 7;
	/** 八 */
	public static final int NO_8 = 8;
	/** 九 */
	public static final int NO_9 = 9;

	/** 一萬 */
	public static final int NO_WAN_1 = 1;
	/** 二萬 */
	public static final int NO_WAN_2 = 2;
	/** 三萬 */
	public static final int NO_WAN_3 = 3;
	/** 四萬 */
	public static final int NO_WAN_4 = 4;
	/** 五萬 */
	public static final int NO_WAN_5 = 5;
	/** 六萬 */
	public static final int NO_WAN_6 = 6;
	/** 七萬 */
	public static final int NO_WAN_7 = 7;
	/** 八萬 */
	public static final int NO_WAN_8 = 8;
	/** 九萬 */
	public static final int NO_WAN_9 = 9;

	/** 一筒 */
	public static final int NO_PIN_1 = 1;
	/** 二筒 */
	public static final int NO_PIN_2 = 2;
	/** 三筒 */
	public static final int NO_PIN_3 = 3;
	/** 四筒 */
	public static final int NO_PIN_4 = 4;
	/** 五筒 */
	public static final int NO_PIN_5 = 5;
	/** 六筒 */
	public static final int NO_PIN_6 = 6;
	/** 七筒 */
	public static final int NO_PIN_7 = 7;
	/** 八筒 */
	public static final int NO_PIN_8 = 8;
	/** 九筒 */
	public static final int NO_PIN_9 = 9;

	/** 一索 */
	public static final int NO_SOU_1 = 1;
	/** 二索 */
	public static final int NO_SOU_2 = 2;
	/** 三索 */
	public static final int NO_SOU_3 = 3;
	/** 四索 */
	public static final int NO_SOU_4 = 4;
	/** 五索 */
	public static final int NO_SOU_5 = 5;
	/** 六索 */
	public static final int NO_SOU_6 = 6;
	/** 七索 */
	public static final int NO_SOU_7 = 7;
	/** 八索 */
	public static final int NO_SOU_8 = 8;
	/** 九索 */
	public static final int NO_SOU_9 = 9;

	/** 東 */
	public static final int NO_TON = 1;
	/** 南 */
	public static final int NO_NAN = 2;
	/** 西 */
	public static final int NO_SHA = 3;
	/** 北 */
	public static final int NO_PE = 4;

	/** 白 */
	public static final int NO_HAKU = 1;
	/** 發 */
	public static final int NO_HATSU = 2;
	/** 中 */
	public static final int NO_CYUN = 3;

	/** 種類 */
	private int kind;

	/** 萬子 */
	public static final int KIND_WAN = 0;
	/** 筒子 */
	public static final int KIND_PIN = 1;
	/** 索子 */
	public static final int KIND_SOU = 2;
	/** 風牌 */
	public static final int KIND_FON = 3;
	/** 三元牌 */
	public static final int KIND_SANGEN = 4;

	/** 字牌フラグ */
	private boolean tsuu;

	/**
	 * 空の牌を作成する。
	 */
	public Hai() {

	}

	/**
	 * 番号から牌を作成する。
	 * 
	 * @param id
	 *            番号
	 */
	public Hai(int id) {
		this.id = id;

		if (id > ID_PE) {
			this.no = id - ID_PE;
			this.kind = KIND_SANGEN;
			this.tsuu = true;

			this.oldId = this.no | OLD_KIND_SANGEN;
		} else if (id > ID_SOU_9) {
			this.no = id - ID_SOU_9;
			this.kind = KIND_FON;
			this.tsuu = true;

			this.oldId = this.no | OLD_KIND_FON;
		} else if (id > ID_PIN_9) {
			this.no = id - ID_PIN_9;
			this.kind = KIND_SOU;
			this.tsuu = false;

			this.oldId = this.no | OLD_KIND_SOU;
		} else if (id > ID_WAN_9) {
			this.no = id - ID_WAN_9;
			this.kind = KIND_PIN;
			this.tsuu = false;

			this.oldId = this.no | OLD_KIND_PIN;
		} else {
			this.no = id + 1;
			this.kind = KIND_WAN;
			this.tsuu = false;

			this.oldId = this.no | OLD_KIND_WAN;
		}
	}

	/**
	 * 牌から牌を作成する。
	 * 
	 * @param hai
	 *            牌
	 */
	public Hai(Hai hai) {
		this.id = hai.id;
		this.no = hai.no;
		this.kind = hai.kind;
		this.tsuu = hai.tsuu;

		this.oldId = hai.oldId;
	}

	/**
	 * 牌をコピーする。
	 * 
	 * @param hai
	 *            牌
	 */
	public void copy(Hai hai) {
		this.id = hai.id;
		this.no = hai.no;
		this.kind = hai.kind;
		this.tsuu = hai.tsuu;

		this.oldId = hai.oldId;
	}

	/**
	 * IDを取得する。
	 * 
	 * @return ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 番号を取得する。
	 * 
	 * @return 番号
	 */
	public int getNo() {
		return no;
	}

	/**
	 * 種類を取得する。
	 * 
	 * @return 種類
	 */
	public int getKind() {
		return kind;
	}

	/**
	 * 字牌フラグを取得する。
	 * 
	 * @return 字牌フラグ
	 */
	public boolean isTsuu() {
		return tsuu;
	}

	/** 萬子 */
	public final static int OLD_KIND_WAN = 0x00000010;
	/** 筒子 */
	public final static int OLD_KIND_PIN = 0x00000020;
	/** 索子 */
	public final static int OLD_KIND_SOU = 0x00000040;
	/** 数牌 */
	public final static int OLD_KIND_SHUU = 0x00000070;

	/** 風牌 */
	public final static int OLD_KIND_FON = 0x00000100;

	/** 東 */
	public final static int OLD_KIND_TON = 0x00000101;
	/** 南 */
	public final static int OLD_KIND_NAN = 0x00000102;
	/** 西 */
	public final static int OLD_KIND_SYA = 0x00000103;
	/** 北 */
	public final static int OLD_KIND_PEE = 0x00000104;

	/** 三元牌 */
	public final static int OLD_KIND_SANGEN = 0x00000200;

	/** 白 */
	public final static int OLD_KIND_HAKU = 0x00000201;
	/** 発 */
	public final static int OLD_KIND_HATU = 0x00000202;
	/** 中 */
	public final static int OLD_KIND_CYUN = 0x00000203;

	/** 字牌 */
	public final static int OLD_KIND_TSUU = 0x00000300;

	/** 牌の種類をマスクする */
	public final static int OLD_KIND_MASK = 0x0000000F;

	/**
	 * 牌番号
	 * <p>
	 * <dl>
	 * <dt>萬子</dt>
	 * <dd>KIND_WAN | 1-9</dd>
	 * <dt>筒子</dt>
	 * <dd>KIND_PIN | 1-9</dd>
	 * <dt>索子</dt>
	 * <dd>KIND_SOU | 1-9</dd>
	 * <dt>風牌</dt>
	 * <dd>KIND_FON | 1-4</dd>
	 * <dt>三元牌</dt>
	 * <dd>KIND_SANGEN | 1-3</dd>
	 * </dl>
	 * </p>
	 */
	private int oldId;

	/**
	 * 牌番号を取得する。
	 * 
	 * @return 牌番号
	 */
	public int getOldId() {
		return oldId;
	}
}
