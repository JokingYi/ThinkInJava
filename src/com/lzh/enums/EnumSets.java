package com.lzh.enums;

import java.util.EnumSet;

enum AlarmPoints{STAIR1, STAIR2, LOBBY, OFFICE, BATHROOM, KITCHEN}

public class EnumSets
{
	public static void main(String[] args)
	{
		//Ð§ÂÊ¸ß
		EnumSet<AlarmPoints> points=EnumSet.noneOf(AlarmPoints.class);
		points.add(AlarmPoints.STAIR1);
		points.add(AlarmPoints.STAIR2);
		points.addAll(EnumSet.of(AlarmPoints.LOBBY, AlarmPoints.KITCHEN));
		for (AlarmPoints enum1 : points)
		{
			System.out.println(enum1);
		}
	}
}
