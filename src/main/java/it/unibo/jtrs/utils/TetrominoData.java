package it.unibo.jtrs.utils;

import java.util.Set;

public class TetrominoData {

	private TetrominoData() {}

	/**
	 * O piece coordinate
	 */
	public static final Set<Pair<Integer, Integer>> O_COORD =
		Set.of(new Pair<>(0,0), new Pair<>(0,1), new Pair<>(1,0), new Pair<>(1,1));
	/**
	 * L piece coordinate
	 */
	public static final Set<Pair<Integer, Integer>> L_COORD =
		Set.of(new Pair<>(0,0), new Pair<>(0,1), new Pair<>(1,1), new Pair<>(2,1));
	/**
	 * J piece coordinate
	 */
	public static final Set<Pair<Integer, Integer>> J_COORD =
		Set.of(new Pair<>(0,1), new Pair<>(0,0), new Pair<>(1,0), new Pair<>(2,0));
	/**
	 * I piece coordinate
	 */
	public static final Set<Pair<Integer, Integer>> I_COORD =
		Set.of(new Pair<>(0,1), new Pair<>(1,1), new Pair<>(2,1), new Pair<>(3,1));
	/**
	 * T piece coordinate
	 */
	public static final Set<Pair<Integer, Integer>> T_COORD =
		Set.of(new Pair<>(0,0), new Pair<>(1,0), new Pair<>(2,0), new Pair<>(1,1));
	/**
	 * Z piece coordinate
	 */
	public static final Set<Pair<Integer, Integer>> Z_COORD =
		Set.of(new Pair<>(0,1), new Pair<>(1,1), new Pair<>(1,0), new Pair<>(2,0));
	/**
	 * S piece coordinate
	 */
	public static final Set<Pair<Integer, Integer>> S_COORD =
		Set.of(new Pair<>(0,0), new Pair<>(1,0), new Pair<>(1,1), new Pair<>(2,1));

	/**
	 * O piece color
	 */
	public static final String O_COLOR = "#FFFF00";
	/**
	 * L piece color
	 */
	public static final String L_COLOR = "#FF8000";
	/**
	 * J piece color
	 */
	public static final String J_COLOR = "#0000FF";
	/**
	 * I piece color
	 */
	public static final String I_COLOR = "#00FFFF";
	/**
	 * T piece color
	 */
	public static final String T_COLOR = "#FF00FF";
	/**
	 * Z piece color
	 */
	public static final String Z_COLOR = "#FF0000";
	/**
	 * S piece color
	 */
	public static final String S_COLOR = "#00FF00";

}
