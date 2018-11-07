package com.dexfun.yiku.activity.adapter.test;

import java.util.Comparator;

/**
 * 
 * @author 
 *
 */
public class PinyinComparator implements Comparator<SortModel> {

	@Override
	public int compare(SortModel o1, SortModel o2) {
		if (o1.getSortLetters().equals("#")
				|| o2.getSortLetters().equals("@")) {
			return 0;
		} else {
			return o1.getSortLetters().compareTo(o2.getSortLetters());
		}
	}

}
